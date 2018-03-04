package xhx.demo.webservice;


import javax.jws.WebService;

//使用@WebService标记该类为webService的服务类
@WebService
public class WeatherInterfaceImpl implements WeatherInterface {

    public String queryWeather(String cityName) {
        //使用静态数据
        String result = "晴";


        return result;
    }
}
