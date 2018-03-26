package xhx.demo.webservice.service;

/**
 * @author xuhaixing
 * @date 2018/3/24 15:59
 */
public interface AreaService {

    /**
     * 查询区域 areaInfo xml串，包括
     *  parentid 区域父节点
     *  start 起始下标 从1开始
     *  end  结束下表
     * @return
     */
    String qeuryArea(String areaInfo);
}
