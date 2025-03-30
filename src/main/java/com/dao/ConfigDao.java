
package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.entity.ConfigEntity;

/**
 * 配置
 *
 * 该接口用于操作配置相关的数据。
 * 继承自 BaseMapper<ConfigEntity>，
 * 提供基本的数据库操作能力，可进行配置信息的基本 CRUD 操作。
 */
public interface ConfigDao extends BaseMapper<ConfigEntity> {
	
}
