package com.xhx.socket.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class WeatherServer {
    public static void main(String[] args) throws Exception {
        //创建socket服务端
        ServerSocket serverSocker = new ServerSocket(12345);
        System.out.println("启动天气的查询服务....");

        Socket socket = null;
        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;
        //接收客户端连接
        socket = serverSocker.accept();
        //接收客户端请求数据
        dataInputStream = new DataInputStream(socket.getInputStream());
        String cityName = dataInputStream.readUTF();

        //向客户端发送数据
        dataOutputStream = new DataOutputStream(socket.getOutputStream());

        //查询天气信息
        String result = "晴朗";
        dataOutputStream.writeUTF(result);


    }
}
