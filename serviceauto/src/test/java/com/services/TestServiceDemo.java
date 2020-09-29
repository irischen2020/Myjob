package com.services;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestServiceDemo {
	
	private static Logger logger = Logger.getLogger(TestServiceDemo.class);
	
	@Test
	public void testSendGet() {
		String url = "http://test.lemonban.com:8080/futureloan/mvc/api/member/login";
		String mobilephone = "18330372028";
		String pwd = "123456";
		//get请求
		//创建连接
		HttpClient httpClient = HttpClientBuilder.create().build();
		String urlPath = url + "?" + "mobilephone=" + mobilephone + "&" + "pwd=" + pwd;
		HttpGet httpGet = new HttpGet(urlPath);
		HttpResponse httpResponse = null;
		HttpEntity httpEntity = null;
		String result = "";
		//执行GET请求
		try {
			httpResponse = httpClient.execute(httpGet);
			//如果服务器返回的状态码200
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				httpEntity = httpResponse.getEntity();
				result = EntityUtils.toString(httpEntity);
				logger.info(result);
			}
		} catch (IOException e) {
			logger.error("请求接口出现异常",e);
		}finally {
			try {
				EntityUtils.consume(httpEntity);
			} catch (IOException e) {
				logger.error("http请求释放资源异常",e);
			}
		}
//		return result;
	}
	
	@Test
	public void testSendPost(){
		String url = "http://test.lemonban.com:8080/futureloan/mvc/api/member/login";
		String mobilephone = "18330372028";
		String pwd = "123456";
		//创建HTTPCLIENT
		HttpClient httpClient = HttpClientBuilder.create().build();
		//创建POST
		HttpPost httpPost = new HttpPost(url);
		HttpResponse httpResponse = null;
		HttpEntity httpEntity = null;
		String result = "";
		//准备参数
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		BasicNameValuePair nameValuePair = new BasicNameValuePair("mobilephone",mobilephone);
		BasicNameValuePair pwdValuePair = new BasicNameValuePair("pwd",pwd);
		list.add(nameValuePair);
		list.add(pwdValuePair);
		//准备entity,数据以实体的方式存储，也就是键值对
		UrlEncodedFormEntity entity = null;
		try {
			entity = new UrlEncodedFormEntity(list);
			//POST请求设置实体
			httpPost.setEntity(entity);
			httpResponse = httpClient.execute(httpPost);
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
				httpEntity = httpResponse.getEntity();
				result = EntityUtils.toString(httpEntity);
				logger.info(result);
			}
		} catch (Exception e) {
			logger.error("请求接口出现异常：",e);
		}finally {
			try {
				EntityUtils.consume(httpEntity);
			} catch (IOException e) {
				logger.error("http请求释放资源异常",e);
			}
		}
//		return result;
	}
	
}
