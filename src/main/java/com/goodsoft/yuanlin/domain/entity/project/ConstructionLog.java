package com.goodsoft.yuanlin.domain.entity.project;

/**
 * ConstructionLog entity.施工日志表实体
 *
 * @author 严彬荣
 */
public class ConstructionLog implements java.io.Serializable {
    // 表ID
    private Integer cid;
    // 项目名称
    private String name;
    // 施工日期
    private String date;
    // 生产活动内容
    private String proContent;
    // 技术安全技术指标
    private String tecIndex;
    // 施工员
    private String builder;
    // 工程项目负责人
    private String principal;
    // 完成工作情况
    private String workCondition;
    //部门编号
    private String deptId;
    // 用户编号
    private String uid;
    // 项目编号
    private Integer pid;


    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuilder() {
        return builder;
    }

    public void setBuilder(String builder) {
        this.builder = builder;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProContent() {
        return proContent;
    }

    public void setProContent(String proContent) {
        this.proContent = proContent;
    }

    public String getTecIndex() {
        return tecIndex;
    }

    public void setTecIndex(String tecIndex) {
        this.tecIndex = tecIndex;
    }

    public String getWorkCondition() {
        return workCondition;
    }

    public void setWorkCondition(String workCondition) {
        this.workCondition = workCondition;
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

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}