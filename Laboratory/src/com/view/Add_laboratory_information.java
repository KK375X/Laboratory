//增添实验室信息
package com.view;

import com.Util.DBUtil;
import com.Util.StringUtil;
import com.dao.Laboratory_addDao;
import com.model.Laboratory_add;
import com.style.Fronts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class Add_laboratory_information extends JFrame {

    //定义标签变量
    JTextField laboratoryNoText;//实验室编号
    JTextField laboratoryNameText;//实验室名称
    JTextField addressText;//地址

    //定义字体样式表对象
    Fronts fronts = new Fronts();

    //定义数据库操作的对象
    private DBUtil dbUtil = new DBUtil();
    private Laboratory_addDao laboratory_addDao = new Laboratory_addDao();


    public Add_laboratory_information(String grade, String self) {
        setTitle("增添实验室信息");
        setLayout(new GridLayout(4, 1));//7行1列布局
        setSize(500, 320);//设置窗口大小
        setLocationRelativeTo(null);//设置窗口居中
        validate();//让组件生效


        JLabel laboratoryNo = new JLabel("实验室编号：");//标签
        laboratoryNo.setFont(Fronts.text_font);//设置样式
        laboratoryNoText = new JTextField(20);//文本框
        laboratoryNoText.setFont(Fronts.textField_font);//设置样式
        JPanel laboratoryNo_panel = new JPanel();//中间组件
        laboratoryNo_panel.add(laboratoryNo);//将标签和文本框添加到中间组件上
        laboratoryNo_panel.add(laboratoryNoText);
        this.add(laboratoryNo_panel);//将中间组件添加到面板上

        JLabel laboratoryName = new JLabel("实验室名称：");
        laboratoryName.setFont(Fronts.text_font);
        laboratoryNameText = new JTextField(20);
        laboratoryNameText.setFont(Fronts.textField_font);
        JPanel laboratoryName_panel = new JPanel();
        laboratoryName_panel.add(laboratoryName);
        laboratoryName_panel.add(laboratoryNameText);
        this.add(laboratoryName_panel);

        JLabel address = new JLabel("实验室地址：");
        address.setFont(Fronts.text_font);
        addressText = new JTextField(20);
        addressText.setFont(Fronts.textField_font);
        JPanel address_panel = new JPanel();
        address_panel.add(address);
        address_panel.add(addressText);
        this.add(address_panel);


        /* 设置按钮 */
        JButton login = new JButton("确定");
        login.setFont(Fronts.button_font);
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    //判断是否是管理员操作
                    if (grade.equals("管理员")) {
                        loginActionPerformed(e);
                    } else {
                        JOptionPane.showMessageDialog(null, "对不起，您没有该权限！");
                    }
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


        setVisible(true);//显示窗口

    }

    //增添事件处理方法
    private void loginActionPerformed(ActionEvent evt) throws Exception {
        //获取用户填写的设备信息
        String laboratoryNo = this.laboratoryNoText.getText();
        String laboratoryName = this.laboratoryNameText.getText();
        String address = this.addressText.getText();

        //弹出提示信息
        if (StringUtil.isEmpty(laboratoryNo) || StringUtil.isEmpty(laboratoryName) || StringUtil.isEmpty(address)) {
            JOptionPane.showMessageDialog(null, "请填写完整的实验室信息！");
            return;
        }

        //实例化设备信息
        Laboratory_add laboratory_add = new Laboratory_add(laboratoryNo, laboratoryName, address);

        //数据库连接
        Connection con = null;
        try {
            con = dbUtil.getCon();
            int item = laboratory_addDao.add(con, laboratory_add);//封装传到数据库，并获取返回值
            if (item == 1) {
                JOptionPane.showMessageDialog(null, "添加成功！");
                this.resetValueActionPerformed(evt);//添加成功，对文本框进行重置
            } else {
                JOptionPane.showMessageDialog(null, "添加失败！");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "添加失败！");
        } finally {
            dbUtil.closeCon(con);//关闭数据库连接
        }
    }

    //重置事件处理方法
    private void resetValueActionPerformed(ActionEvent e) {
        this.laboratoryNoText.setText("");
        this.laboratoryNameText.setText("");
        this.addressText.setText("");
    }

//    public static void main(String[] args) {
//        Add_laboratory_information add_laboratory_information = new Add_laboratory_information();
//    }

}
