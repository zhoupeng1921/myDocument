package com.xhx.java;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * 一、缓冲区（Buffer），在java nio中负责数据的读取，缓冲区就是数组。用于存储不能数据类型的数据
 *
 * 根据数据类型不同（boolean除外），提供了相应类型的缓冲区
 *
 * ByteBuffer
 * ChartBuffer
 * ShortBuffer
 * IntBuffer
 * LongBuffer
 * FloatBuffer
 * DoubleBuffer
 *
 * 上述缓冲区的管理方式几乎一致，通过allocate()获取缓冲区
 *
 * 二、缓冲区存储数据的两个核心方法
 * put() 存数据
 * get() 获取缓冲区的数据
 *
 * 三、缓冲区中四个核心属性
 * capacity: 容量，缓冲区中最大存储数据的容量，一旦声明，不能改变
 * limit: 界限，表示缓冲区中可以操作数据的大小。（limit后面的数据不能进行读写）
 * position：位置，表示缓冲区中正在操作的位置
 *
 * mark： 标记，表示记录当前position的位置，可以通过reset()恢复到mark的位置
 *
 * 0 <= mark <= position <= limit <= capacity
 *
 * 四、直接缓冲区与非直接缓冲区
 * 非直接缓冲区：通过allocate()方法分配缓冲区，将缓冲区建立在jvm内存中
 * 非直接缓冲区：通过allocateDirect()方法分配直接缓冲区，将缓冲区建立在物理内存中。可以提高效率
 */
public class TestBuffer {

    @Test
    public void test01(){
        //1. 分配一个指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        sout(buf);
        /**
         * 0
         * 1024
         * 1024
         */

        //2. 利用put()存入数据到缓冲区中
        String str = "abc";
        buf.put(str.getBytes());
        sout(buf);
        /**
         * 3
         * 1024
         * 1024
         */

        //System.out.println((char)buf.get());//直接读，后面没有存东西，读出来是乱码

        //3. flip() 切换到读数据模式，limit到position位置，position到0位置
        buf.flip();
        sout(buf);
        /**
         * 0
         * 3
         * 1024
         */

        //4. get() 读取缓冲区中的数据
        byte[] dst = new byte[buf.limit()];
        buf.get(dst);
        System.out.println(new String(dst,0,dst.length));
        sout(buf);
        /**
         * 3
         * 3
         * 1024
         */

        //5. rewind() 可重复读数据，position重置为0,会清除remark   -1
        buf.rewind();
        sout(buf);
        /**
         * 0
         * 3
         * 1024
         */

        //6. clear():清空缓冲区,但是缓冲区中的数据依然存在,依旧能读出来，就是不知道长度多少
        buf.clear();
        sout(buf);
        /**
         * 0
         * 1024
         * 1024
         */
        System.out.println((char)buf.get());
        sout(buf);
        /**
         * a
         * 1
         * 1024
         * 1024
         */

        buf.put(str.getBytes());
        sout(buf);
    }

    private void sout(ByteBuffer buf) {
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
    }

    /**
     * reset() mark()
     */
    @Test
    public void test02(){
        String str = "abcde";
        ByteBuffer buf = ByteBuffer.allocate(1024);
        buf.put(str.getBytes());

        buf.flip();

        byte[] dst = new byte[buf.limit()];
        buf.get(dst,0,2);
        sout(buf);
        /**
         * 2
         * 5
         * 1024
         */
        buf.mark();
        buf.get(dst,0,2);
        sout(buf);
        /**
         * 4
         * 5
         * 1024
         */
        //buf.rewind(); 后再调用reset会报错,重置为-1
        buf.reset();
        sout(buf);
        /**
         * 2
         * 5
         * 1024
         */

        //position和limit之间是否还有空闲
        if(buf.hasRemaining()){
            System.out.println(buf.remaining());
            //3
        }
    }

    @Test
    public void test03(){
        //分配直接缓冲区，物理内存中开辟空间（不建议，占用内存地址，完全由操作系统去控制了）
        ByteBuffer buf = ByteBuffer.allocateDirect(1024);
        // 判断是否是直接缓冲区
        System.out.println(buf.isDirect());
    }
}
