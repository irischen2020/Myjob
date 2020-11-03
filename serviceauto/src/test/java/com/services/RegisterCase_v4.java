package com.services;

import apple.pojo.Api;
import apple.utils.ApiUtils;
import apple.utils.CaseUtils;
import apple.utils.ExcelUtils;
import apple.utils.HttpClientUtils;

import com.alibaba.fastjson.JSONObject;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class RegisterCase_v4 {
	
//	@Test(dataProvider = "datas")
//	public void test1(String params){
//		String url = "http://v.juhe.cn/laohuangli/d";
//		//将用例中的params中的JSON格式的字符串解析成MAP
//		Map<String,String> map = new HashMap<String,String>();
//		map = (Map<String, String>) JSONObject.parse(params);
//
//		//POST请求
////		HttpClientUtils.doPost(url,map);
//		HttpClientUtils.doService("post",url,map);
//	}
	//type,url,map都从EXCEL中获取
	@Test(dataProvider = "datas")
	public void test1(String apiId,String params){
		String url = ApiUtils.getUrlByApiId(apiId);
		String type = ApiUtils.getTypeByApiId(apiId);
		
		//将用例中的params中的JSON格式的字符串解析成MAP
		Map<String,String> map = new HashMap<String,String>();
		map = (Map<String, String>) JSONObject.parse(params);
		
		//请求
		HttpClientUtils.doService(type,url,map);
	}
	
	@DataProvider
	public Object[][] datas(){

//		从EXCEL读取数据，封装到二维数组里面
//		Object[][] datas = ExcelUtils.getDatas();
		
		String[] cellNames={"ApiId","Params"};
		Object[][] datas = CaseUtils.getCaseDatasByApiId("1",cellNames);
		return datas;
		
	}
}
