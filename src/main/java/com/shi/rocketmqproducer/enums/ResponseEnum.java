package com.shi.rocketmqproducer.enums;

public enum ResponseEnum {
    SUCCESS(200, "成功"),
    USER_NOTLOGIN(300,"用户未登录"),
    USER_NOAUTHORITY(403,"用户没有权限"),
    VISIT_ERROR(500,"访问异常");


    private Integer code;

    private String msg;

    ResponseEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
