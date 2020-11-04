package com.services;

import apple.pojo.Result;
import apple.utils.ApiUtils;
import apple.utils.ExcelUtils;
import apple.utils.HttpClientUtils;
import apple.utils.ResultUtils;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.annotation.After;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static apple.utils.ExcelUtils.batchWriteActualResponse;

public class BaseCase {
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
		Result result = new Result("用例",caseId,"ActualResponseData",actualResponseData);
		ResultUtils.resultList.add(result);
	}
	@AfterSuite()
	public void afterTest(){
		//解析resultList中的数据，将数据批量回写到EXCEL里面
		ExcelUtils.batchWriteActualResponse("src/test/resources/servicecasesv5.xlsx");
	}
}
