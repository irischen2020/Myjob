package com.services;

import apple.utils.HttpClientUtil;
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class RegisterCase {
//	private static Logger logger = Logger.getLogger(RegisterCase.class);
	@Test(dataProvider = "datas")
	public void test1(String mobilephone,String pwd){
		String url = "http://test.lemonban.com:8080/futureloan/mvc/api/member/login";
		Map<String,String> map = new HashMap<String,String>();
		map.put("mobilephone",mobilephone);
		map.put("pwd",pwd);
		//POST请求
		HttpClientUtil.doPost(url,map);
	}
	@DataProvider
	public Object[][] datas(){
		Object[][] datas = {
				{"18330372028",""},
				{"","111111"},
				{"123",""},
				{"18330372028","12345"},
				{"18330372028","123456"},
				{"12345678956","123456"}
		};
		return datas;
	}
}
