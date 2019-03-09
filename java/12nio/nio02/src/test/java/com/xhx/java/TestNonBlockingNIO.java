package com.xhx.java;


import org.junit.Test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.time.LocalDateTime;
import java.util.Iterator;

/**
 * 非阻塞模式相较于网络io，File没有非阻塞
 * 一、使用NIO完成网络通信的三个核心
 * 1. 通道Channel:负责连接
 * java.nio.channels.Channel 接口
 *  SelectableChannel
 *      SocketChannel
 *      ServerSocketChannel
 *      DatagramChannel
 *
 *      Pipe.SinkChannel
 *      Pipe.SourceChannel
 * 2. 缓冲区Buffer：负责数据获取
 * 3. 选择器Selector:是SelectableChannel的多路复用器。用于监控SelectableChannel的IO状况
 */
public class TestNonBlockingNIO {


    //客户端
    @Test
    public void client() throws Exception{
        //1. 获取通道
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));

        //2. 切换成非阻塞模式
        SelectableChannel selectableChannel = sChannel.configureBlocking(false);

        //3. 分配指定大小缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);

        //4. 发送数据给服务端
        buf.put(LocalDateTime.now().toString().getBytes());

        buf.flip();

        sChannel.write(buf);
        buf.clear();

        //5. 关闭通道
        sChannel.close();



    }

    //服务端
    @Test
    public void server() throws Exception{
        //1. 获取通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        //2. 设置非阻塞模式
        ssChannel.configureBlocking(false);
        //3. 绑定连接
        ssChannel.bind(new InetSocketAddress(9898));

        //4. 获取选择器
        Selector selector = Selector.open();

        //5. 将通道注册到选择器上,并且指定监听接收事件
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);

        //6. 轮询的获取选择器上已经 准备就绪 的事件
        while(selector.select()>0){
            //7. 获取当前选择器中所有注册的 已就绪的监听事件
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()){
                //8. 获取准备就绪的事件
                SelectionKey sk = it.next();
                //9. 判断具体是什么事件准备就绪
                if(sk.isAcceptable()){
                    //10. 获取客户端连接
                    SocketChannel sChannel = ssChannel.accept();
                    //11. 切换非阻塞模式
                    sChannel.configureBlocking(false);

                    //12. 将该通道注册到选择器上
                    sChannel.register(selector,SelectionKey.OP_READ);

                }else if(sk.isReadable()){
                    //13. 获取当前选择器上 读就绪 状态的通道
                    SocketChannel sChannel = (SocketChannel)sk.channel();

                    //14. 读数据
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    while(sChannel.read(buf) != -1){
                        buf.flip();
                        System.out.println(new String(buf.array(),0,buf.limit()));
                        buf.clear();
                    }
                }
                //取消选择键
                it.remove();

            }

        }
    }

}
