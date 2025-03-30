
package com.dao;

import java.util.List;
import java.util.Map;

/**
 * 通用接口
 *
 * 该接口是一个通用接口，提供了一系列通用的数据查询和操作方法。
 * 可以根据传入的参数进行不同的数据库操作，
 * 如获取选项、根据选项获取相关信息、统计提醒数量、进行分组统计等。
 */
public interface CommonDao{
	List<String> getOption(Map<String, Object> params);
	
	Map<String, Object> getFollowByOption(Map<String, Object> params);
	
	List<String> getFollowByOption2(Map<String, Object> params);
	
	void sh(Map<String, Object> params);
	
	int remindCount(Map<String, Object> params);
	
	Map<String, Object> selectCal(Map<String, Object> params);
	
	List<Map<String, Object>> selectGroup(Map<String, Object> params);
	
	List<Map<String, Object>> selectValue(Map<String, Object> params);

	List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params);
}
