/*
 * Created by JFormDesigner on Fri Aug 27 17:49:41 CST 2021
 */

package com.view;

import com.Util.DBUtil;
import com.Util.StringUtil;
import com.dao.User_addDao;
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
public class User_List extends JFrame {

    //定义数据库操作的对象
    private DBUtil dbUtil = new DBUtil();
    private User_addDao user_addDao = new User_addDao();

    //定义变量
    private String grade;
    private String self;

    //定义字体样式表对象
    Fronts fronts = new Fronts();

    public User_List(String grade, String self) throws Exception {

        setTitle("用户信息维护");

        this.grade = grade;
        this.self = self;

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        ResourceBundle bundle = ResourceBundle.getBundle("com.view.Test");
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        scrollPane1 = new JScrollPane();
        table = new JTable();
        userName = new JLabel();
        userNameField = new JTextField();
        search = new JButton();
        panel1 = new JPanel();
        userNo = new JLabel();
        userName_2 = new JLabel();
        sex = new JLabel();
        position = new JLabel();
        phone = new JLabel();
        password = new JLabel();
        userNoField = new JTextField();
        userNameField_2 = new JTextField();
        sexField = new JTextField();
        positionField = new JTextField();
        phoneField = new JTextField();
        passwordField = new JTextField();
        update = new JButton();
        cancel = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder
            ( 0, 0, 0, 0) , "", javax. swing. border. TitledBorder. CENTER, javax. swing. border
            . TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt
            . Color. red) ,dialogPane. getBorder( )) ); dialogPane. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void
            propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException( )
            ; }} );
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
                            "\u5de5\u53f7", "\u59d3\u540d", "\u6027\u522b", "\u804c\u4f4d", "\u8054\u7cfb\u65b9\u5f0f", "\u5bc6\u7801"
                        }
                    ) {
                        boolean[] columnEditable = new boolean[] {
                            false, false, false, false, false, false
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

                //---- userName ----
                userName.setText("请输入用户名");

                //---- search ----
                search.setText("查询");

                //======== panel1 ========
                {
                    panel1.setBorder(new TitledBorder(null, bundle.getString("User_List.panel1.border_3"), TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                        new Font("\u9ed1\u4f53", Font.PLAIN, 24), new Color(0, 118, 23)));

                    //---- userNo ----
                    userNo.setText(bundle.getString("User_List.userNo.text"));

                    //---- userName_2 ----
                    userName_2.setText(bundle.getString("User_List.userName_2.text"));

                    //---- sex ----
                    sex.setText(bundle.getString("User_List.sex.text"));

                    //---- position ----
                    position.setText(bundle.getString("User_List.position.text"));

                    //---- phone ----
                    phone.setText(bundle.getString("User_List.phone.text"));

                    //---- password ----
                    password.setText(bundle.getString("User_List.password.text"));

                    //---- userNoField ----
                    userNoField.setEditable(false);

                    //---- positionField ----
                    positionField.setEditable(false);

                    GroupLayout panel1Layout = new GroupLayout(panel1);
                    panel1.setLayout(panel1Layout);
                    panel1Layout.setHorizontalGroup(
                        panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(userNo, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(sex, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(phone, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(sexField)
                                    .addComponent(phoneField)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(userNoField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(password, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                    .addComponent(position, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                    .addComponent(userName_2, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(userNameField_2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(positionField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 19, Short.MAX_VALUE))
                    );
                    panel1Layout.setVerticalGroup(
                        panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(userNo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(userNoField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(userName_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(userNameField_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(sex, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sexField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(position, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(positionField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(phone, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phoneField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(password, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(26, Short.MAX_VALUE))
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
                            .addContainerGap(68, Short.MAX_VALUE)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addGroup(GroupLayout.Alignment.LEADING, contentPanelLayout.createSequentialGroup()
                                    .addGap(40, 40, 40)
                                    .addComponent(userName, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(userNameField, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
                                    .addGap(35, 35, 35)
                                    .addComponent(search, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                .addComponent(scrollPane1, GroupLayout.Alignment.LEADING)
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
                                .addComponent(userName, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addComponent(userNameField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addComponent(search, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                            .addGap(20, 20, 20)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(42, 42, 42)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(cancel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addComponent(update, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(39, Short.MAX_VALUE))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        // 以下为自定义样式和基本设置
        //设置头部文本框，文本输入框，按钮样式
        userName.setFont(Fronts.text_font);
        userNameField.setFont(Fronts.textField_font);
        search.setFont(Fronts.button_font);
        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    userSearchActionPerformed(e);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        //调用fillTable方法，初始化表格
        this.fillTable(new User_add(), grade);

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
        userNo.setFont(Fronts.text_font);//设置字体样式
        userName_2.setFont(Fronts.text_font);//设置字体样式
        sex.setFont(Fronts.text_font);//设置字体样式
        position.setFont(Fronts.text_font);//设置字体样式
        password.setFont(Fronts.text_font);//设置字体样式
        phone.setFont(Fronts.text_font);//设置字体样式
        userNoField.setFont(Fronts.textField_font);
        userNameField_2.setFont(Fronts.textField_font);
        sexField.setFont(Fronts.textField_font);
        positionField.setFont(Fronts.textField_font);
        passwordField.setFont(Fronts.textField_font);
        phoneField.setFont(Fronts.textField_font);
        update.setFont(Fronts.button_font);
        cancel.setFont(Fronts.button_font);

        //为修改和删除添加事件处理
        update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //判断是否是管理员操作
                if (grade.equals("管理员")) {
                    userInformationUpdateActionEvent(e);
                } else {
                    JOptionPane.showMessageDialog(null, "对不起，您没有该权限！");
                }
            }
        });

        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //判断是否是管理员操作
                if (grade.equals("管理员")) {
                    userInformationDeleteActionEvent(e);
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



    // 用户信息搜索事件
    private void userSearchActionPerformed(ActionEvent evt) throws Exception {
        String s_userNameField = this.userNameField.getText();
        User_add user_add = new User_add();
        user_add.setUserName(s_userNameField);
        this.fillTable(user_add, grade);
    }


    // 获取数据，填充到表格
    private void fillTable(User_add user_add, String grade) throws Exception {

        DefaultTableModel dtm = (DefaultTableModel) table.getModel();

        //清空表格
        dtm.setRowCount(0);

        //数据库查询
        Connection con = null;
        try {
            con = dbUtil.getCon();
            ResultSet rs = user_addDao.list(con, user_add);
            while (rs.next()) {
                //添加数据
                Vector v = new Vector();
                v.add(rs.getString("userNo"));
                v.add(rs.getString("userName"));
                v.add(rs.getString("sex"));
                v.add(rs.getString("position"));
                v.add(rs.getString("phone"));
                //管理员可以查看用户密码
                if (grade.equals("管理员")) {
                    v.add(rs.getString("password"));
                } else {
                    v.add("********");//密码不可见，但是管理员可以修改，或者直接在数据库里修改
                }
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
        userNoField.setText((String)table.getValueAt(row, 0));
        userNameField_2.setText((String)table.getValueAt(row, 1));
        sexField.setText((String)table.getValueAt(row, 2));
        positionField.setText((String)table.getValueAt(row, 3));
        phoneField.setText((String)table.getValueAt(row, 4));
        passwordField.setText((String)table.getValueAt(row, 5));
    }

    //数据更新操作
    private void userInformationUpdateActionEvent(ActionEvent evt) {
        String u_userNo = userNoField.getText();
        String u_userName = userNameField_2.getText();
        String u_sex = sexField.getText();
        String u_position = positionField.getText();
        String u_phone = phoneField.getText();
        String u_password = passwordField.getText();
        if (StringUtil.isEmpty(u_userNo)) {
            JOptionPane.showMessageDialog(null, "请选择要修改的记录");
            return ;
        }
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
                this.resetValue();//修改成功，重置表格
                this.fillTable(new User_add(), grade);//修改成功，刷新表格，第二个传入用户职位设置为空
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
    private void userInformationDeleteActionEvent(ActionEvent evt) {
        String d_userNo = userNoField.getText();
        if (StringUtil.isEmpty(d_userNo)) {
            JOptionPane.showMessageDialog(null, "请选择要删除的记录");
            return ;
        }
        int flag = JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
        if (flag == 0) {
            //数据库连接
            Connection con = null;
            try {
                con = dbUtil.getCon();
                int deleteNum = User_addDao.delete(con, d_userNo);
                if (deleteNum == 1) {
                    JOptionPane.showMessageDialog(null, "删除成功！");
                    this.resetValue();//修改成功，重置表格
                    this.fillTable(new User_add(), grade);//修改成功，刷新表格，第二个传入用户职位设置为空
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
        this.userNoField.setText("");
        this.userNameField_2.setText("");
        this.sexField.setText("");
        this.positionField.setText("");
        this.phoneField.setText("");
        this.passwordField.setText("");
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JScrollPane scrollPane1;
    private JTable table;
    private JLabel userName;
    private JTextField userNameField;
    private JButton search;
    private JPanel panel1;
    private JLabel userNo;
    private JLabel userName_2;
    private JLabel sex;
    private JLabel position;
    private JLabel phone;
    private JLabel password;
    private JTextField userNoField;
    private JTextField userNameField_2;
    private JTextField sexField;
    private JTextField positionField;
    private JTextField phoneField;
    private JTextField passwordField;
    private JButton update;
    private JButton cancel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

//    public static void main(String[] args) throws Exception {
//        User_List user_list = new User_List();
//    }

}
