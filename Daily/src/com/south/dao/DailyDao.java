package com.south.dao;

import java.util.List;
import java.util.Map;

import com.south.entity.Daily;
import com.south.entity.User;

public interface DailyDao {
	
	//�洢��־
	boolean saveDaily(String create_time,String company,String contacts_name,User user,
			   String stage,String budget,String intention,String discount,String progress,String point,String advice);

	//ҵ��Ա�����ҵ��ձ�
	List<Daily> queryDaily_time(String start, String end, String openid);
	
	//�ܾ�����д���
	boolean updateDaily(String advice, String create_time, String userOpenid);
	//�ܾ����ѯ����
	List<Daily> queryDailyManager(Map<String, String> param);
	//����Ա��ѯ����
	List<Daily> queryReportAdmin(Map<String, String> param);
}
