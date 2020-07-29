package selenium.testcase;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.engine.Filter;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runners.Parameterized;
import selenium.pages.App;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;



public class TestWeWork {
	
	public static App app;
	
	@BeforeAll
	public static void beforeAll() {
		app = new App();
		app.loginWithCookie();
	}
	//实现参数化测试：(正向用例)
	//测试添加成员，并且添加以后将其删除
	@ParameterizedTest
	@MethodSource("strings")
	void testAdd(String username,String account,String phone) {
		//添加一个新成员并断言刚刚添加的是否成功存在通讯录页面列表
		List<String> listMember =
		app
				.toAddMember()
				.addMember(username, account, phone)
				.getMemberList();
		
		assertThat(listMember, hasItem(username));
//		添加完以后将刚刚添加的记录删除
		app.toContact().searchOneAndDelete(phone);
		
	}
	static Stream<Arguments> strings() {
		return Stream.of(
				Arguments.of("test072806","test072806a","13122226666"),
				Arguments.of("test072807","test072807a","13122227777"),
				Arguments.of("test072808","test072808a","13122228888")
		);
	}
	//忽略反向用例
	
	//实现数据驱动测试，从EXCEL里面读取测试用例
	//测试添加成员，并且添加以后将其删除
	@ParameterizedTest
	@MethodSource("strings")
	void testAddFromFile(String username,String account,String phone) {
		//添加一个新成员并断言刚刚添加的是否成功存在通讯录页面列表
		List<String> listMember =
				app
						.toAddMember()
						.addMember(username, account, phone)
						.getMemberList();
		
		assertThat(listMember, hasItem(username));
//		添加完以后将刚刚添加的记录删除
		app.toContact().searchOneAndDelete(phone);
		
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
	@Test
	public void test222(){
		String str = "[\"全套\",\"5-1\",\"5-2\",\"5-3\",\"5-4\",\"5-5\"]";
		JSONArray jsonArray = JSONArray.parseArray(str);
		System.out.println("jsonArray:" + jsonArray);
		
		System.out.println("jsonArray.get(3):" + jsonArray.get(3));
		
	}
	
	
//	@AfterAll
//	public static void afterAll() {
//	 	app.quite();
//	}
}
