package cn.sd.sprinmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/index")
	public String index(){
		
		return "index";  //返回对应的视图，即对应的JSP页面文件的名字
	}
}
