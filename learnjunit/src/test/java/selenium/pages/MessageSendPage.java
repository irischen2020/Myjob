package selenium.pages;

import org.openqa.selenium.By;

public class MessageSendPage extends BasePage {
public void send(){
	findElement(By.linkText("选择需要发消息的应用")).click();
	findElement(By.cssSelector(".js_app_dlg_item .ww_bubble_cell:nth-child(2)"),0).click();
}
}

