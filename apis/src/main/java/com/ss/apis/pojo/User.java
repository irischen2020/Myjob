package com.ss.apis.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class User {
	private String id;
	private String username;
	private String password;
	private String regtime;
	
	public User(String username, String password, String regtime) {
		this.username = username;
		this.password = password;
		this.regtime = regtime;
	}
	
	public User() {
	}
}
