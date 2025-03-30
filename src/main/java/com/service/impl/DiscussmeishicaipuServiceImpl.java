package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscussmeishicaipuDao;
import com.entity.DiscussmeishicaipuEntity;
import com.service.DiscussmeishicaipuService;
import com.entity.vo.DiscussmeishicaipuVO;
import com.entity.view.DiscussmeishicaipuView;

@Service("discussmeishicaipuService")
public class DiscussmeishicaipuServiceImpl extends ServiceImpl<DiscussmeishicaipuDao, DiscussmeishicaipuEntity> implements DiscussmeishicaipuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussmeishicaipuEntity> page = this.selectPage(
                new Query<DiscussmeishicaipuEntity>(params).getPage(),
                new EntityWrapper<DiscussmeishicaipuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussmeishicaipuEntity> wrapper) {
		  Page<DiscussmeishicaipuView> page =new Query<DiscussmeishicaipuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussmeishicaipuVO> selectListVO(Wrapper<DiscussmeishicaipuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussmeishicaipuVO selectVO(Wrapper<DiscussmeishicaipuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussmeishicaipuView> selectListView(Wrapper<DiscussmeishicaipuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussmeishicaipuView selectView(Wrapper<DiscussmeishicaipuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
