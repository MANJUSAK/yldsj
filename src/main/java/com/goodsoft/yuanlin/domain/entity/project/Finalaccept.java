package com.goodsoft.yuanlin.domain.entity.project;

import java.util.List;

/**
 * Finalaccept entity.竣工验收表实体
 *
 * @author 严彬荣
 */
public class Finalaccept implements java.io.Serializable {
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
    // 表ID
    private String id;
    //项目信息编号
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

    public List<String> getPicture() {
        return picture;
    }

    public void setPicture(List<String> picture) {
        this.picture = picture;
    }

    // 文件路径
    private List<String> picture;

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


}