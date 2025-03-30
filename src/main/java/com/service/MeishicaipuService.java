package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MeishicaipuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.MeishicaipuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.MeishicaipuView;


/**
 * 美食菜谱
 *
 * @author 
 * @email 
 * @date 2024-01-19 19:30:50
 */
public interface MeishicaipuService extends IService<MeishicaipuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MeishicaipuVO> selectListVO(Wrapper<MeishicaipuEntity> wrapper);
   	
   	MeishicaipuVO selectVO(@Param("ew") Wrapper<MeishicaipuEntity> wrapper);
   	
   	List<MeishicaipuView> selectListView(Wrapper<MeishicaipuEntity> wrapper);
   	
   	MeishicaipuView selectView(@Param("ew") Wrapper<MeishicaipuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MeishicaipuEntity> wrapper);

   	

}

