package xhx.demo.webservice.dao;

import xhx.demo.webservice.po.Area;

import java.util.List;

/**
 * @author xuhaixing
 * @date 2018/3/13 8:51
 */
public interface AreaDao {
    //查询区域信息
    List<Area> queryAreaList(String parentid, int start, int len);

}
