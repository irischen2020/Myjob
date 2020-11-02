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
	
	public static String getUrlByApiId(String apiId) {
		String url ="";
		//遍历apiList
		for (int i=0;i<apiList.size();i++){
			Api api = new Api();
			api = apiList.get(i);
			if(apiId.equals(api.getApiId()))
			{
				url = api.getUrl();
			}
		}
		return url;
	}
	public static String getTypeByApiId(String apiId) {
		String type ="";
		//遍历apiList
		for (int i=0;i<apiList.size();i++){
			Api api = new Api();
			api = apiList.get(i);
			if(apiId.equals(api.getApiId()))
			{
				type = api.getType();
			}
		}
		return type;
	}
	
	//测试代码
//	public static void main(String[] args) {
//		String apiId = "1";
//		String url = getUrlByApiId(apiId);
//		String type = getTypeByApiId(apiId);
//		System.out.println("url:"+url);
//		System.out.print("type:" + type);
//	}
}
