package com.xiao.common.handle;

import com.xiao.common.exception.RestfulException;
import com.xiao.common.exception.ViewException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 * @author 晓
 */
@ControllerAdvice
public class ExceptionHandle {

    /**
     * 全局的异常处理-返回数据
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public String dealException(RuntimeException e){

        return e.getMessage();
    }

    /**
     * 全局的异常处理-返回数据
     * @return
     */
    @ExceptionHandler(RestfulException.class)
    @ResponseBody
    public String dealException(RestfulException e){

        return e.getMessage();
    }

    /**
     * 全局的异常处理-返回视图
     * @return
     */
    @ExceptionHandler(ViewException.class)
    public String dealException(ViewException e, Model model){
        model.addAttribute("info",e.getMessage());
        return "error";
    }
}
