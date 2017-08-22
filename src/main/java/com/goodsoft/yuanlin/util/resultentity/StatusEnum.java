package com.goodsoft.yuanlin.util.resultentity;

/**
 * function 系统响应状态提示枚举类
 * <p>
 * Created by 严彬荣 on 2017/7/24.
 */
public enum StatusEnum implements java.io.Serializable {
    SUCCESS(0, "成功"),
    SERVER_ERROR(500, "服务器繁忙"),
    DEFEAT(500, "失败"),
    UNKONW_ERROR(501, "未知错误"),
    ERROR(502, "错误操作"),
    NO_DATA(404, "无数据"),
    NO_URL(404, "无效请求"),
    NO_RIGHTS(401, "该用户无法操作此功能"),
    NO_ADD(401, "信息不能重复录入"),
    NO_ADDMAINANCE(405, "本植株已经养护过，请明天再来吧！"),
    NO_ADDMABAGEMENT(405, "本植株已经管护过，请明天再来吧！"),
    CHECKUSER(404, "用户名与密码不匹配或已被禁用"),
    USERNAME(402, "用户名已被注册"),
    CHECK_DATA(407, "请正确填写信息后重试"),
    FILE_UPLOAD(600, "文件上传失败，请重试"),
    FILE_SIZE(601, "文件大小不符合要求"),
    FILE_FORMAT(603, "文件格式不正确"),
    NO_FILE(604, "文件不能为空"),
    CHECKCODE(402, "验证码不正确"),
    NO_PRAM(400, "参数错误");


    private final int CODE;
    private final String EXPLAIN;

    StatusEnum(int CODE, String EXPLAIN) {
        this.CODE = CODE;
        this.EXPLAIN = EXPLAIN;
    }

    public int getCODE() {
        return CODE;
    }

    public String getEXPLAIN() {
        return EXPLAIN;
    }
}
