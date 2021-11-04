//设备增添
package com.dao;

import com.Util.StringUtil;
import com.model.Device_add;
import com.model.User_add;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Device_addDao {

    public int add(Connection con, Device_add device_add) throws Exception {
        String sql = "insert into t_device values(?, ?, ?, ?, ?)";//插入语句
        PreparedStatement pstmt = con.prepareStatement(sql);//封装要转递的值
        pstmt.setString(1, device_add.getDeviceNo());
        pstmt.setString(2, device_add.getDeviceName());
        pstmt.setString(3, device_add.getPrice());
        pstmt.setString(4, device_add.getProducer());
        pstmt.setString(5, device_add.getLaboratory());

        return pstmt.executeUpdate();//返回插入后的语句
    }

    //查询设备
    public ResultSet list(Connection con, Device_add device_add) throws Exception {
        StringBuffer sb = new StringBuffer("select * from t_device");
        if (StringUtil.isNotEmpty(device_add.getDeviceName())) {
            sb.append(" and deviceName like '%" + device_add.getDeviceName() + "%'");
        }
        PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
        return pstmt.executeQuery();
    }

    //更新设备
    public static int update(Connection con, Device_add device_add) throws Exception {
        String sql = "update t_device set deviceName=?, price=?, producer=?, laboratoryNo=? where deviceNo=?";
        PreparedStatement pstmt = con.prepareStatement(sql);//封装要转递的值
        pstmt.setString(1, device_add.getDeviceName());
        pstmt.setString(2, device_add.getPrice());
        pstmt.setString(3, device_add.getProducer());
        pstmt.setString(4, device_add.getLaboratory());
        pstmt.setString(5, device_add.getDeviceNo());
        return pstmt.executeUpdate();
    }

    //删除设备
    public static int delete(Connection con, String d_deviceNo) throws Exception{
        String sql = "delete from t_device where deviceNo=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1, d_deviceNo);
        return pstmt.executeUpdate();
    }

}
