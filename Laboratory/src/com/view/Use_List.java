/*
 * Created by JFormDesigner on Fri Aug 27 20:57:43 CST 2021
 */

package com.view;

import com.Util.DBUtil;
import com.dao.Use_addDao;
import com.model.Device_add;
import com.model.Laboratory_add;
import com.model.Use_add;
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
import javax.swing.table.*;

/**
 * @author unknown
 */
public class Use_List extends JFrame {

    //定义字体样式表对象
    Fronts fronts = new Fronts();

    //定义数据库操作的对象
    private DBUtil dbUtil = new DBUtil();
    private Use_addDao use_addDao = new Use_addDao();

    public Use_List(String grade, String self) throws Exception {

        setTitle("实验室设备使用记录");

        userNoField_2 = new JTextField();
        deviceNoField = new JTextField();
        useDateField = new JTextField();
        beginTimeField = new JTextField();
        endTimeField = new JTextField();

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        ResourceBundle bundle = ResourceBundle.getBundle("com.view.Test");
        userNoText = new JLabel();
        userNoField = new JTextField();
        search = new JButton();
        scrollPane = new JScrollPane();
        table = new JTable();
        delete = new JButton();
        cancel = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- userNoText ----
        userNoText.setText(bundle.getString("Use_List.userNoText.text"));

        //---- search ----
        search.setText(bundle.getString("Use_List.search.text"));

        //======== scrollPane ========
        {

            //---- table ----
            table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "\u5de5\u53f7", "\u8bbe\u5907\u7f16\u53f7", "\u4f7f\u7528\u65e5\u671f", "\u4f7f\u7528\u5f00\u59cb\u65f6\u95f4", "\u4f7f\u7528\u7ed3\u675f\u65f6\u95f4"
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

            table.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    try {
                        tableMousePressed(e);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
            scrollPane.setViewportView(table);
        }

        //---- delete ----
        delete.setText(bundle.getString("Use_List.delete.text"));

        //---- cancel ----
        cancel.setText(bundle.getString("Use_List.cancel.text"));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(174, 174, 174)
                            .addComponent(userNoText, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(userNoField, GroupLayout.PREFERRED_SIZE, 316, GroupLayout.PREFERRED_SIZE)
                            .addGap(107, 107, 107)
                            .addComponent(search, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(74, 74, 74)
                            .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 850, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(74, Short.MAX_VALUE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(257, 257, 257)
                    .addComponent(delete, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 290, Short.MAX_VALUE)
                    .addComponent(cancel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                    .addGap(251, 251, 251))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(search, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(userNoField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(userNoText, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 480, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(delete, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(cancel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                    .addGap(33, 33, 33))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents


        //以下为自定义代码
        //设置文本框，文本输入框，按钮样式
        userNoText.setFont(Fronts.text_font);
        userNoField.setFont(Fronts.textField_font);
        search.setFont(Fronts.button_font);
        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    useSearchActionPerformed(e);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


        //调用fillTable方法，初始化表格
        this.fillTable(new Use_add());

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
//        table.getColumnModel().getColumn(0).setPreferredWidth(50);
//        table.getColumnModel().getColumn(4).setPreferredWidth(100);

        //设置按钮样式
        delete.setFont(Fronts.button_font);
        cancel.setFont(Fronts.button_font);

        //为删除和去取消添加事件处理
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //判断是否是管理员操作
                if (grade.equals("管理员")) {
                    useInformationDeleteActionEvent(e);
                } else {
                    JOptionPane.showMessageDialog(null, "对不起，您没有该权限！");
                }
            }
        });

        cancel.addActionListener(new ActionListener() {//取消事件
            public void actionPerformed(ActionEvent e) {
                try {
                    cancelActionEvent(e);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });



        // 显示窗口
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);//设置窗口居中
        setVisible(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel userNoText;
    private JTextField userNoField;
    private JButton search;
    private JScrollPane scrollPane;
    private JTable table;
    private JButton delete;
    private JButton cancel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private JTextField userNoField_2;
    private JTextField deviceNoField;
    private JTextField useDateField;
    private JTextField beginTimeField;
    private JTextField endTimeField;

    //使用记录搜索事件
    private void useSearchActionPerformed(ActionEvent e) throws Exception {
        String s_userNoField = this.userNoField.getText();
        Use_add use_add = new Use_add();
        use_add.setUserNo(s_userNoField);
        this.fillTable(use_add);
    }

    //取消显示页面面板
    private void cancelActionEvent(ActionEvent e) throws Exception {
        this.dispose();
    }

    // 获取数据，填充到表格
    private void fillTable(Use_add use_add) throws Exception {

        DefaultTableModel dtm = (DefaultTableModel) table.getModel();

        //清空表格
        dtm.setRowCount(0);

        //数据库查询
        Connection con = null;
        try {
            con = dbUtil.getCon();
            ResultSet rs = use_addDao.list(con, use_add);
            while (rs.next()) {
                //添加数据
                Vector v = new Vector();
                v.add(rs.getString("userNo"));
                v.add(rs.getString("deviceNo"));
                v.add(rs.getString("useDate"));
                v.add(rs.getString("beginTime"));
                v.add(rs.getString("endTime"));
                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.closeCon(con);//关闭数据库连接
        }

    }

    //表格行点击事件处理
    private void tableMousePressed(MouseEvent evt) throws Exception {
        //获取鼠标选中的行
        int row = table.getSelectedRow();
        userNoField_2.setText((String)table.getValueAt(row, 0));
        deviceNoField.setText((String)table.getValueAt(row, 1));
        useDateField.setText((String)table.getValueAt(row, 2));
        beginTimeField.setText((String)table.getValueAt(row, 3));
        endTimeField.setText((String)table.getValueAt(row, 4));
    }

    //数据删除操作
    private void useInformationDeleteActionEvent(ActionEvent evt) {

        //获取要删除的数据，以深色区域表示
        String d_userNo = userNoField_2.getText();
        String d_deviceNo = deviceNoField.getText();
        String d_useDate = useDateField.getText();

        //获取是否删除标识
        int flag = JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");

        //进行删除操作
        if (flag == 0) {
            //数据库连接
            Connection con = null;
            try {
                con = dbUtil.getCon();
                int deleteNum = Use_addDao.delete(con, d_userNo, d_deviceNo, d_useDate);
                if (deleteNum == 1) {
                    JOptionPane.showMessageDialog(null, "删除成功！");
                    this.fillTable(new Use_add());//修改成功，刷新表格
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


//    public static void main(String[] args) throws Exception {
//        Use_List use_list = new Use_List();
//        use_list.setVisible(true);
//    }
}
