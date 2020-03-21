package com.sd.service.impl;

import com.sd.pojo.Project;
import com.sd.mapper.ProjectMapper;
import com.sd.service.ProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenj
 * @since 2020-03-21
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {

}
