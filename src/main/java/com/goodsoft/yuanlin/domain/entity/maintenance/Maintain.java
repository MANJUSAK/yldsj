package com.goodsoft.yuanlin.domain.entity.maintenance;

import java.util.Objects;

/**
 * 养护信息
 * Created by 龙宏 on 2017/8/17.
 * version v1.0
 */
public class Maintain {
    private String id; //表ID
    private String code; //植物编号
    private String state; // 养护状态
    private String time;  //养护时间
    private String address;  // 养护地点
    private String userId;   //用户ID
    private String dept;  //部门ID
    private String status; //管护状态

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Maintain)) return false;
        Maintain maintain = (Maintain) o;
        return Objects.equals(id, maintain.id) &&
                Objects.equals(code, maintain.code) &&
                Objects.equals(state, maintain.state) &&
                Objects.equals(time, maintain.time) &&
                Objects.equals(address, maintain.address) &&
                Objects.equals(userId, maintain.userId) &&
                Objects.equals(dept, maintain.dept) &&
                Objects.equals(status, maintain.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, state, time, address, userId, dept, status);
    }
}
