package selenium.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public class JsonBl {
	
	private static String getDesc(String jsonStr, String key) {
		JSONObject jsonObject = JSONObject.parseObject(jsonStr);
		for (Map.Entry entry : jsonObject.entrySet()) {
			if (key.equals(entry.getKey())) {
				return entry.getValue().toString();
			}
		}
		return null;
	}
}
