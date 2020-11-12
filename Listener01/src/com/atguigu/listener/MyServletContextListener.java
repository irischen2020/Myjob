package com.atguigu.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 1、编写一个监听ServletContext生命周期的Listener,实现Listerner接口
 * 2、在当前项目中注册(在web.xml)使用
 */
public class MyServletContextListener implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContext context = servletContextEvent.getServletContext();
		System.out.println("contextInitialized......");
	
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		System.out.println("contextDestroyed......");
	}
}
