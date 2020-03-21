package com.sd.controller;


import com.sd.common.Result;
import com.sd.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author chenj
 * @since 2020-03-21
 */
@RestController
@RequestMapping("/user")
public class UserController {
    //注册方法
    @RequestMapping("/register")
    public Result register(User user) {

        return null;
    }

    //账号验重
    @RequestMapping("/find")
    public Result find() {

        return null;
    }
}
