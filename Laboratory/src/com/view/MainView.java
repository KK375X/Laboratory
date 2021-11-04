package com.view;

import com.style.Fronts;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainView extends JFrame {

    //创建字体样式类对象
    Fronts fronts = new Fronts();

    //构造函数
    public MainView(String grade, String self, String deviceNo) {

        setTitle("实验室设备管理系统主界面");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭方式
        setSize(1000, 600);//设置窗口大小
        setLocationRelativeTo(null);//设置窗口居中
        setVisible(true);//显示窗口

        JMenuBar menuBar = new JMenuBar();//创建菜单栏
        setJMenuBar(menuBar);


        JMenu menu_1 = new JMenu("用户信息管理");//创建第一个栏目
        menu_1.setFont(Fronts.menu_font);
        menuBar.add(menu_1);//添加到菜单栏

        JMenuItem menu_1_1 = new JMenuItem("我的信息");//创建第一个栏目的第一个项目
        menu_1_1.setFont(Fronts.menu_font);
        menu_1.add(menu_1_1);//添加到第一个栏目里
        menu_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                personalSelf pS = null;
                try {
                    pS = new personalSelf(grade, self);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        JMenuItem menu_1_2 = new JMenuItem("用户信息维护");
        menu_1_2.setFont(Fronts.menu_font);
        menu_1.add(menu_1_2);
        menu_1_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    new User_List(grade, self);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        //管理员身份进入，有添加用户的权力
        if (grade.equals("管理员")) {
            JMenuItem menu_1_3 = new JMenuItem("增添用户信息");
            menu_1_3.setFont(Fronts.menu_font);
            menu_1.add(menu_1_3);
            menu_1_3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent actionEvent) {
                    try {
                        new Add_user_information(grade);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }


        JMenu menu_2 = new JMenu("设备信息管理");//创建第二个栏目
        menu_2.setFont(Fronts.menu_font);
        menuBar.add(menu_2);//添加到菜单栏

        JMenuItem menu_2_1 = new JMenuItem("设备信息维护");//创建第二个栏目的第一个栏目的第一个项目
        menu_2_1.setFont(Fronts.menu_font);
        menu_2.add(menu_2_1);
        menu_2_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                Device_List device_list = null;
                try {
                    device_list = new Device_List(grade, self);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        JMenuItem menu_2_2 = new JMenuItem("增添设备信息");//创建第二个栏目的第一个栏目的第三个项目（只有管理员有权限）
        menu_2_2.setFont(Fronts.menu_font);
        menu_2.add(menu_2_2);
        menu_2_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (grade.equals("管理员")) {
                    new Add_device_information(grade, self);
                } else {
                    JOptionPane.showMessageDialog(null, "对不起，您没有该权限！");
                }
            }
        });

        JMenuItem menu_2_3 = new JMenuItem("设备使用记录");
        menu_2_3.setFont(Fronts.menu_font);
        menu_2.add(menu_2_3);
        menu_2_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                Use_List use_list = null;
                try {
                    use_list = new Use_List(grade, self);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        JMenu menu_3 = new JMenu("实验室信息管理");//创建第三个栏目
        menu_3.setFont(Fronts.menu_font);
        menuBar.add(menu_3);//添加到菜单栏

        JMenuItem menu_3_1 = new JMenuItem("增添实验室信息");//创建第三个栏目的第一个项目（只有管理员有权限）
        menu_3_1.setFont(Fronts.menu_font);
        menu_3.add(menu_3_1);//添加到第三个栏目里
        menu_3_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (grade.equals("管理员")) {
                    new Add_laboratory_information(grade, self);
                } else {
                    JOptionPane.showMessageDialog(null, "对不起，您没有该权限！");
                }
            }
        });

        JMenuItem menu_3_2 = new JMenuItem("实验室信息维护");//创建第三个栏目的第二个项目
        menu_3_2.setFont(Fronts.menu_font);
        menu_3.add(menu_3_2);//添加到第三个栏目里
        menu_3_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                Laboratory_List laboratory_list = null;
                try {
                    laboratory_list = new Laboratory_List(grade, self);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        JMenu menu_4 = new JMenu("系统设置");//创建第四个栏目
        menu_4.setFont(Fronts.menu_font);
        menuBar.add(menu_4);//添加到菜单栏

        JMenuItem menu_4_1 = new JMenuItem("系统介绍");//创建第四个栏目的第一个项目
        menu_4_1.setFont(Fronts.menu_font);
        menu_4.add(menu_4_1);//添加到第四个栏目里
        menu_4_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                new System_introduction();
            }
        });

        JMenuItem menu_4_2 = new JMenuItem("安全退出");//创建第四个栏目的第二个项目
        menu_4_2.setFont(Fronts.menu_font);
        menu_4.add(menu_4_2);//添加到第四个栏目里
        menu_4_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                int result = JOptionPane.showConfirmDialog(null, "是否退出系统？");
                if (result == 0) {
                    try {
                        new Add_use_information(self, deviceNo, 2, grade);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "退出失败，请重试！");
                    }
                    dispose();
                }
            }
        });


        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        //设置JFrame最大化
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }

//    public static void main(String[] args) {
//        MainView mainView = new MainView("管理员", "001");
//    }

}
