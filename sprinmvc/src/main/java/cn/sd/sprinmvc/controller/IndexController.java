package cn.sd.sprinmvc.controller;

import cn.sd.sprinmvc.dao.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Controller
public class IndexController {
	
	@RequestMapping(value = {"/index/{id}", "/", ""}, method = RequestMethod.GET)
	public String index(@PathVariable(value = "id") int ids) {
		System.out.println("===ids:" + ids);
		System.out.println("index方法被映射到了");
		return "index";  //返回对应的视图，即对应的JSP页面文件的名字
	}
	
	@RequestMapping(value = "/testConsumes", method = RequestMethod.POST)
	public String testConsumes() {
		System.out.println("cominto testConsumes method");
		return "success";
	}
	
	@RequestMapping(value = "/testRequestParam", method = RequestMethod.POST)
	public String testRequestParam(@RequestParam String username, @RequestParam String password) {
		System.out.println("===username:" + username);
		System.out.println("===password:" + password);
		return "success";
	}
	
	@RequestMapping(value = "/testRequestHeader")
	public String testRequestHeader() {
		return "success";
	}
	
	//	从JSP页面里传数据到SpringMVC中的CONTROLLER处理
//	第一种方法：直接读取表单数据
	@RequestMapping("/testjsp2mvc")
	public void testJsp2Mvc(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		int age = Integer.parseInt(req.getParameter("age"));
		System.out.println("===username:" + username);
		System.out.println("===password:" + password);
		System.out.println("===agess:" + age);
	}
	
	//	第二种方法：参数映射
	@RequestMapping(value = "/testjsp2mvcc", method = RequestMethod.POST)
	public void testJsp2Mvcc(@RequestParam String username, @RequestParam String password, @RequestParam int age) {
		System.out.println("===username:" + username);
		System.out.println("===password:" + password);
		System.out.println("===age:" + age);
	}
	
	//第三种方法：直接封装成对象  用得最多
	@RequestMapping("/testjsp2mvcc2")
	public void testJsp2Mvcc2(User user){
		System.out.println("===username:" + user.getUserName());
		System.out.println("===username:" + user.getAge());
	}
	
}