package com.goodsoft.yuanlin.domain.entity.user;

import java.beans.Transient;

/**
 * function 用户签到实体
 * Created by 严彬荣 on 2017/8/14.
 */
public class SignIn implements java.io.Serializable {
    private Integer sid;//表id
    private String address;//签到地址
    private String name;//用户姓名
    private String time;//签到时间
    private String comp;//所在企业
    private String uid;//用户id
    private double latitude;//纬度
    private double longitude;//经度
    private String company;//企业
    private String dept;//部门
    private String comments;//备注

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Transient
    public String getComp() {
        return comp;
    }

    public void setComp(String comp) {
        this.comp = comp;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Transient
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
