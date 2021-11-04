package com.view;

import com.Util.DBUtil;
import com.dao.Use_addDao;
import com.dao.User_addDao;
import com.model.Use_add;
import com.model.User_add;

import javax.swing.*;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//该类自动添加设备使用信息，不显示操作界面，信息添加完成后，自动跳转到主界面
public class Add_use_information {

    //定义数据库操作的对象
    private DBUtil dbUtil = new DBUtil();
    private Use_addDao use_addDao = new Use_addDao();


    //传入时间，用户编号，设备编号，调用某个函数标识
    public Add_use_information(String userNo, String deviceNo, int flag, String grade) throws Exception {

        //获取当前日期
        Date date = new Date();
        SimpleDateFormat ymd = new SimpleDateFormat("yyyy年MM月dd日");
        //获取一个随机数添加到日期后面，防止主键约束
//        Double random = Math.random();
//        DecimalFormat d = new DecimalFormat();
        //将日期和随机数拼接
        String nowDay = ymd.format(date);

        //获取当前时分秒
        SimpleDateFormat hms = new SimpleDateFormat("HH:mm:ss");
        String nowTime = hms.format(date);

        if (flag == 1) {
            //调用开始使用时间函数
            beginUseDeviceUpdateTime(userNo, deviceNo, nowDay, nowTime, grade);
        } else {
            //调用结束使用时间函数
            endUseDeviceUpdateTime(userNo, deviceNo, nowDay, nowTime);
        }

    }

    //开始使用数据的录入
    private void beginUseDeviceUpdateTime(String userNo, String deviceNo, String nowDay, String nowTime, String grade) throws Exception {

        //实例化设备信息，将使用结束时间设置为"正在使用中"
        Use_add use_add = new Use_add(userNo, deviceNo, nowDay, nowTime, "正在使用");

        //数据库连接，添加使用信息到使用表中
        Connection con = null;
        try {
            con = dbUtil.getCon();
            int item = use_addDao.add(con, use_add);//封装传到数据库，并获取返回值
            if (item == 1) {
                //开始使用信息添加成功，跳转到主界面
                //将用户职位、工号、设备ID传递下去
                new MainView(grade, userNo, deviceNo);//跳转到主界面
            } else {
                JOptionPane.showMessageDialog(null, "登录失败！");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "登录失败！");
        } finally {
            dbUtil.closeCon(con);//关闭数据库连接
        }

    }

    //结束使用数据的录入，只需要把结束使用结束添加进去就行，相当于更新，由于结束后就关闭系统了，所以不需要传递用户身份了
    private void endUseDeviceUpdateTime(String userNo, String deviceNo, String nowDay, String nowTime) {

        //实例化设备信息，将使用结束时间设置为null
        Use_add use_add = new Use_add(userNo, deviceNo, nowDay, nowTime, null);

        //数据库连接
        Connection con = null;
        try {
            con = dbUtil.getCon();
            int modifyNum = Use_addDao.update(con, use_add);
            //如果modifyNum为1，则直接退出系统；如果不为1，则弹出提示框
            if (modifyNum != 1) {
                JOptionPane.showMessageDialog(null, "退出失败，请重试！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                dbUtil.closeCon(con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
