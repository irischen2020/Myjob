package apple.utils;

import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.SourceType;

import javax.xml.bind.SchemaOutputResolver;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class HttpClientUtils {
	private static Logger logger = Logger.getLogger(HttpClientUtils.class);
	
	//定义一个MAP，用来存放从响应里面获得的JSESSIONID
	public static Map<String,String> resCookies = new HashMap<String, String>();
	
	public static String doGet(String url, Map<String,String> params) {
		//get请求
		//创建连接
		HttpClient httpClient = HttpClientBuilder.create().build();
		
		//将参数拿出来并进行拼接。判断该MAP是否为空
		if (params.isEmpty() == false){
			int mark = 1;
			Set<String> keySet = params.keySet();
			for (String key : keySet) {
				String value = params.get(key);
				if(mark == 1) {
					url = url + "?" + key + "=" + value;
				}else{
					url = url + "&" + key + "=" + value;
				}
				mark++;
			}
		}
		HttpGet httpGet = new HttpGet(url);
//		HttpResponse httpResponse = null;
		HttpEntity httpEntity = null;
		String result = "";
		//执行GET请求
		//将以下代码抽取出来，定义一个公共的方法
//		try {
//			httpResponse = httpClient.execute(httpGet);
//			//如果服务器返回的状态码200
//			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
//				httpEntity = httpResponse.getEntity();
//				result = EntityUtils.toString(httpEntity);
//				logger.info(result);
//			}
//		} catch (IOException e) {
//			logger.error("请求接口出现异常",e);
//		}finally {
//			try {
//				EntityUtils.consume(httpEntity);
//			} catch (IOException e) {
//				logger.error("http请求释放资源异常",e);
//			}
//		}
		result = getResultString(httpClient, httpGet, httpEntity);
		return result;
	}

	public static String doPost(String url, Map<String, String> params){

		//创建HTTPCLIENT
		HttpClient httpClient = HttpClientBuilder.create().build();
		//创建POST
		HttpPost httpPost = new HttpPost(url);
		String result = "";
		HttpEntity httpEntity = null;
		//准备参数
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		//遍历MAP,取出传入的参数
		Set<String> keySet = params.keySet();  //先拿到KEY的集合
		for (String key : keySet)
			 {
			 	String value = params.get(key);
			 	BasicNameValuePair nameValuePair = new BasicNameValuePair(key,value);
			 	list.add(nameValuePair);

		}
		//准备entity,数据以实体的方式存储，也就是键值对
		UrlEncodedFormEntity entity = null;

		try {
			entity = new UrlEncodedFormEntity(list,"utf-8");
			//POST请求设置实体
			httpPost.setEntity(entity);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		//执行请求并判断请求结果
		result = getResultString(httpClient, httpPost, httpEntity);
		return result;
	}
	
	//公共代码抽取出来。执行请求并拿到响应结果字符串
	private static String getResultString(HttpClient httpClient, HttpUriRequest httpUriRequest, HttpEntity httpEntity) {
		String result = "";
		HttpResponse httpResponse;
		try {
			//添加COOKIE.判断存COOKIE的MAP里面有没有，有就加，没有就不加。
			addCookieInRequestHeaderBeforeRequest(httpUriRequest);
			System.out.println("resCookies:"+resCookies.get("JSESSION"));
			System.out.println("请求：..................."+httpUriRequest);
			httpResponse = httpClient.execute(httpUriRequest);
			System.out.println("响应：------------"+httpResponse);
			
			//从响应结果里面取想要的COOKIE，如果有就存起来。
			getAndStoreCookieFromResponse(httpResponse);
			
			
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
				httpEntity = httpResponse.getEntity();
			
				//响应报文
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
		return result;
	}
	
	/**
	 * //添加COOKIE.判断存COOKIE的MAP里面有没有，有就加，没有就不加。
	 * @param httpUriRequest
	 */
	private static void addCookieInRequestHeaderBeforeRequest(HttpUriRequest httpUriRequest) {
		String resCookie = resCookies.get("JSESSION");
		if (resCookie != null){
			httpUriRequest.addHeader("Cookie",resCookie);
		}
	}
	
	/**
	 * //从响应里面找set-cookie,如果有就保存起来供后面使用
	 * @param httpResponse
	 */
	private static void getAndStoreCookieFromResponse(HttpResponse httpResponse) {

		//从响应里面找set-cookie,如果有就保存起来供后面使用
		Header header = httpResponse.getFirstHeader("Content-Type");
		System.out.println("header:"+header);
		//如果不为空
		if(header != null){
			String cookiePairs = header.getValue();
			//如果不为空，取出响应头的值，以分号切分
			if (cookiePairs !=null && cookiePairs.trim().length()>0){
				String[] cookies = cookiePairs.split(";");
				if(cookies !=null){
					//判断是否有包含JSESSIONID的串。这个视各个项目的具体情况而定
					for (String cookie : cookies){
						if(cookie.contains("JSESSIONID")){
							resCookies.put("JSESSION",cookie);
						}
					}
				}
			}
		}
	}
	
	public static String doService(String type, String url, Map<String, String> params){
		String result = "";
		if(type.equals("get")){
			result = doGet(url,params);
		}
		if(type.equals("post")){
			result = doGet(url,params);
		}
		return result;
	}
	
	//测试登录鉴权的代码
//	public static void main(String[] args) {
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("key","fe6af56e014d3413ce5ed610d72cafc1");
//		params.put("date","2020-10-28");
//		System.out.println("第一次调用：－－－－－－－－－－－");
//		doService("post","http://v.juhe.cn/laohuangli/d",params);
//		System.out.println("第二次调用：－－－－－－－－－－－");
//		doService("post","http://v.juhe.cn/laohuangli/d",params);
//	}

}
