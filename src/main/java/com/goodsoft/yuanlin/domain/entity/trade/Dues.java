package com.goodsoft.yuanlin.domain.entity.trade;

import java.util.Objects;

/**
 * function 会费实体
 * Created by 严彬荣 on 2017/8/21.
 * version v1.0
 */
public class Dues implements java.io.Serializable {
    private String id;//表id
    private String name;//姓名
    private String date;//成立时间
    private String address;//所在地
    private String project;//主经营项目
    private String compScale;//企业规模
    private String qlifLevel;//资质等级
    private String compType;//企业类型
    private Double registerCapital;//注册资金

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCompType() {
        return compType;
    }

    public void setCompType(String compType) {
        this.compType = compType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getCompScale() {
        return compScale;
    }

    public void setCompScale(String compScale) {
        this.compScale = compScale;
    }

    public String getQlifLevel() {
        return qlifLevel;
    }

    public void setQlifLevel(String qlifLevel) {
        this.qlifLevel = qlifLevel;
    }

    public Double getRegisterCapital() {
        return registerCapital;
    }

    public void setRegisterCapital(Double registerCapital) {
        this.registerCapital = registerCapital;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dues)) return false;
        Dues dues = (Dues) o;
        return id == dues.id &&
                Objects.equals(name, dues.name) &&
                Objects.equals(date, dues.date) &&
                Objects.equals(address, dues.address) &&
                Objects.equals(project, dues.project) &&
                Objects.equals(compScale, dues.compScale) &&
                Objects.equals(qlifLevel, dues.qlifLevel) &&
                Objects.equals(compType, dues.compType) &&
                Objects.equals(registerCapital, dues.registerCapital);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, date, address, project, compScale, qlifLevel, compType, registerCapital);
    }
}
