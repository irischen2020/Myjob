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
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpClientUtils {
	private static Logger logger = Logger.getLogger(HttpClientUtils.class);
	
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
		result = getResultString(httpClient, httpGet, httpEntity, result);
		return result;
	}

	public static String doPost(String url, Map<String, String> params){

		//创建HTTPCLIENT
		HttpClient httpClient = HttpClientBuilder.create().build();
		//创建POST
		HttpPost httpPost = new HttpPost(url);
//		HttpResponse httpResponse = null;
		HttpEntity httpEntity = null;
		String result = "";
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
		result = getResultString(httpClient, httpPost, httpEntity, result);
		return result;
	}
	
	//公共代码抽取出来。执行请求并拿到响应结果字符串
	private static String getResultString(HttpClient httpClient, HttpUriRequest httpUriRequest, HttpEntity httpEntity, String result) {
		HttpResponse httpResponse;
		try {
			httpResponse = httpClient.execute(httpUriRequest);
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
	

}
