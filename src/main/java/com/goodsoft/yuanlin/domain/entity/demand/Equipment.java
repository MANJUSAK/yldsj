package com.goodsoft.yuanlin.domain.entity.demand;

import com.goodsoft.yuanlin.domain.entity.file.FileData;

import java.beans.Transient;
import java.util.List;

/**
 * Equipment domain. 设备租赁信息表实体
 *
 * @author 严彬荣
 */
public class Equipment implements java.io.Serializable {

    // 表ID
    private Integer eid;
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
    // 状态参数
    private Integer isNo;
    // 文件路径
    private List<FileData> picture;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
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

    @Transient
    public Integer getIsNo() {
        return isNo;
    }

    public void setIsNo(Integer isNo) {
        this.isNo = isNo;
    }

    public List<FileData> getPicture() {
        return picture;
    }

    public void setPicture(List<FileData> picture) {
        this.picture = picture;
    }
}