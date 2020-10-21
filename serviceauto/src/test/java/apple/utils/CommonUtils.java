package apple.utils;

import java.util.List;

public class CommonUtils {
	
	//二维LIST转换成二维数组
	public static Object[][] listToArray(List<List> list){
		
		//定义一个二维数组接收返回结果
		Object[][] datas = new Object[list.size()][];
		for (int i = 0; i<list.size(); i++){
			List<String> listin = list.get(i);
			datas[i] = new Object[listin.size()];
			for (int j = 0;j < listin.size(); j++){
				String value = listin.get(j);
				datas[i][j] = value;
			}
		}
		return datas;
	}
	
}
