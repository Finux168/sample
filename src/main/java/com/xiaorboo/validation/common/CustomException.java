package com.xiaorboo.validation.common;

import com.xiaorboo.validation.common.ErrorCodes;
import lombok.Getter;
import lombok.Setter;

/**
 * 自定义异常
 *
 * @Author: fgd
 * @Date: 2019-11-15
 */
@Getter
@Setter
public class CustomException extends RuntimeException {

    private Integer code;

    private String msg;

    private Object result;

    public CustomException(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public CustomException(Integer code,String msg,Object result){
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public CustomException(ErrorCodes resultEnum){
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMessage();
    }

    public CustomException(ErrorCodes resultEnum,Object result){
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMessage();
        this.result = result;
    }
}
