package com.xhx.java;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * 2个线程之间的单向数据连接
 * Pipe有一个source通道和一个sink通道，数据会被写到sink通道，从source通道读取
 */
public class TestPipe {

    @Test
    public void test01() throws Exception{
        //1. 获取管道
        Pipe pipe = Pipe.open();

        //2. 将缓冲区的数据写入管道
        ByteBuffer buf = ByteBuffer.allocate(1024);

        Pipe.SinkChannel sinkChannel = pipe.sink();

        buf.put("通过单向管道发送数据".getBytes());
        buf.flip();
        sinkChannel.write(buf);


        //3. 读取缓冲区中的数据
        Pipe.SourceChannel sourceChannel = pipe.source();
        buf.flip();
        sourceChannel.read(buf);
        System.out.println(new String(buf.array(),0,buf.limit()));

        sourceChannel.close();
        sinkChannel.close();
    }
}
