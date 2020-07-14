package com.sele;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.pojo.UIElement;

import com.util.UILibraryUtil;

public class Basic {

	public static WebDriver webdriver;
	public static Logger logger = Logger.getLogger(Basic.class);

	@BeforeSuite
	@Parameters(value = { "browserType", "driverPath" })
	public void init(String browserType, String driverPath) {
		if ("ie".equalsIgnoreCase(browserType)) {
			// 设置浏览器的驱动对象
			System.setProperty("webdriver.ie.driver", driverPath);
			DesiredCapabilities desiredcapabilities = new DesiredCapabilities();
			// 忽略浏览器的安全设置
			desiredcapabilities
					.setCapability(
							InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);
			desiredcapabilities.setCapability(
					InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			webdriver = new InternetExplorerDriver(desiredcapabilities);
		} else if ("chrome".equalsIgnoreCase(browserType)) {
			System.setProperty("webdriver.chrome.driver", driverPath);
			DesiredCapabilities desiredcapabilities = new DesiredCapabilities();
			// 忽略浏览器的安全设置
			desiredcapabilities
					.setCapability(
							InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);
			desiredcapabilities.setCapability(
					InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			webdriver = new ChromeDriver(desiredcapabilities);
		}

	}

	/**
	 * 判断浏览器地址是否包括相应的内容
	 * 
	 * @param part
	 * @return
	 */
	public boolean urlPresenceContent(String part) {
		WebDriverWait wait = new WebDriverWait(webdriver, 30);
		try {
			return wait.until(ExpectedConditions.urlContains(part));
			//return wait.until(ExpectedConditions.urlContains(part));
		} catch (Exception ce) {
			System.out.println("超时了");
		}
		return false;
	}

	/**
	 * 显示等待，智能等待
	 * 
	 * @param locator
	 * @return
	 */
	public WebElement getElement(By locator) {
		WebDriverWait wait = new WebDriverWait(webdriver, 30);
		try {
			
			WebElement webelement = wait.until(ExpectedConditions
					.presenceOfElementLocated(locator));
			return webelement;
		} catch (Exception e) {
			System.out.println("定位元素超时");
		}
		return null;

	}

	/**
	 * 元素定位策略
	 * 
	 * @param locator
	 * @return
	 */
	public WebElement findElement(String pageKeyWord, String elementKeyWord) {
		//获取元素对象
		UIElement element = UILibraryUtil.getUIElement(pageKeyWord,
				elementKeyWord);
		String by = element.getBy();
		String value = element.getValue();
		By locator = null;
		if ("id".equals(by)) {
			locator = By.id(value);
		} else if ("name".equals(by)) {
			locator = By.name(value);

		} else if ("className".equals(by)) {
			locator = By.className(value);

		} else if ("xpath".equals(by)) {
			locator = By.xpath(value);
		}
		else if ("cssSelector".equals(by)) {
			locator = By.cssSelector(value);
		}
		else if ("partialLinkText".equals(by)) {
			locator = By.partialLinkText(value);
		}
		else if ("xpath".equals(by)) {
			locator = By.xpath(value);
		}

		//webdriver.findElement(locator); 系统自带，没有延时等待
		return getElement(locator);//自己封装
			

	}
	
	public void sendKeys(WebElement element,String value){
		logger.info("传的值为"+value);
		element.sendKeys(value);
	}
	
	
	@AfterSuite
	public void tearDown(){
		try {
			Thread.sleep(3000);
			logger.info("驱动退出，测试完成");
			webdriver.quit();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
