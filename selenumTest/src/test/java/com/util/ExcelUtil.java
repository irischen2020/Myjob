package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;

public class ExcelUtil {
	
	
	public static Object[][] read(String path,String sheetName,String[] cellName){
		InputStream file = null;
		ArrayList<ArrayList<String>> goups = new ArrayList<ArrayList<String>>();
		try {
			file = new FileInputStream(new File(path));
			//获取一个workbook
			Workbook workbook = WorkbookFactory.create(file);
			//获取一个sheet
			Sheet sheet = workbook.getSheet(sheetName);
			//获取行数量(只是获得索引，比实际函数少1)
			int rowNum = sheet.getLastRowNum();
			//获取标题列
			Row titleRow = sheet.getRow(0);
			int cellNum = titleRow.getLastCellNum();
			//创建一个MAP对象用例存标题和对应的标题对应的列索引
			Map<String,Integer> mapTitleAndCell = new HashMap<String,Integer>();
			//取出标题
			for(int i=0;i<cellNum;i++){
				Cell cell = titleRow.getCell(i,MissingCellPolicy.CREATE_NULL_AS_BLANK);
				cell.setCellType(CellType.STRING);
				//获取列里面的数据
				String title = cell.getStringCellValue();
				//获取标题对应的列索引
				int titileAndCellNum = cell.getAddress().getColumn();
				mapTitleAndCell.put(title, titileAndCellNum);
				
			}
			ArrayList<String> goup = null;
			//取出除标题行外的所有数据
			for(int j=1;j<=rowNum; j++){
				//把每一行放到一个对象里面，这里有多行，所以需要在这里new对象，而不是循环外面，如果在循环外面NEW，则所有数据只添加到一个对象，与实际不符
				goup = new ArrayList<String>();
				Row row1 = sheet.getRow(j);
				for(int k=0;k<cellName.length;k++){
					//mapTitleAndCell.get(cellName[k])根据列名获得列索引
					Cell cell1 = row1.getCell(mapTitleAndCell.get(cellName[k]), MissingCellPolicy.CREATE_NULL_AS_BLANK);
					cell1.setCellType(CellType.STRING);
					String value = cell1.getStringCellValue();
					goup.add(value);
				}
				//添加这一行
				goups.add(goup);
			}
			
			//listToObject(goups.add(goup));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listToObject(goups);
	}

	private static Object[][] listToObject(ArrayList<ArrayList<String>> listvalue) {
		//声明一个二维数组用来存放数据
		Object[][] rowAndcell = new Object[listvalue.size()][listvalue.get(0).size()];
		
		for (int i=0;i<listvalue.size();i++){
			//取出行元素
			ArrayList group = listvalue.get(i);
			//取出列元素
			for(int j=0;j<group.size();j++){
				String  value = (String) group.get(j);
				rowAndcell[i][j] = value;
			}
		}
		return rowAndcell;
	}
	

}
