package com.xiaorboo.validation.base;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 入参绑定 {@link BindingResult} 的时候,validate异常不会被抛出,
 * 也就不会被{@link org.springframework.web.bind.annotation.RestControllerAdvice}捕获到
 *
 * 本controller只对校验进行分析
 *
 * @Author: fgd
 * @Date: 2019-11-15
 */
@RestController
@RequestMapping("valid")
public class ValidController {

    /**
     * 当使用{@link Valid} 校验时, {@link RequestParam}注解的错误并不会绑定到{@link BindingResult}中.
     * 所以建议不要使用{@link RequestParam}注解
     *
     * @param userJson
     * @param sex
     * @param bindingResult
     * @return
     */
    @GetMapping("getUser")
    public String getUser(@Valid UserJson userJson,@RequestParam("sex")String sex,BindingResult bindingResult){
        System.out.println(bindingResult.toString());
        return userJson.toString();
    }

    @PostMapping("login")
    public String login(@Valid @RequestBody LoginJson loginJson,BindingResult bindingResult){
        for (ObjectError error : bindingResult.getAllErrors()) {
            System.out.println(error.getDefaultMessage());
        }
        return loginJson.toString();
    }


}
