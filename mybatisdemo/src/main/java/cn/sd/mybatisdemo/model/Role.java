package cn.sd.mybatisdemo.model;

import lombok.Data;

import java.util.List;

@Data
public class Role {
	private int id;
	private String roleName;
	
	private List<User> users;
	
	
	public Role() {
	}

	public Role(String roleName) {
		this.roleName = roleName;
	}
	
}
