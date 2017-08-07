package com.goodsoft.yuanlin.util.resultentity;

/**
 * function 返回结果集实体（无文件）
 * <p>
 * date 2017.06.19
 *
 * @author 严彬荣
 */
public class Result implements java.io.Serializable {

    // 状态码
    private int errorCode;
    // 返回数据
    private Object data;

    public Result() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Result(int errorCode, Object data) {
        super();
        this.errorCode = errorCode;
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
