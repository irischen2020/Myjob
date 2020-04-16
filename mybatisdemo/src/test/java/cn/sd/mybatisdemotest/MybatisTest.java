package cn.sd.mybatisdemotest;


import cn.sd.mybatisdemo.mapper.RoleMapper;
import cn.sd.mybatisdemo.mapper.UserMapper;
import cn.sd.mybatisdemo.model.Role;
import cn.sd.mybatisdemo.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.apache.ibatis.io.Resources.*;

public class MybatisTest {
	@Test
	public void test() throws IOException {
		//1:获取到创建数据库链接的会话的工厂类,根据配置文件创建
		InputStream inputStream = getResourceAsStream("mybatisConfig.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		//2:通过工厂类，获取到数据库链接的会话
		SqlSession session = sqlSessionFactory.openSession();
		//3:通过session操作数据库
		try {
//			User user = session.selectOne("cn.sd.mybatisdemo.mapper.getOneUserById",2);
//			System.out.println(user);
			UserMapper mapper = session.getMapper(UserMapper.class);
			System.out.println(mapper.getClass());
			//查询
//			List<User> list = new ArrayList<User>();
//			list = mapper.getUsersById(1,6);
//			System.out.println(list);
			//新增
//			User user = new User("ccc","123",new Date());
//			mapper.insertUser(user);
//			session.commit();
//			System.out.println(user.getId());
			//查询
			User user = mapper.getOneUserById(1);
			System.out.println(user);
			
			//查询ROLE中对应的USERS
//			RoleMapper roleMapper = session.getMapper(RoleMapper.class);
//			Role role = roleMapper.getUsersById(3);
//			System.out.println(role);
		}finally {
			session.close();
		}
	}
}
