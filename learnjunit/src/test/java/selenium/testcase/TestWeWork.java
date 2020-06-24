package selenium.testcase;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import selenium.pages.App;

public class TestWeWork {
	
	public static App app;
	
	@BeforeClass
	public static void beforeAll() {
		app = new App();
		app.loginWithCookie();
	}
	//测试添加成员，并且添加以后将其删除
	@Test
	public void testAdd() {
		String phonenumber = "13511111111";
		app.toAddMember().addMember(phonenumber, phonenumber, phonenumber);
		//添加完以后将刚刚添加的记录删除
//		app.toContact().searchOneAndDelete(phonenumber);
		
	}
	//测试删除功能，多选删除
	@Test
	public void testDelete(){
		app.toContact().deleteMember();
	}
	
	//测试上传通讯录
	@Test
	public void testImport(){
		String filepath = "E:\\Setup\\通讯录批量导入模板.xlsx";
		app.toContact().toImportPage().importFormFile(filepath);
	}
	
	//测试消息发送
	@Test
	public void testMessageSend(){
		app.toMessageSend().send();
	}
	
	@AfterClass
	public static void afterAll() {
	 	app.quite();
	}
}
