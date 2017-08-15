package com.goodsoft.yuanlin.domain.entity.project;

import com.goodsoft.yuanlin.domain.entity.file.FileData;

import java.util.List;

/**
 * Checkout entity.工序报验信息表实体
 *
 * @author 严彬荣
 */

public class Checkout implements java.io.Serializable {
    // 表id
    private Integer cid;
    // 工程名称
    private String gxName;
    // 工序名称
    private String gxProcedure;
    // 人员类型
    private String personnelType;
    // 交接者
    private String receiver;
    // 工作岗位
    private String workPost;
    // 施工日期
    private String gxTime;
    // 影像资料图编号
    private String filesId;
    // 项目信息编号pid
    private Integer pid;
    // 用户ID
    private String uid;
    // 用户ID
    private String deptId;
    // 图片路径
    private List<FileData> picture;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getGxName() {
        return gxName;
    }

    public void setGxName(String gxName) {
        this.gxName = gxName;
    }

    public String getGxProcedure() {
        return gxProcedure;
    }

    public void setGxProcedure(String gxProcedure) {
        this.gxProcedure = gxProcedure;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getPersonnelType() {
        return personnelType;
    }

    public void setPersonnelType(String personnelType) {
        this.personnelType = personnelType;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getWorkPost() {
        return workPost;
    }

    public void setWorkPost(String workPost) {
        this.workPost = workPost;
    }

    public String getGxTime() {
        return gxTime;
    }

    public void setGxTime(String gxTime) {
        this.gxTime = gxTime;
    }

    public String getFilesId() {
        return filesId;
    }

    public void setFilesId(String filesId) {
        this.filesId = filesId;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public List<FileData> getPicture() {
        return picture;
    }

    public void setPicture(List<FileData> picture) {
        this.picture = picture;
    }
}