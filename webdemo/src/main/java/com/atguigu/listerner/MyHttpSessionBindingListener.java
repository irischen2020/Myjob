package com.atguigu.listerner;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.*;

public class MyHttpSessionBindingListener implements ServletContextListener,
		HttpSessionListener, HttpSessionAttributeListener,HttpSessionBindingListener {
	
	// Public constructor is required by servlet spec
	public MyHttpSessionBindingListener() {
	}
	
	
	public void contextInitialized(ServletContextEvent servletContextEvent) {
	
	}
	
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
	
	}
	
	public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
	
	}
	
	public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
	
	}
	
	public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
	
	}
	
	//监听某个对象绑定到SESSION域中
	public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
	
	}
	
	public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
	
	}
	
	public void sessionCreated(HttpSessionEvent httpSessionEvent) {
	
	}
	
	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
	
	}
}
