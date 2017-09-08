package com.goodsoft.yuanlin.domain.entity.recommend;

import java.util.List;
import java.util.Objects;

/**
 * function 企业推荐实体
 * Created by 严彬荣 on 2017/8/11.
 * version v1.0
 */
public class RecomComp implements java.io.Serializable {
    private String id;//数据id
    private String companyName;//企业名称
    private String registFund;//注册资金
    private String registAdress;//注册地址
    private String detailAdress;//详细地址
    private String nature;//经营性质
    private String companyProfile;// 企业简介
    private String registeredId;//营业执照编号
    private String qualificationId;//资质证书编号
    private List<String> picture;//文件

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRegistFund() {
        return registFund;
    }

    public void setRegistFund(String registFund) {
        this.registFund = registFund;
    }

    public String getRegistAdress() {
        return registAdress;
    }

    public void setRegistAdress(String registAdress) {
        this.registAdress = registAdress;
    }

    public String getDetailAdress() {
        return detailAdress;
    }

    public void setDetailAdress(String detailAdress) {
        this.detailAdress = detailAdress;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getCompanyProfile() {
        return companyProfile;
    }

    public void setCompanyProfile(String companyProfile) {
        this.companyProfile = companyProfile;
    }

    public String getRegisteredId() {
        return registeredId;
    }

    public void setRegisteredId(String registeredId) {
        this.registeredId = registeredId;
    }

    public String getQualificationId() {
        return qualificationId;
    }

    public void setQualificationId(String qualificationId) {
        this.qualificationId = qualificationId;
    }

    public List<String> getPicture() {
        return picture;
    }

    public void setPicture(List<String> picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecomComp)) return false;
        RecomComp recomComp = (RecomComp) o;
        return Objects.equals(id, recomComp.id) &&
                Objects.equals(companyName, recomComp.companyName) &&
                Objects.equals(registFund, recomComp.registFund) &&
                Objects.equals(registAdress, recomComp.registAdress) &&
                Objects.equals(detailAdress, recomComp.detailAdress) &&
                Objects.equals(nature, recomComp.nature) &&
                Objects.equals(companyProfile, recomComp.companyProfile) &&
                Objects.equals(registeredId, recomComp.registeredId) &&
                Objects.equals(qualificationId, recomComp.qualificationId) &&
                Objects.equals(picture, recomComp.picture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyName, registFund, registAdress, detailAdress, nature, companyProfile, registeredId, qualificationId, picture);
    }
}
