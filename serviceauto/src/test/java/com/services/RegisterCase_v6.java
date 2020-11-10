package com.services;

import apple.utils.CaseUtils;
import org.testng.annotations.DataProvider;

//第6个版本，只是在HTTPUTILS里面加上了登录鉴权的功能。
public class RegisterCase_v6 extends BaseCase{
	
	@DataProvider
	public Object[][] datas(){

//		从EXCEL读取数据，封装到二维数组里面
//		Object[][] datas = ExcelUtils.getDatas();
		
		String[] cellNames={"CaseId","ApiId","Params"};
		Object[][] datas = CaseUtils.getCaseDatasByApiId("1",cellNames);
		return datas;
		
	}
}

