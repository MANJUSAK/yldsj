package com.goodsoft.yuanlin.domain.entity.project;

import com.goodsoft.yuanlin.domain.entity.file.FileData;

import java.util.List;

/**
 * Finalacceptance entity.竣工验收表实体
 *
 * @author 严彬荣
 */
public class Finalacceptance implements java.io.Serializable {
    // 表ID
    private Integer fid;
    // 工程名称
    private String name;
    // 竣工时间
    private String date;
    // 验收员
    private String insPersonnel;
    // 验收图路径编号
    private String filesId;
    //部门编号
    private String deptId;
    // 用户编号
    private String uid;
    // 项目编号
    private Integer pid;
    // 文件路径
    private List<FileData> picture;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInsPersonnel() {
        return insPersonnel;
    }

    public void setInsPersonnel(String insPersonnel) {
        this.insPersonnel = insPersonnel;
    }

    public String getFilesId() {
        return filesId;
    }

    public void setFilesId(String filesId) {
        this.filesId = filesId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
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

    public List<FileData> getPicture() {
        return picture;
    }

    public void setPicture(List<FileData> picture) {
        this.picture = picture;
    }
}