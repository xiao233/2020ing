package com.xiao.common.enums;

/**
 * 参数处理枚举类
 * @author 晓
 */
public enum ParamEnum {
    PARAM_SUCCESS("PA000000","参数正常!"),

    PARAM_NOT_EMPTY("PA000001","参数不能为空!")
    ;


    private String code;

    private String msg;

    ParamEnum(String code,String msg){
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
        return "{" + "code: " + code + ", msg: " + msg + '}';
    }
}
