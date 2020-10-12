package apple.utils;

import org.testng.annotations.Test;

public class TestExcelUtils {
	@Test
	public void testExcel(){
		
		Object[][] datas = null;
		datas = ExcelUtils.getDatas();
		for (int i=0;i<datas.length;i++){
			for (int j=0;j<datas[i].length;j++){
				String s= (String) datas[i][j];
//				System.out.println(s);
			}
		}
		
	}
	@Test
	public void testdatas(){
		Object ss[][] = new Object[1][2];
		ss[0][0] = "";
		System.out.println(ss[0][0]);
	}
}
