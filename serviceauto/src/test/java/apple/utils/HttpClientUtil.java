package apple.utils;

import com.services.TestServiceDemo;
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

public class HttpClientUtil {
	private static Logger logger = Logger.getLogger(TestServiceDemo.class);
	
	
	public static String doGet(String url,String mobilephone,String pwd) {
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
		return result;
	}
	

	public static String doPost(String url,String mobilephone,String pwd){

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
			entity = new UrlEncodedFormEntity(list,"utf-8");
			//POST请求设置实体
			httpPost.setEntity(entity);
			httpResponse = httpClient.execute(httpPost);
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
	
	//把传入的JSON格式的参数字符串。解析，成可以传入请求的参数
	public static void jsonToStrings(String jsonstr){
	
	}
}
