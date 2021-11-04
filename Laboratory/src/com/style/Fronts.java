package com.style;

import java.awt.*;

public class Fronts {

    //定义公共静态变量，任何类都可以调用
    public static Font title_font;//标题变量
    public static Font text_font;//文本标签变量
    public static Font textField_font;//文本框变量
    public static Font button_font;//按钮变量
    public static Font menu_font;//菜单栏变量
    public static Font Text_font;//菜单栏变量


    public Fronts() {
        title_font = new Font("华文行楷", Font.PLAIN, 40);//标题变量
        text_font = new Font("宋体", Font.PLAIN, 20);//文本标签变量
        textField_font = new Font("宋体", Font.PLAIN, 20);//文本框文字变量
        button_font = new Font("宋体", Font.BOLD, 16);//按钮变量
        menu_font = new Font("黑体", Font.PLAIN, 18);//菜单栏变量
        Text_font = new Font("黑体", Font.PLAIN, 22);//文本变量
    }

}
