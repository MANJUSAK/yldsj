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
    private String msg;

    public Status(int errorCode, String msg) {
        this.errorCode = errorCode;
        this.msg = msg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
