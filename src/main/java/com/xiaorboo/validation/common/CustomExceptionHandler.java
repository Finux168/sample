package com.xiaorboo.validation.common;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @Author: fgd
 * @Date: 2019-11-15
 */
@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public Result<String> handleCustomException(CustomException e){
        return Result.err(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result<String> handle(Exception e){
        e.printStackTrace();
        return Result.err(500,e.getMessage());
    }
}
