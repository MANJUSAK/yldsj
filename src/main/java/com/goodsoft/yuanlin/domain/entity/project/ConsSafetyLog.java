package com.goodsoft.yuanlin.domain.entity.project;

/**
 * ConsSafetyLog entity.施工安全日志表实体
 *
 * @author 严彬荣
 */
public class ConsSafetyLog implements java.io.Serializable {

    //项目名称
    private String name;
    // 日期
    private String date;
    // 施工部位
    private String constLocation;
    // 施工工序动态
    private String constDynamic;
    // 安全状况
    private String sftSituation;
    // 安全问题的处理
    private String sftProblems;
    // 填写人
    private String fillPle;
    // 用户ID
    private String uid;
    //部门编号
    private String deptId;
    // 表ID
    private String id;
    //项目信息编号
    private String pid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getConstLocation() {
        return constLocation;
    }

    public void setConstLocation(String constLocation) {
        this.constLocation = constLocation;
    }

    public String getConstDynamic() {
        return constDynamic;
    }

    public void setConstDynamic(String constDynamic) {
        this.constDynamic = constDynamic;
    }

    public String getSftSituation() {
        return sftSituation;
    }

    public void setSftSituation(String sftSituation) {
        this.sftSituation = sftSituation;
    }

    public String getSftProblems() {
        return sftProblems;
    }

    public void setSftProblems(String sftProblems) {
        this.sftProblems = sftProblems;
    }

    public String getFillPle() {
        return fillPle;
    }

    public void setFillPle(String fillPle) {
        this.fillPle = fillPle;
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
