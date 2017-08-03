package com.goodsoft.yuanlin.entity;

/**
 * function 用户表实体
 * Created by 严彬荣 on 2017/8/3.
 */
public class User {

    private String tel;
    private String userName;
    private String passWord;
    private int gender;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
