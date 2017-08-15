package com.goodsoft.yuanlin.domain.entity.project;

/**
 * ConstructionSafetyLog entity.施工安全日志表实体
 *
 * @author 严彬荣
 */
public class ConstructionSafetyLog implements java.io.Serializable {

    // 表ID
    private Integer cid;
    // 日期
    private String dates;
    // 施工部位
    private String constLocation;
    // 施工工序动态
    private String constDynamic;
    // 安全状况
    private String sftSituation;
    // 安全问题的处理
    private String sftProblems;
    // 填写人
    private String fillPeople;
    // 用户ID
    private String uid;
    // 项目编号
    private Integer pid;
    //部门编号
    private String deptId;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
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

    public String getFillPeople() {
        return fillPeople;
    }

    public void setFillPeople(String fillPeople) {
        this.fillPeople = fillPeople;
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
}
