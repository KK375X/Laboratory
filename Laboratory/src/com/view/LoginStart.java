package com.view;

import com.Util.DBUtil;
import com.Util.StringUtil;
import com.dao.UserDao;
import com.model.User;
import com.style.Fronts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Date;

/*
调用开始的图形化界面
 */

public class LoginStart extends JFrame {

    private JTextField userNameField;//设置用户名变量
    private JPasswordField passwordField;//设置密码变量
    private JTextField deviceNoField;//设置密码变量

    //为数据库连接做准备w
    private DBUtil dbUtil = new DBUtil();
    private final UserDao userDao = new UserDao();


    /* 设置窗口大小和位置 */
    static final int WIDTH = 500;//设置顶层框架的宽度
    static final int HEIGHT = 300;//设置顶层框架的高度

    FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);//定义布局变量，居中对齐


    public LoginStart() {
        init();//自定义方法

        setVisible(true);//设置当前窗口是否可显示
        setResizable(false);//设置窗口的大小不可变
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置默认关闭方式（关闭，非隐藏）
        validate();//让组件生效
        this.setLayout(new GridLayout(5,1));//定义五行一列式布局

    }

    void init() {

        /* 设置标题 */
        this.setTitle("实验室设备管理系统");

        /* 定义字体样式类对象 */
        Fronts fronts = new Fronts();

        /* 设置窗口大小 */
//        this.setBounds(520, 230, WIDTH, HEIGHT);
        this.setSize(520, 400);//设置窗口大小
        this.setLocationRelativeTo(null);//设置窗口居中


        /* 设置标题 */
        JLabel title = new JLabel("实验室设备管理系统");//定义标题标签
        title.setFont(Fronts.title_font);//调用样式表中的方法
        title.setForeground(Color.BLUE);//设置字体颜色

        JPanel jPanel_title = new JPanel();//创建标题的中间组件
//        jPanel_title.setBounds(0, 50, WIDTH, 50);
        jPanel_title.setLayout(flowLayout);//设置组件布局
        jPanel_title.add(title);//添加标题到中间组件
        this.add(jPanel_title);//添加到面板


        /* 设置用户名、密码和文本框 */
        JLabel userName = new JLabel("用户名：");//定义账号标签
        userName.setFont(Fronts.text_font);//设置字体样式
        userNameField = new JTextField(20);//定义账号文本框
        userNameField.setFont(Fronts.textField_font);
        JLabel password = new JLabel("密  码：");//定义密码标签
        password.setFont(Fronts.text_font);//设置字体样式
        passwordField = new JPasswordField(20);//定义密码文本框
        passwordField.setFont(Fronts.textField_font);
        JLabel deviceNo = new JLabel("设备ID：");//定义设备编号标签
        deviceNo.setFont(Fronts.text_font);//设置字体样式
        deviceNoField = new JTextField(20);//定义设备编号文本框
        deviceNoField.setFont(Fronts.textField_font);
        JPanel jPanel_account = new JPanel();//创建中间组件
        JPanel jPanel_password = new JPanel();
        JPanel jPanel_deviceNo = new JPanel();
        jPanel_account.setLayout(flowLayout);//设置布局样式
        jPanel_password.setLayout(flowLayout);
        jPanel_deviceNo.setLayout(flowLayout);
        jPanel_account.add(userName);//添加到中间组件
        jPanel_account.add(userNameField);
        jPanel_password.add(password);
        jPanel_password.add(passwordField);
        jPanel_deviceNo.add(deviceNo);
        jPanel_deviceNo.add(deviceNoField);
        this.add(jPanel_account);//添加到面板
        this.add(jPanel_password);
        this.add(jPanel_deviceNo);

        /* 设置按钮 */
        JButton login = new JButton("登录");
        login.setFont(Fronts.button_font);
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    loginActionPerformed(e);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton register = new JButton("注册");
        register.setFont(Fronts.button_font);
        register.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                new Add_user_information("普通用户");//普通用户无法创建管理员账号
            }
        });

        JButton reset = new JButton("重置");
        reset.setFont(Fronts.button_font);
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetValueActionPerformed(e);
            }
        });


        JPanel button = new JPanel();//设置按钮的中间组件
        button.add(login);//添加按钮到中间组件
        button.add(register);
        button.add(reset);
        this.add(button);//添加中间组件到面板

    }


    //登录事件处理方法
    private void loginActionPerformed(ActionEvent evt) throws Exception {
        String userName = this.userNameField.getText();//获取用户名
        String password = new String(this.passwordField.getPassword());//password返回的是数组，需要强制转换
        String deviceNo = this.deviceNoField.getText();//获取设备ID
        //判断信息是否齐全
        if (StringUtil.isEmpty(userName) || StringUtil.isEmpty(password) || StringUtil.isEmpty(deviceNo)) {
            JOptionPane.showMessageDialog(null, "请填写完整的信息！");
            return;
        }
        //封装用户名和密码
        User user = new User(userName, password);
        //数据库连接
        Connection con = null;
        try {
            con = dbUtil.getCon();
            User currentUser = UserDao.login(con, user);
            if (currentUser != null) {
                //跳转到主界面并销毁当前页面，将用户身份和用户编号作为参数传入系统中，方便对系统的等级操作
                String grade = currentUser.getPosition();
                String selfNo = currentUser.getUserNo();
                //跳转到添加使用信息的那个类中，将开始时间传入，用户工号，设备编号，调用开始使用函数，用户身份
                new Add_use_information(selfNo, deviceNo, 1, grade);
                this.dispose();//销毁登录界面
            } else {
                JOptionPane.showMessageDialog(null, "用户名或密码错误！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.closeCon(con);
        }

    }

    //重置事件处理方法----文本框直接清除
    private void resetValueActionPerformed(ActionEvent evt) {
        this.userNameField.setText("");
        this.passwordField.setText("");
        this.deviceNoField.setText("");
    }


    //主调程序
    public static void main(String[] args) {
        LoginStart loginStart = new LoginStart();
    }

}
