package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {
	public static WebDriver driver;
	
	public static WebElement findElement(By by){
		return driver.findElement(by);
	}
	//隐式等待
	public void yWait(long time){
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	//显示等待
	public void waitClickable(long time,By by){
		new WebDriverWait(driver,time).until(ExpectedConditions.elementToBeClickable(by));
	}
	
	public void waitClickable(By by){
		new WebDriverWait(driver,5).until(ExpectedConditions.elementToBeClickable(by));
	}
}
