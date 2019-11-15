package com.xiaorboo.validation.base;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 *
 * @Author: fgd
 * @Date: 2019-11-15
 */
@Data
public class LoginJson {

    @NotEmpty(message = "用户名不能为空!")
    private String username;

    @NotEmpty(message = "密码不能为空!")
    private String password;
}
