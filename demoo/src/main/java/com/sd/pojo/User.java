package com.sd.pojo;

import lombok.Data;

@Data
public class User {
	private int userId;
	private String userName;
	private String userPwd;
	
	
	public User(int userId, String userName, String userPwd) {
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
	}
}
