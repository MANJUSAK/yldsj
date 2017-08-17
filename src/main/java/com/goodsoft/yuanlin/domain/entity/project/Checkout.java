package com.goodsoft.yuanlin.domain.entity.project;

import java.util.List;

/**
 * Checkout entity.工序报验信息表实体
 *
 * @author 严彬荣
 */

public class Checkout implements java.io.Serializable {
    // 工程名称
    private String name;
    // 工序名称
    private String gxProcedure;
    // 人员类型
    private String persType;
    // 交接者
    private String receiver;
    // 工作岗位
    private String workPost;
    // 施工日期
    private String date;
    // 影像资料图编号
    private String filesId;
    // 用户ID
    private String uid;
    // 图片路径
    private List<String> picture;
    // 表ID
    private String id;
    //项目信息编号
    private String pid;
    //部门编号
    private String deptId;

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

    public List<String> getPicture() {
        return picture;
    }

    public void setPicture(List<String> picture) {
        this.picture = picture;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersType() {
        return persType;
    }

    public void setPersType(String persType) {
        this.persType = persType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}