package com.ss.apis.controller;

import com.ss.apis.pojo.Result;
import com.ss.apis.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping(value = "/toRegister")
	public ModelAndView toRegister(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("register");
		return  modelAndView;
	}
	
	@RequestMapping("/register")
	public Result register(User user){
		Result result = new Result("1",user);
		return result;
	}
	
	

}
