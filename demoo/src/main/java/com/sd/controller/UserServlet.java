package com.sd.controller;

import com.sd.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = {"/userServlet"})
public class UserServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");

		String act = request.getParameter("act");
		if ("login".equals(act)) {
			loginm(request, response);
		} else if ("findall".equals(act)) {
			findallm(request, response);
		}
		
	}
	
	//登录方法
	
	private void loginm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收请求并响应
		//1、获取请求参数并封装为对象
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		
		//2、数据验证，非空，正则表达式 略 必须要有。
		//3、登录业务处理
		boolean b = false;
		if ("zs".equals(username) && "666".equals(userpwd)) {
			b = true;
		}
		//4、根据结果进行跳转
		if (b) {
			//服务器内部转发,同一请求，地址栏不会变化
//			request.setCharacterEncoding("UTF-8");
			request.getSession().setAttribute("username",username);
			
			//从一个控制层方法跳到另一个控制层方法
//			request.getRequestDispatcher("userServlet?act=findall").forward(request,response);
			
			//从SERVLET跳到JSP
//			request.getRequestDispatcher("index.jsp").forward(request, response);
			
			//登录成功，返回一个JSON格式字符串
			String jsonstr = "{status:200,message:\"OK\"}";
			response.getWriter().print(jsonstr);
			
		} else {
			//重定向
			response.sendRedirect("login.jsp?msg=error");
		}
	}
	
	//查询所有的方法
	private void findallm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> list = new ArrayList<>();
		list.add(new User(1,"zs","666"));
		list.add(new User(2,"lisi","888"));
		request.setAttribute("list",list);
		request.getRequestDispatcher("index.jsp").forward(request,response);
	}
}
