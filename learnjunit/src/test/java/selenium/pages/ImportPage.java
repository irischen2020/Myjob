package selenium.pages;

import org.openqa.selenium.By;

public class ImportPage extends BasePage {
	public ContactPage importFormFile(String filepath)
	{
//		findElement(By.cssSelector(".js_upload_label")).sendKeys(filepath);
		
//		findElement(By.cssSelector(".js_upload_label")).click();
		findElement(By.id("js_upload_file_input")).sendKeys(filepath);
		
//		findElement(By.linkText("确认导入"));
//		findElement(By.linkText("前往查看"));
		return new ContactPage();
	}
	
}
