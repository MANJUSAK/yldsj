package com.goodsoft.yuanlin.domain.entity.user;

import java.util.Objects;

/**
 * Corporation entity. 法人库实体
 * <p>
 * date 2017-08-18
 * <p>
 * author 严彬荣
 * version v1.0
 */
public class Corporation implements java.io.Serializable {

    private String id; // 表id
    private String company;//企业名称
    private String registerCap;// 注册资金
    private String detailAddress;// 详细地址
    private String nature;// 经营性质
    private String registerAddress;//注册地址
    private String companyIntro;//企业简介

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRegisterCap() {
        return registerCap;
    }

    public void setRegisterCap(String registerCap) {
        this.registerCap = registerCap;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getRegisterAddress() {
        return registerAddress;
    }

    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress;
    }

    public String getCompanyIntro() {
        return companyIntro;
    }

    public void setCompanyIntro(String companyIntro) {
        this.companyIntro = companyIntro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Corporation)) return false;
        Corporation that = (Corporation) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(company, that.company) &&
                Objects.equals(registerCap, that.registerCap) &&
                Objects.equals(detailAddress, that.detailAddress) &&
                Objects.equals(nature, that.nature) &&
                Objects.equals(registerAddress, that.registerAddress) &&
                Objects.equals(companyIntro, that.companyIntro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, registerCap, detailAddress, nature, registerAddress, companyIntro);
    }
}
