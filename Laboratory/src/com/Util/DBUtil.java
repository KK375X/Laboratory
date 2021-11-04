package com.Util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

    private String dbUrl = "jdbc:mysql://localhost:3306/laboratory";//数据库连接地址
    private String dbUserName = "root";//用户名
    private String dbPassword = "934087731";//密码
    private final String jdbcName = "com.mysql.cj.jdbc.Driver";//驱动名称

    //获取数据库连接
    public Connection getCon() throws Exception {
        Class.forName(jdbcName);
        Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        return con;
    }

    //关闭数据库连接
    public void closeCon(Connection con) throws Exception {
        if (con != null) {
            con.close();
        }
    }

}
