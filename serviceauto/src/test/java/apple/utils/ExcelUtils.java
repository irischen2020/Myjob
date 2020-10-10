package apple.utils;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ExcelUtils {
	@Test
	public  void getDatas() {
		String excelPath = "src/test/resources/servicecasesv1.xlsx";
		try {
			//获取WORKBOOK对象
			Workbook workbook = WorkbookFactory.create(new File(excelPath));
			//获取SHEET对象
			Sheet sheet = workbook.getSheet("Cases");
			//获取行
			Row row = sheet.getRow(2);
			//获取列
			Cell cell = row.getCell(6);
			//将单元格类型设置为STRING类型
			cell.setCellType(CellType.STRING);
			String value = cell.getStringCellValue();
			System.out.println(value);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
//		return null;
	}
}
