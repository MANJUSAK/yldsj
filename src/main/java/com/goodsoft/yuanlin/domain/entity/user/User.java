package com.goodsoft.yuanlin.domain.entity.user;

import java.beans.Transient;

/**
 * function：用户实体
 * Created by 严彬荣 on 2017/8/10.
 */
public class User implements java.io.Serializable {

    private String uid;//用户编号
    private String name;//姓名
    private String userName;//用户名
    private String passWord;//密码
    private String tel;//联系方式
    private String member;//是否为会员（0为是/1为否）
    private String email;//邮箱
    private int sex;//性别（0为男/1为女）
    private String date;//注册时间
    private String idCard;//身份证号
    private String comp;//所属企业
    private String dept;//企业编号
    private int lev;//部门等级

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Transient
    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getComp() {
        return comp;
    }

    public void setComp(String comp) {
        this.comp = comp;
    }

    public int getLev() {
        return lev;
    }

    public void setLev(int lev) {
        this.lev = lev;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
