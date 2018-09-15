package com.south.dao;

import java.util.List;
import java.util.Map;

import com.south.entity.Daily;
import com.south.entity.User;

public interface DailyDao {
	
	//存储日志
	boolean saveDaily(String create_time,String company,String contacts_name,User user,
			   String stage,String budget,String intention,String discount,String progress,String point,String advice);

	//业务员查找我的日报
	List<Daily> queryDaily_time(String start, String end, String openid);
	
	//总经理填写意见
	boolean updateDaily(String advice, String create_time, String userOpenid);
	//总经理查询报表
	List<Daily> queryDailyManager(Map<String, String> param);
	//管理员查询报表
	List<Daily> queryReportAdmin(Map<String, String> param);
}
