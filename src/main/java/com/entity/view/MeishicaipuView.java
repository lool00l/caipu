package com.entity.view;

import com.entity.MeishicaipuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 美食菜谱
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-01-19 19:30:50
 */
@TableName("meishicaipu")
public class MeishicaipuView  extends MeishicaipuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public MeishicaipuView(){
	}
 
 	public MeishicaipuView(MeishicaipuEntity meishicaipuEntity){
 	try {
			BeanUtils.copyProperties(this, meishicaipuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
