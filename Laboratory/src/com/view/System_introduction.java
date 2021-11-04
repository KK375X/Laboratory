package com.view;

import com.style.Fronts;

import javax.swing.*;
import java.awt.*;

public class System_introduction extends JFrame {

    //创建字体样式类对象
    Fronts fronts = new Fronts();

    public System_introduction() {
        setTitle("系统介绍");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭方式
        setLayout(new GridLayout(10, 1));//设置系统布局为5行一列
        setSize(1000, 600);//设置窗口大小
        setLocationRelativeTo(null);//设置窗口居中
        setVisible(true);//显示窗口
        setResizable(false);//设置窗口的大小不可变

        JLabel title = new JLabel("  系统介绍");
        title.setFont(Fronts.title_font);
        title.setForeground(Color.blue);
        this.add(title);

        //填写对该系统的介绍
        JLabel jTextField_1 = new JLabel("  1、退出该系统时，请点击“安全退出”，否则将无法记录您的使用信息。");
        jTextField_1.setFont(Fronts.Text_font);
        this.add(jTextField_1);

        JLabel jTextField_2 = new JLabel("  2、如果在操作过程中出现问题，请及时联系系统管理员，联系电话为：198xxxxxxxx。");
        jTextField_2.setFont(Fronts.Text_font);
        this.add(jTextField_2);

        JLabel jTextField_3 = new JLabel("  3、管理员拥有最高权限，教师其次，学生只允许查看、增添、修改个人信息和部分操作。");
        jTextField_3.setFont(Fronts.Text_font);
        this.add(jTextField_3);

        JLabel jTextField_4 = new JLabel("  4、如果需要注册管理员账户，可以由其他管理员代为注册。");
        jTextField_4.setFont(Fronts.Text_font);
        this.add(jTextField_4);

        JLabel jTextField_5 = new JLabel("  5、用户如果需要修改账户密码，可以联系管理员，或者在个人信息里进行修改。");
        jTextField_5.setFont(Fronts.Text_font);
        this.add(jTextField_5);


    }


    public static void main(String[] args) {
        System_introduction system_introduction = new System_introduction();
    }

}
