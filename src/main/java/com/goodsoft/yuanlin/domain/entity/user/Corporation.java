package com.goodsoft.yuanlin.domain.entity.user;

/**
 * Corporation entity. 法人库实体
 * <p>
 * <p>
 * date 2017-08-18
 *
 * @author 严彬荣
 */
public class Corporation implements java.io.Serializable {

    private String id; // 表id
    private String company;//企业名称
    private double registerCap;// 注册资金
    private String detailAddress;// 详细地址
    private String nature;// 经营性质
    private String registerAddress;//注册地址

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getRegisterCap() {
        return registerCap;
    }

    public void setRegisterCap(double registerCap) {
        this.registerCap = registerCap;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getRegisterAddress() {
        return registerAddress;
    }

    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress;
    }
}
