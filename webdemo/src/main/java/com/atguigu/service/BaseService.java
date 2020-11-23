package com.atguigu.service;

import com.atguigu.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<T> {
	
	@Autowired
	private BaseDao<T> baseDao;
	
	public void save() {
		System.out.println("baseService正在调用DAO帮你保存…………");
		baseDao.save();
	}
}
