package xhx.demo.webservice.client;

import xhx.demo.webservice.WeatherInterfaceImpl;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class WeatherClient2 {
    public static void main(String[] args) throws Exception{

        //wsdl路径
        URL wsdlDocumentLocation = new URL("http://127.0.0.1:54321/weather?wsdl");

        //从wsdl中找到服务视图
        //第一个参数：wsdl的命名空间
        //第二个参数：服务视图名称
        QName serviceName = new QName("http://webservice.demo.xhx/","WeatherInterfaceImplService");

        //第一步使用Service创建服务视图
        Service service = Service.create(wsdlDocumentLocation,serviceName);

        //第二步 从服务视图中得到portType对象
        //参数：portType
        WeatherInterfaceImpl weatherInterface = service.getPort(WeatherInterfaceImpl.class);
        String result = weatherInterface.queryWeather("北京");
        System.out.println(result);

    }
}
