package xhx.demo.webservice.service.impl;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import xhx.demo.webservice.dao.AreaDao;
import xhx.demo.webservice.dao.impl.AreaDaoImpl;
import xhx.demo.webservice.po.Area;
import xhx.demo.webservice.service.AreaService;

import javax.jws.WebService;
import java.util.List;

/**
 * @author xuhaixing
 * @date 2018/3/24 16:34
 */
@WebService
public class AreaServiceImpl implements AreaService {
    private AreaDao areaDao = new AreaDaoImpl();

    public String qeuryArea(String areaInfo) {
        String responseString = null;
        try {
            //解析xml areaInfo
            Area area = parseXml(areaInfo);
            List<Area> areaList = areaDao.queryAreaList(area.getParentid(), area.getStart() - 1, area.getEnd() - area.getStart() + 1);
            responseString = parseXmlFromAreaList(areaList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseString;
    }

    //根据list解析生产xml
    private String parseXmlFromAreaList(List<Area> areas) throws Exception {
        Document document = DocumentHelper.createDocument();
        Element root = DocumentHelper.createElement("areas");
        document.add(root);
        for (Area area : areas) {
            String areaId = area.getAreaid();
            String areaName = area.getAreaname();
            String areaLevel = area.getArealevel();
            String parentId = area.getParentid();
            Element areaElement = DocumentHelper.createElement("area");
            //向root节点填充数据
            areaElement.addElement("areaId").addText(areaId);
            areaElement.addElement("areaName").addText(areaName);
            areaElement.addElement("areaLevel").addText(areaLevel);
            areaElement.addElement("parentId").addText(parentId);
            root.add(areaElement);
        }
        return document.asXML();
    }


    /**
     * 解析请求的xml数据
     *
     * @param areaInfo
     * @return
     * @throws Exception
     */
    private Area parseXml(String areaInfo) throws Exception {
        Area area = new Area();

        //使用dom4j解析
        Document document = DocumentHelper.parseText(areaInfo);
        String parentId = document.selectSingleNode("/queryarea/parentid").getText();
        String start = document.selectSingleNode("/queryarea/start").getText();
        String end = document.selectSingleNode("/queryarea/end").getText();
        area.setParentid(parentId);
        area.setStart(Integer.valueOf(start));
        area.setEnd(Integer.valueOf(end));
        return area;
    }
}
