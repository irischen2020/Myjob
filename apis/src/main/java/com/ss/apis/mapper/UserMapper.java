package com.ss.apis.mapper;

import com.ss.apis.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

public interface UserMapper {
	public void add(User user) throws Exception;
}
