package xhx.demo.webservice.pojo;

import java.util.Date;

/**
 * @author xuhaixing
 * @date 2018/4/1 13:08
 */
public class WeatherModel {
    //天气状况
    private String detail;

    //日期
    private Date date;

    //最高温度
    private  int temperatureMax;

    //最低温度
    private int temperatureMin;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(int temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public int getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(int temperatureMin) {
        this.temperatureMin = temperatureMin;
    }
}
