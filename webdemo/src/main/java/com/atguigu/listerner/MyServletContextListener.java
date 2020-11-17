package com.atguigu.listerner;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**监听器如何工作
 * 1、编写一个监听ServletContext生命周期的Listener,实现Listener接口
 * 2、在当前项目中注册(web.xml)使用
 */
public class MyServletContextListener implements ServletContextListener{
	
	// Public constructor is required by servlet spec
	public MyServletContextListener() {
	}
	
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();
		System.out.println("contextInitialized……");
		
	}
	
	public void contextDestroyed(ServletContextEvent sce) {

		System.out.println("contextDestroyed……");
	}

}
