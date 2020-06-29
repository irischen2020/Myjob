package selenium.pages;

import org.openqa.selenium.By;

public class MessageSendPage extends BasePage {
public void send() throws InterruptedException {
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
//	window.scrollTo(0,0);
	//点击确认
	findElement(By.linkText("确认")).click();
	
}
}

