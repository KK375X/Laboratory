//用户登录字符串判空工具类
package com.Util;

public class StringUtil {

    //判断是否是空
    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str.trim())) {
            return true;
        } else {
            return false;
        }
    }

    //判断是否不是空
    public static boolean isNotEmpty(String str) {
//        if (str != null && "".equals(str.trim())) {
        if (str != null) {
            return true;
        } else {
            return false;
        }
    }

}
