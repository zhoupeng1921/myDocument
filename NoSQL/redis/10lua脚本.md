# lua脚本

##  1. 介绍

redis从2.6版本在服务器内部嵌入了一个lua解释器，用户可以在服务端执行lua脚本。

这个功能有一下好处：

- 可以直接在服务端执行redis命令，一般的数据处理操作可以直接使用lua语言或者lua解释器提供的函数库来完成，不必返回客户端进行处理。
- 所有脚本都是以事务的形式来执行的，脚本在执行过程中不会被其它工作打断，也不会引起任何竞争条件，完全可以使用lua脚本来代替事物和乐观锁。
- 所有脚本都是可重用的，也就是说，重复执行相同操作时，只要调用存储在服务器内部的脚本缓存就可以了，不用重新发送整个脚本，从而尽可能地节约网络资源。

## 2. 执行lua脚本

```shell
eval script numkeys key [key ...] arg [arg ...]
```

script参数是要执行的lua脚本

numkeys是脚本要处理的数据库键的数量，之后的key[key...]参数指定了脚本要处理的数据库键，被传入的键可以在脚本里通过访问KEYS数组来取得，比如KEYS[1]就取出第一个输入的键，KEYS[2]就取出第二个输入的键。KEYS必须是大写

arg[arg...]参数指定了脚本要用到的参数，在脚本里可以通过访问ARGV数组来获取这些参数 。ARGV必须是大写

显示的指定了脚本里面用到的键是为了配合redis集群对键的检查，如果不这样的话，在集群里使用脚本可能会出错。

另外，通过显示的指定脚本要用到的数据库键以及相关参数，而不是将数据库键和参数硬写在脚本里面，用户可以更方便的重用一个脚本。

```shell
127.0.0.1:6379> eval "return {KEYS[1],KEYS[2], ARGV[1]} " 2 msg msg2 'hello'
msg
msg2
hello
```

## 3. 在lua脚本中执行redis命令

通过调用redis.call()函数或者redis.pcall()函数，我们可以直接在lua脚本里面执行redis命令。可以用`..`进行拼接

```
127.0.0.1:6379> eval "return redis.call('get', KEYS[1])" 1 msg
aa
127.0.0.1:6379> eval "return 'the dbsize is '..redis.call('dbsize')" 0
the dbsize is 2
127.0.0.1:6379> eval "return redis.call('ping')" 0
PONG

```

redis.call()与redis.pcall()区别：在执行脚本出错时，redis.call()会返回出错脚本的名字以及eval命令的错误信息，而redis.pcall()只返回eval命令的错误信息

执行lua文件脚本：KEYS与ARGV参数用`,`分割，并且`,`两边有空格

```shell
[xuhaixing@localhost lua]$ cat zdecrby.lua 
local old_score = redis.call('zscore',KEYS[1],ARGV[2])
local new_score = old_score - ARGV[1]
return redis.call('zadd',KEYS[1],new_score,ARGV[2])
[xuhaixing@localhost lua]$ redis-cli -a xuhaixing --eval zdecrby.lua salary , 500 xiaohong
(integer) 0

```

## 4. 使用EVALSHA来减少网络资源损耗

任何lua脚本，只要被eval命令执行过一次，就会被存储到服务器的脚本缓存里，用户只要通过evalsha命令，执行缓存脚本的sha1值，就可以在不发送脚本的情况下，再次执行脚本

```shell
evalsha sha1 numkeys key [key ...] arg [arg ...]
```

## 5. 脚本管理命令

1. ```shell
   script exists sha1[sha1...]
   ```

   检查sha1值所代表的脚本是否已经被加入到脚本缓存里，是返回1，否返回0

2. ```shell
   SCRIPT LOAD script
   ```

   将脚本存储到脚本缓存里，等待将来evalsha使用

3. ```shell
   SCRIPT FLUSH
   ```

   清除脚本缓存的所有脚本

4. ```shell
   SCRIPT KILL
   ```

   杀死运行超时的脚本，如果脚本已经执行过写入命令，那么还需要使用shutdown nosave命令来强制服务器不保存数据，以免错误的数据被保存到数据库里面

## 6. 函数库

redis在lua环境里载入了一些常用的函数库，我们可以使用这些函数库，直接放在脚本里面处理数据

标准库：

- base库: 包含lua的核心函数：assert,tostring,error,type等
- string库: 包含用于处理字符串的函数，find,format,len,reverse等
- table库: 包含用于处理表格的函数，concat,insert,remove,sort等
- math库: 包含常用的数学计算函数，比如abs,sqrt,log等
- debug库: 包含调试程序所需的函数，sethook,gethook等

外部库：

- struct库: 在c语言的结构和lua语言的值之间进行转换
- cjson库: 将lua值转换为json对象或者将json对象转换为lua值
- cmsgpack库: 将lua值编码为messagepack格式，或者从messagepack格式里解码出lua值

还有一个用于计算sha1值的外部函数redis.sha1hex.