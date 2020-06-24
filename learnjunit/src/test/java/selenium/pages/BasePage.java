package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {
	public static WebDriver driver;
	
	//固定等待3秒后定位元素
	public WebElement findElement(By by) {
		waitClickable(by);
		return driver.findElement(by);
	}
	
	//不固定等待时间
	public WebElement findElement(By by, long time) {
		if (time == 0) {
			return driver.findElement(by);
		} else {
			waitClickable(time, by);
			return driver.findElement(by);
		}
	}
	
	//隐式等待
	public void yWait(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	//显示等待,等到visible and clickable
	public void waitClickable(long time, By by) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, time);
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
		webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
	}
	//固定3秒，显示等待,等到visible and clickable
	public void waitClickable(By by) {
		new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(by));
		new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(by));
	}
	
	public void quite() {
		driver.quit();
	}
	
}
