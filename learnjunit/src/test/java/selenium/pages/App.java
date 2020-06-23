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
		driver.manage().addCookie(new Cookie("wwrtx.sid", "iA3OFT_hCudvuMl57KD3EAI7BY32gz-TVk7B3jL-d7bUljvijMRj8OikOTFVO1PL"));
		driver.manage().addCookie(new Cookie("wwrtx.vst",
				"ctZotwZzvtZJVVj0a9NQwrGIgLoEd_QI2QsugggLDq8rNjWdojvLv87ZxAW4tS--h5bQ_W0Ox9fDuoZpgbTKK4dvEOncNvD9zbOGZwXM1bulx0ekHpuEEReVaxKo6inA4tUptSn3z-UIyEfPqee3NtnLS32qjVsv71pgwo60xTlJKVB4CZ2d2P4xBLlVdlEaXEy8yhbDbxjb0Rj_lGPg-Eq7BVKtJnURsU7Xvpq05H60OZRc1SiijAC9NCoA1DcFfvki0gEAT8pL4QPcdoZMYg"));
		
		findElement(By.linkText("企业登录")).click();
		//或者直接刷新
//		driver.navigate().refresh();
		return this;
	}
	
	public static ContactPage toContact() {
		findElement(By.linkText("通讯录")).click();
		return new ContactPage();
	}
	
	public static ContactPage toAddMember() {
		findElement(By.linkText("添加成员")).click();
		return new ContactPage();
	}
	
}
