package xhx.demo.webservice;

import xhx.demo.webservice.service.impl.AreaServiceImpl;

import javax.xml.ws.Endpoint;

/**
 * Hello world!
 *
 */
public class AreaServer
{
    /**
     * wsimport -s . http://127.0.0.1:12345/area?wsdl
     * 生成的包名为wsdl命名空间的倒序
     *
     * @param args
     */
    public static void main( String[] args )
    {
        Endpoint.publish("http://127.0.0.1:12345/area",new AreaServiceImpl());
    }
}
