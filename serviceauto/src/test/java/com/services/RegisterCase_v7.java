package com.services;

import apple.pojo.Api;
import apple.pojo.Result;
import apple.utils.*;

import com.alibaba.fastjson.JSONObject;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class RegisterCase_v7 extends BaseCase{
	
	@DataProvider
	public Object[][] datas(){

//		从EXCEL读取数据，封装到二维数组里面
//		Object[][] datas = ExcelUtils.getDatas();
		
		String[] cellNames={"CaseId","ApiId","Params"};
		Object[][] datas = CaseUtils.getCaseDatasByApiId("1",cellNames);
		return datas;
		
	}
}

