package com.services;

import apple.pojo.Api;
import apple.pojo.Result;
import apple.utils.*;

import com.alibaba.fastjson.JSONObject;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class RegisterCase_v5 {
	
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
	public void test(String caseId,String apiId,String params){
		String url = ApiUtils.getUrlByApiId(apiId);
		String type = ApiUtils.getTypeByApiId(apiId);
		
		//将用例中的params中的JSON格式的字符串解析成MAP
		Map<String,String> map = new HashMap<String,String>();
		map = (Map<String, String>) JSONObject.parse(params);
		
		//执行请求，将每次请求的数据回写到EXCEL，多次读写EXCEL，造成效率低下。换一种方式，批量回写数据。
//		String actualResponseData = HttpClientUtils.doService(type,url,map);
//		ExcelUtils.writeActualResponse("src/test/resources/servicecasesv5.xlsx","用例",caseId,"ActualResponseData",actualResponseData);
		
		String actualResponseData = HttpClientUtils.doService(type,url,map);
		Result result = new Result();
		result.setCaseId(caseId);
		result.setCellName("ActualResponseData");
		result.setActualResponseData(actualResponseData);
		ResultUtils.resultList.add(result);
	}
	
	@DataProvider
	public Object[][] datas(){

//		从EXCEL读取数据，封装到二维数组里面
//		Object[][] datas = ExcelUtils.getDatas();
		
		String[] cellNames={"CaseId","ApiId","Params"};
		Object[][] datas = CaseUtils.getCaseDatasByApiId("1",cellNames);
		return datas;
		
	}
}

