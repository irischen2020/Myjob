package apple.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;


public class JsonBl {
	
	//取到某个JSON串的指定key值对应的value值。即JSON遍历
	private static String getValue(String jsonStr, String key) {
		JSONObject jsonObject = JSONObject.parseObject(jsonStr);
		for (Map.Entry entry : jsonObject.entrySet()) {
			if (key.equals(entry.getKey())) {
				return entry.getValue().toString();
			}
		}
		return null;
	}
	
	//以下为测试代码。拷贝一个JSON串进去，会自动转义
//	public static void main(String[] args) {
//		String jsonStr = "{\n" +
//				"    \"status\": 1,\n" +
//				"    \"code\": \"10001\",\n" +
//				"    \"data\": null,\n" +
//				"    \"msg\": \"注册成功\"\n" +
//				"}";
//		String key = "code";
//		System.out.println(getValue(jsonStr,key));
//	}
}
