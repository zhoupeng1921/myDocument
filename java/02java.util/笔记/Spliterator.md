# Spliterator

## 1. 介绍

​       可分割迭代器，用来把原来的对象元素进行分割和遍历，也可能会修改元素。可以用`tryAdvance`来操作一个元素，可以用`forEachRemaining`来批量操作元素。Spliterator可以用`trySplit`来分割元素，返回另一个Spliterator，用在并发操作中。如果Spliterator不能分割或者分割后元素非常不均衡或者是效率差，将不会从并发操作中受益。

​	Spliterator有一些特征：ORDERED,DISTINCT,SORTED,SIZED,NONNULL,IMMUTABLE,CONCURRENT,SUBSIZED，这些特征会作为交集表现出来。某些特征也约束了某些方法的操作。

jdk1.8加入

## 2. tryAdvance

```java
    boolean tryAdvance(Consumer<? super T> action);
```

如果有其它元素，对一个元素执行action

## 3. forEachRemaining

```java
default void forEachRemaining(Consumer<? super T> action) {
    do { } while (tryAdvance(action));
}
```

对于剩余的元素，在当前线程中按序执行action

## 4. trySplist

```java
    Spliterator<T> trySplit();
```

如果这个spliterator可以被分割，返回分割后的迭代器，迭代器会包含当前的一部分元素，如果不能被分割，返回null

## 5. estimateSize

```java
    long estimateSize();
```

返回当前要处理的元素的数量，如果为无穷大或者未知的或者无法计算，返回Long.MAX_VALUE

## 6. getExactSizeIfKnown

```
    default long getExactSizeIfKnown() {
        return (characteristics() & SIZED) == 0 ? -1L : estimateSize();
    }
```

如果特征为`SIZED`返回`estimateSize`否则返回`-1`

## 7. characteristics

```java
    int characteristics();
```

返回集合的特征。通过判断集合的特征，可以更好的做运算

## 8. hasCharacteristics

```java
    default boolean hasCharacteristics(int characteristics) {
        return (characteristics() & characteristics) == characteristics;
    }
```

集合是否拥有某个特征

## 9. getComparator

```java
    default Comparator<? super T> getComparator() {
        throw new IllegalStateException();
    }
```

如果迭代器的源是`SORTED`，如果有`Comparator`返回原来的，如果没有返回null，如果不是`SORTED`抛出异常

## 10. ofPrimitive

```
public interface OfPrimitive<T, T_CONS, T_SPLITR extends Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>>
            extends Spliterator<T> {
        @Override
        T_SPLITR trySplit();


        @SuppressWarnings("overloads")
        boolean tryAdvance(T_CONS action);


        @SuppressWarnings("overloads")
        default void forEachRemaining(T_CONS action) {
            do { } while (tryAdvance(action));
        }
    }
```

包装了一下