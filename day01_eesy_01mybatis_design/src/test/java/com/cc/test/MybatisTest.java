package com.cc.test;

import com.cc.dao.IUserDao;
import com.cc.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * MYBATIS入门案例
 */
public class MybatisTest {
	public static void main(String[] args) throws Exception {
		//1、读取配置文件
		InputStream in = Resources.getResourceAsStream("sqlMapperConfig.xml");
		//2、创建SqlSessionFactory工厂
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(in);
		//3、使用工厂生产SqlSession对象
		SqlSession sqlSession = factory.openSession();
		//4、使用SqlSession创建Dao接口的代理对象
		IUserDao userDao = sqlSession.getMapper(IUserDao.class);
		//5、使用代理对象执行方法
		List<User> list = userDao.findALL();
		//6、释放资源
		sqlSession.close();
		in.close();
	}
}
