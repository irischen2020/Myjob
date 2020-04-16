package cn.sd.mybatisdemo.mapper;


import cn.sd.mybatisdemo.model.Role;
import cn.sd.mybatisdemo.model.User;

import java.util.List;

public interface RoleMapper {
	
	public Role getOneRoleById(Integer id);
	
	public Role getUsersById(int id);
}
