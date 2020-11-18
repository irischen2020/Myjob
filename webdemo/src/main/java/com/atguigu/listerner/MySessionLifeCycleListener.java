package com.atguigu.listerner;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MySessionLifeCycleListener implements
		HttpSessionListener, HttpSessionAttributeListener {
	
	// Public constructor is required by servlet spec
	public MySessionLifeCycleListener() {
	}
	

	// -------------------------------------------------------
	// HttpSessionListener implementation
	// -------------------------------------------------------
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("session created...");
		String sessionid = se.getSession().getId();
		System.out.println("sessionid="+sessionid);
	}
	
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("sessionid="+se.getSession().getId());
		System.out.println("session created...");
	}
	
	// -------------------------------------------------------
	// HttpSessionAttributeListener implementation
	// -------------------------------------------------------
	
	public void attributeAdded(HttpSessionBindingEvent sbe) {
		System.out.println("session中添加了"+sbe.getValue()+"属性");
	}
	
	public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
		System.out.println("session中移除了"+sbe.getValue()+"属性");
	}
	
	public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
	}
}
