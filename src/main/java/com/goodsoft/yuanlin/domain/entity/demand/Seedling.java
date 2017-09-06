package com.goodsoft.yuanlin.domain.entity.demand;

import com.goodsoft.yuanlin.domain.entity.file.FileData;

import java.beans.Transient;
import java.util.List;

/**
 * Seedling domain. 苗木信息表实体
 *
 * @author 严彬荣
 */
public class Seedling implements java.io.Serializable {
    // 表ID
    private Integer sid;
    // 标题名称
    private String titleName;
    // 内容
    private String content;
    // 联系人
    private String contact;
    // 联系电话
    private String tel;
    //发布日期
    private String date;
    // 发布时间
    private String time;
    // 供应商地址
    private String address;
    // 供应商
    private String supplier;
    // 苗木种类
    private String breed;
    //胸径
    private String dbh;
    //蓬径
    private String pdt;
    //高度
    private String height;
    //数量
    private String num;
    //单位
    private String unit;
    //价格
    private String price;
    // 苗木子种类
    private String sub;
    // 文件编号
    private String filesId;
    // 文件路径
    private List<FileData> picture;
    //发布企业
    private String comp;
    // 用户编号
    private String uid;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getFilesId() {
        return filesId;
    }

    public void setFilesId(String filesId) {
        this.filesId = filesId;
    }

    public List<FileData> getPicture() {
        return picture;
    }

    public void setPicture(List<FileData> picture) {
        this.picture = picture;
    }

    public String getComp() {
        return comp;
    }

    public void setComp(String comp) {
        this.comp = comp;
    }

    public String getDbh() {
        return dbh;
    }

    public void setDbh(String dbh) {
        this.dbh = dbh;
    }

    public String getPdt() {
        return pdt;
    }

    public void setPdt(String pdt) {
        this.pdt = pdt;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Transient
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

}