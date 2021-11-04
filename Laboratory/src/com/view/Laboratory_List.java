/*
 * Created by JFormDesigner on Thu Aug 26 10:29:29 CST 2021
 */

package com.view;

import com.Util.DBUtil;
import com.Util.StringUtil;
import com.dao.Device_addDao;
import com.dao.Laboratory_addDao;
import com.model.Device_add;
import com.model.Laboratory_add;
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


public class Laboratory_List extends JFrame {

    //定义字体样式表对象
    Fronts fronts = new Fronts();

    //定义数据库操作的对象
    private DBUtil dbUtil = new DBUtil();
    private Laboratory_addDao laboratory_addDao = new Laboratory_addDao();

    Laboratory_List(String grade, String self) throws Exception {

        setTitle("实验室信息管理");

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        ResourceBundle bundle = ResourceBundle.getBundle("com.view.Test");
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        scrollPane1 = new JScrollPane();
        table = new JTable();
        laboratoryNameText = new JLabel();
        laboratoryNameField = new JTextField();
        search = new JButton();
        panel1 = new JPanel();
        laboratoryName = new JLabel();
        address = new JLabel();
        laboratoryNameField_2 = new JTextField();
        addressField = new JTextField();
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
            dialogPane.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax.
            swing. border. EmptyBorder( 0, 0, 0, 0) , "", javax. swing. border
            . TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dialo\u0067"
            ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,dialogPane. getBorder
            ( )) ); dialogPane. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java
            .beans .PropertyChangeEvent e) {if ("borde\u0072" .equals (e .getPropertyName () )) throw new RuntimeException
            ( ); }} );
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
                            "\u5b9e\u9a8c\u5ba4\u7f16\u53f7", "\u5b9e\u9a8c\u5ba4\u540d\u79f0", "\u5b9e\u9a8c\u5ba4\u5730\u5740"
                        }
                    ) {
                        boolean[] columnEditable = new boolean[] {
                            false, false, false
                        };
                        @Override
                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return columnEditable[columnIndex];
                        }
                    });

                    table.addMouseListener(new MouseAdapter() {
                        public void mousePressed(MouseEvent e) {
                            tableMousePressed(e);
                        }
                    });
                    scrollPane1.setViewportView(table);
                }

                //---- laboratoryNameText ----
                laboratoryNameText.setText(bundle.getString("User_List.laboratoryNameText.text"));

                //---- search ----
                search.setText(bundle.getString("User_List.search.text"));

                //======== panel1 ========
                {
                    panel1.setBorder(new TitledBorder(null, bundle.getString("User_List.panel1.border_3"), TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                        new Font("\u9ed1\u4f53", Font.PLAIN, 24), new Color(0, 118, 23)));

                    //---- laboratoryName ----
                    laboratoryName.setText(bundle.getString("User_List.laboratoryName.text"));

                    //---- address ----
                    address.setText(bundle.getString("User_List.address.text"));

                    //---- laboratoryNo ----
                    laboratoryNo.setText(bundle.getString("User_List.laboratoryNo.text"));

                    //---- laboratoryNoField ----
                    laboratoryNoField.setEditable(false);

                    GroupLayout panel1Layout = new GroupLayout(panel1);
                    panel1.setLayout(panel1Layout);
                    panel1Layout.setHorizontalGroup(
                        panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(address, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                    .addComponent(laboratoryNo, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                    .addComponent(laboratoryName, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                                .addGap(36, 36, 36)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(laboratoryNameField_2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(laboratoryNoField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addressField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
                    );
                    panel1Layout.setVerticalGroup(
                        panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(laboratoryNo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(laboratoryNoField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(laboratoryName, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(laboratoryNameField_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(address, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addressField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25))
                    );
                }

                //---- update ----
                update.setText(bundle.getString("User_List.update.text_3"));

                //---- cancel ----
                cancel.setText(bundle.getString("User_List.cancel.text_3"));

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addContainerGap(127, Short.MAX_VALUE)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(laboratoryNameText, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(laboratoryNameField, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(search, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                .addComponent(scrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(127, 127, 127))
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(230, 230, 230)
                            .addComponent(update, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                            .addGap(160, 160, 160)
                            .addComponent(cancel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(264, Short.MAX_VALUE))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(search, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addComponent(laboratoryNameField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addComponent(laboratoryNameText, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                            .addGap(20, 20, 20)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(cancel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addComponent(update, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(60, Short.MAX_VALUE))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents


        //以下为自定义代码
        //设置文本框，文本输入框，按钮样式
        laboratoryNameText.setFont(Fronts.text_font);
        laboratoryNameField.setFont(Fronts.textField_font);
        search.setFont(Fronts.button_font);
        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    laboratorySearchActionPerformed(e);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


        //调用fillTable方法，初始化表格
        this.fillTable(new Laboratory_add());

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

        //设置数据操作区域的字体，文本框和按钮样式
        laboratoryNo.setFont(Fronts.text_font);//设置字体样式
        laboratoryName.setFont(Fronts.text_font);//设置字体样式
        address.setFont(Fronts.text_font);//设置字体样式
        laboratoryNoField.setFont(Fronts.textField_font);
        laboratoryNameField_2.setFont(Fronts.textField_font);
        addressField.setFont(Fronts.textField_font);
        update.setFont(Fronts.button_font);
        cancel.setFont(Fronts.button_font);

        //为修改和删除添加事件处理
        update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //判断是否是管理员操作
                if (grade.equals("管理员")) {
                    laboratoryInformationUpdateActionEvent(e);
                } else {
                    JOptionPane.showMessageDialog(null, "对不起，您没有该权限！");
                }
            }
        });

        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //判断是否是管理员操作
                if (grade.equals("管理员")) {
                    laboratoryInformationDeleteActionEvent(e);
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
    private JLabel laboratoryNameText;
    private JTextField laboratoryNameField;
    private JButton search;
    private JPanel panel1;
    private JLabel laboratoryName;
    private JLabel address;
    private JTextField laboratoryNameField_2;
    private JTextField addressField;
    private JLabel laboratoryNo;
    private JTextField laboratoryNoField;
    private JButton update;
    private JButton cancel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    // 实验室信息搜索事件
    private void laboratorySearchActionPerformed(ActionEvent evt) throws Exception {
        String s_laboratoryNameField = this.laboratoryNameField.getText();
        Laboratory_add laboratory_add = new Laboratory_add();
        laboratory_add.setLaboratoryName(s_laboratoryNameField);
        this.fillTable(laboratory_add);
    }


    // 获取数据，填充到表格
    private void fillTable(Laboratory_add laboratory_add) throws Exception {

        DefaultTableModel dtm = (DefaultTableModel) table.getModel();

        //清空表格
        dtm.setRowCount(0);

        //数据库查询
        Connection con = null;
        try {
            con = dbUtil.getCon();
            ResultSet rs = laboratory_addDao.list(con, laboratory_add);
            while (rs.next()) {
                //添加数据
                Vector v = new Vector();
                v.add(rs.getString("laboratoryNo"));
                v.add(rs.getString("laboratoryName"));
                v.add(rs.getString("address"));
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
        laboratoryNoField.setText((String)table.getValueAt(row, 0));
        laboratoryNameField_2.setText((String)table.getValueAt(row, 1));
        addressField.setText((String)table.getValueAt(row, 2));
    }

    //数据更新操作
    private void laboratoryInformationUpdateActionEvent(ActionEvent evt) {
        String u_laboratoryNo = laboratoryNoField.getText();
        String u_laboratoryName = laboratoryNameField_2.getText();
        String u_address = addressField.getText();
        if (StringUtil.isEmpty(u_laboratoryNo)) {
            JOptionPane.showMessageDialog(null, "请选择要修改的记录");
            return ;
        }
        if (StringUtil.isEmpty(u_laboratoryName) || StringUtil.isEmpty(u_address)) {
            JOptionPane.showMessageDialog(null, "请将信息填写完整");
        }
        Laboratory_add laboratory_add = new Laboratory_add(u_laboratoryNo, u_laboratoryName, u_address);

        //数据库连接
        Connection con = null;
        try {
            con = dbUtil.getCon();
            int modifyNum = Laboratory_addDao.update(con, laboratory_add);
            if (modifyNum == 1) {
                JOptionPane.showMessageDialog(null, "修改成功！");
                this.resetValue();//修改成功，重置表格
                this.fillTable(new Laboratory_add());//修改成功，刷新表格
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
    private void laboratoryInformationDeleteActionEvent(ActionEvent evt) {
        String d_laboratoryNo = laboratoryNoField.getText();
        if (StringUtil.isEmpty(d_laboratoryNo)) {
            JOptionPane.showMessageDialog(null, "请选择要删除的记录");
            return ;
        }
        int flag = JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
        if (flag == 0) {
            //数据库连接
            Connection con = null;
            try {
                con = dbUtil.getCon();
                int deleteNum = Laboratory_addDao.delete(con, d_laboratoryNo);
                if (deleteNum == 1) {
                    JOptionPane.showMessageDialog(null, "删除成功！");
                    this.resetValue();//修改成功，重置表格
                    this.fillTable(new Laboratory_add());//修改成功，刷新表格
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
        this.laboratoryNoField.setText("");
        this.laboratoryNameField_2.setText("");
        this.addressField.setText("");
    }


//    public static void main(String[] args) throws Exception {
//        Laboratory_List laboratory_list = new Laboratory_List(grade);
//    }

}
