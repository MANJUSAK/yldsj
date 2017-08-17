package com.goodsoft.yuanlin.domain.entity.project;

/**
 * KgReport entity. 开工报告实体
 *
 * @author 严彬荣
 */
public class KgReport implements java.io.Serializable {
    // 项目名称
    private String name;
    // 开工日期
    private String date;
    //文件编号
    private String filesId;
    // 用户ID
    private String uid;
    //部门编号
    private String deptId;
    //确认文件
    private String document;
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

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}