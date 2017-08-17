package com.goodsoft.yuanlin.domain.entity.project;

import java.util.List;

/**
 * Settlement entity.项目结算表实体
 *
 * @author 严彬荣
 */
public class Settlement implements java.io.Serializable {
    // 项目名称
    private String name;
    // 结算日期
    private String date;
    // 结算书编号
    private String filesId;
    // 用户ID
    private String uid;
    //部门编号
    private String deptId;
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

    // 图片路径
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

}