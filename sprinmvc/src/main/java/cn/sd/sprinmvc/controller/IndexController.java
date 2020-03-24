package cn.sd.sprinmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	
	@RequestMapping(value = "/index/{id}",method = RequestMethod.POST)
	public String index(@PathVariable(value="id") int ids){
		System.out.println("===ids:" + ids);
		System.out.println("index方法被映射到了");
		return "index";  //返回对应的视图，即对应的JSP页面文件的名字
	}
	
	@RequestMapping(value="/testConsumes",method = RequestMethod.POST)
	public String testConsumes(){
		System.out.println("cominto testConsumes method");
			return "success";
	}
}
