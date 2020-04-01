package cn.sd.mybatisdemo.Test;


import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.apache.ibatis.io.Resources.*;

public class MybatisTest {
	@Test
	public void test() throws IOException {
		//1:获取到创建数据库链接的会话的工厂类,根据配置文件创建
		InputStream inputStream = getResourceAsStream("mybatisConfig.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
	}
}
