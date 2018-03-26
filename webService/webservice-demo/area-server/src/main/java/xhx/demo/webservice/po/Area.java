package xhx.demo.webservice.po;

/**
 * 区域的po类
 */
public class Area {
	//区域id	
	private String  areaid;
	
	//区域名称
	private String areaname; 
	//区域级别(0到3)
	private String arealevel;
	//父区域的id
	private String parentid;
	//开始记录号
	private Integer start;
	//结束记录号
	private Integer end;
	public String getAreaid() {
		return areaid;
	}
	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}
	public String getAreaname() {
		return areaname;
	}
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	public String getArealevel() {
		return arealevel;
	}
	public void setArealevel(String arealevel) {
		this.arealevel = arealevel;
	}
	public String getParentid() {
		return parentid;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getEnd() {
		return end;
	}
	public void setEnd(Integer end) {
		this.end = end;
	}
	@Override
	public String toString() {
		return "Area [areaid=" + areaid + ", areaname=" + areaname
				+ ", arealevel=" + arealevel + ", parentid=" + parentid
				+ ", start=" + start + ", end=" + end + "]";
	}
	
	
	
	
}
