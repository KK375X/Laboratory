package com.model;

public class User_add {

    private String userNo;//工号
    private String userName;//姓名
    private String sex;//性别
    private String position;//职位
    private String phone;//联系方式
    private String password;//密码

    public User_add() {
        super();
    }

    public User_add(String userNo, String userName, String sex, String position, String phone, String password) {
        super();
        this.userNo = userNo;
        this.userName = userName;
        this.sex = sex;
        this.position = position;
        this.phone = phone;
        this.password = password;
    }


    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
