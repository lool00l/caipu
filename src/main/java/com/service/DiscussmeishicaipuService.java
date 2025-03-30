package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussmeishicaipuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussmeishicaipuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussmeishicaipuView;


/**
 * 美食菜谱评论表
 *
 * @author 
 * @email 
 * @date 2024-01-19 19:30:50
 */
public interface DiscussmeishicaipuService extends IService<DiscussmeishicaipuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussmeishicaipuVO> selectListVO(Wrapper<DiscussmeishicaipuEntity> wrapper);
   	
   	DiscussmeishicaipuVO selectVO(@Param("ew") Wrapper<DiscussmeishicaipuEntity> wrapper);
   	
   	List<DiscussmeishicaipuView> selectListView(Wrapper<DiscussmeishicaipuEntity> wrapper);
   	
   	DiscussmeishicaipuView selectView(@Param("ew") Wrapper<DiscussmeishicaipuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussmeishicaipuEntity> wrapper);

   	

}

