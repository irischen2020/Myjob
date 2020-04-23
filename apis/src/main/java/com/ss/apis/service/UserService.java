package com.ss.apis.service;

import com.ss.apis.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
	public void add(User user);
}
