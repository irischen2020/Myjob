package recordcodes;



import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class WorkweixinTest {
	// Generated by Selenium IDE
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;
	
	@BeforeAll
	public void setUp() {
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}
	
	@AfterAll
//	public void tearDown() {
//		driver.quit();
//	}
	
	@Test
	public void workweixin() {
		System.setProperty("webdriver.gecko.driver", "F:\\Myjob\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://work.weixin.qq.com/");
		driver.manage().addCookie(new Cookie("wwrtx.sid","iA3OFT_hCudvuMl57KD3EAI7BY32gz-TVk7B3jL-d7bUljvijMRj8OikOTFVO1PL"));
		driver.manage().addCookie(new Cookie("wwrtx.vst",
				"ctZotwZzvtZJVVj0a9NQwrGIgLoEd_QI2QsugggLDq8rNjWdojvLv87ZxAW4tS--h5bQ_W0Ox9fDuoZpgbTKK4dvEOncNvD9zbOGZwXM1bulx0ekHpuEEReVaxKo6inA4tUptSn3z-UIyEfPqee3NtnLS32qjVsv71pgwo60xTlJKVB4CZ2d2P4xBLlVdlEaXEy8yhbDbxjb0Rj_lGPg-Eq7BVKtJnURsU7Xvpq05H60OZRc1SiijAC9NCoA1DcFfvki0gEAT8pL4QPcdoZMYg"));
		
		driver.findElement(By.linkText("企业登录")).click();

	}
}

