package apple.utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.params.provider.Arguments;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ExcelReader {
	
	//EXCEL中一列保存了所有的参数，参数以JSON格式存放
	public static Stream<Arguments> getArgumentsStream(String filePath, String sheetName) {
		//定义一个空的返回对象
		Stream<Arguments> returnStream = Stream.empty();
		InputStream inp = null;
		try {
			inp = new FileInputStream(new File(filePath));
			Workbook workbook = WorkbookFactory.create(inp);
			Sheet sheet1 = workbook.getSheet(sheetName);
			//EXCEL中一列保存了所有的参数，参数以JSON格式存放
			//拿到行数（包括了空行）
			int rowNums = sheet1.getLastRowNum() + 1;
			System.out.println(rowNums);
			//屏蔽掉第一行标题行，循环行
			for (int i = 1; i < rowNums; i++) {
				Row row = sheet1.getRow(i);
				List<String> list = new ArrayList<String>();
				if (ExcelReader.isRowEmpty(row) == false) {
					System.out.println("this is a not null row");
					Cell cell = row.getCell(1);
					String s = cell.getStringCellValue();
					
					//为了使转为JSONObject以后的顺序不会改变，加了Feature.OrderedField
					JSONObject jsonObject = (JSONObject) JSONObject.parseObject(s, Feature.OrderedField);
					
					//循环JSONOBJECT，把拿到的VALUES值装到ARGUMENTS里面
					for (Map.Entry entry : jsonObject.entrySet()) {
						list.add(entry.getValue().toString());
					}
					System.out.println(list);
					//转换为MethodSource的Arguments对象
					Arguments arguments = Arguments.of(list.toArray());
					//Arguments转换为Stream
					returnStream = Stream.concat(returnStream, Stream.of(arguments));
				}
			}
			return returnStream;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnStream;
	}
	
	//如果EXCEL表格中，一列保存一个参数，三个参数用三列来存放，可以用这种方式读取
	public static Stream<Arguments> getArgumentsStream2(String filePath, String sheetName) {
		//定义单元格数据格式处理对象
		DataFormatter myDataFormatter = new DataFormatter();
		//定义一个空的返回对象
		Stream<Arguments> returnStream = Stream.empty();
		InputStream inp = null;
		try {
			inp = new FileInputStream(new File(filePath));
			Workbook workbook = WorkbookFactory.create(inp);
			Sheet sheet1 = workbook.getSheet(sheetName);
			//如果EXCEL表格中，一列保存一个参数，三个参数用三列来存放，可以用这种方式读取
			for(Row row: sheet1){
				if(row.getRowNum()==0) {continue;}
				ArrayList<Object> rowArrayList = new ArrayList<>();
				//获取单元格数值，存入行List
				for (Cell cell : row) {
					rowArrayList.add(myDataFormatter.formatCellValue(cell));
				}
				//转换为MethodSource的Arguments对象
				Arguments arguments = Arguments.of(rowArrayList.toArray());
				//Arguments转换为Stream
				returnStream = Stream.concat(returnStream,Stream.of(arguments));
			}
			return returnStream;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnStream;
	}
	
	//判断EXCEL表格中的某一行是否为空
	public static boolean isRowEmpty(Row row){
		for(int i = row.getFirstCellNum();i < row.getLastCellNum();i++){
			Cell cell = row.getCell(i);
			if(cell != null && cell.getCellType() != CellType.BLANK)
				return false;
		}
		return true;
	}
}
