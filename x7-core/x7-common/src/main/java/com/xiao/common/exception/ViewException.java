package com.xiao.common.exception;

import com.xiao.common.enums.AccessEnum;
import com.xiao.common.enums.ParamEnum;

/**
 * view 视图异常，用于异常返回视图
 * @author 晓
 */
public class ViewException extends RuntimeException {

    public ViewException(String  msg) {
        super(msg);
    }

    public ViewException(String  msg,Throwable cause) {
        super(msg,cause);
    }

    public ViewException(AccessEnum accessEnum) {
        super(accessEnum.toString());
    }

    public ViewException(AccessEnum accessEnum,Throwable cause) {
        super(accessEnum.toString(),cause);
    }

    public ViewException(ParamEnum paramEnum) {
        super(paramEnum.toString());
    }

    public ViewException(ParamEnum paramEnum,Throwable cause) {
        super(paramEnum.toString(),cause);
    }
}
