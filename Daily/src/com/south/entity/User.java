package com.south.entity;

/**
 * @author yao 用户信息表
 */
public class User {
	
	/*//登录账号
	private String account;
	//登录密码
	private String password;*/
	// 用户的标识
	private String openId;
	// 真实姓名
	private String name;
	// 电话
    private String tel;
    //角色
    private Role role;
	
	//部门
    private String department;
    //邮箱
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
