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


import com.dao.MeishicaipuDao;
import com.entity.MeishicaipuEntity;
import com.service.MeishicaipuService;
import com.entity.vo.MeishicaipuVO;
import com.entity.view.MeishicaipuView;

@Service("meishicaipuService")
public class MeishicaipuServiceImpl extends ServiceImpl<MeishicaipuDao, MeishicaipuEntity> implements MeishicaipuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MeishicaipuEntity> page = this.selectPage(
                new Query<MeishicaipuEntity>(params).getPage(),
                new EntityWrapper<MeishicaipuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MeishicaipuEntity> wrapper) {
		  Page<MeishicaipuView> page =new Query<MeishicaipuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<MeishicaipuVO> selectListVO(Wrapper<MeishicaipuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public MeishicaipuVO selectVO(Wrapper<MeishicaipuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<MeishicaipuView> selectListView(Wrapper<MeishicaipuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MeishicaipuView selectView(Wrapper<MeishicaipuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
