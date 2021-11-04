package com.view;

import com.Util.DBUtil;
import com.Util.StringUtil;
import com.dao.User_addDao;
import com.model.User_add;
import com.style.Fronts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class Add_user_information extends JFrame {

    //定义标签变量
    JTextField userNoText;//工号
    JTextField userNameText;//姓名
    JTextField sexText;//性别
    JComboBox<String> positionText;//职位
    JTextField phoneText;//联系方式
    JTextField passwordText;//密码

    //定义字体样式表对象
    Fronts fronts = new Fronts();

    //定义数据库操作的对象
    private DBUtil dbUtil = new DBUtil();
    private User_addDao user_addDao = new User_addDao();


    public Add_user_information(String grade) {
        if (grade.equals("管理员")) {
            setTitle("添加用户信息");
        } else {
            setTitle("用户注册");
        }
        setLayout(new GridLayout(7, 1));//7行1列布局
        setSize(820, 560);//设置窗口大小
        setLocationRelativeTo(null);//设置窗口居中
        validate();//让组件生效


        JLabel userNo = new JLabel("工    号：");//标签
        userNo.setFont(Fronts.text_font);//设置样式
        userNoText = new JTextField(30);//文本框
        userNoText.setFont(Fronts.textField_font);//设置样式
        JPanel userNo_panel = new JPanel();//中间组件
        userNo_panel.add(userNo);//将标签和文本框添加到中间组件上
        userNo_panel.add(userNoText);
        this.add(userNo_panel);//将中间组件添加到面板上

        JLabel userName = new JLabel("姓    名：");
        userName.setFont(Fronts.text_font);
        userNameText = new JTextField(30);
        userNameText.setFont(Fronts.textField_font);
        JPanel userName_panel = new JPanel();
        userName_panel.add(userName);
        userName_panel.add(userNameText);
        this.add(userName_panel);

        JLabel password = new JLabel("登录密码：");
        password.setFont(Fronts.text_font);
        passwordText = new JTextField(30);
        passwordText.setFont(Fronts.textField_font);
        JPanel password_panel = new JPanel();
        password_panel.add(password);
        password_panel.add(passwordText);
        this.add(password_panel);

        JLabel phone = new JLabel("联系方式：");
        phone.setFont(Fronts.text_font);
        phoneText = new JTextField(30);
        phoneText.setFont(Fronts.textField_font);
        JPanel phone_panel = new JPanel();
        phone_panel.add(phone);
        phone_panel.add(phoneText);
        this.add(phone_panel);

        JLabel sex = new JLabel("性别：");
        sex.setFont(Fronts.text_font);
        JRadioButton radioBtn01 = new JRadioButton("男");//创建两个单选按钮
        radioBtn01.setFont(Fronts.text_font);
        JRadioButton radioBtn02 = new JRadioButton("女");
        radioBtn02.setFont(Fronts.text_font);
        ButtonGroup btnGroup = new ButtonGroup();//创建按钮组，把两个单选按钮添加到该组
        btnGroup.add(radioBtn01);
        btnGroup.add(radioBtn02);
        radioBtn01.setSelected(true);//设置第一个单选按钮选中
        JPanel sex_panel = new JPanel();//设置性别的中间组件
        sex_panel.add(sex);
        sex_panel.add(radioBtn01);
        sex_panel.add(radioBtn02);

        JLabel position = new JLabel("职位：");
        position.setFont(Fronts.text_font);//我自己写的样式
        String[] listData;//定义下拉框元素数组
        //如果用户是管理员，则可以添加任意用户的信息
        if (grade.equals("管理员")) {
            listData = new String[]{"管理员", "教师", "学生"};//需要选择的条目
        } else {
            listData = new String[]{"教师", "学生"};//需要选择的条目
        }
        positionText = new JComboBox<String>(listData);//创建一个下拉列表框
        JPanel position_panel = new JPanel();//中间组件
        position_panel.add(position);//将下拉框添加到中间组件
        position_panel.add(positionText);//将中间组件添加到底层面板

        //将性别和职位安排在一行
        JPanel sex_position_panel = new JPanel(new GridLayout(1, 4));
        sex_position_panel.add(new JPanel());//没用，占位置
        sex_position_panel.add(sex_panel);
        sex_position_panel.add(position_panel);
        sex_position_panel.add(new JPanel());//没用，占位置
        this.add(sex_position_panel);

        /* 设置按钮 */
        JButton login = new JButton("确定");
        login.setFont(Fronts.button_font);
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    //第一个值为事件，第二个值是单选框的值（传递的是中间组件），第三个是下拉面板的值
                    loginActionPerformed(e, sex_panel, positionText);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
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
        button.add(reset);
        this.add(button);//添加中间组件到面板

        //添加提示信息
        JLabel Text = new JLabel("         提示：如果需要注册管理员账户，可以由其他管理员代为注册。");
        Text.setFont(Fronts.Text_font);
        this.add(Text);

        setResizable(false);//设置窗口的大小不可变
        setLocationRelativeTo(null);//设置窗口居中
        setVisible(true);//显示窗口

    }


    //增添事件处理方法
    private void loginActionPerformed(ActionEvent evt, JPanel sex_panel, JComboBox<String> positionText) throws Exception {

        //获取用户填写的个人信息
        String userNo = this.userNoText.getText();
        String userName = this.userNameText.getText();
        String phone = this.phoneText.getText();
        String password = this.passwordText.getText();

        //获取性别
        String sex = "";
        //通过面板属性名获取到该面板上的所有组件
        for(Component c : sex_panel.getComponents()){
            if(c instanceof JRadioButton){
                if(((JRadioButton) c).isSelected()){
                    sex += ((JRadioButton)c).getText();
                }
            }
        }
//        System.out.println(sex);//输出选择的单选框文本
//        JOptionPane.showMessageDialog(null, "你选择了"+sex);

        //获取职位
        String position = positionText.getEditor().getItem().toString();
//        System.out.println(position);

//        System.out.println(userName+";"+userNo+";"+sex+";"+position+";"+phone+";"+password);

        //弹出提示信息
        if (StringUtil.isEmpty(userNo) || StringUtil.isEmpty(userName) || StringUtil.isEmpty(sex) || StringUtil.isEmpty(position) || StringUtil.isEmpty(phone) || StringUtil.isEmpty(password)) {
            JOptionPane.showMessageDialog(null, "请填写完整的用户信息！");
            return;
        }

        //实例化设备信息
        User_add user_add = new User_add(userNo, userName, sex, position, phone, password);

        //数据库连接
        Connection con = null;
        try {
            con = dbUtil.getCon();
            int item = user_addDao.add(con, user_add);//封装传到数据库，并获取返回值
            if (item == 1) {
                JOptionPane.showMessageDialog(null, "注册成功！");
                this.resetValueActionPerformed(evt);//添加成功，对文本框进行重置
            } else {
                JOptionPane.showMessageDialog(null, "注册失败！");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "注册失败！");
        } finally {
            dbUtil.closeCon(con);//关闭数据库连接
        }
    }

    //重置事件处理方法
    private void resetValueActionPerformed(ActionEvent e) {
        this.userNoText.setText("");
        this.userNameText.setText("");
        this.phoneText.setText("");
        this.passwordText.setText("");
    }

//    public static void main(String[] args) {
//        Add_user_information add_user_information = new Add_user_information();
//    }

}
