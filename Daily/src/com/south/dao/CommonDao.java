package com.south.dao;

import java.util.List;

public interface CommonDao {
	
	//���ݿ͹�˾��ҵ��Ա��ѯ��ϵ��
	String query_contacts_company(String openid,String company_name);
	
	//������ϵ��
	boolean save_add_contacts(String contacts_name,String company_name,String department,String post,String tel);
	
	//������ϵ�������͵绰��ѯ��ϵ��id
	int query_contactsid(String name,String tel);
	
	//��ϵ�ˡ��ͻ���˾��ҵ��Աһһ��Ӧ�������ݿ���
	boolean save_contacts_user(String company_name,int contacts_id,String open_id,String user_name);
	
	//�жϹ�˾�Ƿ����
	boolean isExist_company(String company_name);
	
	//��ѯ���й�˾
	//List<String> getCompanyNames(String company);
	List<String> getCompanyNames(String sql);
	
	//��ѯ����ҵ��Ա������
	List<String> getAllSale();
}