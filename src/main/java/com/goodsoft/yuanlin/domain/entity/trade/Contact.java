package com.goodsoft.yuanlin.domain.entity.trade;

import java.util.Objects;

/**
 * function 联系协会实体
 * Created by 严彬荣 on 2017/8/21.
 * version v1.0
 */
public class Contact implements java.io.Serializable {
    private String id;//表id
    private String name;//姓名
    private String tel;//联系方式
    private String address;//联系地址
    private String email;//联系邮箱
    private String webSite;//联系网址
    private int postCode;//邮编
    private String date;//日期
    private String time;//时间

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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return id == contact.id &&
                postCode == contact.postCode &&
                Objects.equals(name, contact.name) &&
                Objects.equals(tel, contact.tel) &&
                Objects.equals(address, contact.address) &&
                Objects.equals(email, contact.email) &&
                Objects.equals(webSite, contact.webSite) &&
                Objects.equals(date, contact.date) &&
                Objects.equals(time, contact.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, tel, address, email, webSite, postCode, date, time);
    }
}
