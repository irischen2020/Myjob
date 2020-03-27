package cn.sd.sprinmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Index2Controller {
	
	@RequestMapping("/testredirect")
	public String testRedirect(){
		return "redirect:/test";
	}
}
