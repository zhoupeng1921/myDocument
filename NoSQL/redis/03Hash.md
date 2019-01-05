# 03Hash

## 1. 介绍

 一个散列由多个域值对组成

## 2.HSET设置域值对

```shell
hset key field value
```

如果field之前没有关联值，则返回1，如果已经关联值，会用新值覆盖旧值，返回0，复杂度为O(1)	

## 3. HGET获取域关联的值

```shell
hget key field
```

返回key中域field关联的值，如果没有则返回nil，复杂度为O(1)

## 4. HSETNX仅当域不存在时设置值

```shell
HSETNX key field value
```

field不存在会设置相应的值，如果已经存在返回0，表示没有进行设置

## 5. HEXISTS检查域是否存在

```shell
hexists key field
```

检查域是否存在，存在返回1，否则返回0，复杂度为O(1)

## 6. HDEL删除给定的域值对

```shell
 hdel key field [field ...]
```

删除散列key中的一个或多个指定域，以及那些域的值，返回删除的域值对的数量

## 7. HLEN获取散列包含的键值对数量

```shell
hlen key
```

返回散列key包含的域值对的数量

## 8. HMSET一次设置多个域值对

```shell
HMSET key field value [field value ...]
```

在散列键key中关联多个域值对，相当于同时执行多个HSET，复杂度O(N)，N为输入的域值对的数量

## 9. HMGET一次获取多个域值对

```shell
HMGET key field [field ...]
```

返回散列键key中，一个或多个filed的值，复杂度O(N)，N为输入的域的数量

## 10. HKEYS获取散列所有的域

```shell
HKEYS key
```

## 11. HVALS获取散列所有域的值

```shell
HVALS key
```

## 12. HGETALL获取散列所有键值对

```shell
HGETALL key
```

## 13. 数字操作

在散列里面，域的值也可以被解释为数字，并执行相应的数字操作

### 13.1 HINCRBY增加域的值

```shell
HINCRBY key field increment
```

增加域的值，没有HDECRBY命令，需要设置负数做减法

### 13.2 HINCRBYFLOAT增加浮点数的值

```shell
HINCRBYFLOAT key field increment
```

增加浮点数的值，也是传入负值做减法

## 14. 散列的好处

- 可以将相关的信息存在同一个地方，而不是分散的存储在数据库里面，这不仅方便了数据的管理，还可以尽量避免误操作发生 
- 避免键名冲突，储存都是隔离的。例如以租户为key 
- 减少内存占用，保存相同数量的键值对信息，使用散列键比使用字符串键更节约内存。因为在数据库里面创建的每个键都带有数据库附加的管理信息，比如这个键的类型，最后一次被访问的时间等等。所以数据库里面的键越多，服务器在存储附加管理信息方面耗费的内存就越多，花在管理数据库键上的cpu也会越多。除此之外，散列包含的键值对数量比较少的时候，redis会自动使用一种占用内存非常少的数据结构来做散列的底层实现。在散列数量比较多的时候，这一措施对减少内存有很大帮助。

注意：不支持二进制位操作命令、过期功能只能针对key使用，不能针对散列的域进行过期操作。如果能用散列存储尽量用散列存储

## 15. 示例

- 多个计数器存储在一个散列中