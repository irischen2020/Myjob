package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MessageSendPage extends BasePage {
public MessageListPage send() throws InterruptedException {
	findElement(By.linkText("选择需要发消息的应用")).click();
	findElement(By.cssSelector(".js_app_dlg_item .ww_bubble_cell:nth-child(2)"),0).click();
	findElement(By.linkText("确定")).click();

	//选择发送范围
	findElement(By.cssSelector(".js_select_range_btn")).click();
	//搜索需要发送的人员
	findElement(By.id("memberSearchInput")).sendKeys("13511111111");
	//点击搜索按钮
	findElement(By.cssSelector(".ww_commonImg_Search")).click();
	//选中需要发送的人员
	findElement(By.cssSelector(".ww_searchResult_title_peopleDepartment")).click();
	//滚动窗口
//	执行JS脚本
//	window.scrollTo(0,103);
	//点击确认
	findElement(By.linkText("确认")).click();
	//点击输入标题
	findElement(By.cssSelector(".ww_editorTitle")).sendKeys("testtitle");
	Thread.sleep(3000);
	
	//切换iframe,iframe id 是动态变化的,以ueditor_打头
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[starts-with(@id, 'ueditor_')]")));
	
	//输入正文
	findElement(By.cssSelector(".msg_noticeEditor_frameBody"),0).sendKeys("testarticle");
	//切换回原来的窗体
	driver.switchTo().defaultContent();
	
	
	//	执行JS脚本,滚动窗口
	JavascriptExecutor jsdriver = (JavascriptExecutor) driver;
	jsdriver.executeScript("window.scrollTo(0,800)");
	
	//点击摘要后的输入框,注意：这个框和后面输入内容的框不是同一个元素
	findElement(By.cssSelector(".msg_edit_infoItem_textWord")).click();
	//输入摘要
	findElement(By.cssSelector(".qui_textarea"),0).sendKeys("testsummary");
	
	
	//输入作者
	findElement(By.cssSelector(".js_amrd_sendName")).sendKeys("testauthor");
	//点击发送
	findElement(By.linkText("发送")).click();
	//弹框，点击确定
	findElement(By.linkText("确定")).click();
	return new MessageListPage();
}
}

