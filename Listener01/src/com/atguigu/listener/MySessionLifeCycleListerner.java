package com.atguigu.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionLifeCycleListerner implements HttpSessionListener {
	@Override
	public void sessionCreated(HttpSessionEvent httpSessionEvent) {
		HttpSession httpSession = httpSessionEvent.getSession();
		System.out.println("session创建了：" + httpSession);
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
	
	}
}
