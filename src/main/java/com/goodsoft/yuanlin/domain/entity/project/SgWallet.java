package com.goodsoft.yuanlin.domain.entity.project;

/**
 * SgWallet entity. 施工钱包实体
 *
 * @author 严彬荣
 */
public class SgWallet implements java.io.Serializable {

    // 表ID
    private String id;
    //项目名称
    private String name;
    //施工单位
    private String company;
    //记录人
    private String contact;
    // 用户ID
    private String uid;
    //项目编号
    private String pid;
    //部门编号
    private String deptId;
    // 金额
    private Double money;
    // 类型(0为收入/1为支出)
    private int type;
    // 备注
    private String comment;
    // 交易时间
    private String date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}