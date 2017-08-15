package com.goodsoft.yuanlin.domain.entity.project;

/**
 * Mylocus entity. 我的轨迹表实体
 *
 * @author 严彬荣
 */
public class Mylocus implements java.io.Serializable {
    // 表id
    private Integer mid;
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

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
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