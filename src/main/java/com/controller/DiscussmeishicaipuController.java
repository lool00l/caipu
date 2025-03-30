package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscussmeishicaipuEntity;
import com.entity.view.DiscussmeishicaipuView;

import com.service.DiscussmeishicaipuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 美食菜谱评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-19 19:30:50
 */
@RestController
@RequestMapping("/discussmeishicaipu")
public class DiscussmeishicaipuController {
    @Autowired
    private DiscussmeishicaipuService discussmeishicaipuService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussmeishicaipuEntity discussmeishicaipu,
		HttpServletRequest request){
        EntityWrapper<DiscussmeishicaipuEntity> ew = new EntityWrapper<DiscussmeishicaipuEntity>();

		PageUtils page = discussmeishicaipuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussmeishicaipu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussmeishicaipuEntity discussmeishicaipu, 
		HttpServletRequest request){
        EntityWrapper<DiscussmeishicaipuEntity> ew = new EntityWrapper<DiscussmeishicaipuEntity>();

		PageUtils page = discussmeishicaipuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussmeishicaipu), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussmeishicaipuEntity discussmeishicaipu){
       	EntityWrapper<DiscussmeishicaipuEntity> ew = new EntityWrapper<DiscussmeishicaipuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussmeishicaipu, "discussmeishicaipu")); 
        return R.ok().put("data", discussmeishicaipuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussmeishicaipuEntity discussmeishicaipu){
        EntityWrapper< DiscussmeishicaipuEntity> ew = new EntityWrapper< DiscussmeishicaipuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussmeishicaipu, "discussmeishicaipu")); 
		DiscussmeishicaipuView discussmeishicaipuView =  discussmeishicaipuService.selectView(ew);
		return R.ok("查询美食菜谱评论表成功").put("data", discussmeishicaipuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussmeishicaipuEntity discussmeishicaipu = discussmeishicaipuService.selectById(id);
        return R.ok().put("data", discussmeishicaipu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussmeishicaipuEntity discussmeishicaipu = discussmeishicaipuService.selectById(id);
        return R.ok().put("data", discussmeishicaipu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussmeishicaipuEntity discussmeishicaipu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussmeishicaipu);
        discussmeishicaipuService.insert(discussmeishicaipu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussmeishicaipuEntity discussmeishicaipu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussmeishicaipu);
        discussmeishicaipuService.insert(discussmeishicaipu);
        return R.ok();
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscussmeishicaipuEntity discussmeishicaipu = discussmeishicaipuService.selectOne(new EntityWrapper<DiscussmeishicaipuEntity>().eq("", username));
        return R.ok().put("data", discussmeishicaipu);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussmeishicaipuEntity discussmeishicaipu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussmeishicaipu);
        discussmeishicaipuService.updateById(discussmeishicaipu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussmeishicaipuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussmeishicaipuEntity discussmeishicaipu, HttpServletRequest request,String pre){
        EntityWrapper<DiscussmeishicaipuEntity> ew = new EntityWrapper<DiscussmeishicaipuEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = discussmeishicaipuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussmeishicaipu), params), params));
        return R.ok().put("data", page);
    }










}
