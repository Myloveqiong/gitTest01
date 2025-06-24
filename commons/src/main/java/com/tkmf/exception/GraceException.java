package com.tkmf.exception;
import com.tkmf.grace.enums.ResponseStatusEnum;

/**
 * 优雅处理异常，统一封装
 */
public class GraceException {
    public static void display(ResponseStatusEnum responseStatus) {
        throw new MyCustomException(responseStatus);
    }
}


