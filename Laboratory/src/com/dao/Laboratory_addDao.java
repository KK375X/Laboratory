package com.dao;

import com.Util.StringUtil;
import com.model.Device_add;
import com.model.Laboratory_add;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Laboratory_addDao {

    public int add(Connection con, Laboratory_add laboratory_add) throws Exception {
        String sql = "insert into t_laboratory values(?, ?, ?)";//插入语句
        PreparedStatement pstmt = con.prepareStatement(sql);//封装要转递的值
        pstmt.setString(1, laboratory_add.getLaboratoryNo());
        pstmt.setString(2, laboratory_add.getLaboratoryName());
        pstmt.setString(3, laboratory_add.getAddress());

        return pstmt.executeUpdate();//返回插入后的语句
    }

    //查询实验室
    public ResultSet list(Connection con, Laboratory_add laboratory_add) throws Exception {
        StringBuffer sb = new StringBuffer("select * from t_laboratory");
        if (StringUtil.isNotEmpty(laboratory_add.getLaboratoryName())) {
            sb.append(" and laboratoryName like '%" + laboratory_add.getLaboratoryName() + "%'");
        }
        PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
        return pstmt.executeQuery();
    }

    //更新实验室
    public static int update(Connection con, Laboratory_add laboratory_add) throws Exception {
        String sql = "update t_laboratory set laboratoryName=?, address=? where laboratoryNo=?";
        PreparedStatement pstmt = con.prepareStatement(sql);//封装要转递的值
        pstmt.setString(1, laboratory_add.getLaboratoryName());
        pstmt.setString(2, laboratory_add.getAddress());
        pstmt.setString(3, laboratory_add.getLaboratoryNo());
        return pstmt.executeUpdate();
    }

    //删除实验室
    public static int delete(Connection con, String d_laboratoryNo) throws Exception{
        String sql = "delete from t_laboratory where laboratoryNo=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1, d_laboratoryNo);
        return pstmt.executeUpdate();
    }

}
