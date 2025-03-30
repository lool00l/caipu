package com.dao;

import com.entity.NewstypeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.NewstypeVO;
import com.entity.view.NewstypeView;


/**
 * 美食资讯分类
 * 
 * 该接口用于操作美食资讯分类相关的数据。
 * 继承自 BaseMapper<NewstypeEntity>，具备基本的数据库操作能力。
 * 定义的查询方法用于根据条件查询美食资讯分类信息，
 * 返回不同视图对象的列表或单个对象。
 */
public interface NewstypeDao extends BaseMapper<NewstypeEntity> {
	
	List<NewstypeVO> selectListVO(@Param("ew") Wrapper<NewstypeEntity> wrapper);
	
	NewstypeVO selectVO(@Param("ew") Wrapper<NewstypeEntity> wrapper);
	
	List<NewstypeView> selectListView(@Param("ew") Wrapper<NewstypeEntity> wrapper);

	List<NewstypeView> selectListView(Pagination page,@Param("ew") Wrapper<NewstypeEntity> wrapper);

	
	NewstypeView selectView(@Param("ew") Wrapper<NewstypeEntity> wrapper);
	

}
