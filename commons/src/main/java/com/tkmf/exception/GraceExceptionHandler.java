package com.tkmf.exception;

import com.tkmf.grace.result.GraceJSONResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常拦截处理
 * 可以针对异常类型进行补货处理，然后返回信息到页面
 */
@ControllerAdvice
public class GraceExceptionHandler {
    /**
     * 只要抛出MyCustomException，就会被此方法拦截到，随后可以自定义处理
     * @param e
     * @return
     */
    @ExceptionHandler(MyCustomException.class)
    @ResponseBody
    public GraceJSONResult returnMyException(MyCustomException e) {
        e.printStackTrace();
        return GraceJSONResult.exception(e.getResponseStatus());
    }
}


