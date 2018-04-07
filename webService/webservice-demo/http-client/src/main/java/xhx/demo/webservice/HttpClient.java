package xhx.demo.webservice;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author xuhaixing
 * @date 2018/3/7 20:12
 */
public class HttpClient {
    public static void main(String[] args) throws Exception{
        URL url = new URL("http://127.0.0.1:12345/weather?wsdl");
        HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
        //POST必须大写
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Content-Type","text/xml;charset=utf-8");

        //设置请求和响应
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);

        String requestString = requestString("郑州");

        //发送soap协议
        httpURLConnection.getOutputStream().write(requestString.getBytes());

        //接收相应内容
        InputStream inputStream = httpURLConnection.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int len  = 1;
        byte[] b= new byte[1024];
        //将inputStream内容写到byteArrayOutputStream中
        while ((len=inputStream.read(b,0,1024))!=-1){
            byteArrayOutputStream.write(b,0,len);
        }

        String responseString = byteArrayOutputStream.toString();
        System.out.println(requestString);
        inputStream.close();
        byteArrayOutputStream.close();

        //解析xml数据




    }

    private static String requestString(String city) {

        String xmlString = "";

        return xmlString;
    }


}
