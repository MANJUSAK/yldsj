package com.goodsoft.yuanlin.domain.entity.trade;

import java.util.Objects;

/**
 * function 优质工程实体
 * Created by 严彬荣 on 2017/8/21.
 * version v1.0
 */
public class QualEngin implements java.io.Serializable {
    private int id;//表id
    private String engName;//优质工程名称
    private String date;//发布日期
    private String selectYear;//评选年度
    private String company;//施工企业

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSelectYear() {
        return selectYear;
    }

    public void setSelectYear(String selectYear) {
        this.selectYear = selectYear;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QualEngin)) return false;
        QualEngin qualEngin = (QualEngin) o;
        return id == qualEngin.id &&
                Objects.equals(engName, qualEngin.engName) &&
                Objects.equals(date, qualEngin.date) &&
                Objects.equals(selectYear, qualEngin.selectYear) &&
                Objects.equals(company, qualEngin.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, engName, date, selectYear, company);
    }
}
