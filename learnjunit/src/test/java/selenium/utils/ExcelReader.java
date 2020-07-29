package selenium.utils;

import org.apache.poi.ss.format.CellTextFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

public class ExcelReader {
	public static void getDataFromExcel(String filepath,String sheetname){
	
	}
	
	public static boolean isRowEmpty(Row row){
		for(int i = row.getFirstCellNum();i < row.getLastCellNum();i++){
			Cell cell = row.getCell(i);
			if(cell != null && cell.getCellType() != CellType.BLANK)
				return false;
		}
		return true;
	}
}
