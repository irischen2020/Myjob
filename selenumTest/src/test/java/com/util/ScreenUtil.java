package com.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


import com.sele.Basic;

/**
 * 屏幕截图工具类
 * @author Administrator
 *
 */
public class ScreenUtil {
	
	
	/**
	 * 将图片保存在指定目录
	 * @param baseURL
	 * @return 返回目标文件
	 */
	public static File takeScreenShot(String baseURL) {
		WebDriver webderiver = Basic.webdriver;
		//获取到的截图文件
		File screenImg = null;
		if(webderiver instanceof ChromeDriver){
			//向下转换
			ChromeDriver chromedriver = (ChromeDriver)webderiver;
			screenImg = chromedriver.getScreenshotAs(OutputType.FILE);
		}else if(webderiver instanceof InternetExplorerDriver){
			InternetExplorerDriver internetdriver = (InternetExplorerDriver)webderiver;
			screenImg = internetdriver.getScreenshotAs(OutputType.FILE);
		}
		
		Date date = new Date();
		//当前日期以毫秒形式显示
		long time = date.getTime();
		//目标文件路径及格式
		File destFile = new File(baseURL+File.separator+time+".jpg");
		try {
			FileUtils.copyFile(screenImg, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("拷贝出错");
		}
		
		return destFile;
		
	}
	
}
