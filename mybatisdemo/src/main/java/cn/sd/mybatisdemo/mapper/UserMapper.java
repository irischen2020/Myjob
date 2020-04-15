package cn.sd.mybatisdemo.mapper;


import cn.sd.mybatisdemo.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	/**
	 * 通过ID获取一条用户信息
	 * @param id
	 * @return
	 */
	public User getOneUserById(Integer id);
	
	public void insetUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(@Param("id") int id);
	
	
}
