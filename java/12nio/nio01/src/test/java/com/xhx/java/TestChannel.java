package com.xhx.java;

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


}
