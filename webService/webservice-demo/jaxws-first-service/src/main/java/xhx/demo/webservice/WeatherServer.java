package xhx.demo.webservice;

import javax.xml.ws.Endpoint;

/**
 * 发布天气查询的服务
 */
public class WeatherServer {
    public static void main(String[] args) {
        //发布天气查询服务
        //第一个参数，webService的地址
        //第二个参数，使用webService标记的服务对象
		//http://127.0.0.1:12345/weather?wsdl 访问地址
        Endpoint.publish("http://127.0.0.1:12345/weather",new WeatherInterfaceImpl());
    }
}
