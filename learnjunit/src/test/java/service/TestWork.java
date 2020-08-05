package service;


import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestWork {
	public static String token;
	public static int parentDepartId = 2;
	@BeforeAll
	public static void getToken() {
		token =
		given()
				.param("corpid", "wwc135398b05beab7c")
				.param("corpsecret", "cPMWkjGTqDxhI3dWGjFgGmG53hS_lZQj-q_Lj3madTQ")
		.when()
				.log().all()
				.get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
		.then()
				.log().all()
				.body("errcode",equalTo(0))
		.extract()
				.body().path("access_token");
		System.out.println(token);
	}
	
	@Test
	public void departCreate(){
		Map<String,Object> data = new HashMap<>();
		data.put("name","部门1");
		data.put("parentid",parentDepartId);
		
		given()
				.queryParam("access_token",token)
				.contentType(ContentType.JSON)
				.body(data)
		.when().log().all()
				.post("https://qyapi.weixin.qq.com/cgi-bin/department/create")
		.then().log().all()
				.body("errcode",equalTo(0));
				
	}
}
