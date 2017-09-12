package com.goodsoft.yuanlin.domain.entity.demand;

import com.goodsoft.yuanlin.domain.entity.file.FileData;

import java.beans.Transient;
import java.util.List;
import java.util.Objects;

/**
 * Equipment domain. 设备租赁信息表实体
 * <p>
 * author 严彬荣
 * version v1.0
 */
public class Equipment implements java.io.Serializable {

    // 标题名称
    private String titleName;
    // 内容
    private String content;
    //发布日期
    private String date;
    // 发布时间
    private String time;
    // 联系人
    private String contact;
    // 联系电话
    private String tel;
    // 图片文件编号
    private String filesId;
    //企业
    private String comp;
    // 用户编号
    private String uid;
    // 文件路径
    private List<FileData> picture;

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

    public String getFilesId() {
        return filesId;
    }

    public void setFilesId(String filesId) {
        this.filesId = filesId;
    }

    public String getComp() {
        return comp;
    }

    public void setComp(String comp) {
        this.comp = comp;
    }

    @Transient
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public List<FileData> getPicture() {
        return picture;
    }

    public void setPicture(List<FileData> picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipment)) return false;
        Equipment equipment = (Equipment) o;
        return Objects.equals(titleName, equipment.titleName) &&
                Objects.equals(content, equipment.content) &&
                Objects.equals(date, equipment.date) &&
                Objects.equals(time, equipment.time) &&
                Objects.equals(contact, equipment.contact) &&
                Objects.equals(tel, equipment.tel) &&
                Objects.equals(filesId, equipment.filesId) &&
                Objects.equals(comp, equipment.comp) &&
                Objects.equals(uid, equipment.uid) &&
                Objects.equals(picture, equipment.picture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titleName, content, date, time, contact, tel, filesId, comp, uid, picture);
    }
}