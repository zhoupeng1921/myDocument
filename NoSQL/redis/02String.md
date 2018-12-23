# 02String

## 1. 介绍

Redis中最简单的数据结构，既可以存储文字，可以存储数字，还可以存储二进制，Redis为这集中类型的值分别设置了相应的操作命令，让用户可以针对不同的值做不同的处理。

## 2. SET为字符串键设置值

```shell
set key value [EX seconds] [PX milliseconds] [NX|XX]
```



将字符串键key的值设置为value，命令返回OK表示设置成功。如果键已经存在，会覆盖原来的值。

复杂度为O(1)

- [NX] 如果设定了NX选项，那么命令仅在键key不存在的情况下才进行设置。

- [XX] 如果设定了XX选项，那么命令仅在key已经存在的情况下，才进行设置。

在给定NX与XX选项的情况下，SET命令设置成功时返回OK，设置失败时返回nil

## 3. GET获取字符串的值

```shell
get key
```

## 4. SETNX仅在键不存在的情况下进行设置

```shell
SETNX key value
```



效果和SET key value NX一样。键不存在并且设置成功时，命令返回1，因为键存在而导致设置失败时，返回0。复杂度为O(1)

## 5. MSET 同时设置多个字符串的值

```shell
 mset key value [key value ...]
```

一次为一个或多个字符串设置值，效果和同时执行多个SET命令一样，命令返回OK，复杂度O(N),N为要设置的字符串键数量

## 6.MGET 同时获取多个字符串键的值

```shell
mget key [key ...]
```

一次返回一个或多个字符串键的值，效果和同时执行多个GET命令一样，复杂度O(N),N为要获取字符串键的数量

## 7. MSETNX一次设置多个不存在的键

```shell
MSETNX key value [key value ...]
```

只有在所有给定的键都不存在的情况下，MSETNX会为所有给定键设置值，效果和同时执行多个SETNX一样。如果有一个失败，将不执行任何操作

返回1表示设置成功，返回0表示设置失败，复杂度为O(N),N为给定的键的数量

## 8. GETSET设置新值返回旧值

```shell
GETSET key value
```

将字符串键的值设置为new-value，并返回旧值，复杂度为O(1)

## 9. APPEND追加内容到末尾

```shell
APPEND key value
```

将vlaue值推入到key对应value的末尾，若key不存在，会新建这个key

O(N)，N为value的长度

## 10. STRLEN返回值的长度

```shell
strlen key
```

返回键key对应的值的长度，因为redis会记录每个字符串的长度，所以获取该值的复杂度为O(1)，若key不存在，返回0

## 11. 索引

从开头到末尾为0～N-1

从末尾到开头-N~-1

### 11.1 SETRANGE设置范围

```shell
SETRANGE key offset value
```

从索引offset开始，用value覆盖原来的值，只接受正数索引，返回值为复写后值的长度。

复杂度为O(N)，N为value的长度

### 11.2 GETRANGE范围取值

```shell
getrange key start end
```

返回start到end之间的内容，闭区间。可以是正数也可以是负数，start到end必须是从左到右的顺序，否则返回空。复杂度为O(N)，N为被选中内容的长度

```shell
127.0.0.1:6379> set name 'abcdefghi'
OK
127.0.0.1:6379> getrange name 0 -1
"abcdefghi"
127.0.0.1:6379> getrange name 0 -2
"abcdefgh"
127.0.0.1:6379> getrange name 1 -1
"bcdefghi"
127.0.0.1:6379> getrange name -5 -3
"efg"
127.0.0.1:6379> getrange name -5 -5
"e"
127.0.0.1:6379> getrange name 2 1
""
127.0.0.1:6379> getrange name -1 2
""
```

## 12. 数字操作

只要存储在字符串键里面的值可以被解释为64位整数，或者IEEE-754标准的64位浮点数，那么就可以对字符串键执行对数字值的命令

| 值                          | 能否执行数字指令 | 原因                           |
| --------------------------- | ---------------- | ------------------------------ |
| 10086                       | 可以             | 值可以被解释为整数             |
| 3.14                        | 可以             | 值可以被解释为浮点数           |
| +123                        | 可以             | 值可以被解析为整数             |
| 123456789123456789123456789 | 不可以           | 值太大，没办法用64位整数来存储 |
| 2.0e7                       | 不可以           | 不支持科学计数法               |
| 123QWE                      | 不可以           | 包含文字                       |

### 12.1 INCRBY增加指定数字的值

```shell
incrby key increment
```

将key所对应的值，增加increment，返回计算后的key的值，复杂度O(1)，如果执行时key不存在，则默认初始化为0

### 12.2 DECRBY减少指定数字的值

```
decrby key decrement
```

将key所对应的值，减少increment，返回计算后的key的值，复杂度O(1)，如果执行时key不存在，则默认初始化为0

### 12.3 INCR增加1

```shell
incr key
```

### 12.4 DECR减少1

```shell
decr key
```

### 12.5 实例

- 计数器 例如被点击次数
- id生成器 

### 12.6 INCRBYFLOAT浮点数自增自减

```shell
incrbyfloat key increment
```

没有自减方法，可以通过给定负值来达到自减的效果

## 13. 二进制数据操作

和存储字符串不一样，在存储二进制时，二进制位的索引会从右到左依次递增

### 13.1 SETBIT设置二进制位的值

```shell
setbit key offset value
```

对给定索引位置设置值，返回旧值

### 13.2 GETBIT获取二进制位的值

```shell
getbit key offset
```

返回给定索引上的二进制位的值

### 13.3 BITCOUNT计算值为1的二进制位的数量

```shell
bitcount key [start end]
```

计算并返回字符串键对应的值中，被设置为1的二进制位的数量

### 13.4 BITOP二进制位运算

```shell
bitop operation destkey key [key ...]
```

operation可以使 and/or/not/xor中的任意一种操作（并、或、非、异或），将结果赋到destkey中，除了not操作外，其它操作都可以接受一个或以上数量的key作为输入。复杂度为O(N)，N为进行计算的二进制位数量的总和。命令返回值为计算所得结果的字节长度，相当于对destkey执行STRLEN操作

### 13.5 案例

- 在线用户统计，每个用户的id对应一个二进制位，为1表示在线，为0表示不在线 ，缺点每次统计复杂度为O(N)

- 缓存热门图片

### 14. 注意

- 一个英文字符需要单个字节来存储，而一个中文字符需要多个字节来存储，登录redis时使用--raw选项，可以正常显示中文，不要使用STRLEN,SETRANGE,GETRANGE来处理中文，是按照字节操作的，不是按照字符操作的

```shell
[xuhaixing@localhost init.d]$ redis-cli -a xuhaixing -p 6379 --raw
127.0.0.1:6379> get msg
你好
127.0.0.1:6379> strlen msg
6

```

