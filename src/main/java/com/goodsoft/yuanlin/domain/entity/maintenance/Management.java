package com.goodsoft.yuanlin.domain.entity.maintenance;

/**
 * app管护信息录入
 * Created by 龙宏 on 2017/8/16.
 */
public class Management {
    private String id;         //表ID
    private String code;       // 植株编码
    private String address;    //种植地点
    private String time;       // 养护时间
    private String personnel;  // 养护人员
    private String content;    //养护内容
    private String frontPhoto; // 养护前照片
    private String afterPhoto; // 养护后照片
    private String problem;    // 发现问题
    private String cleaning;   //保洁情况
    private String plantGrowth;//植物长势
    private String remarks;    //备注
    private String userId;     //用户ID
    private String type;       //养护类型
    private String maintenanceCode; //养护编号
    private String dept;        //部门ID

    public String getMaintenanceCode() {
        return maintenanceCode;
    }

    public void setMaintenanceCode(String maintenanceCode) {
        this.maintenanceCode = maintenanceCode;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPersonnel() {
        return personnel;
    }

    public void setPersonnel(String personnel) {
        this.personnel = personnel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFrontPhoto() {
        return frontPhoto;
    }

    public void setFrontPhoto(String frontPhoto) {
        this.frontPhoto = frontPhoto;
    }

    public String getAfterPhoto() {
        return afterPhoto;
    }

    public void setAfterPhoto(String afterPhoto) {
        this.afterPhoto = afterPhoto;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getCleaning() {
        return cleaning;
    }

    public void setCleaning(String cleaning) {
        this.cleaning = cleaning;
    }

    public String getPlantGrowth() {
        return plantGrowth;
    }

    public void setPlantGrowth(String plantGrowth) {
        this.plantGrowth = plantGrowth;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
