package com.dao;

import com.Util.StringUtil;
import com.model.User_add;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class User_addDao {

    //添加用户
    public int add(Connection con, User_add user_add) throws Exception {
        String sql = "insert into t_user values(?, ?, ?, ?, ?, ?)";//插入语句
        PreparedStatement pstmt = con.prepareStatement(sql);//封装要转递的值
        pstmt.setString(1, user_add.getUserNo());
        pstmt.setString(2, user_add.getUserName());
        pstmt.setString(3, user_add.getSex());
        pstmt.setString(4, user_add.getPosition());
        pstmt.setString(5, user_add.getPhone());
        pstmt.setString(6, user_add.getPassword());
        return pstmt.executeUpdate();//返回插入后的语句
    }

    //查询用户
    public ResultSet list(Connection con, User_add user_add) throws Exception {
        StringBuffer sb = new StringBuffer("select * from t_user");
        if (StringUtil.isNotEmpty(user_add.getUserName())) {
            sb.append(" and userName like '%" + user_add.getUserName() + "%'");
        }
        PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
        return pstmt.executeQuery();
    }

    //更新用户
    public static int update(Connection con, User_add user_add) throws Exception {
        String sql = "update t_user set userName=?, sex=?, position=?, phone=?, password=? where userNo=?";
        PreparedStatement pstmt = con.prepareStatement(sql);//封装要转递的值
        pstmt.setString(1, user_add.getUserName());
        pstmt.setString(2, user_add.getSex());
        pstmt.setString(3, user_add.getPosition());
        pstmt.setString(4, user_add.getPhone());
        pstmt.setString(5, user_add.getPassword());
        pstmt.setString(6, user_add.getUserNo());
        return pstmt.executeUpdate();
    }

    //删除用户
    public static int delete(Connection con, String d_userNo) throws Exception{
        String sql = "delete from t_user where userNo=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1, d_userNo);
        return pstmt.executeUpdate();
    }

    //获取自身的信息
    public ResultSet selfList(Connection con, String userNo) throws Exception {
        StringBuffer sb = new StringBuffer("select * from t_user");
        if (StringUtil.isNotEmpty(userNo)) {
            sb.append(" and userNo like '%" + userNo + "%'");
        }
        PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
        return pstmt.executeQuery();
    }

}
