package com.xiaorboo.validation.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 错误码枚举类
 *
 * @Author: fgd
 * @Date: 2019-11-15
 */
public enum ErrorCodes {

    USER_USERNAME_NOT_NULL(10000,"username不能为空!"),
    USER_PASSWORD_NOT_NULL(10001,"password不能为空!"),

    APPVERSION_NUM_NOT_MATCH(10010,"版本号不匹配!"),
    APPVERSION_NUM_INCORRECT(10011,"版本号不正确!")
    ;

    public static final Map<Integer,ErrorCodes> MAP = new HashMap<>();

    static {
        for (ErrorCodes errorCode : ErrorCodes.values()){
            MAP.put(errorCode.code,errorCode);
        }
    }

    private Integer code;

    private String message;

    ErrorCodes(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static ErrorCodes getErrorCodeByCode(Integer code){
       return MAP.get(code);
    }
}
