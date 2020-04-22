package com.ss.apis.controller;

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

////		准备数据
//		List<String> names = new ArrayList<>();
//		names.add("11");
//		names.add("22");
//		//设置要传到模板中的数据
//		modelAndView.addObject("names",names);
//		modelAndView.setViewName("showNames");
		modelAndView.setViewName("register");
		return  modelAndView;
		
	}

}
