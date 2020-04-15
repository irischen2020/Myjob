package cn.sd.mybatisdemo.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {
	private int id;
	private String username;
	private String password;
	private Date regtime;
	
	
	public User() {
		super();
	}
	
	public User(String username, String password, Date regtime) {
		this.username = username;
		this.password = password;
		this.regtime = regtime;
	}
}

