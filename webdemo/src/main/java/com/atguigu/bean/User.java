package com.atguigu.bean;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

public class User implements Serializable,HttpSessionActivationListener {
	public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {
		System.out.println("User"+this+"将要钝化");
	}
	
	public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {
		System.out.println("User"+this+"已经活化了");
	}
}
