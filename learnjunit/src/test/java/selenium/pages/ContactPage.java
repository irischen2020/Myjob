package selenium.pages;

import org.openqa.selenium.By;

public class ContactPage extends BasePage{
	public ContactPage AddMember(String username, String useraccount, String phonenumber){
		
		findElement(By.id("username")).sendKeys(username);
		findElement(By.id("memberAdd_acctid")).sendKeys(useraccount);
		findElement(By.id("memberAdd_phone")).sendKeys(useraccount);
		findElement(By.linkText("保存")).click();
		return this;
	}
}
