package cn.sd.sprinmvc.controller;

import cn.sd.sprinmvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @SessionAttributes:会在处理方法testMV2中的model.addAttribute("name2","hahaha");
 * 这个方法把键值对放进了model，把model里面的数据，最终放入REQUEST域。
 * SessionAttributes会将键值对放进REQUEST域的同时，将这个键值对的一个副本同时放入HttpSession的域空间里
 */
//@SessionAttributes(value={"name2","user2"})
//@SessionAttributes(types = {User.class,String.class})   types根据类型来还未实现
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
	public void testJsp2Mvcc2(User user) {
		System.out.println("===username:" + user.getUserName());
		System.out.println("===username:" + user.getAge());
	}
	
	//控制器返回的数据注入到前台页面
//	第一种方式：通过ModelAndView。
	@RequestMapping("/testMV")
	public ModelAndView testMV() {
		ModelAndView mv = new ModelAndView();
		//注入字符串
		mv.addObject("name", "xiaobai");
		
		//注入对象
		User user = new User();
		user.setId(1);
		user.setUserName("dabai");
		user.setAge(12);
		mv.addObject("user", user);
		
		//注入LIST或MAP集合
		User user1 = new User();
		user1.setId(2);
		user1.setUserName("xiaohei");
		user1.setAge(10);
		
		List<User> userList = new ArrayList<User>();
		userList.add(user);
		userList.add(user1);
		mv.addObject("userList",userList);
		
		//success为跳转到的页面的名称
		mv.setViewName("success");
		return mv;
	}
	
	//	第二种方式：返回字符串。这种用得最多
	@RequestMapping("/testMV2")
	public String testMV2(Model model){
		
		//注入字符串
		model.addAttribute("name2","hahaha");
		
		//注入LIST集合
		User user1 = new User();
		user1.setId(1);
		user1.setUserName("dabai");
		user1.setAge(12);

		User user2 = new User();
		user2.setId(2);
		user2.setUserName("xiaohei");
		user2.setAge(10);
		
		List<User> userList = new ArrayList<User>();
		userList.add(user1);
		userList.add(user2);
		
		model.addAttribute("userList",userList);
		
		//注入MAP
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("user1",user1);
		map.put("user2",user2);
		model.addAttribute("map",map);
		
		return "success";
	}
	
	
	@ModelAttribute
	private void testModelAttribute(){
		System.out.println("ModelAttribute 标注的方法实现了");
	}
	@RequestMapping
	public String testma(){
		return "testma";
	}
	
	
	
}