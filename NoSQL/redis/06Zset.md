# Zset

## 1. 介绍

有序集合和集合一样，都可以包含任意数量的、各不相同的元素，不同于Set的是，有序集合每个元素都关联着一个浮点数（score），并且有序集合会按照分值，以从小到大的顺序来排列有序集合中的各个元素。

## 2. ZADD添加元素

```shell
zadd key [NX|XX] [CH] [INCR] score member [score member ...]
```

复杂度O(M*log(N))，其中N为有序集合已有的元素数量，M为成功添加的元素数量

## 3. ZREM删除元素

```shell
zrem key member [member ...]
```

删除指定元素，返回被删除的数量

复杂度O(M*log(N))，其中N为有序集合已有的元素数量，M为成功删除的元素数量

## 4. ZSCORE返回元素的分值

```shell
zscore key member
```

## 5.ZINCRBY增加元素的分值

```shell
zincrby key increment member
```

在有序集合指定元素的分值上，增加increment，若指定负数，则为减去

复杂度O(log(N))

## 6.ZCARD返回元素数量

```shell
zcard key
```

返回有序集合的元素数量，复杂度O(1)

## 7. ZRANK返回元素排名

```shell
zrank key member
```

返回指定元素在有序集合中的排名，其中排名按照从小到大计算。从0开始

复杂度O(log(N))。 

## 8. ZREVRANK返回元素逆序排名

```shell
zrevrank key member
```

返回成员在有序集合中的逆序排名，其中排名按照元素的分值从大到小计算

复杂度O(log(N))。 

## 9. ZRANGE返回指定索引范围内的升序元素

```shell
zrange key start stop [WITHSCORES]
```

返回有序集合在按照分值从小到大排列的元素，范围从start 到 stop，可以使正数或负数，当指定WITHSCORES时，分值也会一起返回。复杂度为O(log(N)+M)，N为有序集合基数，M为被返回元素的数量

## 10. ZREVRANGE返回指定索引范围内的降序元素

```shell
 zrevrange key start stop [WITHSCORES]
```

降序返回范围内的元素

## 11. ZRANGEBYSCORE获取指定分值范围内的升序元素

```shell
zrangebyscore key min max [WITHSCORES] [LIMIT offset count]
```

返回有序集合在按照分值升序排列的情况下，分值在min和max范围之内的所有元素，offset表示跳过多少元素，count表示返回元素数量。闭区间

复杂度为O(log(N)+M)，N为有序集合基数，M为被返回元素的数量

## 12. ZREVRANGEBYSCORE获取指定分值范围内的降序元素

```shell
zrevrangebyscore key max min [WITHSCORES] [LIMIT offset count]
```

按照降序返回分值在min与max之间的元素

## 13. ZCOUNT计算给定分值范围内的元素数量

```
zcount key min max
```

闭区间，返回分值在min和max范围内的元素数量

复杂度为O(log(N))，N为有序集合的基数

## 14. ZREMRANGEBYRANK移除指定排名范围内的升序排列元素

```shell
zremrangebyrank key start stop
```

移除有序集合中，元素按升序进行排列的情况下，指定排名范围内的所有元素，排名范围可以是正数和负数

复杂度为O(log(N)+M)，N为有序集合基数，M为被移除元素的数量

## 15. ZREMRANGEBYSCORE移除指定分值范围内的升序排列元素

```java
ZREMRANGEBYSCORE key min max
```

移除有序集合中分值介于min到max之内的所有元素。闭区间

复杂度为O(log(N)+M)，N为有序集合基数，M为被移除元素的数量，返回值为移除的数量

## 16. 示例

- 排行榜   点击量为分数

- 博客、论坛等按照时间排序分页（转换为时间戳）
- 补完功能 实际存储了一个有序集合，集合中按照使用次数进行排列

## 17. ZUNIONSTORE并集

```java
ZUNIONSTORE destination numkeys key [key ...] [WEIGHTS weight] [AGGREGATE SUM|MIN|MAX]
```

计算并集，分数会相加，复杂度O(N)+O(Mlog(M))，N为参与并集计算的元素的数量，M为结果集的基数

## 18. ZINTERSTORE交集

```java
 ZINTERSTORE destination numkeys key [key ...] [WEIGHTS weight] [AGGREGATE SUM|MIN|MAX]
```

计算交集，分数会相加，复杂度O(N\*K)+O(M\*log(M))，N为给定有序集合中技术最小的有序集合的基数，K为给定有序集合的数量，M为结果集的基数

## 19. 实例

- 使用并集计算周、月、年榜。周排行榜：一周七天进行并集，月排行榜：一个月每天进行并集，年排行榜：12个月进行并集