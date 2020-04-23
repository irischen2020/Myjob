package com.ss.apirunner;

import com.ss.apis.Application;
import com.ss.apis.mapper.UserMapper;
import com.ss.apis.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={Application.class})
public class UserTest {
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void test() {
		User user = new User("aa", "123456", "2020-04-23");
		userMapper.add(user);
	}
}
