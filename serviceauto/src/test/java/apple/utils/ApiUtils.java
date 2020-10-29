package apple.utils;

import apple.pojo.Api;

import java.util.ArrayList;
import java.util.List;

public class ApiUtils {
	//一次性拿出所有接口信息
	public static List<Api> apiList = new ArrayList<Api>();
	static{
	
		ExcelUtils.load("src/test/resources/servicecasesv3.xlsx","接口信息",Api.class);
	
	}
}
