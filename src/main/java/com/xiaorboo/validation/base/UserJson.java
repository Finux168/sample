package com.xiaorboo.validation.base;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 *
 * @Author: fgd
 * @Date: 2019-11-15
 */
@Data
public class UserJson {

    @NotEmpty(message = "username不能为空!")
    private String username;

    @Min(value = 18,message = "年龄不能小于18岁")
    @NotNull(message = "年龄不能为空!")
    private Integer age;
}
