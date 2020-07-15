package service;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestWork {
	public static String token;
	@BeforeAll
	public void getToken() {
		token =
		given()
				.param("corpid", "wwc135398b05beab7c")
				.param("corpsecret", "cPMWkjGTqDxhI3dWGjFgGnQE03KH40F3yPtm8iSTyvc")
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
}
