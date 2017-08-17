package com.goodsoft.yuanlin.domain.entity.project;

/**
 * SgPersonnel entity. 施工人员信息表
 *
 * @author 严彬荣
 */
public class SgPersonnel implements java.io.Serializable {
    // 项目名称
    private String name;
    // 姓名
    private String contact;
    // 身份证号码
    private String idCard;
    // 联系方式
    private String tel;
    // 人员类型
    private String persType;
    // 工作岗位
    private String workPost;
    // 用户id
    private String uid;
    //部门编号
    private String deptId;
    // 表ID
    private String id;
    //项目信息编号
    private String pid;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPersType() {
        return persType;
    }

    public void setPersType(String persType) {
        this.persType = persType;
    }

    public String getWorkPost() {
        return workPost;
    }

    public void setWorkPost(String workPost) {
        this.workPost = workPost;
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