package com.goodsoft.yuanlin.util.resultentity;

/**
 * function 状态信息提示返回结果集实体
 * <p>
 * date 2017.06.19
 *
 * @author 严彬荣
 */
public class Status implements java.io.Serializable {
    private int errorcode;
    private String mag;

    public Status(int errorcode, String mag) {
        this.errorcode = errorcode;
        this.mag = mag;
    }

    public int getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(int errorcode) {
        this.errorcode = errorcode;
    }

    public String getMag() {
        return mag;
    }

    public void setMag(String mag) {
        this.mag = mag;
    }
}
