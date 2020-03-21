package com.sd.service.impl;

import com.sd.pojo.Api;
import com.sd.mapper.ApiMapper;
import com.sd.service.ApiService;
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
public class ApiServiceImpl extends ServiceImpl<ApiMapper, Api> implements ApiService {

}
