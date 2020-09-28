package apple.littletest;

import com.alibaba.fastjson.JSONArray;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestLittle {
	public Logger logger = Logger.getLogger("日志测试");
	
	//测试用
	
	@Test
	public void test222() {
		String str = "[\"全套\",\"5-1\",\"5-2\",\"5-3\",\"5-4\",\"5-5\"]";
		JSONArray jsonArray = JSONArray.parseArray(str);
		System.out.println("jsonArray:" + jsonArray);

		System.out.println("jsonArray.get(3):" + jsonArray.get(3));
	}
	
	@Test
	//迭代器的使用
	public void test0731(){
	List<String> list = new ArrayList<String>();
	list.add("111");
	list.add("222");
	list.add("333");

	//获取迭代器
		Iterator it = list.iterator();

		while(it.hasNext())
		{
		System.out.println(it.next());}

	}
	
	//测试YAML文件解析
	
	@Test
	//测试获取随机手机号
	public void test0907() {
		String phonePrefix = "171";
		String timestamp = String.valueOf(System.currentTimeMillis());
		Random random = new Random();
		
		Integer rand1 = random.nextInt(10); //生成一个0－10的任意正整数
		Integer rand2 = random.nextInt(10);
		
		String phoneEnd = rand1.toString() + timestamp.substring(7) +rand2.toString();
		
		String phone = phonePrefix + phoneEnd;
		System.out.println(phone);
	}
	
	@Test
	//记录日志，有点问题
	public void test0915(){
		//记录日志，有点问题
		logger.info("this is info log");
		logger.log(Level.INFO,"THIS IS INFO LOG");
		logger.log(Level.WARNING,"this is warning");
	}
	
	//异常处理机制，抛出异常
	@Test
	public void testException(){
		String filePath = "src/test/resources/11.properties";
		
		try {
			loadProperties(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("111");
		
	}
	
	private void loadProperties(String filePath) throws IOException {
		//准备文件对象
		File file = new File(filePath);
		//将文件的内容读取到输入流对象
		InputStream inputStream = new FileInputStream(file);
		Properties properties = new Properties();
		properties.load(inputStream);
		System.out.println(properties.getProperty("log4j.rootLogger"));
	}
}
