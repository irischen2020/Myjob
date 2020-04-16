package com.sd.mapper;

import com.sd.pojo.Api;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author chenj
 * @since 2020-03-21
 */
public interface ApiMapper extends BaseMapper<Api> {
	public List<Api> getApisByclassid(int api_classification_id);
}
