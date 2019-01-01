# HyperLogLog

## 1. 介绍

HyperLogLog可以接受多个元素作为输入，并给出输入元素的基数估算值

- 基数：集合中不同元素的数量
- 估算值：算法给出的基数并不是精确的，可能会比实际稍微多一些或少一些，但会控制在合理范围之内

HyperLogLog的优点是，即使输入元素的数量或者体积非常非常大，计算基数所需要的空间总是固定的，并且是很小的。

在Redis里面每个HyperLogLog键只需花费12KB的内存，就可以计算接近2^64个不同元素的基数，这和计算基数时，元素越多耗费内存就越多的集合形成鲜明对比。

但是，因为HyperLogLog只会根据输入元素来计算基数，而不会存储输入元素本身，所以HyperLogLog不能像集合那样，返回输入的各个元素。

## 2. PFADD 添加元素

```java
pfadd key element [element ...]
```

将任意数量的元素添加到HyperLogLog里面，如果估算值在执行后发生了变化，命令返回1，否则返回0

命令复杂度为O(N)，N为被添加元素的数量

## 3. PFCOUNT返回基数估算值

```java
PFCOUNT key [key ...]
```

当只给定一个HyperLogLog时，命令返回HyperLogLog的基数估算值。复杂度为O(1)。并且具有非常低的平均常数时间。

当给定多个HyperLogLog时，命令会先对给定的HyperLogLog进行并集计算，得出一个合并后的HyperLogLog，然后返回这个合并的HyperLogLog的基数估算值作为命令的结果（合并得出的HyperLogLog不会被存储，使用之后就会被删除）,复杂度为O(N)，并且常数时间也比处理单个HyperLogLog时要大得多。

## 4. PFMERGE合并

```java
 PFMERGE destkey sourcekey [sourcekey ...]
```

将多个HyperLogLog合并为一个HyperLogLog，合并后的HyperLogLog的基数估算值通过对所有给定HyperLogLog进行并集计算得出的。

命令复杂度为O(N),其中N为被合并的HyperLogLog的数量，不过这个命令的常数复杂度比较高。

记录网站每天访问的独立ip数量，消耗内存数量

| 独立ip数量 | 一天 | 一个月 | 一年   |
| ---------- | ---- | ------ | ------ |
| 一百万     | 12KB | 360KB  | 4.32MB |
| 一千万     | 12KB | 360KB  | 4.32MB |
| 一亿       | 12KB | 360KB  | 4.32MB |

若使用Set，ipv4地址15位

| 独立ip数量 | 一天  | 一个月 | 一年  |
| ---------- | ----- | ------ | ----- |
| 一百万     | 15MB  | 450MB  | 5.4GB |
| 一千万     | 150MB | 4.5GB  | 54GB  |
| 一亿       | 1.5G  | 45GB   | 540GB |

HyperLogLog接收多个元素作为输入，估算出输入元素的基数，因为HyperLogLog只需要使用少量的内存就可以对非常多的元素进行计数，对于那些只想知道输入元素的基数，但是并不需要知道具体输入的是哪些元素的程序来说，使用HyperLogLog而不是集合来计算基数，可以节约大量内存。

