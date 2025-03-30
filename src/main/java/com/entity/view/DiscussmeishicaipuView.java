package com.entity.view;

import com.entity.DiscussmeishicaipuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 美食菜谱评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-01-19 19:30:50
 */
@TableName("discussmeishicaipu")
public class DiscussmeishicaipuView  extends DiscussmeishicaipuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussmeishicaipuView(){
	}
 
 	public DiscussmeishicaipuView(DiscussmeishicaipuEntity discussmeishicaipuEntity){
 	try {
			BeanUtils.copyProperties(this, discussmeishicaipuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
