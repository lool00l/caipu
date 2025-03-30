
package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.TokenEntity;

/**
 * token
 *
 * 该接口用于操作 token 相关的数据。
 * 继承自 BaseMapper<TokenEntity>，
 * 具备基本的数据库操作能力。
 * 定义的查询方法用于根据条件查询 token 信息，
 * 返回 TokenEntity 对象的列表。
 */
public interface TokenDao extends BaseMapper<TokenEntity> {
	
	List<TokenEntity> selectListView(@Param("ew") Wrapper<TokenEntity> wrapper);

	List<TokenEntity> selectListView(Pagination page,@Param("ew") Wrapper<TokenEntity> wrapper);
	
}
