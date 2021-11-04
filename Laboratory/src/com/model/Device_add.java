package com.model;

public class Device_add {

    private String deviceNo;//设备编号
    private String deviceName;//设备名称
    private String price;//设备价格
    private String producer;//生产厂家
    private String laboratory;//所属实验室编号

    public Device_add() {
        super();
    }

    public Device_add(String deviceNo, String deviceName, String price, String producer, String laboratory) {
        super();
        this.deviceNo = deviceNo;
        this.deviceName = deviceName;
        this.price = price;
        this.producer = producer;
        this.laboratory = laboratory;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(String laboratory) {
        this.laboratory = laboratory;
    }
}
