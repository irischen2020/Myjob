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
	//实现参数化测试：(正向用例)
	//测试添加成员，并且添加以后将其删除
	@ParameterizedTest
	@ValueSource(strings = {"test0716","test0716a","13100002222"})
	public void testAddSuccess(String username,String account,String phone) {
		//添加一个新成员并断言刚刚添加的是否成功存在通讯录页面列表
		List<String> listMember =
		app
				.toAddMember()
				.addMember(username, account, phone)
				.getMemberList();
		
		assertThat(listMember, hasItem("test0716"));
		//添加完以后将刚刚添加的记录删除
//		app.toContact().searchOneAndDelete(phonenumber);
		
	}
	//实现参数化测试：(反向用例)
	//测试添加成员，并且添加以后将其删除
	@ParameterizedTest
	@ValueSource(strings = {"test0716","test0716a","13100002222"})
	public void testAddFail(String username,String account,String phone) {
		//添加一个新成员并断言刚刚添加的是否成功存在通讯录页面列表
		List<String> listMember =
				app
						.toAddMember()
						.addMember(username, account, phone)
						.getMemberList();
		
		assertThat(listMember, hasItem("test0716"));
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
	
	//测试用
	public void test(){
		String str = "[\"全套\",\"5-1\",\"5-2\",\"5-3\",\"5-4\",\"5-5\"]";
		JSONObject jsonArray = JSONArray
		
	}
	
	
//	@AfterClass
//	public static void afterAll() {
//	 	app.quite();
//	}
}
