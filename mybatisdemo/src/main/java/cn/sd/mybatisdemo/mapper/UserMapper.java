package cn.sd.mybatisdemo.mapper;


import cn.sd.mybatisdemo.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
	/**
	 * 通过ID获取一条用户信息
	 * @param
	 * @return
	 */
	public List<User> getUsersById(@Param("start_id") Integer start_id, @Param("end_id") Integer end_id);
	
	public User getOneUserById(Integer id);
	
	public void insetUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(@Param("id") int id);
	
	
}
