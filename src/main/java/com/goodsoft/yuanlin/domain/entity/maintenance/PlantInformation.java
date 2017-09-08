package com.goodsoft.yuanlin.domain.entity.maintenance;

import java.util.Objects;

/**
 * 园林管护信息
 * Created by 龙宏 on 2017/8/16.
 * version v1.0
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlantInformation)) return false;
        PlantInformation that = (PlantInformation) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(code, that.code) &&
                Objects.equals(name, that.name) &&
                Objects.equals(purpose, that.purpose) &&
                Objects.equals(specifications, that.specifications) &&
                Objects.equals(address, that.address) &&
                Objects.equals(time, that.time) &&
                Objects.equals(dept, that.dept);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, purpose, specifications, address, time, dept);
    }
}
