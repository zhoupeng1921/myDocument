package xhx.demo.webservice.service;

import xhx.demo.webservice.pojo.WeatherModel;

import java.util.List;

/**
 * 天气查询
 * @author xuhaixing
 * @date 2018/4/1 13:11
 */
public interface WeatherInterface {
    //查询三天天气
    public List<WeatherModel> queryWeather(String cityName);
}
