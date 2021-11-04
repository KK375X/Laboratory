//增添设备信息界面
package com.view;

import com.Util.DBUtil;
import com.Util.StringUtil;
import com.dao.Device_addDao;
import com.model.Device_add;
import com.style.Fronts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class Add_device_information extends JFrame {

    //定义标签变量
    JTextField deviceNoText;//设备编号
    JTextField deviceNameText;//设备名称
    JTextField priceText;//设备单价
    JTextField producerText;//生产厂家
    JTextField laboratoryText;//实验室编号

    //定义字体样式表对象
    Fronts fronts = new Fronts();

    //定义数据库操作的对象
    private DBUtil dbUtil = new DBUtil();
    private Device_addDao device_addDao = new Device_addDao();


    public Add_device_information(String grade, String self) {
        setTitle("增添设备信息");
        setLayout(new GridLayout(6, 1));//7行1列布局
        setSize(500, 480);//设置窗口大小
        setLocationRelativeTo(null);//设置窗口居中
        validate();//让组件生效


        JLabel deviceNo = new JLabel("设备编号：");//标签
        deviceNo.setFont(Fronts.text_font);//设置样式
        deviceNoText = new JTextField(20);//文本框
        deviceNoText.setFont(Fronts.textField_font);//设置样式
        JPanel deviceNo_panel = new JPanel();//中间组件
        deviceNo_panel.add(deviceNo);//将标签和文本框添加到中间组件上
        deviceNo_panel.add(deviceNoText);
        this.add(deviceNo_panel);//将中间组件添加到面板上

        JLabel deviceName = new JLabel("设备名称：");
        deviceName.setFont(Fronts.text_font);
        deviceNameText = new JTextField(20);
        deviceNameText.setFont(Fronts.textField_font);
        JPanel deviceName_panel = new JPanel();
        deviceName_panel.add(deviceName);
        deviceName_panel.add(deviceNameText);
        this.add(deviceName_panel);

        JLabel price = new JLabel("设备单价：");
        price.setFont(Fronts.text_font);
        priceText = new JTextField(20);
        priceText.setFont(Fronts.textField_font);
        JPanel price_panel = new JPanel();
        price_panel.add(price);
        price_panel.add(priceText);
        this.add(price_panel);

        JLabel producer = new JLabel("生产厂家：");
        producer.setFont(Fronts.text_font);
        producerText = new JTextField(20);
        producerText.setFont(Fronts.textField_font);
        JPanel producer_panel = new JPanel();
        producer_panel.add(producer);
        producer_panel.add(producerText);
        this.add(producer_panel);

        JLabel laboratory = new JLabel("实验室编号：");
        laboratory.setFont(Fronts.text_font);
        laboratoryText = new JTextField(20);
        laboratoryText.setFont(Fronts.textField_font);
        JPanel laboratory_panel = new JPanel();
        laboratory_panel.add(laboratory);
        laboratory_panel.add(laboratoryText);
        this.add(laboratory_panel);

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
        String deviceNo = this.deviceNoText.getText();
        String deviceName = this.deviceNameText.getText();
        String price = this.priceText.getText();
        String producer = this.producerText.getText();
        String laboratory = this.laboratoryText.getText();
        //弹出提示信息
        if (StringUtil.isEmpty(deviceNo) || StringUtil.isEmpty(deviceName) || StringUtil.isEmpty(price) || StringUtil.isEmpty(producer) || StringUtil.isEmpty(laboratory)) {
            JOptionPane.showMessageDialog(null, "请填写完整的设备信息！");
            return;
        }
        //实例化设备信息
        Device_add device_add = new Device_add(deviceNo, deviceName, price, producer, laboratory);
        //数据库连接
        Connection con = null;
        try {
            con = dbUtil.getCon();
            int item = device_addDao.add(con, device_add);//封装传到数据库，并获取返回值
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
        this.deviceNoText.setText("");
        this.deviceNameText.setText("");
        this.priceText.setText("");
        this.producerText.setText("");
        this.laboratoryText.setText("");
    }

//    public static void main(String[] args) {
//        Add_device_information add_device_information = new Add_device_information();
//    }

}
