package com.ss.apis.service;

import com.ss.apis.mapper.UserMapper;
import com.ss.apis.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void add(User user) {
		userMapper.add(user);
	}
}
