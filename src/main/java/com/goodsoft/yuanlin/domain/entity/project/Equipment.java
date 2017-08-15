package com.goodsoft.yuanlin.domain.entity.project;

/**
 * Equipment entity.设备信息数据表实体
 *
 * @author 严彬荣
 */
public class Equipment implements java.io.Serializable {

    // 表id
    private Integer eid;
    // 项目名称
    private String name;
    // 设备名称
    private String sbName;
    // 设备型号
    private String sbSpec;
    // 设备数量
    private Integer sbNum;
    // 设备用途
    private String sbPurpose;
    // 设备来源
    private String sbSource;
    //部门编号
    private String deptId;
    // 用户id
    private String uid;
    // 项目编号
    private Integer pid;


    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSbName() {
        return sbName;
    }

    public void setSbName(String sbName) {
        this.sbName = sbName;
    }

    public String getSbSpec() {
        return sbSpec;
    }

    public void setSbSpec(String sbSpec) {
        this.sbSpec = sbSpec;
    }

    public Integer getSbNum() {
        return sbNum;
    }

    public void setSbNum(Integer sbNum) {
        this.sbNum = sbNum;
    }

    public String getSbPurpose() {
        return sbPurpose;
    }

    public void setSbPurpose(String sbPurpose) {
        this.sbPurpose = sbPurpose;
    }

    public String getSbSource() {
        return sbSource;
    }

    public void setSbSource(String sbSource) {
        this.sbSource = sbSource;
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