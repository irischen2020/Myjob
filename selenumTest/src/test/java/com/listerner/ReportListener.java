package com.listerner;

import java.io.File;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import com.util.ScreenUtil;
/**
 * 通过TestListenerAdapter类来监听测试类
 * @author Administrator
 *
 */
public class ReportListener extends TestListenerAdapter{
	/**
	 * 当某一个用例（测试方法）执行失败，就会进入此方法
	 */
	@Override
	public void onTestFailure(ITestResult tr) {
		
		String baseURL = "target/surefire-reports/screenshot";
		//获取测试套件里面当前test的name 如 "注册"
		String testName = tr.getTestContext().getCurrentXmlTest().getName();
		baseURL+=File.separator+testName;
		//获取当前时间，按特定格式截取
		String date = DateFormatUtils.format(new Date().getTime(), "yyyy-MM-dd");
		baseURL+=File.separator+date;
		//在此目录下保存截图,并返回目标文件
		File destFile = ScreenUtil.takeScreenShot(baseURL);
		//获得文件的绝对路径
		String solutepath = destFile.getAbsolutePath();
		//将绝对路径path换成apach配置的默认路径
		//C:\TestSelenium\selenumTest\target\surefire-reports\screenshot\注册\2018-09-02\1535886656717.jpg
		//C:\TestSelenium\selenumTest\target\surefire-reports\screenshot\注册\2018-09-02\*.jpg
		String toberepalce = solutepath.substring(0, solutepath.indexOf("screenshot"));
		String accesspath = solutepath.replace(toberepalce, "http://localhost:10080/");
		System.out.println("accesspath----------"+accesspath);
		Reporter.log("<img src='"+accesspath+"' width='100' height='100'><a href='"+accesspath+"' target='_blank'>点击查看大图</a></img>");
		
		
	}

}
