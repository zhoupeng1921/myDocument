package xhx.demo.webservice;

import xhx.demo.webservice.service.impl.WeatherInterfaceImpl;

import javax.xml.ws.Endpoint;

/**
 * Hello world!
 */
public class WeatherServer {
    public static void main(String[] args) {
        Endpoint.publish("http://127.0.0.1:12345/weather",new WeatherInterfaceImpl());
    }
}
