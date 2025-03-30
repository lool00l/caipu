package com.dao;

import com.entity.DiscussmeishicaipuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussmeishicaipuVO;
import com.entity.view.DiscussmeishicaipuView;


/**
 * 美食菜谱评论表
 * 
 *该接口用于操作美食菜谱评论表相关的数据。
 * 它继承自 BaseMapper<DiscussmeishicaipuEntity>，
 * 具备基本的 CRUD 操作能力。
 * 定义了多个查询方法，用于根据不同的条件查询评论信息，
 * 返回不同视图对象的列表或单个对象。
 */
public interface DiscussmeishicaipuDao extends BaseMapper<DiscussmeishicaipuEntity> {
	
	List<DiscussmeishicaipuVO> selectListVO(@Param("ew") Wrapper<DiscussmeishicaipuEntity> wrapper);
	
	DiscussmeishicaipuVO selectVO(@Param("ew") Wrapper<DiscussmeishicaipuEntity> wrapper);
	
	List<DiscussmeishicaipuView> selectListView(@Param("ew") Wrapper<DiscussmeishicaipuEntity> wrapper);

	List<DiscussmeishicaipuView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussmeishicaipuEntity> wrapper);

	
	DiscussmeishicaipuView selectView(@Param("ew") Wrapper<DiscussmeishicaipuEntity> wrapper);
	

}
