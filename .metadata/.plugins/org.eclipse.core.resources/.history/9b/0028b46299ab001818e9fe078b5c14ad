package com.south.dao;

import com.south.entity.User;
import com.south.po.UserInfo;

public interface UserDao {
	
	//保存用户
	void saveUser(UserInfo userInfo);
	//用户取消关注时，删除
	void deleteUser(String openId);
	//查询用户是否存在
	String queryUser(String openid);
	//查询角色
	String queryRoleName(String role_id);
	//查询用户所有信息
	User query_allInfo_User(String openid);
	//查询用户昵称
	String getNickName(String openid);
	//获得user_id
	int get_userId(String openid);
	//获得用户权限
	int get_roleId(String openid);
	//个人信息更新
	boolean updateUserInfo(String openid, String department, String name, String tel,String email);
	//获得userid
	int userId(String openid);
	//获得userid根据业务员姓名
	int userId_Name(String name);
	//根据userid查找user
	User getUser(String userid);
	
}
