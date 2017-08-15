package com.goodsoft.yuanlin.domain.entity.project;

/**
 * KgReport entity. 开工报告实体
 *
 * @author 严彬荣
 */
public class KgReport implements java.io.Serializable {
    // 表ID
    private Integer kid;
    // 项目名称
    private String name;
    // 开工日期
    private String time;
    //文件编号
    private String filesId;
    // 用户ID
    private String uid;
    // 项目编号
    private Integer pid;
    //部门编号
    private String deptId;
    //确认文件
    private String document;

    public Integer getKid() {
        return kid;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}