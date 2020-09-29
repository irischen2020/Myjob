package apple.utils;

import org.apache.http.*;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

	/**
	 * @author : cj
	 * @version : 2.0
	 * @date : 2020/9/28
	 */
	public class HttpClientUtilBak {

		private static Logger logger = Logger.getLogger(HttpClientUtilBak.class);
		/**
		 * 处理application/json 格式报文的请求
		 * 通过post方式调用http接口
		 * @param url     url路径
		 * @param jsonParam    json格式的参数
		 * @return
		 * @throws Exception
		 */
		public static String sendPostByJson(String url, String jsonParam) {
			//声明返回结果
			String result = "";
			HttpEntity httpEntity = null;
			HttpResponse httpResponse = null;
			HttpClient httpClient = null;
			try {
				// 创建httpclient连接
				httpClient = HttpClientBuilder.create().build();
				//创建HTTPPOST
				HttpPost httpPost = new HttpPost(url);
				// 设置请求头
				Header header = new BasicHeader("Accept-Encoding","application/json");
				httpPost.setHeader(header);
				// 设置请求参数
				StringEntity stringEntity = new StringEntity(jsonParam,"utf-8");
				httpPost.setEntity(stringEntity);
				
				logger.info("请求接口的参数为:"+url+jsonParam);
				
				//执行发送，获取相应结果
				httpResponse = httpClient.execute(httpPost);
				//判断是否成功，处理请求结果
				if(httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					//读取服务器返回的JSON字符串数据
					httpEntity = httpResponse.getEntity();
					result = EntityUtils.toString(httpEntity);
				}
				
			} catch (Exception e) {
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
		
		/**
		 * 处理 application/x-www-form-urlencoded格式报文的请求
		 * 通过post方式调用http接口
		 * @param url     url路径
		 * @param map    form格式的参数
		 * @return
		 * @throws Exception
		 */
		public static String sendPostByForm(String url, Map<String,String> map) {
			//声明返回结果
			String result = "";
			HttpEntity httpEntity = null;
			UrlEncodedFormEntity entity = null;
			HttpResponse httpResponse = null;
			HttpClient httpClient = null;
			try {
				// 创建连接
				httpClient = HttpClientBuilder.create().build();
				// 创建HTTP
				HttpPost httpPost = new HttpPost(url);
				//设置参数
				List<NameValuePair> list = new ArrayList<NameValuePair>();
				Iterator iterator = map.entrySet().iterator();
				while(iterator.hasNext()){
					Map.Entry<String,String> elem = (Map.Entry<String, String>) iterator.next();
					list.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));
				}
				entity = new UrlEncodedFormEntity(list,"utf-8");
				httpPost.setEntity(entity);
				logger.info("请求接口的参数为:"+map);
				//执行发送，获取相应结果
				httpResponse = httpClient.execute(httpPost);
				//判断是否成功，处理请求结果
				if(httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					httpEntity = httpResponse.getEntity();
					result = EntityUtils.toString(httpEntity);
				}
			} catch (Exception e) {
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
		/**
		 *  处理 text/xml 格式报文的请求
		 *
		 * 通过post方式调用http接口
		 * @param url     url路径
		 * @param xmlParam    json格式的参数
		 * @param reSend     重发次数
		 * @return
		 * @throws Exception
		 */
		public static String sendPostByXml(String url, String xmlParam,int reSend) {
			//声明返回结果
			String result = "";
			HttpEntity httpEntity = null;
			HttpResponse httpResponse = null;
			HttpClient httpClient = null;
			try {
				// 创建连接
				httpClient = HttpClientBuilder.create().build();
				// 设置请求头和报文
				HttpPost httpPost = new HttpPost(url);
				StringEntity stringEntity = new StringEntity(xmlParam, "utf-8");
				stringEntity.setContentEncoding("utf-8");
				stringEntity.setContentType("text/xml");
				httpPost.setEntity(stringEntity);
				logger.info("请求接口的参数为"+xmlParam);
				//执行发送，获取相应结果
				httpResponse = httpClient.execute(httpPost);
				//判断是否成功
				if(httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK ){
					httpEntity = httpResponse.getEntity();
					result = EntityUtils.toString(httpEntity,"utf-8");
				}

			} catch (Exception e) {
				logger.error("请求接口出现异常", e);

			} finally {
				try {
					EntityUtils.consume(httpEntity);
				} catch (IOException e) {
					logger.error("http请求释放资源异常", e);
				}
				return result;
			}

		}
	}

