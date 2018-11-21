package com.xhx.java.nio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class TestNIO {

    String path = "/home/xuhaixing/Documents/myDocument/java/java高并发程序设计/java-06nio-aio/";
    /**
     * 复制文件
     * Buffer中有三个重要的参数：
     * 位置position 容量capacity  上限limit
     */
    @Test
    public void test01() throws Exception{

        FileInputStream fis = new FileInputStream(path+"pom.xml");
        FileOutputStream fos = new FileOutputStream(path+"pom2.xml");
        FileChannel readChannel = fis.getChannel();
        FileChannel writeChannel = fos.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true){
            buffer.clear();
            int len = readChannel.read(buffer);
            if(len == -1){
                break;
            }
            buffer.flip();
            writeChannel.write(buffer);
        }
        readChannel.close();
        writeChannel.close();
    }


    @Test
    public void test02() throws Exception{
        RandomAccessFile raf = new RandomAccessFile(path+"pom2.xml","rw");
        FileChannel fc = raf.getChannel();
        MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, 0, raf.length());
        while (mbb.hasRemaining()){
            System.out.print((char)mbb.get());
        }
        mbb.put(0,(byte)98);//修改文件
        raf.close();

    }


}
