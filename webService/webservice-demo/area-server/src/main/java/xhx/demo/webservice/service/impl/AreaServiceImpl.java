package xhx.demo.webservice.service.impl;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import xhx.demo.webservice.dao.AreaDao;
import xhx.demo.webservice.dao.impl.AreaDaoImpl;
import xhx.demo.webservice.po.Area;
import xhx.demo.webservice.service.AreaService;

/**
 * @author xuhaixing
 * @date 2018/3/24 16:34
 */
public class AreaServiceImpl implements AreaService{
    private AreaDao areaDao= new AreaDaoImpl();

    @Override
    public String qeuryArea(String areaInfo) {
        //解析xml areaInfo



        return null;
    }

    /**
     * 解析请求的xml数据
     * @param areaInfo
     * @return
     * @throws Exception
     */
    private Area parseXml(String areaInfo) throws Exception{
        Area area = new Area();

        //使用dom4j解析
        Document document = DocumentHelper.parseText(areaInfo);
        document.selectSingleNode("/queryarea/parentid")

    }
}
