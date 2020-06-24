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
		driver.manage().addCookie(new Cookie("wwrtx.sid", "iA3OFT_hCudvuMl57KD3EMK8li9Z2CNDLJaQU7GLXMV2BFtGr8AUxGOGEUCCeP-P"));
		driver.manage().addCookie(new Cookie("wwrtx.vst",
				"gMzL8c_p92-Epeejv3q2CrrZWQaw2Lv9tkrQoNPd8qC6Df173lzQCdehQDzCJEOQoxQupk9DGbbcrFoAjgft2ernjH-K2UBxJ66ksy0a_jHGy1GAQfA2qK58-CY5tbzGTu5-JbVgAujguL7lWyBYmy7xUKCiceMAT7zsr-FrUPO2cfyt2FE4MHf8IN8J1pLuQSFmThD7GgKjEIWcGMvdgMz6SwABPNPgvGszHGUfenBVxAv9FbB-PXUk1fkbSmlh42YZYTXh1PuWKISjjNoinQ"));
		
		findElement(By.linkText("企业登录")).click();
		//或者直接刷新
//		driver.navigate().refresh();
		return this;
	}
	
	public  ContactPage toContact() {
		findElement(By.linkText("通讯录")).click();
		return new ContactPage();
	}
	
	public  ContactPage toAddMember() {
		findElement(By.linkText("添加成员")).click();
		return new ContactPage();
	}

}
