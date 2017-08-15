package com.goodsoft.yuanlin.domain.entity.project;

import com.goodsoft.yuanlin.domain.entity.file.FileData;

import java.util.List;

/**
 * Alteration entity. 变更管理表实体
 *
 * @author 严彬荣
 */
public class Alteration implements java.io.Serializable {
    // 表ID
    private Integer aid;
    // 项目名称
    private String name;
    // 确认方
    private String confParty;
    // 变更时间
    private String time;
    // 变更依据图片路径编号
    private String filesId;
    // 用户ID
    private String uid;
    // 项目信息编号
    private Integer pid;
    //部门编号
    private String deptId;
    // 图片路径
    private List<FileData> picture;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConfParty() {
        return confParty;
    }

    public void setConfParty(String confParty) {
        this.confParty = confParty;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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