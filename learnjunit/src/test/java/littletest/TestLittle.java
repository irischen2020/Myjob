package littletest;

import com.alibaba.fastjson.JSONArray;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TestLittle {
	
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
}
