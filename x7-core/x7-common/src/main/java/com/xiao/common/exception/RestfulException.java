package com.xiao.common.exception;

import com.xiao.common.enums.AccessEnum;
import com.xiao.common.enums.ParamEnum;

/**
 * Restful api 异常,用于全局捕获此异常返回数据
 *
 * @author 晓
 */
public class RestfulException extends RuntimeException {

    public RestfulException(String  msg) {
        super(msg);
    }

    public RestfulException(String  msg,Throwable cause) {
        super(msg,cause);
    }

    public RestfulException(AccessEnum accessEnum){
        super(accessEnum.toString());
    }

    public RestfulException(AccessEnum accessEnum,Throwable cause){
        super(accessEnum.toString(),cause);
    }

    public RestfulException(ParamEnum paramEnum) {
        super(paramEnum.toString());
    }

    public RestfulException(ParamEnum paramEnum,Throwable cause) {
        super(paramEnum.toString(),cause);
    }
}
