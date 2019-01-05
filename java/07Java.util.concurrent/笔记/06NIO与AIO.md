# NIO与AIO

## 什么是NIO

### 介绍

NIO是New I/O的简称，与旧式的基于流的I/O方法相对，从名字看，它表示新的一套Java I/O标准。jdk1.4引入

- NIO是基于块（Block）的，它以块为基本单位处理数据
- 为所有原始类型提供（Buffer）缓存支持
  - ByteBuffer
  - CharBuffer
  - DoubleBuffer
  - FloatBuffer
  - IntBuffer
  - LongBuffer
  - ShortBuffer
- 增加通道（Channel）对象，作为新的原始I/O对象
- 支持锁和内存映射文件的文件访问接口
- 提供了基于Selector的异步网络I/O

### 例子

```java
FileInputeStream fin = new FileIntputStream(new File("/home/xuhaixing/aaa.txt"));
FileChannel fc = fin.getChannel();

ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
fc.read(byteBuffer);

fc.close();
byteBuffer.flip();
```



### buffer

Buffer中有三个重要的参数：

- 位置position 
- 容量capacity  
- 上限limit

| 参数 | 写模式                                                       | 读模式                                       |
| ---- | ------------------------------------------------------------ | -------------------------------------------- |
| 位置 | 当前缓冲区的位置，将从position的下一个位置写数据             | 当前缓冲区的位置，将从此位置后读取数据       |
| 容量 | 缓存区总容量上限                                             | 缓存区总容量上限                             |
| 上限 | 缓冲区的实际上限，它总是小于等于容量，通常情况下，和容量相等 | 可读取的总容量，和上次写入buffer的数据量相等 |

写入时，capacity和limit不会变，会把position向后移动

#### filp()：

- 该操作会重置position，把limit放到position的位置，并清除标志位mark
- 通常，将buffer从写模式转换到读模式需要执行此方法

#### rewind()

- 将position置零，并清除标志位

#### clear()

- 将position置零，同时将limit设置为capacity的大小，并清楚了标志mark