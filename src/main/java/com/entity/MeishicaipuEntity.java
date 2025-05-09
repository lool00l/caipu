package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 美食菜谱
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-01-19 19:30:50
 */
@TableName("meishicaipu")
public class MeishicaipuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public MeishicaipuEntity() {
		
	}
	
	public MeishicaipuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
    private Long id;
	/**
	 * 菜品名称
	 */
					
	private String caipinmingcheng;
	
	/**
	 * 食谱分类
	 */
					
	private String shipufenlei;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 参考价格
	 */
					
	private Double cankaojiage;
	
	/**
	 * 菜品材料
	 */
					
	private String caipincailiao;
	
	/**
	 * 菜品做法
	 */
					
	private String caipinzuofa;
	
	/**
	 * 制作市场
	 */
					
	private String zhizuoshichang;
	
	/**
	 * 制作视频
	 */
					
	private String zhizuoshipin;
	
	/**
	 * 发布时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date fabushijian;
	
	/**
	 * 菜品简介
	 */
					
	private String caipinjianjie;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 审核回复
	 */
					
	private String shhf;
	
	/**
	 * 赞
	 */
					
	private Integer thumbsupnum;
	
	/**
	 * 踩
	 */
					
	private Integer crazilynum;
	
	/**
	 * 最近点击时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date clicktime;
	
	/**
	 * 点击次数
	 */
					
	private Integer clicknum;
	
	/**
	 * 评论数
	 */
					
	private Integer discussnum;
	
	/**
	 * 用户id
	 */
					
	private Long userid;
	
	/**
	 * 收藏数
	 */
					
	private Integer storeupnum;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：菜品名称
	 */
	public void setCaipinmingcheng(String caipinmingcheng) {
		this.caipinmingcheng = caipinmingcheng;
	}
	/**
	 * 获取：菜品名称
	 */
	public String getCaipinmingcheng() {
		return caipinmingcheng;
	}
	/**
	 * 设置：食谱分类
	 */
	public void setShipufenlei(String shipufenlei) {
		this.shipufenlei = shipufenlei;
	}
	/**
	 * 获取：食谱分类
	 */
	public String getShipufenlei() {
		return shipufenlei;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：参考价格
	 */
	public void setCankaojiage(Double cankaojiage) {
		this.cankaojiage = cankaojiage;
	}
	/**
	 * 获取：参考价格
	 */
	public Double getCankaojiage() {
		return cankaojiage;
	}
	/**
	 * 设置：菜品材料
	 */
	public void setCaipincailiao(String caipincailiao) {
		this.caipincailiao = caipincailiao;
	}
	/**
	 * 获取：菜品材料
	 */
	public String getCaipincailiao() {
		return caipincailiao;
	}
	/**
	 * 设置：菜品做法
	 */
	public void setCaipinzuofa(String caipinzuofa) {
		this.caipinzuofa = caipinzuofa;
	}
	/**
	 * 获取：菜品做法
	 */
	public String getCaipinzuofa() {
		return caipinzuofa;
	}
	/**
	 * 设置：制作市场
	 */
	public void setZhizuoshichang(String zhizuoshichang) {
		this.zhizuoshichang = zhizuoshichang;
	}
	/**
	 * 获取：制作市场
	 */
	public String getZhizuoshichang() {
		return zhizuoshichang;
	}
	/**
	 * 设置：制作视频
	 */
	public void setZhizuoshipin(String zhizuoshipin) {
		this.zhizuoshipin = zhizuoshipin;
	}
	/**
	 * 获取：制作视频
	 */
	public String getZhizuoshipin() {
		return zhizuoshipin;
	}
	/**
	 * 设置：发布时间
	 */
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
	}
	/**
	 * 设置：菜品简介
	 */
	public void setCaipinjianjie(String caipinjianjie) {
		this.caipinjianjie = caipinjianjie;
	}
	/**
	 * 获取：菜品简介
	 */
	public String getCaipinjianjie() {
		return caipinjianjie;
	}
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：审核回复
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
	/**
	 * 设置：赞
	 */
	public void setThumbsupnum(Integer thumbsupnum) {
		this.thumbsupnum = thumbsupnum;
	}
	/**
	 * 获取：赞
	 */
	public Integer getThumbsupnum() {
		return thumbsupnum;
	}
	/**
	 * 设置：踩
	 */
	public void setCrazilynum(Integer crazilynum) {
		this.crazilynum = crazilynum;
	}
	/**
	 * 获取：踩
	 */
	public Integer getCrazilynum() {
		return crazilynum;
	}
	/**
	 * 设置：最近点击时间
	 */
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
	/**
	 * 设置：点击次数
	 */
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
	/**
	 * 设置：评论数
	 */
	public void setDiscussnum(Integer discussnum) {
		this.discussnum = discussnum;
	}
	/**
	 * 获取：评论数
	 */
	public Integer getDiscussnum() {
		return discussnum;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserid() {
		return userid;
	}
	/**
	 * 设置：收藏数
	 */
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}

}
