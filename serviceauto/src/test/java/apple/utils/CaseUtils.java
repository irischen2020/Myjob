package apple.utils;

import apple.pojo.Cases;

import java.util.ArrayList;
import java.util.List;

public class CaseUtils {
	//一次性拿出所有用例，用静态代码块
	public static List<Cases> casesList = new ArrayList<Cases>();
	static{
		//将所有用例数据解析封装到Cases
		casesList = ExcelUtils.load("src/test/resources/servicecasesv2.xlsx","用例");
	
	}
	
	//拿到对应接口的用例
	public static Object[][] getCaseDatasByApiId(String apiId,String[] cellNames){
		//通过循环找出指定接口编号对应的这些用例数据
		return null;
	}
}
