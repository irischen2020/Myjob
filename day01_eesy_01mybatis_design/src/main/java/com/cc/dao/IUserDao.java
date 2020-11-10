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
	List<User> finaALL();
}
