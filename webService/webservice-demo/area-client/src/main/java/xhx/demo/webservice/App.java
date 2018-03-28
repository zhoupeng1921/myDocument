package xhx.demo.webservice;


import xhx.demo.webservice.service.impl.AreaServiceImpl;
import xhx.demo.webservice.service.impl.AreaServiceImplService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception{
        URL url = new URL("http://127.0.0.1:12345/area?wsdl");
        QName qName = new QName("http://impl.service.webservice.demo.xhx/","AreaServiceImplService");
        //创建服务视图
        Service service = Service.create(url, qName);

        //得到portType
        AreaServiceImpl AreaServiceImpl = service.getPort(AreaServiceImpl.class);

        String requestString  = getXmlString("1.",1,15);
        //调用方法
        //发送xml数据
        String s = AreaServiceImpl.qeuryArea(requestString);
        System.out.println(s);

    }

    /*
    <?xml version="1.1"  encoding="utf-8"?>
    <queryarea>
    <parentid> </parentid>//父级区域id
    <start></start>//起始记录，从1开始
    <end></end>//结束记录
    </queryarea>

     */
    private static String getXmlString(String parentId, int start,int end ){
        String xmlString="<?xml version=\"1.1\"  encoding=\"utf-8\"?>" +
                "<queryarea>" +
                "<parentid>"+parentId+"</parentid>" +
                "<start>"+start+"</start>" +
                "<end>"+end+"</end>" +
                "</queryarea>";
        return xmlString;

    }
}
