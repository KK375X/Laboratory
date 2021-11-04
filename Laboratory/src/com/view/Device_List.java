/*
 * Created by JFormDesigner on Wed Aug 25 23:24:05 CST 2021
 */

package com.view;

import com.Util.DBUtil;
import com.Util.StringUtil;
import com.dao.Device_addDao;
import com.dao.User_addDao;
import com.model.Device_add;
import com.model.User_add;
import com.style.Fronts;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.border.*;
import javax.swing.table.*;

/**
 * @author unknown
 */
public class Device_List extends JFrame {

    //定义字体样式表对象
    Fronts fronts = new Fronts();

    //定义数据库操作的对象
    private DBUtil dbUtil = new DBUtil();
    private Device_addDao device_addDao = new Device_addDao();

    Device_List(String grade, String self) throws Exception {

        setTitle("实验室设备信息管理");

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        ResourceBundle bundle = ResourceBundle.getBundle("com.view.Test");
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        scrollPane1 = new JScrollPane();
        table = new JTable();
        deviceNameText = new JLabel();
        deviceNameField = new JTextField();
        search = new JButton();
        panel1 = new JPanel();
        deviceNo = new JLabel();
        deviceName = new JLabel();
        price = new JLabel();
        producer = new JLabel();
        deviceNoField = new JTextField();
        deviceNameField_2 = new JTextField();
        priceField = new JTextField();
        producerField = new JTextField();
        laboratoryNo = new JLabel();
        laboratoryNoField = new JTextField();
        update = new JButton();
        cancel = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.
            EmptyBorder(0,0,0,0), "",javax.swing.border.TitledBorder.CENTER,javax.swing
            .border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069alog",java.awt.Font.BOLD,12),
            java.awt.Color.red),dialogPane. getBorder()));dialogPane. addPropertyChangeListener(new java.beans.PropertyChangeListener()
            {@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062order".equals(e.getPropertyName()))
            throw new RuntimeException();}});
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //======== scrollPane1 ========
                {

                    //---- table ----
                    table.setModel(new DefaultTableModel(
                        new Object[][] {
                        },
                        new String[] {
                            "\u8bbe\u5907\u7f16\u53f7", "\u8bbe\u5907\u540d\u79f0", "\u8bbe\u5907\u5355\u4ef7", "\u751f\u4ea7\u5382\u5bb6", "\u5b9e\u9a8c\u5ba4\u7f16\u53f7"
                        }
                    ) {
                        boolean[] columnEditable = new boolean[] {
                            false, false, false, false, false
                        };
                        @Override
                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return columnEditable[columnIndex];
                        }
                    });

                    //鼠标点击记录，自动添加到下方表单中
                    table.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            tableMousePressed(e);
                        }
                    });
                    scrollPane1.setViewportView(table);
                }

                //---- deviceNameText ----
                deviceNameText.setText(bundle.getString("User_List.deviceNameText.text"));

                //---- search ----
                search.setText(bundle.getString("User_List.search.text"));

                //======== panel1 ========
                {
                    panel1.setBorder(new TitledBorder(null, bundle.getString("User_List.panel1.border_2"), TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                        new Font("\u9ed1\u4f53", Font.PLAIN, 24), new Color(0, 118, 23)));

                    //---- deviceNo ----
                    deviceNo.setText(bundle.getString("User_List.deviceNo.text_2"));

                    //---- deviceName ----
                    deviceName.setText(bundle.getString("User_List.deviceName.text_2"));

                    //---- price ----
                    price.setText(bundle.getString("User_List.price.text_2"));

                    //---- producer ----
                    producer.setText(bundle.getString("User_List.producer.text_2"));

                    //---- deviceNoField ----
                    deviceNoField.setEditable(false);

                    //---- priceField ----
                    priceField.setEditable(false);

                    //---- producerField ----
                    producerField.setEditable(false);

                    //---- laboratoryNo ----
                    laboratoryNo.setText(bundle.getString("User_List.laboratoryNo.text_2"));

                    GroupLayout panel1Layout = new GroupLayout(panel1);
                    panel1.setLayout(panel1Layout);
                    panel1Layout.setHorizontalGroup(
                        panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addComponent(deviceNo, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(deviceNoField, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addComponent(price, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(priceField)))
                                        .addGap(18, 18, 18)
                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addComponent(producer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(producerField, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addComponent(deviceName, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                                                .addGap(9, 9, 9)
                                                .addComponent(deviceNameField_2, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)))
                                        .addContainerGap())
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(laboratoryNo, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(laboratoryNoField, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                        .addGap(123, 123, 123))))
                    );
                    panel1Layout.setVerticalGroup(
                        panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(deviceNameField_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(deviceName, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(deviceNo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(deviceNoField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
                                .addGap(30, 30, 30)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(price, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(producerField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(priceField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(producer, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(laboratoryNoField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(laboratoryNo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(19, Short.MAX_VALUE))
                    );
                }

                //---- update ----
                update.setText(bundle.getString("User_List.update.text_2"));

                //---- cancel ----
                cancel.setText(bundle.getString("User_List.cancel.text_2"));

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap(161, Short.MAX_VALUE)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                    .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addComponent(deviceNameText, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(deviceNameField, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(search, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(scrollPane1)
                                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(127, 127, 127))
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                    .addComponent(update, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                    .addGap(219, 219, 219)
                                    .addComponent(cancel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                    .addGap(205, 205, 205))))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(deviceNameText, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addComponent(search, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addComponent(deviceNameField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                            .addGap(20, 20, 20)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(cancel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addComponent(update, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(54, Short.MAX_VALUE))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents


        //以下为自定义代码
        //设置文本框，文本输入框，按钮样式
        deviceNameText.setFont(Fronts.text_font);
        deviceNameField.setFont(Fronts.textField_font);
        search.setFont(Fronts.button_font);
        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    deviceSearchActionPerformed(e);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


        //调用fillTable方法，初始化表格
        this.fillTable(new Device_add());

        //设置表格样式
        // 设置表格内容颜色
        table.setForeground(Color.BLACK);                   // 字体颜色
        table.setFont(new Font(null, Font.PLAIN, 16));      // 字体样式
        table.setSelectionForeground(Color.DARK_GRAY);      // 选中后字体颜色
        table.setSelectionBackground(Color.LIGHT_GRAY);     // 选中后字体背景
        table.setGridColor(Color.GRAY);                     // 网格颜色

        // 设置表头
        table.getTableHeader().setFont(new Font(null, Font.BOLD, 20));  // 设置表头名称字体样式
        table.getTableHeader().setForeground(Color.RED);                // 设置表头名称字体颜色
        table.getTableHeader().setResizingAllowed(true);               // 设置允许手动改变列宽
        table.getTableHeader().setReorderingAllowed(true);             // 设置允许拖动重新排序各列

        // 设置行高
        table.setRowHeight(35);

        // 设置列宽
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);

        //设置数据操作区域的字体，文本框和按钮样式
        deviceNo.setFont(Fronts.text_font);//设置字体样式
        deviceName.setFont(Fronts.text_font);//设置字体样式
        price.setFont(Fronts.text_font);//设置字体样式
        producer.setFont(Fronts.text_font);//设置字体样式
        laboratoryNo.setFont(Fronts.text_font);//设置字体样式
        deviceNoField.setFont(Fronts.textField_font);
        deviceNameField_2.setFont(Fronts.textField_font);
        priceField.setFont(Fronts.textField_font);
        producerField.setFont(Fronts.textField_font);
        laboratoryNoField.setFont(Fronts.textField_font);
        update.setFont(Fronts.button_font);
        cancel.setFont(Fronts.button_font);

        //为修改和删除添加事件处理
        update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //判断是否是管理员操作
                if (grade.equals("管理员")) {
                    deviceInformationUpdateActionEvent(e);
                } else {
                    JOptionPane.showMessageDialog(null, "对不起，您没有该权限！");
                }
            }
        });

        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //判断是否是管理员操作
                if (grade.equals("管理员")) {
                    deviceInformationDeleteActionEvent(e);
                } else {
                    JOptionPane.showMessageDialog(null, "对不起，您没有该权限！");
                }
            }
        });


        // 显示窗口
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);//设置窗口居中
        setVisible(true);

    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JScrollPane scrollPane1;
    private JTable table;
    private JLabel deviceNameText;
    private JTextField deviceNameField;
    private JButton search;
    private JPanel panel1;
    private JLabel deviceNo;
    private JLabel deviceName;
    private JLabel price;
    private JLabel producer;
    private JTextField deviceNoField;
    private JTextField deviceNameField_2;
    private JTextField priceField;
    private JTextField producerField;
    private JLabel laboratoryNo;
    private JTextField laboratoryNoField;
    private JButton update;
    private JButton cancel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    // 设备信息搜索事件
    private void deviceSearchActionPerformed(ActionEvent evt) throws Exception {
        String s_deviceNameField = this.deviceNameField.getText();
        Device_add device_add = new Device_add();
        device_add.setDeviceName(s_deviceNameField);
        this.fillTable(device_add);
    }

    // 获取数据，填充到表格
    private void fillTable(Device_add device_add) throws Exception {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        //清空表格
        dtm.setRowCount(0);
        //数据库查询
        Connection con = null;
        try {
            con = dbUtil.getCon();
            ResultSet rs = device_addDao.list(con, device_add);
            while (rs.next()) {
                //添加数据
                Vector v = new Vector();
                v.add(rs.getString("deviceNo"));
                v.add(rs.getString("deviceName"));
                v.add(rs.getString("price"));
                v.add(rs.getString("producer"));
                v.add(rs.getString("laboratoryNo"));
                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.closeCon(con);//关闭数据库连接
        }
    }

    //表格行点击事件处理
    private void tableMousePressed(MouseEvent evt) {
        //获取鼠标选中的行
        int row = table.getSelectedRow();
        deviceNoField.setText((String)table.getValueAt(row, 0));
        deviceNameField_2.setText((String)table.getValueAt(row, 1));
        priceField.setText((String)table.getValueAt(row, 2));
        producerField.setText((String)table.getValueAt(row, 3));
        laboratoryNoField.setText((String)table.getValueAt(row, 4));
    }

    //数据更新操作
    private void deviceInformationUpdateActionEvent(ActionEvent evt) {
        String u_deviceNo = deviceNoField.getText();
        String u_deviceName = deviceNameField_2.getText();
        String u_price = priceField.getText();
        String u_producer = producerField.getText();
        String u_laboratoryNo = laboratoryNoField.getText();
        if (StringUtil.isEmpty(u_deviceNo)) {
            JOptionPane.showMessageDialog(null, "请选择要修改的记录");
            return ;
        }
        if (StringUtil.isEmpty(u_deviceName) || StringUtil.isEmpty(u_laboratoryNo)) {
            JOptionPane.showMessageDialog(null, "请将信息填写完整");
        }
        Device_add device_add = new Device_add(u_deviceNo, u_deviceName, u_price, u_producer, u_laboratoryNo);
        //数据库连接
        Connection con = null;
        try {
            con = dbUtil.getCon();
            int modifyNum = Device_addDao.update(con, device_add);
            if (modifyNum == 1) {
                JOptionPane.showMessageDialog(null, "修改成功！");
                this.resetValue();//修改成功，重置表格
                this.fillTable(new Device_add());//修改成功，刷新表格
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

    //删除记录
    private void deviceInformationDeleteActionEvent(ActionEvent evt) {
        String d_deviceNo = deviceNoField.getText();
        if (StringUtil.isEmpty(d_deviceNo)) {
            JOptionPane.showMessageDialog(null, "请选择要删除的记录");
            return ;
        }
        int flag = JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
        if (flag == 0) {
            //数据库连接
            Connection con = null;
            try {
                con = dbUtil.getCon();
                int deleteNum = Device_addDao.delete(con, d_deviceNo);
                if (deleteNum == 1) {
                    JOptionPane.showMessageDialog(null, "删除成功！");
                    this.resetValue();//修改成功，重置表格
                    this.fillTable(new Device_add());//修改成功，刷新表格
                } else {
                    JOptionPane.showMessageDialog(null, "删除失败！");
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

    //重置表单
    public void resetValue() {
        this.deviceNoField.setText("");
        this.deviceNameField_2.setText("");
        this.priceField.setText("");
        this.producerField.setText("");
        this.laboratoryNoField.setText("");
    }


//    public static void main(String[] args) throws Exception {
//        Device_List device_list = new Device_List(grade);
//    }

}
