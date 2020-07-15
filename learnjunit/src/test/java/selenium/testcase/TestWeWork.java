package selenium.testcase;

import org.hamcrest.Matcher;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import selenium.pages.App;

import java.util.List;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;


public class TestWeWork {
	
	public static App app;
	
	@BeforeClass
	public static void beforeAll() {
		app = new App();
		app.loginWithCookie();
	}
	//实现参数化测试：
	//测试添加成员，并且添加以后将其删除
	@Test
//	@ParameterizedTest
//	@ValueSource(strings = {"13100000000","13100001111","13100002222"})
	public void testAdd(String phonenumber) {
		//添加一个新成员并断言刚刚添加的是否成功存在通讯录页面列表
		Iterable iterMember =
		app
				.toAddMember()
				.addMember(phonenumber, phonenumber, phonenumber)
				.getMemberList();
		
		assertThat(iterMember, (Matcher<? super Iterable>) hasItem("13100000000"));
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
