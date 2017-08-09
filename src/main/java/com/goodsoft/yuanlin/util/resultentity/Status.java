package com.goodsoft.yuanlin.util.resultentity;

/**
 * function 状态信息提示返回结果集实体
 * <p>
 * date 2017.06.19
 *
 * @author 严彬荣
 */
public class Status implements java.io.Serializable {
    private int errorCode;
    private String mag;

    public Status(int errorCode, String mag) {
        this.errorCode = errorCode;
        this.mag = mag;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMag() {
        return mag;
    }

    public void setMag(String mag) {
        this.mag = mag;
    }
}
