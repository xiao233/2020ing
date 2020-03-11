package com.xiao.common.enums;

/**
 * 权限访问枚举类
 * @author 晓
 */
public enum AccessEnum{
    ACCESS_SUCCESS("AC000000","访问成功!"),

    ACCESS_FAIL("AC000001","没有访问权限!"),

    ACCESS_ERROR("AC100000","访问异常!")
    ;

    private String code;

    private String msg;

    AccessEnum(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "{" + "code: " + code+ ", msg: " + msg + '}';
    }
}
