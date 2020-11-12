package com.cc.dao;

import com.cc.domain.User;

import java.util.List;

/**
 * USER的持久层接口
 */
public interface IUserDao {
	/**
	 * 查询所有用户
	 * @return
	 */
	List<User> findALL();
	
	/**
	 * 保存用户
	 * @param user
	 */
	public void saveUser(User user);
	
	/**
	 * 更新用户
	 * @param user
	 */
	public void updateUser(User user);
	
	/**
	 * 删除用户
	 * @param id
	 */
	public void deleteUser(int id);
}
