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

import com.entity.MeishicaipuEntity;
import com.entity.view.MeishicaipuView;

import com.service.MeishicaipuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 美食菜谱
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-19 19:30:50
 */
@RestController
@RequestMapping("/meishicaipu")
public class MeishicaipuController {
    @Autowired
    private MeishicaipuService meishicaipuService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MeishicaipuEntity meishicaipu,
		HttpServletRequest request){
        if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
            meishicaipu.setUserid((Long)request.getSession().getAttribute("userId"));
        }
        EntityWrapper<MeishicaipuEntity> ew = new EntityWrapper<MeishicaipuEntity>();

		PageUtils page = meishicaipuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, meishicaipu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,MeishicaipuEntity meishicaipu, 
		HttpServletRequest request){
        EntityWrapper<MeishicaipuEntity> ew = new EntityWrapper<MeishicaipuEntity>();

		PageUtils page = meishicaipuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, meishicaipu), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MeishicaipuEntity meishicaipu){
       	EntityWrapper<MeishicaipuEntity> ew = new EntityWrapper<MeishicaipuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( meishicaipu, "meishicaipu")); 
        return R.ok().put("data", meishicaipuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MeishicaipuEntity meishicaipu){
        EntityWrapper< MeishicaipuEntity> ew = new EntityWrapper< MeishicaipuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( meishicaipu, "meishicaipu")); 
		MeishicaipuView meishicaipuView =  meishicaipuService.selectView(ew);
		return R.ok("查询美食菜谱成功").put("data", meishicaipuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MeishicaipuEntity meishicaipu = meishicaipuService.selectById(id);
		meishicaipu.setClicknum(meishicaipu.getClicknum()+1);
		meishicaipu.setClicktime(new Date());
		meishicaipuService.updateById(meishicaipu);
        meishicaipu = meishicaipuService.selectView(new EntityWrapper<MeishicaipuEntity>().eq("id", id));
        return R.ok().put("data", meishicaipu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MeishicaipuEntity meishicaipu = meishicaipuService.selectById(id);
		meishicaipu.setClicknum(meishicaipu.getClicknum()+1);
		meishicaipu.setClicktime(new Date());
		meishicaipuService.updateById(meishicaipu);
        meishicaipu = meishicaipuService.selectView(new EntityWrapper<MeishicaipuEntity>().eq("id", id));
        return R.ok().put("data", meishicaipu);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        MeishicaipuEntity meishicaipu = meishicaipuService.selectById(id);
        if(type.equals("1")) {
        	meishicaipu.setThumbsupnum(meishicaipu.getThumbsupnum()+1);
        } else {
        	meishicaipu.setCrazilynum(meishicaipu.getCrazilynum()+1);
        }
        meishicaipuService.updateById(meishicaipu);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MeishicaipuEntity meishicaipu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(meishicaipu);
    	meishicaipu.setUserid((Long)request.getSession().getAttribute("userId"));
        meishicaipuService.insert(meishicaipu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody MeishicaipuEntity meishicaipu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(meishicaipu);
        meishicaipuService.insert(meishicaipu);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody MeishicaipuEntity meishicaipu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(meishicaipu);
        meishicaipuService.updateById(meishicaipu);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<MeishicaipuEntity> list = new ArrayList<MeishicaipuEntity>();
        for(Long id : ids) {
            MeishicaipuEntity meishicaipu = meishicaipuService.selectById(id);
            meishicaipu.setSfsh(sfsh);
            meishicaipu.setShhf(shhf);
            list.add(meishicaipu);
        }
        meishicaipuService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        meishicaipuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序，按照点击数降序排列。
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,MeishicaipuEntity meishicaipu, HttpServletRequest request,String pre){
        EntityWrapper<MeishicaipuEntity> ew = new EntityWrapper<MeishicaipuEntity>();
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
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = meishicaipuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, meishicaipu), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（按收藏推荐），实现的是一种简单的基于物品的协同过滤思想，具体来说是根据用户的收藏记录，找出用户收藏的食谱分类，然后推荐同一分类下的其他美食菜谱。
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,MeishicaipuEntity meishicaipu, HttpServletRequest request){
        //从用户的会话中获取当前用户的 ID，用于后续查询该用户的收藏记录。
        String userId = request.getSession().getAttribute("userId").toString();
        //定义用于匹配的列名，这里是食谱分类的列名 shipufenlei，表示根据食谱分类来进行推荐。
        String inteltypeColumn = "shipufenlei";
        //使用 storeupService 查询用户的收藏记录，条件是 type 为 1，userid 为当前用户 ID，tablename 为 meishicaipu（美食菜谱表），并按照收藏时间降序排列。
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "meishicaipu").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        //limit：推荐结果的数量限制，如果参数中未指定，则默认为 10。
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        //meishicaipuList：用于存储推荐的美食菜谱列表。
        List<MeishicaipuEntity> meishicaipuList = new ArrayList<MeishicaipuEntity>();
        //去重，如果用户有收藏记录，则遍历收藏记录，根据每条记录中的食谱分类 inteltype，从美食菜谱表中查询同一分类下的所有美食菜谱，并添加到 meishicaipuList 中。
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                meishicaipuList.addAll(meishicaipuService.selectList(new EntityWrapper<MeishicaipuEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        //查询所有美食菜谱，并按照 id 降序排列，将结果存储在 pageList 中。
        EntityWrapper<MeishicaipuEntity> ew = new EntityWrapper<MeishicaipuEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = meishicaipuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, meishicaipu), params), params));
        List<MeishicaipuEntity> pageList = (List<MeishicaipuEntity>)page.getList();
        //去重并补齐推荐列表
        //如果 meishicaipuList 中的菜谱数量小于 limit，则从 pageList 中选取未在 meishicaipuList 中的菜谱添加到 meishicaipuList 中，直到达到 limit 或者 pageList 遍历完。
        //如果 meishicaipuList 中的菜谱数量大于 limit，则截取前 limit 个菜谱。
        if(meishicaipuList.size()<limit) {
            int toAddNum = (limit-meishicaipuList.size())<=pageList.size()?(limit-meishicaipuList.size()):pageList.size();
            for(MeishicaipuEntity o1 : pageList) {
                boolean addFlag = true;
                for(MeishicaipuEntity o2 : meishicaipuList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    meishicaipuList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(meishicaipuList.size()>limit) {
            meishicaipuList = meishicaipuList.subList(0, limit);
        }
        //返回推荐结果，将推荐的美食菜谱列表设置到 page 中，并返回给前端。
        page.setList(meishicaipuList);
        return R.ok().put("data", page);
    }

}
