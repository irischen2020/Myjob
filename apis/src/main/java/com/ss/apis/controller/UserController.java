package com.ss.apis.controller;

import com.ss.apis.pojo.Result;
import com.ss.apis.pojo.User;
import com.ss.apis.service.UserService;
import com.ss.apis.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/toRegister")
	public ModelAndView toRegister(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("register");
		return  modelAndView;
	}
	
	@RequestMapping("/register")
	public Result register(User user){
		Result result = null;
		user.setRegtime(DateUtil.formatyy_ss(new Date()));
		try {
			userService.add(user);
			new Result("1","注册成功");
			
		} catch (Exception e) {
			e.printStackTrace();
			new Result("0","注册失败");
		}
		
		return result;
	}
	
	
}
