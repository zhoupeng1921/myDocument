package xhx.demo.webservice;

import xhx.demo.webservice.service.impl.AreaServiceImpl;

import javax.xml.ws.Endpoint;

/**
 * Hello world!
 *
 */
public class AreaServer
{
    public static void main( String[] args )
    {
        Endpoint.publish("http://127.0.0.1:12345/area",new AreaServiceImpl());
    }
}
