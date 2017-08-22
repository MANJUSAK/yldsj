package com.goodsoft.yuanlin.domain.entity.trade;

/**
 * function 联系协会实体
 * Created by 严彬荣 on 2017/8/21.
 */
public class Contact implements java.io.Serializable {
    private int id;//表id
    private String name;//姓名
    private String tel;//联系方式
    private String address;//联系地址
    private String email;//联系邮箱
    private String webSite;//联系网址
    private int postCode;//邮编
    private String date;//时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
