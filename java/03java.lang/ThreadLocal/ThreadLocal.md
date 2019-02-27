# ThreadLocal

## 1. 介绍

基于jdk11。可以为不同的线程保存一个不同的变量，（如果是引用类型的变量，多线程操作依旧会有线程安全问题）。

基本原理：

 	1. 线程：内部通过`Thread.currentThread().threadLocals`获得当前线程的ThreadLocalMap
 	2. ThreadLocalMap内部类：内部有一个 `Entry[] table`类型的数组，下标为当前ThreadLocal对象的threadLocalHashCode & (table.length- 1)的值，Entry里面存储了当前的ThreadLocal对象和要设置的值。

所以 *同一个线程与同一个ThreadLocal对象* 唯一定位一个值。

*不同线程同一个ThreadLocal*  或者 *同一线程不同的ThreadLocal对象* 设置值都会单独设置进去



## 2. 源码解析

### 2.1 threadLocalHashCode

​         threadLocalHashCode当前ThreadLocal对象的hashCode，通过下面代码计算出来的

```java
 	private final int threadLocalHashCode = nextHashCode();

    private static AtomicInteger nextHashCode =
        new AtomicInteger();

    private static final int HASH_INCREMENT = 0x61c88647;

    private static int nextHashCode() {
        return nextHashCode.getAndAdd(HASH_INCREMENT);
    }
```

### 2.2 initialValue()

设置初始化值，可以进行重写

```java
    protected T initialValue() {
        return null;
    }
```

### 2.3 withInitial()

一个静态初始化方法，jdk11中目前没有发现引用

```java
    public static <S> ThreadLocal<S> withInitial(Supplier<? extends S> supplier) {
        return new SuppliedThreadLocal<>(supplier);
    }
    static final class SuppliedThreadLocal<T> extends ThreadLocal<T> {

        private final Supplier<? extends T> supplier;

        SuppliedThreadLocal(Supplier<? extends T> supplier) {
        	this.supplier = Objects.requireNonNull(supplier);
    	}

    	@Override
    	protected T initialValue() {
        	return supplier.get();
        }
    }
```



### 2.4 内部类ThreadLocalMap

#### 2.4.1 内部类Entry

​	这个类继承自弱引用（若对象只有弱引用，会在gc时直接回收），防止强引用造成k无法回收，生命周期就会和当前线程绑定在一起。

```java
        static class Entry extends WeakReference<ThreadLocal<?>> {
            /** The value associated with this ThreadLocal. */
            Object value;

            Entry(ThreadLocal<?> k, Object v) {
                super(k);
                value = v;
            }
        }
```

#### 2.4.2 INITIAL_CAPACITY

​	初始化值，必须时2的幂（后面再解释）

```java
  		private static final int INITIAL_CAPACITY = 16;
```

#### 2.4.3 table

​     table数组，会用来存k，v，数组大小必须时2的幂

```java
        private Entry[] table;
```

#### 2.4.4 size

​	数组的大小

```java
        private int size = 0;
```

#### 2.4.5 threshold

​	重新分配数组大小的阈值，数组大小达到阈值时需要重新扩容

```java
		private int threshold
		
		private void setThreshold(int len) {
            threshold = len * 2 / 3;
        }
```

#### 2.4.6 nextIndex/prevIndex

​	以长度为模，增加或减小一个值

```java
        private static int nextIndex(int i, int len) {
            return ((i + 1 < len) ? i + 1 : 0);
        }

        private static int prevIndex(int i, int len) {
            return ((i - 1 >= 0) ? i - 1 : len - 1);
        }
```

#### 2.4.7 ThreadLocalMap构造方法

​	当需要设置值的时候才进行创建对象，同时在构造方法中设置一些初始化的值

```java
        ThreadLocalMap(ThreadLocal<?> firstKey, Object firstValue) {
            table = new Entry[INITIAL_CAPACITY];
            int i = firstKey.threadLocalHashCode & (INITIAL_CAPACITY - 1);
            table[i] = new Entry(firstKey, firstValue);
            size = 1;
            setThreshold(INITIAL_CAPACITY);
        }
```

#### 2.4.8 ThreadLocalMap私有构造方法

​	继承父类线程，只能在`createInheritedMap`方法中调用

```java
 		private ThreadLocalMap(ThreadLocalMap parentMap) {
            Entry[] parentTable = parentMap.table;
            int len = parentTable.length;
            setThreshold(len);
            table = new Entry[len];

            for (Entry e : parentTable) {
                if (e != null) {
                    @SuppressWarnings("unchecked")
                    ThreadLocal<Object> key = (ThreadLocal<Object>) e.get();
                    if (key != null) {
                        Object value = key.childValue(e.value);
                        Entry c = new Entry(key, value);
                        int h = key.threadLocalHashCode & (len - 1);
                        while (table[h] != null)
                            h = nextIndex(h, len);
                        table[h] = c;
                        size++;
                    }
                }
            }
        }
```

#### 2.4.9 getEntry

​	根据`key`获取entry，首先根据key的hash计算出下标，如果存在下标冲突的情况下，执行`getEntryAfterMiss`方法，每次后移一个下标，直到k等于当前key，或者e等于null时退出。`expungeStaleEntry`方法后面讲

```java
        private Entry getEntry(ThreadLocal<?> key) {
            int i = key.threadLocalHashCode & (table.length - 1);
            Entry e = table[i];
            if (e != null && e.get() == key)
                return e;
            else
                return getEntryAfterMiss(key, i, e);
        }
        private Entry getEntryAfterMiss(ThreadLocal<?> key, int i, Entry e) {
            Entry[] tab = table;
            int len = tab.length;

            while (e != null) {
                ThreadLocal<?> k = e.get();
                if (k == key)
                    return e;
                if (k == null)
                    expungeStaleEntry(i);
                else
                    i = nextIndex(i, len);
                e = tab[i];
            }
            return null;
        }
```

#### 2.4.10 expungeStaleEntry

​	如果e.get()为null，证明这个entry无效，k已经被回收了。清除下标staleSlot及其后面无效的entry，如果无效entry后面有有效的entry,会重新计算位置。直到tab[i]为null退出

```java
 		private int expungeStaleEntry(int staleSlot) {
            Entry[] tab = table;
            int len = tab.length;

            // expunge entry at staleSlot
            tab[staleSlot].value = null;
            tab[staleSlot] = null;
            size--;

            // Rehash until we encounter null
            Entry e;
            int i;
            for (i = nextIndex(staleSlot, len);
                 (e = tab[i]) != null;
                 i = nextIndex(i, len)) {
                ThreadLocal<?> k = e.get();
                if (k == null) {
                    e.value = null;
                    tab[i] = null;
                    size--;
                } else {
                    int h = k.threadLocalHashCode & (len - 1);
                    if (h != i) {
                        tab[i] = null;

                        // Unlike Knuth 6.4 Algorithm R, we must scan until
                        // null because multiple entries could have been stale.
                        while (tab[h] != null)
                            h = nextIndex(h, len);
                        tab[h] = e;
                    }
                }
            }
            return i;
        }
```

#### 2.4.11 set

​	向threadLocalMap里面设置值，首先计算出下标i，如果key==k则替换原来的值，如果k==null，证明k已无效，则替换，如果原来i下标不存在entry则新建

```java
 private void set(ThreadLocal<?> key, Object value) {

            // We don't use a fast path as with get() because it is at
            // least as common to use set() to create new entries as
            // it is to replace existing ones, in which case, a fast
            // path would fail more often than not.

            Entry[] tab = table;
            int len = tab.length;
            int i = key.threadLocalHashCode & (len-1);

            for (Entry e = tab[i];
                 e != null;
                 e = tab[i = nextIndex(i, len)]) {
                ThreadLocal<?> k = e.get();

                if (k == key) {
                    e.value = value;
                    return;
                }

                if (k == null) {
                    replaceStaleEntry(key, value, i);
                    return;
                }
            }

            tab[i] = new Entry(key, value);
            int sz = ++size;
            if (!cleanSomeSlots(i, sz) && sz >= threshold)
                rehash();
        }
```

#### 2.4.12 remove

​	移除对应key的entry

```java
  		private void remove(ThreadLocal<?> key) {
            Entry[] tab = table;
            int len = tab.length;
            int i = key.threadLocalHashCode & (len-1);
            for (Entry e = tab[i];
                 e != null;
                 e = tab[i = nextIndex(i, len)]) {
                if (e.get() == key) {
                    //清除对key的引用，不会入队
                    e.clear();
                    expungeStaleEntry(i);
                    return;
                }
            }
        }
```

#### 2.4.13 replaceStaleEntry

​	替换无效的entry，for循环里prevIndex是为了找到最开始需要回收的下标，去避免造成重新扩容

```java
		private void replaceStaleEntry(ThreadLocal<?> key, Object value,
                                       int staleSlot) {
            Entry[] tab = table;
            int len = tab.length;
            Entry e;

            // Back up to check for prior stale entry in current run.
            // We clean out whole runs at a time to avoid continual
            // incremental rehashing due to garbage collector freeing
            // up refs in bunches (i.e., whenever the collector runs).
            int slotToExpunge = staleSlot;
            for (int i = prevIndex(staleSlot, len);
                 (e = tab[i]) != null;
                 i = prevIndex(i, len))
                if (e.get() == null)
                    slotToExpunge = i;

            // Find either the key or trailing null slot of run, whichever
            // occurs first
            for (int i = nextIndex(staleSlot, len);
                 (e = tab[i]) != null;
                 i = nextIndex(i, len)) {
                ThreadLocal<?> k = e.get();

                // If we find key, then we need to swap it
                // with the stale entry to maintain hash table order.
                // The newly stale slot, or any other stale slot
                // encountered above it, can then be sent to expungeStaleEntry
                // to remove or rehash all of the other entries in run.
                if (k == key) {
                    e.value = value;

                    tab[i] = tab[staleSlot];
                    tab[staleSlot] = e;

                    // Start expunge at preceding stale entry if it exists
                    if (slotToExpunge == staleSlot)
                        slotToExpunge = i;
                    cleanSomeSlots(expungeStaleEntry(slotToExpunge), len);
                    return;
                }

                // If we didn't find stale entry on backward scan, the
                // first stale entry seen while scanning for key is the
                // first still present in the run.
                if (k == null && slotToExpunge == staleSlot)
                    slotToExpunge = i;
            }

            // If key not found, put new entry in stale slot
            tab[staleSlot].value = null;
            tab[staleSlot] = new Entry(key, value);

            // If there are any other stale entries in run, expunge them
            if (slotToExpunge != staleSlot)
                cleanSomeSlots(expungeStaleEntry(slotToExpunge), len);
        }
```

#### 2.4.14 cleanSomeSlots

​	清除一些无效节点

```
        private boolean cleanSomeSlots(int i, int n) {
            boolean removed = false;
            Entry[] tab = table;
            int len = tab.length;
            do {
                i = nextIndex(i, len);
                Entry e = tab[i];
                if (e != null && e.get() == null) {
                    n = len;
                    removed = true;
                    i = expungeStaleEntry(i);
                }
            } while ( (n >>>= 1) != 0);
            return removed;
        }
```

