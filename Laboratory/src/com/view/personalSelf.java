/*
 * Created by JFormDesigner on Thu Aug 26 10:57:14 CST 2021
 */

package com.view;

import com.Util.DBUtil;
import com.Util.StringUtil;
import com.dao.Device_addDao;
import com.dao.User_addDao;
import com.model.Device_add;
import com.model.User_add;
import com.style.Fronts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author unknown
 */
public class personalSelf extends JFrame {

    //定义数据库操作的对象
    private DBUtil dbUtil = new DBUtil();
    private StringUtil stringUtil = new StringUtil();
    private User_addDao user_addDao = new User_addDao();

    /* 定义字体样式类对象 */
    Fronts fronts = new Fronts();

    personalSelf(String grade, String self) throws Exception {

        /* 设置标题 */
        setTitle("我的信息");

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        ResourceBundle bundle = ResourceBundle.getBundle("com.view.Test");
        buttonPanel = new JPanel();
        update = new JButton();
        cancel = new JButton();
        textPanel = new JPanel();
        userNo = new JLabel();
        userName = new JLabel();
        sex = new JLabel();
        position = new JLabel();
        userNoField = new JTextField();
        userNameField = new JTextField();
        sexField = new JTextField();
        positionField = new JTextField();
        phone = new JLabel();
        phoneField = new JTextField();
        passwordField = new JTextField();
        password = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //======== buttonPanel ========
        {
            buttonPanel.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(
            0,0,0,0), "",javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder
            .BOTTOM,new java.awt.Font("Dialo\u0067",java.awt.Font.BOLD,12),java.awt.Color.
            red),buttonPanel. getBorder()));buttonPanel. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.
            beans.PropertyChangeEvent e){if("borde\u0072".equals(e.getPropertyName()))throw new RuntimeException();}});

            //---- update ----
            update.setText(bundle.getString("personalSelf.update.text"));

            //---- cancel ----
            cancel.setText(bundle.getString("personalSelf.cancel.text"));

            GroupLayout buttonPanelLayout = new GroupLayout(buttonPanel);
            buttonPanelLayout.setHonorsVisibility(false);
            buttonPanel.setLayout(buttonPanelLayout);
            buttonPanelLayout.setHorizontalGroup(
                buttonPanelLayout.createParallelGroup()
                    .addGroup(buttonPanelLayout.createSequentialGroup()
                        .addComponent(update, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                        .addComponent(cancel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
            );
            buttonPanelLayout.setVerticalGroup(
                buttonPanelLayout.createParallelGroup()
                    .addGroup(buttonPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(update, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cancel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            );
        }

        //======== textPanel ========
        {
            textPanel.setBorder(new TitledBorder(bundle.getString("personalSelf.textPanel.border")));

            //---- userNo ----
            userNo.setText(bundle.getString("personalSelf.userNo.text"));

            //---- userName ----
            userName.setText(bundle.getString("personalSelf.userName.text"));

            //---- sex ----
            sex.setText(bundle.getString("personalSelf.sex.text"));

            //---- position ----
            position.setText(bundle.getString("personalSelf.position.text"));

            //---- userNoField ----
            userNoField.setEditable(false);

            //---- positionField ----
            positionField.setEditable(false);

            //---- phone ----
            phone.setText(bundle.getString("personalSelf.phone.text"));

            //---- password ----
            password.setText(bundle.getString("personalSelf.password.text"));

            GroupLayout textPanelLayout = new GroupLayout(textPanel);
            textPanelLayout.setHonorsVisibility(false);
            textPanel.setLayout(textPanelLayout);
            textPanelLayout.setHorizontalGroup(
                textPanelLayout.createParallelGroup()
                    .addGroup(textPanelLayout.createSequentialGroup()
                        .addGap(0, 98, Short.MAX_VALUE)
                        .addGroup(textPanelLayout.createParallelGroup()
                            .addGroup(textPanelLayout.createSequentialGroup()
                                .addComponent(password, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE))
                            .addGroup(textPanelLayout.createSequentialGroup()
                                .addComponent(userNo, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(userNoField, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE))
                            .addGroup(textPanelLayout.createSequentialGroup()
                                .addComponent(userName, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(userNameField, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE))
                            .addGroup(textPanelLayout.createSequentialGroup()
                                .addComponent(sex, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(sexField, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE))
                            .addGroup(textPanelLayout.createSequentialGroup()
                                .addComponent(position, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(positionField, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE))
                            .addGroup(textPanelLayout.createSequentialGroup()
                                .addComponent(phone, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(phoneField, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 114, Short.MAX_VALUE))
            );
            textPanelLayout.setVerticalGroup(
                textPanelLayout.createParallelGroup()
                    .addGroup(textPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(textPanelLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, textPanelLayout.createSequentialGroup()
                                .addGroup(textPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(userNoField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(userNo, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(textPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(userName, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(userNameField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(textPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(sex, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sexField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addComponent(position, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                            .addComponent(positionField, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(textPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(phoneField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(phone, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(textPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(password, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(99, 99, 99)
                            .addComponent(textPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(249, 249, 249)
                            .addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(99, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addComponent(textPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(38, 38, 38)
                    .addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(24, 24, 24))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents


        //以下为自定义代码
        //设置字体，文本框和按钮样式
        userNo.setFont(Fronts.text_font);//设置字体样式
        userName.setFont(Fronts.text_font);//设置字体样式
        sex.setFont(Fronts.text_font);//设置字体样式
        position.setFont(Fronts.text_font);//设置字体样式
        phone.setFont(Fronts.text_font);//设置字体样式
        password.setFont(Fronts.text_font);//设置字体样式
        userNoField.setFont(Fronts.textField_font);
        userNameField.setFont(Fronts.textField_font);
        sexField.setFont(Fronts.textField_font);
        positionField.setFont(Fronts.textField_font);
        phoneField.setFont(Fronts.textField_font);
        passwordField.setFont(Fronts.textField_font);
        update.setFont(Fronts.button_font);
        cancel.setFont(Fronts.button_font);

        //调用函数，将自己的信息填入到表格中，工号作为参数
        this.fillTable(self);

        //为修改和删除添加事件处理
        update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //添加self参数是为了通过工号找到该用户信息
                userInformationUpdateActionEvent(e, self);
            }
        });

        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    cancelActionEvent(e);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        setLocationRelativeTo(null);//设置窗口居中
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }



    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel buttonPanel;
    private JButton update;
    private JButton cancel;
    private JPanel textPanel;
    private JLabel userNo;
    private JLabel userName;
    private JLabel sex;
    private JLabel position;
    private JTextField userNoField;
    private JTextField userNameField;
    private JTextField sexField;
    private JTextField positionField;
    private JLabel phone;
    private JTextField phoneField;
    private JTextField passwordField;
    private JLabel password;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    //取消显示页面面板
    private void cancelActionEvent(ActionEvent e) throws Exception {
        this.dispose();
    }

    // 获取数据，填充到表格
    private void fillTable(String self) throws Exception {

        //数据库查询
        Connection con = null;
        try {
            con = dbUtil.getCon();
            ResultSet rs = user_addDao.selfList(con, self);
            while (rs.next()) {
                //添加数据
                userNoField.setText(rs.getString("userNo"));
                userNameField.setText(rs.getString("userName"));
                sexField.setText(rs.getString("sex"));
                positionField.setText(rs.getString("position"));
                phoneField.setText(rs.getString("phone"));
                passwordField.setText(rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.closeCon(con);//关闭数据库连接
        }

    }

    //数据更新操作
    private void userInformationUpdateActionEvent(ActionEvent evt, String self) {
        String u_userNo = userNoField.getText();
        String u_userName = userNameField.getText();
        String u_sex = sexField.getText();
        String u_position = positionField.getText();
        String u_phone = phoneField.getText();
        String u_password = passwordField.getText();
        if (StringUtil.isEmpty(u_userName) || StringUtil.isEmpty(u_sex) || StringUtil.isEmpty(u_phone) || StringUtil.isEmpty(u_position)) {
            JOptionPane.showMessageDialog(null, "请将信息填写完整");
        }
        User_add user_add = new User_add(u_userNo, u_userName, u_sex, u_position, u_phone, u_password);

        //数据库连接
        Connection con = null;
        try {
            con = dbUtil.getCon();
            int modifyNum = User_addDao.update(con, user_add);
            if (modifyNum == 1) {
                JOptionPane.showMessageDialog(null, "修改成功！");
                this.fillTable(self);//修改成功，刷新表格
            } else {
                JOptionPane.showMessageDialog(null, "修改失败！");
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


//    public static void main(String[] args) throws Exception {
//        personalSelf personalSelf = new personalSelf(grade);
//    }

}
