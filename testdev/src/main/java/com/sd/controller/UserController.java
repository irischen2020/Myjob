package com.sd.controller;


import com.sd.common.Result;
import com.sd.pojo.User;
import com.sd.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
@Api("用户模块")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    //注册方法
//    @RequestMapping("/register")
    @PostMapping("/register")
    @ApiOperation(value = "注册方法", httpMethod = "POST")
    public Result register(User user) {
        //调用业务层方法，插入到DB，后面统一处理异常
        boolean s = userService.save(user);
        Result result = new Result("1", "注册成功");
        return result;
    }
    
    //账号验重
    @RequestMapping("/find")
    public Result find() {
    
        return null;
    }
    
    @PostMapping("/login")
    @ApiOperation(value = "登录方法", httpMethod = "POST")
    public Result login(User user) {
        Result result = null;
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            result = new Result("1", "登录成功");
        } catch (AuthenticationException e) {
            if (e instanceof UnknownAccountException) {
                result = new Result("0", "用户名错误");
            } else {
                result = new Result("0", "密码错误");
            }
            e.printStackTrace();
        }
        return result;
    }
    
    
}
