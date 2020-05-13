package com.test.web;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Webpage {
	private String pageUrl; //定义需要操作的网页地址
	private String pageEncode;//定义需要操作的网页的编码
	
	public String getPageUrl(){
		return pageUrl;
	}
	public void setPageUrl(String pageUrl){
		this.pageUrl = pageUrl;
	}
	public String getPageEncode(){
		return pageEncode;
	}
	public void setPageEncode(String pageEncode){
		this.pageEncode = pageEncode;
	}
	//定义取源码的方法
	public String getPageSource(){
		StringBuffer sb = new StringBuffer();
		
		//构建一URL对象
		try {
			URL url = new URL(pageUrl);
			
			//获取网页的编码方式，这里可以解决乱码问题
			HttpURLConnection uc = (HttpURLConnection) url.openConnection();
			pageEncode = uc.getContentType();
			pageEncode = pageEncode.substring(pageEncode.indexOf("charset=")+8).trim();
			System.out.println(pageEncode);
			
			//使用openStream得到一输入流并由此构造一个BufferedReader对象
			//整体意思就是用InputStreamReader这个中介把url.openStream()这个字节流转换成字符流BufferedReader
			//BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
			//或者分步写
			InputStream in = url.openStream(); //打开这个URL连接并从中获取到这个连接的输入流（此时得到的输入流是字节流）
			InputStreamReader isr = new InputStreamReader(in,pageEncode);//字节流转换为字符流
			BufferedReader bufferedReader = new BufferedReader(isr);//把字符流添加到缓冲流
			
			//把这个缓冲流(即网页源码)一行一行地读取出来添加到StringBuffer
			String line = null;
			while((line = bufferedReader.readLine()) != null){
				sb.append(line + "\t\n");
//				System.out.println(line);
			}
			bufferedReader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	//定义一个把图片URL地址拿到的方法
	public List<String> getImageUrls(){
		List<String> strs = new ArrayList<String>();
		//获取未处理过的源码
		String htmlSource = getPageSource();
		//定义正则表达式
		final String pattern = "src=\"(.*)>";
		Pattern p = Pattern.compile(pattern,Pattern.MULTILINE);
		Matcher m = p.matcher(htmlSource);
		System.out.println("group:"+ m.groupCount());
//		return null;
		while(m.find()){
			strs.add(m.group());
		}
		System.out.println(strs);
		return strs;
	}
	
	//定义一个把HTML标签删除过的源码的方法
	public String getPageSourceWithoutHtml()
	{
		final String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
		final String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
		final String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
		final String regEx_space = "\\s*|\t|\r|\n";//定义空格回车换行符
		String htmlStr = getPageSource();//获取未处理过的源码
		Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
		Matcher m_script = p_script.matcher(htmlStr);
		htmlStr = m_script.replaceAll(""); // 过滤script标签
		Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
		Matcher m_style = p_style.matcher(htmlStr);
		htmlStr = m_style.replaceAll(""); // 过滤style标签
		Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
		Matcher m_html = p_html.matcher(htmlStr);
		htmlStr = m_html.replaceAll(""); // 过滤html标签
		Pattern p_space = Pattern.compile(regEx_space, Pattern.CASE_INSENSITIVE);
		Matcher m_space = p_space.matcher(htmlStr);
		htmlStr = m_space.replaceAll(""); // 过滤空格回车标签
		htmlStr = htmlStr.trim(); // 返回文本字符串
		htmlStr = htmlStr.replaceAll(" ", "");
		htmlStr = htmlStr.substring(0, htmlStr.indexOf("。")+1);
		return htmlStr;
	}
}
