package cn.sd.mybatisdemo.Test;


import cn.sd.mybatisdemo.mapper.UserMapper;
import cn.sd.mybatisdemo.model.User;
import org.apache.ibatis.session.SqlSession;
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
		//2:通过工厂类，获取到数据库链接的会话
		SqlSession session = sqlSessionFactory.openSession();
		//3:通过session操作数据库
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user = mapper.getOneUserById(1);
		}finally {
			session.close();
		}
	}
}
