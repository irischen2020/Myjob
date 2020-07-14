package com.sele;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.util.ExcelUtil;

public class Register extends Basic{
	
	/**
	 * 反向测试用例
	 */
	@Test(dataProvider= "getFail")
	public void register(String phone,String pwd,String repwd,String expect){
		//System.out.println(phone+"-"+pwd+"-"+repwd+"-"+expect);
		webdriver.navigate().to("http://39.108.136.60:8085/lmcanon_web_auto/mng/register.html");
		//findElement("注册页", "用户名").sendKeys(phone);
		//在父类封装了方法sendKeys，用于日志记录
		sendKeys(findElement("注册页", "用户名"),phone);
		findElement("注册页", "密码").sendKeys(pwd);
		findElement("注册页", "重复密码").sendKeys(repwd);
		//webdriver.findElement(By.id("password")).sendKeys("123");
		findElement("注册页", "注册按钮").click();
		String resulst = findElement("注册页", "错误信息").getText();
		Assert.assertEquals(resulst, expect);
		
	}
	
	/**
	 * 正向测试用例
	 */
	@Test(dataProvider="getSucess")
	public void register1(String phone,String pwd,String repwd){
		//System.out.println(phone+"-"+pwd+"-"+repwd);
		webdriver.navigate().to("http://39.108.136.60:8085/lmcanon_web_auto/mng/register.html");
		findElement("注册页", "用户名").sendKeys(phone);
		findElement("注册页", "密码").sendKeys(pwd);
		findElement("注册页", "重复密码").sendKeys(repwd);
		findElement("注册页", "注册按钮").click();
		//以下方法的源代码会获取到当前页面的URL
		boolean  flag = urlPresenceContent("login.html");
		Assert.assertTrue(flag);
	}
	
	@DataProvider
	public Object[][] getFail(){
		String[] cellName = {"手机号","密码","重复密码","期望值"};
		return ExcelUtil.read("src/test/resources/data.xlsx", "DL-1",cellName);
	}
	
	@DataProvider
	public Object[][] getSucess(){
		String[] cellName = {"手机号","密码","重复密码"};
		return ExcelUtil.read("src/test/resources/data.xlsx","DL-2",cellName);
	}
	
	
	
	
}
