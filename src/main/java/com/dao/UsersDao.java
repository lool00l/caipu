
package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.UsersEntity;

/**
 * 用户
 *
 * 该接口用于操作系统用户相关的数据。
 * 继承自 BaseMapper<UsersEntity>，具备基本的数据库操作能力。
 * 定义的查询方法用于根据条件查询系统用户信息，
 * 返回 UsersEntity 对象的列表。
 */
public interface UsersDao extends BaseMapper<UsersEntity> {
	
	List<UsersEntity> selectListView(@Param("ew") Wrapper<UsersEntity> wrapper);

	List<UsersEntity> selectListView(Pagination page,@Param("ew") Wrapper<UsersEntity> wrapper);
	
}
