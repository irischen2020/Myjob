package com.cc.test;

import com.cc.dao.IUserDao;
import com.cc.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.*;
import java.util.List;

public class MybatisCrudTest {
	@Test
	public void testFindAll() throws IOException {
		//1、读取配置文件，生成字节输入流
//		InputStream in = new FileInputStream("src/resources/sqlMapperConfig.xml");
		Reader reader = Resources.getResourceAsReader("sqlMapperConfig.xml");
		//2、获取SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//3、获取SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//4、获取DAO的代理对象
		IUserDao userDao = sqlSession.getMapper(IUserDao.class);
		//5、执行查询所有方法
		List<User> users = userDao.findALL();
		for (User user :users){
			System.out.println(user);
		}
		//6、释放资源
		sqlSession.close();
		reader.close();
	}
}
