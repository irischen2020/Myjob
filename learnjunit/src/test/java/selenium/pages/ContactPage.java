package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ContactPage extends BasePage {
	//添加成员
	public ContactPage addMember(String username, String useraccount, String phonenumber) {
		
		findElement(By.id("username")).sendKeys(username);
		findElement(By.id("memberAdd_acctid")).sendKeys(useraccount);
		findElement(By.id("memberAdd_phone")).sendKeys(useraccount);
		findElement(By.linkText("保存")).click();
		return this;
	}
	
	//查询出所有成员，放入LIST集合，用来后面做断言用
	public List<String> getMemberList(){
		
		List<String> listText = new ArrayList<String>();
		List<WebElement> elements = new ArrayList<WebElement>();
		elements = driver.findElements(By.cssSelector(".member_colRight_memberTable_td:nth-child(2) > span"));
		for (WebElement element:elements) {
			String text = element.getText().toString();
			System.out.println(text);
			listText.add(text);
		}
		return listText;
	}
	
	//查询出某个成员然后删除
	public ContactPage searchOneAndDelete(String useraccount) {
		findElement(By.cssSelector("#memberSearchInput")).sendKeys(useraccount);
		findElement(By.cssSelector(".ww_commonImg_Search")).click();
		findElement(By.cssSelector(".js_del_member")).click();
		findElement(By.linkText("确认")).click();
		return this;
	}
	
	public ContactPage deleteMember() {
		try {
			findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
			findElement(By.xpath("(//input[@type='checkbox'])[4]")).click();
			findElement(By.linkText("删除")).click();
			findElement(By.linkText("确认")).click();
			return this;
		} catch (Exception e) {
			e.printStackTrace();
			return this;
		}
		
	}
	
	//点击文件导入，进入文件导入页面
	public ImportPage toImportPage() {
		findElement(By.cssSelector(".ww_operationBar:nth-child(1) .ww_btn_PartDropdown_left")).click();
		findElement(By.linkText("文件导入")).click();
		return new ImportPage();
	}
}
