package com.south.dao;

import java.util.List;

public interface CommonDao {
	
	//根据客公司和业务员查询联系人
	String query_contacts_company(String openid,String company_name);
	
	//添加联系人
	boolean save_add_contacts(String contacts_name,String company_name,String department,String post,String tel);
	
	//根据联系人姓名和电话查询联系人id
	int query_contactsid(String name,String tel);
	
	//联系人、客户公司、业务员一一对应插入数据库中
	boolean save_contacts_user(String company_name,int contacts_id,String open_id,String user_name);
	
	//判断公司是否存在
	boolean isExist_company(String company_name);
	
	//查询所有公司
	//List<String> getCompanyNames(String company);
	List<String> getCompanyNames(String sql);
	
	//查询所有业务员的姓名
	List<String> getAllSale();
}
