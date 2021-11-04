//用户Dao类
//用户登录验证
package com.dao;

import com.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {

    public static User login(Connection con, User user) throws Exception {
        User resultUser = null;
        String sql = "select * from t_user where userName=? and password=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, user.getUserName());//第一个问号代表用户名
        pstmt.setString(2, user.getPassword());//第二个问号代表密码
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            resultUser = new User();
            resultUser.setUserName(rs.getString("userName"));
            resultUser.setPassword(rs.getString("password"));

            //身份判断
            resultUser.setPosition(rs.getString("position"));//返回等级
            resultUser.setUserNo(rs.getString("userNo"));//返回编号

        }
        return resultUser;
    }


}
