package com.xiaorboo.validation.middle;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 *
 * @Author: fgd
 * @Date: 2019-11-15
 */
@Data
public class UserCodeJson {

    @NotEmpty(message = "10000")
    private String username;
}
