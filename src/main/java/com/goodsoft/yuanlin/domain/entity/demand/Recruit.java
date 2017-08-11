package com.goodsoft.yuanlin.domain.entity.demand;

import java.beans.Transient;

/**
 * Blueprint domain. 人员招聘表实体
 *
 * @author 严彬荣
 */
public class Recruit implements java.io.Serializable {

    // 表ID
    private Integer rid;
    // 职位
    private String positions;
    // 企业名称
    private String companyName;
    //企业简介
    private String companyIntro;
    // 企业地址
    private String companyAdress;
    // 工作地点
    private String workAdress;
    //工作内容
    private String content;
    // 联系人
    private String contact;
    //email邮箱
    private String email;
    //月薪
    private Double money;
    //工作经历
    private String experience;
    // 联系电话
    private String tel;
    //自我评价
    private String evaluate;
    //发布日期
    private String date;
    // 发布时间
    private String time;
    //招聘类型（招聘 1/求职 2）
    private int tp;
    //工作性质(全职 1/兼职 2)
    private int characters;
    //企业编号
    private String compId;
    // 用户编号
    private String uid;
    // 状态参数
    private Integer isNo;


    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getPositions() {
        return positions;
    }

    public void setPositions(String positions) {
        this.positions = positions;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyIntro() {
        return companyIntro;
    }

    public void setCompanyIntro(String companyIntro) {
        this.companyIntro = companyIntro;
    }

    public String getCompanyAdress() {
        return companyAdress;
    }

    public void setCompanyAdress(String companyAdress) {
        this.companyAdress = companyAdress;
    }

    public String getWorkAdress() {
        return workAdress;
    }

    public void setWorkAdress(String workAdress) {
        this.workAdress = workAdress;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Transient
    public int getTp() {
        return tp;
    }

    public void setTp(int tp) {
        this.tp = tp;
    }

    @Transient
    public int getCharacters() {
        return characters;
    }

    public void setCharacters(int characters) {
        this.characters = characters;
    }

    @Transient
    public String getCompId() {
        return compId;
    }

    public void setCompId(String compId) {
        this.compId = compId;
    }

    @Transient
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Transient
    public Integer getIsNo() {
        return isNo;
    }

    public void setIsNo(Integer isNo) {
        this.isNo = isNo;
    }
}
