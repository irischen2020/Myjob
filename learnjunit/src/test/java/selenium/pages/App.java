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
		driver.manage().addCookie(new Cookie("wwrtx.sid", "iA3OFT_hCudvuMl57KD3EDUlPKkji6O8yp8FNrDa9mr1HpuywVQ9FChg5LrrZLlA"));
		driver.manage().addCookie(new Cookie("wwrtx.vst",
				"GvclpFQQIdEbF0h6K03U3bnGoorvf3aaQq0VNlg26Yn_aMTnsFlRNnAhRM1JL4lDq46JP1Re6HA9v0Tf9UZbmLyFNsM9UR_UmUBlNiQ3yZJSghjxjSQLeIyV-TyZflU_vw_AsrqlKy-jx-_F1EEGdMefBmMivISQLiZTSCXZhTwFVkATqtwc02wVNp4E-NbMj6dGCqzSNeLOjyKe704ymezYgAa487KRaUGhF9otpEFHR06nnQlBtnEAqJM2XPE8DrNq_2JNM2v7VjRsKZ2NsQ"));
		
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
