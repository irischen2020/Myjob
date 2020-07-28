package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class App extends BasePage {
	
	public App loginWithCookie() {
		System.setProperty("webdriver.gecko.driver", "F:\\Myjob\\geckodriver.exe");
		driver = new FirefoxDriver();
		//隐式等待
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://work.weixin.qq.com/");
		driver.manage().addCookie(new Cookie("wwrtx.sid", "iA3OFT_hCudvuMl57KD3EODq03VFHw00I5gmmHlXHM1x6pJpIk-iZ2YMSOeqenzB"));
		driver.manage().addCookie(new Cookie("wwrtx.vst",
				"yxKHiA2gn1i46bkG65oP9vhlNYWScKUsxeVcUP8izfvM4gaF9HpQozyZgT72WQZtyJRL3CiRiOAlifWDQ_EACGLErleq2h9pma4JsAgkbV5yjnJAOoWFjijW9CRJiXeZUxUgGq2FXvgewPVzb7QXoY1VF8pnumj77dLMJWUQiiPDhDPsw0p6ho3YY864MOtQAQ8WEP0qAM5lQYvVeAEosHhZ36RLm-8l-JuX-FZTGLZ_f4Hjm-1rYkpeMm3QllRsv9h2qTWMVb7bl4MCnm0OkQ"));
		
		findElement(By.linkText("企业登录")).click();
		//或者直接刷新
//		driver.navigate().refresh();
		return this;
	}
	
	//进入通讯录页面
	public ContactPage toContact() {
		findElement(By.linkText("通讯录")).click();
		return new ContactPage();
	}
	
	//进入添加成员页面
	public ContactPage toAddMember() {
		findElement(By.linkText("添加成员")).click();
		return new ContactPage();
	}
	
	//进入消息群发页面
	public MessageSendPage toMessageSend(){
		//点击管理工具
		findElement(By.cssSelector("#menu_manageTools")).click();
		//点击消息群发
		findElement(By.cssSelector(".js_show_SendMessage")).click();
		return new MessageSendPage();
		
	}
	//进入已发送页面
	public MessageListPage toMessageListPage(){
		//点击管理工具
		findElement(By.cssSelector("#menu_manageTools")).click();
		//点击消息群发
		findElement(By.cssSelector(".js_show_SendMessage")).click();
		//点击已发送
		findElement(By.linkText("已发送"));
		return new MessageListPage();
	}
}
