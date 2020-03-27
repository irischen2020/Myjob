package cn.sd.sprinmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Index2Controller {
	
	@RequestMapping(value="/testGet",method = RequestMethod.GET)
	public String testGet(){
		return "success";
	}
	
	@RequestMapping(value="/testPost",method = RequestMethod.POST)
	public String testPost(){
		return "success";
	}
	
	@RequestMapping(value="/testPut",method = RequestMethod.PUT)
	public String testPut(){
		return "success";
	}
	
	@RequestMapping(value="/testGet",method = RequestMethod.DELETE)
	public String testDelete(){
		return "success";
	}

}
