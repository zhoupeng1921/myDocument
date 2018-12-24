# 03List

## 1. 介绍

一个列表可以包含一个或以上数量的项，索引从0开始，列表中的项不是唯一的

## 2. LPUSH从列表左端推入

```shell
lpush key value [value ...]
```

按照给定值的顺序依次推入到列表的左端

## 3. RPUSH从列表右端推入

```shell
rpush key value [value ...]
```

按照给定的顺序依次推入到列表右端

## 4. LPOP移除并返回列表最左端的项

```shell
lpop key
```

## 5. RPOP移除并返回列表最右端的项

```shell
rpop key
```

## 6. LLEN获取列表长度

```shell
LLEN key
```

redis会记录每个列表的长度，复杂度为O(1)

## 7. LINDEX返回给定索引上的项

```shell
lindex key index
```

返回列表键key对应的索引上的列表项，复杂度为O(N)

## 8. LRANGE

```shell
lrange key start stop
```

返回key对应的索引范围内的所有列表项，闭区间，可以使整数或负数

## 9. 案例

- 使用列表实现用户时间线，列表中每一项都包含一个消息id，每次有新消息推入开始端

- 浏览记录，达到最大长度以后，头端插入一个元素，尾部删除一个元素。

  特点1.固定长度 2.先进先出

- 消息队列FIFO（下面阻塞的用法），把动态推送到消息队列，消费者消费推送给关注者,达到解耦消息推送的效果

## 10. LSET设置指定索引上的列表项

```shell
lset key index value	
```

将列表键key索引index上的值设置为value，不在索引范围内会报错。头和尾处理时复杂度为O(1)，其它情况复杂度为O(N)

## 11. LINSERT在指定位置插入列表项

```shell
linsert key BEFORE|AFTER pivot value
```

将值value插入在pivot之前或之后，如果pivot不存在，返回-1，如果key不存在，返回0，插入成功返回当前列表长度。如果有相同元素，在第一个前面插入

## 12. LREM从列表中删除指定的值

```shell
lrem key count value
```

根据参数count 的值，移除列表中与参数value相等的列表项

- count>0，从头开始向表尾搜索，移除最多count个值为vlaue的列表项
- count<0，从表尾开始向表头搜索，移除最多count绝对值个为vlaue的列表项
- count=0，移除列表中所有值为value的列表项

返回被移除的列表项的数量。命令复杂度为O(N)，N为列表的长度

## 13. LTRIM裁切列表

```shell
ltrim key start stop
```

闭区间，裁切列表

## 14. BLPOP阻塞弹出命令

```shell
blpop key [key ...] timeout
```

LPOP命令的阻塞版本，命令会以从左到右的顺序，访问给定的哥哥列表，并弹出飞空列表最左端的项，如果列表为空，会等待直到超时。

timeout为0表示永不阻塞，单位为s。复杂度O(1)，N为输入列表的数量。

如果多个客户端同时因为某个列表阻塞，那么当有新值时，服务器会按照先到先服务的原则，返回给首先被阻塞的客户端，其它客户端将不会收到

## 15. BRPOP阻塞弹出命令

```shell
BRPOP key [key ...] timeout
```

RPOP命令的阻塞版本



