package com.dao;

import com.Util.StringUtil;
import com.model.Device_add;
import com.model.Laboratory_add;
import com.model.Use_add;
import com.model.User_add;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Use_addDao {

    //添加开始使用信息
    public int add(Connection con, Use_add use_add) throws Exception {
        String sql = "insert into t_use values(?, ?, ?, ?, ?)";//插入语句
        PreparedStatement pstmt = con.prepareStatement(sql);//封装要转递的值
        pstmt.setString(1, use_add.getUserNo());
        pstmt.setString(2, use_add.getDeviceNo());
        pstmt.setString(3, use_add.getUseDate());
        pstmt.setString(4, use_add.getBeginTime());
        pstmt.setString(5, use_add.getEndTime());
        return pstmt.executeUpdate();//返回插入后的语句
    }


    //更新结束使用信息
    public static int update(Connection con, Use_add use_add) throws Exception {
        String sql = "update t_use set endTime=? where userNo=? and deviceNo=? and useDate=?";
        PreparedStatement pstmt = con.prepareStatement(sql);//封装要转递的值
        pstmt.setString(1, use_add.getBeginTime());
        pstmt.setString(2, use_add.getUserNo());
        pstmt.setString(3, use_add.getDeviceNo());
        pstmt.setString(4, use_add.getUseDate());
        return pstmt.executeUpdate();
    }

    //查询使用信息
    public ResultSet list(Connection con, Use_add use_add) throws Exception {
        //按照 使用开始时间 进行去重操作
//        StringBuffer sb = new StringBuffer("select * from t_user a, t_device b, t_use c");
//        if (StringUtil.isNotEmpty(use_add.getUserNo())) {
//            sb.append(" and a.userNo = c.userNo and c.deviceNo = b.deviceNo and a.userNo like '%" + use_add.getUserNo() + "%'");
//        }
        StringBuffer sb = new StringBuffer("select * from t_use");
        if (StringUtil.isNotEmpty(use_add.getUserNo())) {
            sb.append(" and userNo like '%" + use_add.getUserNo() + "%'");
        }
        PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
        return pstmt.executeQuery();
    }

    //删除使用信息
    public static int delete(Connection con, String d_userNo, String d_deviceNo, String d_useDate) throws Exception{
        String sql = "delete from t_use where userNo=? and deviceNo=? and useDate=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1, d_userNo);
        pstmt.setString(2, d_deviceNo);
        pstmt.setString(3, d_useDate);
        return pstmt.executeUpdate();
    }

}
