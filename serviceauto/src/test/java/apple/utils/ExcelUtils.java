package apple.utils;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {
	public  static Object[][] getDatas() {
		String excelPath = "src/test/resources/servicecasesv1.xlsx";
		List<List> lists = null;
		String value = "";
		try {
			//获取WORKBOOK对象
			Workbook workbook = WorkbookFactory.create(new File(excelPath));
			//获取SHEET对象
			Sheet sheet = workbook.getSheet("Cases");
			//获取行
			lists = new ArrayList<List>();
			for (int i = 1;i <= 6; i++ ){
				//获取行
				Row row = sheet.getRow(i);
				List<String> list = new ArrayList<String>();
				for (int j = 5;j <= 6; j++){
//					Cell cell = row.getCell(j);
					//避免拿到的 CELL为NULL
//					if (cell == null){
//						value = "";
//					}else{
//						cell.setCellType(CellType.STRING);
//						value = cell.getStringCellValue();
//					}
					//或者这样写,同样可以避免拿到的CELL为NULL
					Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					cell.setCellType(CellType.STRING);
					value = cell.getStringCellValue();
					System.out.println(value);
					list.add(value);
				}
				lists.add(list);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		Object[][] datas = new Object[lists.size()][];
		datas = listToArray(lists);
		return datas;
	}
	
	public static Object[][] listToArray(List<List> list){
//		String value = null;
		int wsize = list.size();
		//定义一个二维数组接收返回结果
		Object[][] datas = null;
		for (int i = 0; i<wsize; i++){
			List<String> listin = list.get(i);
			int lsize = listin.size();
			datas = new Object[wsize][lsize];
			for (int j = 0;j < lsize; j++){
				String value = listin.get(j);
				datas[i][j] = value;
//				System.out.println(value);
			}
		}
		return datas;
	}
	
	public static void main(String[] args) {
		List<List<String>> list = new ArrayList<List<String>>();
		
		List<String> list0 = new ArrayList<String>();
		List<String> list1 = new ArrayList<String>();
		list0.add("1234567890");
		list0.add("");
		list1.add("13265896589");
		list1.add("");
		list.add(list0);
		list.add(list1);
		Object[][] datas = new Object[list.size()][];
//		datas = listToArray(list);
		for (int i = 0; i<list.size(); i++){
			List<String> listin = list.get(i);
			datas[i] = new Object[listin.size()];
			for (int j = 0;j < listin.size(); j++){
				String value = listin.get(j);
				datas[i][j] = value;
				System.out.println(value);
			}
		}
		
	}
}
