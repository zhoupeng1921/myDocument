package com.xhx.java;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 *  一、通道Channel:Channel表示io源与目标打开连接,Channel不能直接访问数据，Channel只能与Buffer进行交互，
 *  在noi中负责缓冲区数据的传输，本身不存储数据
 *
 *  二、通道的主要实现类
 *  java.nio.channels.Channel接口
 *      FileChannel
 *      SocketChannel
 *      ServerSocketChannel
 *      DatagramChannel
 *  三、获取通道
 *      1. java针对支持通道的类提供了getChannel()方法
 *          本地io:
 *              FileInputStream/FileOutputStream
 *              RandomAccessFile
 *          网络io:
 *              Socket
 *              ServerSocket
 *              DatagramSocket
 *       2. 在jdk1.7中的NIO.2，针对各个通道提供了静态方法open()
 *       3. 在jdk1.7中的NIO.2，的Files工具类newByteChannel()
 */
public class TestChannel {

    //1. 利用通道完成文件的复制(非直接缓冲区)
    @Test
    public void test01() throws Exception{
        FileInputStream fis = new FileInputStream("pom.xml");
        FileOutputStream fos = new FileOutputStream("pom2.xml");

        //1. 获取通道
        FileChannel inChannel = fis.getChannel();
        FileChannel outChannel = fos.getChannel();


        //2. 分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);

        //将通道中的数据写入到缓冲区
        while(inChannel.read(buf) != -1){
            buf.flip();//切换成读数据模式
            outChannel.write(buf);
            buf.clear();
        }
        outChannel.close();
        inChannel.close();
        fis.close();
        fos.close();
    }

    //2. 使用缓冲区完成文件的复制（内存映射文件）
    @Test
    public void test02() throws Exception{
        FileChannel inChannel = FileChannel.open(Paths.get("pom.xml"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("pom2.xml"), StandardOpenOption.WRITE, StandardOpenOption.READ,StandardOpenOption.CREATE_NEW);

        //内存映射文件
        MappedByteBuffer inMapBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMapBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        //直接对缓冲区进行数据的读写操作
        byte[] dst = new byte[inMapBuf.limit()];
        inMapBuf.get(dst);
        outMapBuf.put(dst);


    }




}
