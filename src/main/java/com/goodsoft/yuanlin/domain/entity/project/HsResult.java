package com.goodsoft.yuanlin.domain.entity.project;

import com.goodsoft.yuanlin.domain.entity.file.FileData;

import java.util.List;

/**
 * HsResult entity. 会审结果表实体
 *
 * @author 严彬荣
 */
public class HsResult implements java.io.Serializable {
    // 表id
    private Integer hid;
    // 项目名称
    private String name;
    // 会审单位
    private String company;
    // 会审图片编号
    private String filesId;
    // 用户id
    private String uid;
    // 项目编号
    private Integer pid;
    //部门编号
    private String deptId;
    // 图片路径
    private List<FileData> picture;

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFilesId() {
        return filesId;
    }

    public void setFilesId(String filesId) {
        this.filesId = filesId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public List<FileData> getPicture() {
        return picture;
    }

    public void setPicture(List<FileData> picture) {
        this.picture = picture;
    }
}