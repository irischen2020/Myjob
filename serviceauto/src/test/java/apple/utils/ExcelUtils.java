package apple.utils;

import apple.pojo.Case;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {
	public  static Object[][] getDatas() {
		String excelPath = "src/test/resources/servicecasesv3.xlsx";
		//定义一个二维数组
		Object[][] datas = new Object[6][];
		String value = "";
		try {
			//获取WORKBOOK对象
			Workbook workbook = WorkbookFactory.create(new File(excelPath));
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
		workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return datas;
	}
	
	public  static Object[][] getDatas2(String excelPath) {
				//定义一个二维数组
		Object[][] datas = new Object[6][];
		String value = "";
		try {
			//获取WORKBOOK对象
			Workbook workbook = WorkbookFactory.create(new File(excelPath));
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
		workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return datas;
	}
	
	public static List<Case> load(String excelPath, String sheetName) {
		//定义一个LIST来接收读取出来的数据
		List<Case> list = new ArrayList<Case>();
		try {
			Workbook workbook = WorkbookFactory.create(new File(excelPath));
			Sheet sheet = workbook.getSheet(sheetName);
			Class clazz = Case.class;
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
				Case cs = (Case) clazz.newInstance();
				for (int j = 0;j < cellNum; j++){
					//避免拿 到的CELL为空
					Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					cell.setCellType(CellType.STRING);
					String value = cell.getStringCellValue();
					 //获取要反射的方法名
					 String methodName =  "set" + fields[j];
					 //获得方法对象
					 Method method = clazz.getMethod(methodName,String.class);
					 //反射调用方法
					 method.invoke(cs,value);
				}
				list.add(cs);
			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
//	测试代码
//	public static void main(String[] args) {
//		List<Case> list = new ArrayList<Case>();
//		list = load("src/test/resources/servicecasesv3.xlsx","用例");
//
//		for (Case cs : list){
//			System.out.println(cs.toString());
//		}
//
//	}
}
