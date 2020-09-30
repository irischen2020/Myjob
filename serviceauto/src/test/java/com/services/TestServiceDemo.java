package com.services;

import apple.utils.HttpClientUtil;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class TestServiceDemo {
	
	private static Logger logger = Logger.getLogger(TestServiceDemo.class);
	
	@Test
	public void testSendGet() {
		String url = "http://test.lemonban.com:8080/futureloan/mvc/api/member/login";
		Map<String,String> map = new HashMap<String,String>();
		map.put("mobilephone","18330372028");
		map.put("pwd","123456");
		//get请求
		HttpClientUtil.doGet(url,map);
	}
	
	@Test
	public void testSendPost(){
		String url = "http://test.lemonban.com:8080/futureloan/mvc/api/member/login";
		Map<String,String> map = new HashMap<String,String>();
		map.put("mobilephone","18330372028");
		map.put("pwd","123456");
		//POST请求
		HttpClientUtil.doPost(url,map);
	}
	
}
