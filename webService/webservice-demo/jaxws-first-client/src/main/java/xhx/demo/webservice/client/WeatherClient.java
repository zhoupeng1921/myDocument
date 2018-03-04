package xhx.demo.webservice.client;

import xhx.demo.webservice.WeatherInterfaceImpl;
import xhx.demo.webservice.WeatherInterfaceImplService;

/**
 * jaxws天气客户端
 */
public class WeatherClient {
    public static void main(String[] args) {
        //创建服务视图对象
        WeatherInterfaceImplService weatherInterfaceImplService = new WeatherInterfaceImplService();
        //通过服务视图得到portType(接口类型)
        WeatherInterfaceImpl weatherInterfaceImplPort = weatherInterfaceImplService.getWeatherInterfaceImplPort();

        //调用webService
        String weather = weatherInterfaceImplPort.queryWeather("郑州");
        System.out.println(weather);
    }
}
