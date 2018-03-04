package com.xhx.socket.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.sql.ResultSet;

public class WeatherClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1",12345);

        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream =null;

        dataOutputStream = new DataOutputStream(socket.getOutputStream());
        String cityName = "北京";
        dataOutputStream.writeUTF(cityName);

        dataInputStream = new DataInputStream(socket.getInputStream());
        System.out.println("from server..."+ dataInputStream.readUTF());
    }
}
