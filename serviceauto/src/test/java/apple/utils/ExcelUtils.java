package apple.utils;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ExcelUtils {
	@org.junit.jupiter.api.Test
	public  void getDatas() {
		String excelPath = "src/test/resources/servicecasesv1.xlsx";
		try {
			Workbook workbook = WorkbookFactory.create(new File(excelPath));
			Sheet sheet = workbook.getSheet("Cases");
			
			Row row = sheet.getRow(2);
			Cell cell = row.getCell(6);
//			String value = cell.;
//			System.out.println(value);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
//		return null;
	}
}
