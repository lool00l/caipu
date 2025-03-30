package com.dao;

import com.entity.MeishicaipuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.MeishicaipuVO;
import com.entity.view.MeishicaipuView;


/**
 * 美食菜谱
 * 
 * 该接口用于操作美食菜谱相关的数据。
 * 继承自 BaseMapper<MeishicaipuEntity>，
 * 提供基本的数据库操作。
 * 定义的查询方法用于根据条件查询美食菜谱信息，
 * 返回不同视图对象的列表或单个对象。
 */
public interface MeishicaipuDao extends BaseMapper<MeishicaipuEntity> {
	
	List<MeishicaipuVO> selectListVO(@Param("ew") Wrapper<MeishicaipuEntity> wrapper);
	
	MeishicaipuVO selectVO(@Param("ew") Wrapper<MeishicaipuEntity> wrapper);
	
	List<MeishicaipuView> selectListView(@Param("ew") Wrapper<MeishicaipuEntity> wrapper);

	List<MeishicaipuView> selectListView(Pagination page,@Param("ew") Wrapper<MeishicaipuEntity> wrapper);

	
	MeishicaipuView selectView(@Param("ew") Wrapper<MeishicaipuEntity> wrapper);
	

}
