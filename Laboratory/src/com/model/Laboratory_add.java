package com.model;

public class Laboratory_add {

    private String laboratoryNo;//实验室编号
    private String laboratoryName;//实验室名称
    private String address;//地址

    public Laboratory_add() {
        super();
    }

    public Laboratory_add(String laboratoryNo, String laboratoryName, String address) {
        super();
        this.laboratoryNo = laboratoryNo;
        this.laboratoryName = laboratoryName;
        this.address = address;
    }

    public String getLaboratoryNo() {
        return laboratoryNo;
    }

    public void setLaboratoryNo(String laboratoryNo) {
        this.laboratoryNo = laboratoryNo;
    }

    public String getLaboratoryName() {
        return laboratoryName;
    }

    public void setLaboratoryName(String laboratoryName) {
        this.laboratoryName = laboratoryName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
