# Set

## 1. 介绍

redis set集合以无序的方式存储多个各不相同的元素，不会重复

## 2.SADD添加元素

```shell
sadd key member [member ...]
```

将一个或多个元素添加到集合里面，返回新添加集合的元素数量，复杂度为O(N),N为成功添加的元素数量

## 3. SREM移除元素

```shell
srem key member [member ...]
```

移除集合中的一个或多个元素，返回被移除元素的数量。复杂度为O(N),N为被删除元素的数量

## 4. SISMEMBER检查元素是否在给定集合

```shell
SISMEMBER key member
```

检查给定的键是否存在于集合，存在返回1，否则返回0

## 5. SCARD返回集合大小

```shell
scard key
```

返回集合的长度，复杂度为O(1)

## 6.SMEMBERS返回集合的所有元素

```shell
smembers key
```

返回集合所有元素，复杂度为O(N)，N为集合的大小。数量比较大时，会造成服务器阻塞

## 7. 示例

- 赞、签到、投票等
- 标签
- 抽奖（下面的用法）

## 8. SPOP从集合里随机地弹出元素

```shell
spop key [count]
```

从集合里随机的弹出count个元素，不指定count弹出一个

## 9. SRANDMEMBER

```shell
srandmember key [count]
```

从集合中随机的返回count个元素，不会移除元素，不指定count弹出一个

count>0  返回count个元素，如果count大于集合长度返回整个集合

count<0  返回的数据可能会出现重复，数量为count的绝对值

## 10. SDIFF计算所有给定集合的差集，并返回结果

```shell
sdiff key1 [key2 ...]
```

计算所有给定集合的差集，并返回结果。key1有其它集合没有。复杂度O(N)

## 11. SDIFFSTORE计算所有给定集合的差集，存到destkey中

```shell
SDIFFSTORE destination key1 [key2 ...]
```

返回差集元素的数量

## 12. SINTER计算交集，并返回结果

```shell
sinter key [key ...]
```

复杂度O(N*M)，N为给定集合当中基数最小的集合，M为给定集合的个数

## 13. SINTERSTORE计算交集并存储到destkey中

```shell
sinterstore destination key [key ...]
```

返回交集元素的数量

## 14. SUNION计算并集，并返回结果

```shell
SUNION key [key ...]
```

复杂度为O(N),N为参与运算的元素的数量

## 15. SUNIONSTORE计算并集并存储到destkey中

```shell
SUNIONSTORE destination key [key ...]
```

 返回并集元素的数量

## 16. 示例

- 实现共同关注功能
- 筛选功能 - 每次计算太慢，可以预先计算好，存储起来