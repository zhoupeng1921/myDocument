# Iterable<T>

## 介绍

迭代对象接口，继承这个接口，允许一个对象用for-each循环。Collection接口继承了Iterable，子类可以通过实现此类，返回一个迭代器对象。因为迭代器里面有迭代指针，所以可以通过此接口每次返回一个新迭代器对象，这样多次调用迭代器不会造成迭代位置不可控问题。所以list、set集合对象没有直接继承Iterator类

## ` iterable`

```java
 Iterator<T> iterator();
```

返回一个迭代器

## `forEach`

```java
  default void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (T t : this) {
            action.accept(t);
        }
    }	
```

入参是`Consumer`，对于集合每个元素，执行action函数接口



## `spliterator`

```java
  default Spliterator<T> spliterator() {
        return Spliterators.spliteratorUnknownSize(iterator(), 0);
    }
```

返回一个可分割迭代器





