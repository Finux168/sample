package com.xiaorboo.validation.common;

import lombok.Data;

import java.io.Serializable;

/**
 *
 *
 * @Author: fgd
 * @Date: 2019-11-15
 */
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -4779692828357703251L;

    /** 成功标志 */
    private boolean success;

    /** 提示信息 */
    private String message;

    /** 错误码  200:正常  500:未知异常  其他的具体错误码含义详见枚举定义 */
    private int code;

    /** 返回的数据对象 */
    private T data;

    /** 时间戳 */
    private long timeStamp = System.currentTimeMillis();

    public Result() {
    }

    public Result(boolean success, String message, int code, T data, long timeStamp) {
        this.success = success;
        this.message = message;
        this.code = code;
        this.data = data;
        this.timeStamp = timeStamp;
    }

    public static<T> Result<T> succ(int code,String message,T data){
        Result<T> result = new Result<>(true, message, code, data, System.currentTimeMillis());
        return result;
    }

    public static<T> Result<T> succ(String message,T data){
        return Result.succ(200,message,data);
    }

    public static<T> Result<T> succ(T data){
        return Result.succ(null,data);
    }

    public static<T> Result<T> err(int code,String message,T data){
        Result<T> result = new Result<>(false, message, code, data, System.currentTimeMillis());
        return result;
    }

    public static<T> Result<T> err(int code,String message){
        return Result.err(code,message,null);
    }
}
