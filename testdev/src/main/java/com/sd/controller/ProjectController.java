package com.sd.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sd.common.Result;
import com.sd.service.ProjectService;
import com.sd.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chenj
 * @since 2020-03-21
 */
@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/toList")
	@ApiOperation(value="获取项目列表方法",httpMethod = "GET")
	public Result toList(Integer userId){
		Result result = null;
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.eq("create_user",userId);
		List list = projectService.list(queryWrapper);
		result = new Result("1",list,"项目列表");
		return result;
	}

}
