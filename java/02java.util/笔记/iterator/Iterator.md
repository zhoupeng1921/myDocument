# Iterator<E>

正常大家在循环集合的时候，如果删除了或者添加了元素，可能就会出现问题，而用Iterator去删除元素就不会出问题，自己也不用考虑下标问题。

## 介绍

Iterator是一个集合迭代器，取代Enumeration，允许调用者去移除元素。如果实现类没有线程安全策略，多线程情况下调用里面的方法可能会抛出`ConcurrentModificationException`异常。

## 方法

### hasNext

```java
boolean hasNext();
```

如果迭代器还有剩余迭代的元素，返回true

### next

```java
E next();
```

返回迭代器中的下一个元素

### remove

```java
default void remove() {
        throw new UnsupportedOperationException("remove");
}
```

从底层集合中移除被这个迭代器最后一次返回的元素，这个方法每个next()后只能调用一次

### forEachRemaining

```java
default void forEachRemaining(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        while (hasNext())
            action.accept(next());
}
```

对于剩余的所有元素，执行指定的操作

