package com.goodsoft.yuanlin.domain.entity.project;

import java.util.List;

/**
 * Alteration entity. 变更管理表实体
 *
 * @author 严彬荣
 */
public class Alteration implements java.io.Serializable {

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
    //部门编号
    private String deptId;
    // 图片路径
    private List<String> picture;
    // 表ID
    private String id;
    // 项目信息编号
    private String pid;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

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

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public List<String> getPicture() {
        return picture;
    }

    public void setPicture(List<String> picture) {
        this.picture = picture;
    }
}