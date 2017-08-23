package com.goodsoft.yuanlin.domain.entity.user;

/**
 * employees entity. 从业人员库表实体
 * <p>
 * <p>
 * date 2017-08-18
 *
 * @author 严彬荣
 */
public class Employees implements java.io.Serializable {
    // 表id
    private String id;
    // 姓名
    private String name;
    // 性别
    private int gender;
    // 隶属企业
    private String company;
    //是否继续教育
    private String education;
    //从业经历
    private String experience;

    public String getId() {
        return id;
    }

    public void setGender(int gender) {
        this.gender = gender;
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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}
