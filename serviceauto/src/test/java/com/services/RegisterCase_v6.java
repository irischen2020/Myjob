package com.services;

import apple.utils.ExcelUtils;
import apple.utils.HttpClientUtils;

import com.alibaba.fastjson.JSONObject;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class RegisterCase_v6 {
	
	@Test(dataProvider = "datas")
	public void test1(String params){
		String url = "http://test.lemonban.com:8080/futureloan/mvc/api/member/login";
		//将用例中的params中的JSON格式的字符串解析成MAP
		Map<String,String> map = new HashMap<String,String>();
		map = (Map<String, String>) JSONObject.parse(params);
		
		//POST请求
		HttpClientUtils.doPost(url,map);
	}
	@DataProvider
	public Object[][] datas(){

//		从EXCEL读取数据，封装到二维数组里面
		
		Object[][] datas = ExcelUtils.getDatas();
		return datas;
		
	}
}
