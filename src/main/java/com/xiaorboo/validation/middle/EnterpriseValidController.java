package com.xiaorboo.validation.middle;

import com.xiaorboo.validation.common.CustomException;
import com.xiaorboo.validation.common.ErrorCodes;
import com.xiaorboo.validation.common.ValidateUtils;
import com.xiaorboo.validation.middle.UserCodeJson;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 优雅校验
 *
 * @Author: fgd
 * @Date: 2019-11-15
 */
@RestController
@RequestMapping("enterpriseValid")
public class EnterpriseValidController {

    @GetMapping("getUser")
    public String getUser(@Valid UserCodeJson userCodeJson, BindingResult bindingResult){
        ErrorCodes errorCodes = ValidateUtils.invoke(bindingResult);
        if (errorCodes != null){
            throw new CustomException(errorCodes);
        }
        return userCodeJson.toString();
    }
}
