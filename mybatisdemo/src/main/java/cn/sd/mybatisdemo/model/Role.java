package cn.sd.mybatisdemo.model;

import lombok.Data;

import java.util.List;

@Data
public class Role {
	private int id;
	private String roleName;
	
	
	public Role() {
	}
	
	public Role(String roleName) {
		this.roleName = roleName;
	}
	
}
