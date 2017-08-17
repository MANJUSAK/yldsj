package com.goodsoft.yuanlin.domain.entity.project;

import java.beans.Transient;

/**
 * Project entity.项目信息报实体
 *
 * @author 严彬荣
 */
public class Project implements java.io.Serializable {
    // 项目名称
    private String name;
    // 项目负责人
    private String principal;
    // 联系方式
    private String tel;
    // 项目人数
    private Integer personNum;
    // 项目地点
    private String address;
    // 施工单位
    private String company;
    // 开工时间
    private String startTime;
    // 竣工时间
    private String endTime;
    // 用户ID
    private String uid;
    //部门编号
    private String deptId;
    // 表ID
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getPersonNum() {
        return personNum;
    }

    public void setPersonNum(Integer personNum) {
        this.personNum = personNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Transient
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Transient
    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
}