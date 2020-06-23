package selenium.testcase;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import selenium.pages.App;

public class TestWeWork {
	
	public static App app;
	
	@BeforeClass
	public static void beforeAll() {
		app = new App();
		app.loginWithCookie();
	}
	
	@Test
	public void testAdd() {
		String phonenumber = "13152698569";
		app.toAddMember().AddMember(phonenumber, phonenumber, phonenumber);
		
	}
}
