package xhx.demo.webservice.dao.impl;

import xhx.demo.webservice.dao.AreaDao;
import xhx.demo.webservice.po.Area;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xuhaixing
 * @date 2018/3/24 15:47
 */
public class AreaDaoImpl implements AreaDao {
    private static String sql = "select * from area where parentid=? limit ?,?";
    public List<Area> queryAreaList(String parentid, int start, int pageSize) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        ResultSet resultSet = null;
        List<Area> areaList = new ArrayList<>();


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://192.168.94.151:3306/webservice","root","xuhaixing");
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,parentid);
            preparedStatement.setInt(2,start);
            preparedStatement.setInt(3,pageSize);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Area area = new Area();
                area.setAreaid(resultSet.getString("areaid"));
                area.setAreaname(resultSet.getString("areaname"));
                area.setArealevel(resultSet.getString("arealevel"));
                area.setParentid(resultSet.getString("arealevel"));
                areaList.add(area);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return areaList;
    }
}
