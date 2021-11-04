package com.model;

import java.text.SimpleDateFormat;

public class Use_add {

    private String userNo;//工号
    private String deviceNo;//设备编号
    private String useDate;//使用日期
    private String beginTime;//使用开始时间
    private String endTime;//使用结束时间

    public Use_add(String userNo, String deviceNo, String useDate, String beginTime, String endTime) {
        super();
        this.userNo = userNo;
        this.deviceNo = deviceNo;
        this.useDate = useDate;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public Use_add() {
        super();
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public String getUseDate() {
        return useDate;
    }

    public void setUseDate(String useDate) {
        this.useDate = useDate;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
