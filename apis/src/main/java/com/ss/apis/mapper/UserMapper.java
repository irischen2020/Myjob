package com.ss.apis.mapper;

import com.ss.apis.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

public interface UserMapper {
	//新增一条用户记录
	public void add(User user) throws Exception;
	//用户名查重
	public String find(User user) throws Exception;
}
