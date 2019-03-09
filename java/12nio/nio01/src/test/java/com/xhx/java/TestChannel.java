package com.xhx.java;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

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
 *
 *  四、通道之间的数据传输
 *  transferFrom()
 *  transferTo()
 *
 *  五、分散（scatter）与聚集（gather）
 *  分散读取（Scattering Reads）:将通道中的数据分散到多个缓冲区中
 *  聚集写入（Gathering Writes）：将多个缓冲区的数据聚集到通道中
 *
 *  六、字符集 Chartset
 *  编码：字符串转换成字节数组
 *  解码：字节数组转换成字符串
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

    //2. 使用直接缓冲区完成文件的复制（内存映射文件），可能会造成内存释放慢
    //只有ByteBuffer支持
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

    //3 通道之间数据传输(直接缓冲区)
    @Test
    public void test03() throws Exception{
        FileChannel inChannel = FileChannel.open(Paths.get("pom.xml"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("pom2.xml"), StandardOpenOption.WRITE, StandardOpenOption.READ,StandardOpenOption.CREATE_NEW);

        //inChannel.transferTo(0, inChannel.size(),outChannel);

        //也可以
        outChannel.transferFrom(inChannel,0,inChannel.size());

        inChannel.close();
        outChannel.close();

    }

    //4 分散和聚集
    @Test
    public void test04() throws Exception{
        RandomAccessFile raf1 = new RandomAccessFile("pom.xml","rw");

        //1. 获取通道
        FileChannel channel1 = raf1.getChannel();

        //2. 分配指定大小的缓冲区
        ByteBuffer buf1 = ByteBuffer.allocate(395);

        ByteBuffer buf2 = ByteBuffer.allocate(1000);

        //3.分散读取,按数组顺序依次填满
        ByteBuffer[] bufs = {buf1,buf2};
        channel1.read(bufs);

        for (ByteBuffer buffer:bufs){
            buffer.flip();
        }
        System.out.println(new String(bufs[0].array(),0,bufs[0].limit()));
        System.out.println("------------"+channel1.size());
        System.out.println(new String(bufs[1].array(),0,bufs[1].limit()));

        //聚集写入
        RandomAccessFile raf2 = new RandomAccessFile("2.xml","rw");
        FileChannel channel2 = raf2.getChannel();

        channel2.write(bufs);


    }


    @Test
    public void test05() throws Exception{
        SortedMap<String, Charset> stringCharsetSortedMap =
                Charset.availableCharsets();
        Set<Map.Entry<String, Charset>> entries =
                stringCharsetSortedMap.entrySet();
        for (Map.Entry<String,Charset> entry: entries) {
            System.out.println(entry.getKey()+"     "+entry.getValue());
        }
    }

    //字符集
    @Test
    public void test06() throws Exception{
        Charset cs1 = Charset.forName("GBK");
        //获取编码器与解码器
        CharsetEncoder ce = cs1.newEncoder();

        CharsetDecoder cd = cs1.newDecoder();

        CharBuffer cBuf = CharBuffer.allocate(1024);
        cBuf.put("哈哈哈哈哈！");
        cBuf.flip();

        //编码
        ByteBuffer bBuf = ce.encode(cBuf);
        for( int i = 0;i<12;i++){
            System.out.println(bBuf.get());
        }
        //解码
        bBuf.flip();
        CharBuffer cBuf2 = cd.decode(bBuf);
        System.out.println(cBuf2.toString());

    }


}
