package cn.sd.mybatisdemo.mapper;

import cn.sd.mybatisdemo.model.User;

public interface UserMapper {
	/**
	 * 通过ID获取一条用户信息
	 * @param id
	 * @return
	 */
	public User getOneUserById(Integer id);
}
