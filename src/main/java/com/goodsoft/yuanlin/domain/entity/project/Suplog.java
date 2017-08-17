package com.goodsoft.yuanlin.domain.entity.project;

/**
 * Suplog entity.监理日志表实体
 *
 * @author 严彬荣
 */
public class Suplog implements java.io.Serializable {
    // 工程名称
    private String name;
    // 监理部位
    private String supLocation;
    // 工程施工进度情况
    private String proSituation;
    // 监理工作情况
    private String workSitustion;
    // 存在及处理问题
    private String question;
    // 日期
    private String date;
    // 记录人
    private String noteTaker;
    // 监理工程师
    private String engineer;
    // 其它有关事项
    private String other;
    // 用户编号
    private String uid;
    //部门编号
    private String deptId;
    //项目信息编号
    private String pid;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
    // 表ID
    private String id;

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

    public String getSupLocation() {
        return supLocation;
    }

    public void setSupLocation(String supLocation) {
        this.supLocation = supLocation;
    }

    public String getProSituation() {
        return proSituation;
    }

    public void setProSituation(String proSituation) {
        this.proSituation = proSituation;
    }

    public String getWorkSitustion() {
        return workSitustion;
    }

    public void setWorkSitustion(String workSitustion) {
        this.workSitustion = workSitustion;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNoteTaker() {
        return noteTaker;
    }

    public void setNoteTaker(String noteTaker) {
        this.noteTaker = noteTaker;
    }

    public String getEngineer() {
        return engineer;
    }

    public void setEngineer(String engineer) {
        this.engineer = engineer;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
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