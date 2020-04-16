package cn.sd.mybatisdemo.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {
	private int id;
	private String username;
	private String password;
	private Date regtime;
	
	private Role role; //假设每个用户只关联一个角色
	
	
	public User() {
		super();
	}
	
//	public User(String username, String password, Date regtime) {
//		this.username = username;
//		this.password = password;
//		this.regtime = regtime;
//	}
	
	
	public User(String username, String password, Date regtime, Role role) {
		this.username = username;
		this.password = password;
		this.regtime = regtime;
		this.role = role;
	}
}

