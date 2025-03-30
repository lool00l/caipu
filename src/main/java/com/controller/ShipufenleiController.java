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

import com.entity.ShipufenleiEntity;
import com.entity.view.ShipufenleiView;

import com.service.ShipufenleiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 食谱分类
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-19 19:30:50
 */
@RestController
@RequestMapping("/shipufenlei")
public class ShipufenleiController {
    @Autowired
    private ShipufenleiService shipufenleiService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShipufenleiEntity shipufenlei,
		HttpServletRequest request){
        EntityWrapper<ShipufenleiEntity> ew = new EntityWrapper<ShipufenleiEntity>();

		PageUtils page = shipufenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shipufenlei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShipufenleiEntity shipufenlei, 
		HttpServletRequest request){
        EntityWrapper<ShipufenleiEntity> ew = new EntityWrapper<ShipufenleiEntity>();

		PageUtils page = shipufenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shipufenlei), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShipufenleiEntity shipufenlei){
       	EntityWrapper<ShipufenleiEntity> ew = new EntityWrapper<ShipufenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shipufenlei, "shipufenlei")); 
        return R.ok().put("data", shipufenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShipufenleiEntity shipufenlei){
        EntityWrapper< ShipufenleiEntity> ew = new EntityWrapper< ShipufenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shipufenlei, "shipufenlei")); 
		ShipufenleiView shipufenleiView =  shipufenleiService.selectView(ew);
		return R.ok("查询食谱分类成功").put("data", shipufenleiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShipufenleiEntity shipufenlei = shipufenleiService.selectById(id);
        return R.ok().put("data", shipufenlei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShipufenleiEntity shipufenlei = shipufenleiService.selectById(id);
        return R.ok().put("data", shipufenlei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShipufenleiEntity shipufenlei, HttpServletRequest request){
        if(shipufenleiService.selectCount(new EntityWrapper<ShipufenleiEntity>().eq("shipufenlei", shipufenlei.getShipufenlei()))>0) {
            return R.error("食谱分类已存在");
        }
    	//ValidatorUtils.validateEntity(shipufenlei);
        shipufenleiService.insert(shipufenlei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShipufenleiEntity shipufenlei, HttpServletRequest request){
        if(shipufenleiService.selectCount(new EntityWrapper<ShipufenleiEntity>().eq("shipufenlei", shipufenlei.getShipufenlei()))>0) {
            return R.error("食谱分类已存在");
        }
    	//ValidatorUtils.validateEntity(shipufenlei);
        shipufenleiService.insert(shipufenlei);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShipufenleiEntity shipufenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shipufenlei);
        if(shipufenleiService.selectCount(new EntityWrapper<ShipufenleiEntity>().ne("id", shipufenlei.getId()).eq("shipufenlei", shipufenlei.getShipufenlei()))>0) {
            return R.error("食谱分类已存在");
        }
        shipufenleiService.updateById(shipufenlei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shipufenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
