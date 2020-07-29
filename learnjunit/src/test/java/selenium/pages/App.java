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
		driver.manage().addCookie(new Cookie("wwrtx.sid", "iA3OFT_hCudvuMl57KD3ELrjyxYdcMOcWSn_UG7pjnbNDzRHCI0NuVFhQMMruZWx"));
		driver.manage().addCookie(new Cookie("wwrtx.vst",
				"67QqYK71GukpTKMUOZ5IuODll_F815jN1b5YXP5Uc9ldN5HtIvlLzbjpE3Lr4oMOrqo2X9cwhz9cyU_kVZVTjm9feA7YJDyzODdMlYHo-daq8XPhqwoFygrjQNG3KMZdlAE10TftESHWAt6c1-crnFeVZglFebjS2Mt7d2wpvLDp1MX4gI1ODF9HLqZ6I9PYaVU5ddCRyynhLibIRCa-ywP_NdfFWKfWvov9cdbHL2qtrk_nU9oUpHpunxd9B5a14hlp6WoRf2foUxTnzFVRpw"));
		
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
