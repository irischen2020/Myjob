package selenium.testcase;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import selenium.pages.App;

import static org.hamcrest.MatcherAssert.assertThat;

public class TestWeWork {
	
	public static App app;
	
	@BeforeClass
	public static void beforeAll() {
		app = new App();
		app.loginWithCookie();
	}
	//实现参数化测试：
	//测试添加成员，并且添加以后将其删除
	@ParameterizedTest
	@ValueSource(strings = {"13100000000","13100001111","13100002222"})
	public void testAdd(String phonenumber) {
		app.toAddMember().addMember(phonenumber, phonenumber, phonenumber);
//		assertThat()
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
	public void testMessageSend() throws InterruptedException {
		app.toMessageSend().send();
	}
	
	//测试获取成员列表方法
	@Test
	public void testGetList(){
		app.toContact().getMemberList();
	}
	
//	@AfterClass
//	public static void afterAll() {
//	 	app.quite();
//	}
}
