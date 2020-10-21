package apple.utils;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;

public class ExcelUtils {
	public  static Object[][] getDatas() {
		String excelPath = "src/test/resources/servicecasesv1.xlsx";
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
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return datas;
	}
	
	public static void main(String[] args) {
		getDatas();
	}
	
}
