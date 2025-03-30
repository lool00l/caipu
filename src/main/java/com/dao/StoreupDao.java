package com.dao;

import com.entity.StoreupEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.StoreupVO;
import com.entity.view.StoreupView;


/**
 * 收藏表
 * 
 * 该接口用于操作收藏表相关的数据。
 * 继承自 BaseMapper<StoreupEntity>，提供基本的数据库操作。
 * 定义的查询方法用于根据条件查询收藏信息，
 * 返回不同视图对象的列表或单个对象。
 */
public interface StoreupDao extends BaseMapper<StoreupEntity> {
	
	List<StoreupVO> selectListVO(@Param("ew") Wrapper<StoreupEntity> wrapper);
	
	StoreupVO selectVO(@Param("ew") Wrapper<StoreupEntity> wrapper);
	
	List<StoreupView> selectListView(@Param("ew") Wrapper<StoreupEntity> wrapper);

	List<StoreupView> selectListView(Pagination page,@Param("ew") Wrapper<StoreupEntity> wrapper);

	
	StoreupView selectView(@Param("ew") Wrapper<StoreupEntity> wrapper);
	

}
