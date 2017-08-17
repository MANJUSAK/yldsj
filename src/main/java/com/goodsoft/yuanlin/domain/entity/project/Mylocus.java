package com.goodsoft.yuanlin.domain.entity.project;

/**
 * Mylocus entity. 我的轨迹表实体
 *
 * @author 严彬荣
 */
public class Mylocus implements java.io.Serializable {
    // 人员
    private String contact;
    // 工作内容
    private String details;
    // 时间
    private String date;
    // 工作类型
    private String workType;
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
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