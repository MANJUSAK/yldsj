package com.goodsoft.yuanlin.domain.entity.maintenance;

/**
 * 园林管护信息
 * Created by 龙宏 on 2017/8/16.
 */
public class PlantInformation {
    /**
     * ID
     */
    private String id;

    /**
     * 植株编码
     */
    private String code;
    /**
     * 植株名称
     */
    private String name;
    /**
     * 植株用途
     */
    private String purpose;
    /**
     * 植株规格
     */
    private String specifications;
    /**
     * 种植地点
     */
    private String address;
    /**
     * 录入时间
     */
    private String time;

    /**
     * 部门ID
     *
     * @return
     */
    private String dept;

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
