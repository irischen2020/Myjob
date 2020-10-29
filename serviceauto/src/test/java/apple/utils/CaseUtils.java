package apple.utils;


import apple.pojo.Case;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class CaseUtils {
	//一次性拿出所有用例，用静态代码块
	public static List<Case> caseList = new ArrayList<Case>();
	static{
		//将所有用例数据解析封装到Case
		ExcelUtils.load("src/test/resources/servicecasesv3.xlsx","用例",Case.class);
	}
	
	//拿到对应接口的用例
	public static Object[][] getCaseDatasByApiId(String apiId,String[] cellNames){
		//先拿到符合条件的Case对象集，再到对象集里面找到符合条件的列
		List<Case> list = new ArrayList<Case>();
		//通过循环找出指定接口编号对应的这些用例数据
		for (int i = 0;i < caseList.size(); i++){
			if(apiId.equals(caseList.get(i).getApiId())){
				list.add(caseList.get(i));
			}
		}
		//定义一个二维数组，接收方法返回值
		Object[][] datas = new Object[list.size()][cellNames.length];
		Class clazz = Case.class;
		//遍历list
		for (int i = 0;i < list.size(); i++){
			Case cs = list.get(i);
			//从指定编号的用例数据里面拿出指定列的数据，遍历传入的cellNames数组
			for (int j = 0;j < cellNames.length; j++){
				String cellName = cellNames[j];
				String methodName = "get" + cellName;
				try {
					//反射调用GET方法，拿到对应属性的值
					Method method = clazz.getMethod(methodName);
					String value = (String) method.invoke(cs);
					datas[i][j] = value;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return datas;
	}
	
	//测试代码,测试拿到的数据是否符合要求
//	public static void main(String[] args) {
//		String[] cellNames={"CaseId","Params"};
//		Object[][] datas = CaseUtils.getCaseDatasByApiId("2",cellNames);
//		System.out.println(datas.length);
//		for (int i = 0;i<datas.length;i++){
//			for (int j=0;j<datas[i].length;j++){
//				System.out.println(datas[i][j]);
//			}
//		}
//	}
}
