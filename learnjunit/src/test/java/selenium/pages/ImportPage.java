package selenium.pages;

import org.openqa.selenium.By;

public class ImportPage extends BasePage {
	public ContactPage importFormFile(String filepath)
	{
		findElement(By.id("js_upload_file_input"),0).sendKeys(filepath);
		
		findElement(By.linkText("确认导入")).click();
		findElement(By.linkText("前往查看")).click();
		return new ContactPage();
	}
	
}
