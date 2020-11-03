package apple.utils;

import apple.pojo.Api;
import apple.pojo.Case;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.lang.reflect.Method;
import java.util.*;

public class ExcelUtils {
	
	public static Map<String,Integer> rowNumMap = new HashMap<String,Integer>();
	public static Map<String,Integer> cellNumMap = new HashMap<String,Integer>();
	static{
		getRowAndCellNumMap("src/test/resources/servicecasesv5.xlsx","用例");
	}
	
	//获取CASEID和行号之间的映射关系，获取列号和列名之间的映射关系
	private static void getRowAndCellNumMap(String excelPath, String sheetName) {
		InputStream inp = null;
		try {
			inp = new FileInputStream(new File(excelPath));
			Workbook workbook = WorkbookFactory.create(inp);
			Sheet sheet = workbook.getSheet(sheetName);
			//拿到第一行
			//sheet.getLastRowNum();//返回最后一行的索引，即比行总数小1
			//row.getLastCellNum();//返回的是最后一列的列数，即等于总列数
			Row rowTitle = sheet.getRow(0);
			int cellNum = rowTitle.getLastCellNum();
			for (int i = 0; i < cellNum; i++){
				Cell cell = rowTitle.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
				cell.setCellType(CellType.STRING);
				String cellName = cell.getStringCellValue();
				cellNumMap.put(cellName,i);
			}
			//遍历所有的行，把行号和第一列的值，存到rowNumMap中。先拿到最后一行的行索引
			int rowNum = sheet.getLastRowNum();
			for(int i = 1;i <= rowNum; i++){
				Row rowi = sheet.getRow(i);
				Cell cell = rowi.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
				cell.setCellType(CellType.STRING);
				String caseId = cell.getStringCellValue();
				rowNumMap.put(caseId,i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(inp != null){
				try {
					inp.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public  static Object[][] getDatas() {
		String excelPath = "src/test/resources/servicecasesv3.xlsx";
		//定义一个二维数组
		Object[][] datas = new Object[6][];
		String value = "";
		InputStream inp = null;
		try {
			inp = new FileInputStream(new File(excelPath));
			//获取WORKBOOK对象
			Workbook workbook = WorkbookFactory.create(inp);
			//获取SHEET对象
			Sheet sheet = workbook.getSheet("Cases");
			//获取行
			for (int i = 1;i <= 6; i++ ){
				//获取行
				Row row = sheet.getRow(i);
				datas[i-1] = new Object[1];
				for (int j = 5;j <= 5; j++){
					//避免拿到的 CELL为NULL
					Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					cell.setCellType(CellType.STRING);
					value = cell.getStringCellValue();
					System.out.println(value);
					datas[i-1][j-5] = value;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(inp != null){
				try {
					inp.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return datas;
	}
	
	public  static Object[][] getDatas2(String excelPath) {
				//定义一个二维数组
		Object[][] datas = new Object[6][];
		String value = "";
		InputStream inp = null;
		try {
			inp = new FileInputStream(new File(excelPath));
			//获取WORKBOOK对象
			Workbook workbook = WorkbookFactory.create(inp);
			//获取SHEET对象
			Sheet sheet = workbook.getSheet("Cases");
			//获取行
			for (int i = 1;i <= 6; i++ ){
				//获取行
				Row row = sheet.getRow(i);
				datas[i-1] = new Object[2];
				for (int j = 5;j <= 6; j++){
					//避免拿到的 CELL为NULL
					Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					cell.setCellType(CellType.STRING);
					value = cell.getStringCellValue();
					System.out.println(value);
					datas[i-1][j-5] = value;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(inp != null){
				try {
					inp.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return datas;
	}
	//解析EXCEL文件，传入EXCEL路径和表单名称
//	public static void load(String excelPath, String sheetName) {
//		//获取类的字节码文件
//		Class clazz = Case.class;
//		try {
//			Workbook workbook = WorkbookFactory.create(new File(excelPath));
//			Sheet sheet = workbook.getSheet(sheetName);
//			//通过反射封装对象
//			//获取第一行标题行，拿到列名，等同于拿到了方法名，存入数组
//			Row titleRow = sheet.getRow(0);
//			//获取到列的索引+1
//			int cellNum = titleRow.getLastCellNum();
//			String[] fields = new String[cellNum];
//			for (int i  =0;i < cellNum; i++){
//				Cell titleCell = titleRow.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//				titleCell.setCellType(CellType.STRING);
//				String title = titleCell.getStringCellValue();
//				title = title.substring(0,title.indexOf("("));
//				fields[i] = title;
//			}
//			//获取最后一行的行号
//			int rowNum = sheet.getLastRowNum();
//			//循环行,循环处理每个数据行
//			for (int i = 1;i <= rowNum; i++){
//				Row row = sheet.getRow(i);
//				//通过反射封装
//				Case cs = (Case) clazz.newInstance();
//				for (int j = 0;j < cellNum; j++){
//					//避免拿 到的CELL为空
//					Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//					cell.setCellType(CellType.STRING);
//					String value = cell.getStringCellValue();
//					 //获取要反射的方法名
//					 String methodName =  "set" + fields[j];
//					 //获得方法对象
//					 Method method = clazz.getMethod(methodName,String.class);
//					 //反射调用方法
//					 method.invoke(cs,value);
//				}
//				CaseUtils.caseList.add(cs);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	public static void load(String excelPath, String sheetName, Class<?> ssClass) {
		InputStream inp = null;
		//参数中有传类的字节码对象 Class<T> apiOrCaseClass
		try {
			inp = new FileInputStream(new File(excelPath));
			Workbook workbook = WorkbookFactory.create(inp);
			Sheet sheet = workbook.getSheet(sheetName);
			//通过反射封装对象
			//获取第一行标题行，拿到列名，等同于拿到了方法名，存入数组
			Row titleRow = sheet.getRow(0);
			//获取到列的索引+1
			int cellNum = titleRow.getLastCellNum();
			String[] fields = new String[cellNum];
			for (int i  =0;i < cellNum; i++){
				Cell titleCell = titleRow.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
				titleCell.setCellType(CellType.STRING);
				String title = titleCell.getStringCellValue();
				title = title.substring(0,title.indexOf("("));
				fields[i] = title;
			}
			//获取最后一行的行号
			int rowNum = sheet.getLastRowNum();
			//循环行,循环处理每个数据行
			for (int i = 1;i <= rowNum; i++){
				Row row = sheet.getRow(i);
				//通过反射封装
//				Case cs = (Case) clazz.newInstance();
				Object obj = ssClass.newInstance();
				for (int j = 0;j < cellNum; j++){
					//避免拿 到的CELL为空
					Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					cell.setCellType(CellType.STRING);
					String value = cell.getStringCellValue();
					//获取要反射的方法名
					String methodName =  "set" + fields[j];
					//获得方法对象
//					Method method = clazz.getMethod(methodName,String.class);
					Method method =ssClass.getMethod(methodName,String.class);
					//反射调用方法
//					method.invoke(cs,value);
					method.invoke(obj,value);
				}
				if(obj instanceof Case) {
					CaseUtils.caseList.add((Case) obj);
				}else if(obj instanceof Api){
					ApiUtils.apiList.add((Api)obj);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(inp != null){
				try {
					inp.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
//	测试代码
	public static void main(String[] args) {
		//遍历MAP
		for (String key : rowNumMap.keySet()){
			System.out.println("caseId:" + key + ",rowNum:" + rowNumMap.get(key));
		}
		for (String key : cellNumMap.keySet()){
			System.out.println("cellName:" + key + ",cellNum:" + cellNumMap.get(key));
		}

	}
	
	public static void writeActualResponse(String caseId,String cellName, String result) {
		//1、首先要拿到caseId和行号的映射关系，列名和列号的映射关系；
		//2、写入EXCEL即可
		
	
	}
}
