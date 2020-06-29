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
		driver.manage().addCookie(new Cookie("wwrtx.sid", "iA3OFT_hCudvuMl57KD3EJi_tYfGxbqARG4cpPhpeWOcoPoyIOBFPbA5QFX5Jrvw"));
		driver.manage().addCookie(new Cookie("wwrtx.vst",
				"JNa81bvf29Xmsc_-c_-AnkOd0jmuX9Zk_tG2qQPmy1-pfdewIC7nFWddFxWpMimIutdINAlxF6GzI6BbEPiGZuDpoeTq2IkP2Ni8kKO-eWHWFRyQxMaduTE6ztLlapWKz9dt-CS8XAt22gyanuFic0_22Ce5q76rzHRE0UuS29AdFINcjsElcnmnnX38Hs743WPa6pPHtLwSf2QOtb3LtVUQ_RrC3NN7T8YyoVP9INpEoWEcPEjVGd0lWoS_Zx26LXJu-cti55LRVPQOqkEQWQ"));
		
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
}
