package xhx.demo.webservice.service.impl;

import xhx.demo.webservice.pojo.WeatherModel;
import xhx.demo.webservice.service.WeatherInterface;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author xuhaixing
 * @date 2018/4/1 13:12
 */
@WebService
public class WeatherInterfaceImpl implements WeatherInterface {
    @Override
    public List<WeatherModel> queryWeather(String cityName) {
        //构造三天天气
        List<WeatherModel> list=new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());


        WeatherModel weatherModel1 = new WeatherModel();
        weatherModel1.setDetail("晴");
        weatherModel1.setDate(calendar.getTime());
        weatherModel1.setTemperatureMax(28);
        weatherModel1.setTemperatureMin(16);
        WeatherModel weatherModel2 = new WeatherModel();
        weatherModel1.setDetail("多云");
        calendar.add(Calendar.YEAR,1);
        weatherModel1.setDate(calendar.getTime());
        weatherModel1.setTemperatureMax(23);
        weatherModel1.setTemperatureMin(12);
        WeatherModel weatherModel3 = new WeatherModel();
        weatherModel1.setDetail("晴");
        calendar.add(Calendar.YEAR,1);
        weatherModel1.setDate(calendar.getTime());
        weatherModel1.setTemperatureMax(29);
        weatherModel1.setTemperatureMin(20);

        list.add(weatherModel1);
        list.add(weatherModel2);
        list.add(weatherModel3);

        return list;
    }
}
