package com.south.entity;

/**
 * @author yao �û���Ϣ��
 */
public class User {
	
	/*//��¼�˺�
	private String account;
	//��¼����
	private String password;*/
	// �û��ı�ʶ
	private String openId;
	// ��ʵ����
	private String name;
	// �绰
    private String tel;
    //��ɫ
    private Role role;
	
	//����
    private String department;
    //����
    private String email;
    
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
		
			
}
