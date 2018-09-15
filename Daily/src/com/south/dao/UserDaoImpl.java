package com.south.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.south.entity.Role;
import com.south.entity.User;
import com.south.po.UserInfo;
import com.south.util.DBUtil;

public class UserDaoImpl implements UserDao{
	
	
	
	/* �����û�
	 * @see com.south.dao.UserDao#saveUser(com.south.po.UserInfo)
	 */
	public void saveUser(UserInfo userInfo) {
		
		User user=new User();
		user.setOpenId(userInfo.getOpenId());
		user.setName(userInfo.getName());
		user.setTel(userInfo.getTel());
		user.setRole(userInfo.getRole());
		user.setDepartment(userInfo.getDepartment());
		user.setEmail(userInfo.getEmail());
		Connection conn =null;
		PreparedStatement pst=null;
		//String sql="insert into user(account,password,open_id,name,nick_name,sex,tel) values(?,?,?,?,?,?,?)";
		String sql="insert into user(open_id,name,tel,role_id,department,email) values(?,?,?,?,?,?)";
		try {
			conn=DBUtil.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setString(1, user.getOpenId());
			pst.setString(2, user.getName());
			pst.setString(3, user.getTel()); 
			pst.setString(4, user.getRole().getRole_id()); 
			pst.setString(5, user.getDepartment());
			pst.setString(6, user.getEmail());
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���ݿ�����쳣��" + e.getMessage());  
		}finally {
			DBUtil.closeConnection(conn);
		}
	}
	
	/**ȡ����עʱɾ�����û�
	 * @param userInfo
	 */
	@Override
	public void deleteUser(String  openId) {
		Connection conn=null;
		PreparedStatement pst=null;
		String sql="update user set deleted=1 where open_id='"+openId+"' and deleted=0";
		try {
			conn=DBUtil.getConnection();
			pst=conn.prepareStatement(sql);
			int i=pst.executeUpdate();
			System.out.println("��Ӱ�������Ϊ��"+i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(conn);
		}
		
	}
	
	/**
	 * ��ѯ�û��Ƿ����
	 * @param openid
	 * @return
	 */
	public String queryUser(String openid) {
		Connection conn =null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		String isExist="";
		String sql="select open_id from user where open_id=? and deleted=0";
		try {
			conn=DBUtil.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setString(1, openid);
			rs = pst.executeQuery();
			while(rs.next()) {
				//System.out.println(rs.getString("open_id")+"-------����");
				isExist=rs.getString("open_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���ݿ�����쳣��" + e.getMessage());  
		}finally {
			DBUtil.closeConnection(conn);
		}
		return isExist;
	}
	
	/**
	 * ��ѯ�û�,������
	 * @param roleid
	 * @return
	 */
	@Override
	public User query_allInfo_User(String openid) {
		User user=new User();
		UserDao userDao=new UserDaoImpl();
		Connection conn=null;
		ResultSet rs=null;
		Statement stmt=null;
		String sql="select *  from user where deleted=0 and open_id='"+openid+"'";
		try {
			conn=DBUtil.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				user.setOpenId(rs.getString(2));
				user.setName(rs.getString(3));
				Role role=new Role();
				String role_id=rs.getInt(4)+"";
				role.setRole_id(role_id);
				String role_name=userDao.queryRoleName(role_id);
				role.setRole_name(role_name);
				user.setRole(role);
				user.setTel(rs.getString(5));
				user.setDepartment(rs.getString(7));
				user.setEmail(rs.getString(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	/**
	 * ����userid����user
	 * @param userid
	 * @return
	 */
	@Override
	public User getUser(String userid) {
		User user=new User();
		UserDao userDao=new UserDaoImpl();
		Connection conn=null;
		ResultSet rs=null;
		Statement stmt=null;
		String sql="select *  from user where deleted=0 and user_id="+userid;
		try {
			conn=DBUtil.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				user.setOpenId(rs.getString(2));
				user.setName(rs.getString(3));
				Role role=new Role();
				String role_id=rs.getInt(4)+"";
				role.setRole_id(role_id);
				String role_name=userDao.queryRoleName(role_id);
				role.setRole_name(role_name);
				user.setRole(role);
				user.setTel(rs.getString(5));
				user.setDepartment(rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	
	/* 
	 * ����ǳ�
	 * 
	 */
	@Override
	public String getNickName(String openid) {
		String nickName="";
		Connection conn =null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select nick_name from user where open_id=?";
		try {
			conn=DBUtil.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setString(1, openid);
			rs = pst.executeQuery();
			while(rs.next()) {
				nickName=rs.getString("nick_name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���ݿ�����쳣��" + e.getMessage());  
		}finally {
			DBUtil.closeConnection(conn);
		}
		return nickName;
	}


	/* 
	 * ���userId
	 * 
	 */
	@Override
	public int userId(String openid) {
		int userid=0;
		Connection conn =null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select user_id from user where open_id=?";
		try {
			conn=DBUtil.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setString(1, openid);
			rs = pst.executeQuery();
			while(rs.next()) {
				userid=rs.getInt("user_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���ݿ�����쳣��" + e.getMessage());  
		}finally {
			DBUtil.closeConnection(conn);
		}
		return userid;
	}

	/*
	 * ����role_id��ѯrole_name
	 *
	 */
	@Override
	public String queryRoleName(String role_id) {
		String roleName="";
		Connection conn =null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select role_name from role where role_id=?";
		try {
			conn=DBUtil.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setString(1, role_id);
			rs = pst.executeQuery();
			while(rs.next()) {
				roleName=rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���ݿ�����쳣��" + e.getMessage());  
		}finally {
			DBUtil.closeConnection(conn);
		}
		return roleName;
		
	}

	/* 
	 * ��ȡuserId
	 */
	@Override
	public int get_userId(String openid) {
		int userid=0;
		Connection conn =null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select user_id from user where open_id=? and deleted=0";
		try {
			conn=DBUtil.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setString(1, openid);
			rs = pst.executeQuery();
			while(rs.next()) {
				userid=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���ݿ�����쳣��" + e.getMessage());  
		}finally {
			DBUtil.closeConnection(conn);
		}
		return userid;
	}
	
	/*
		��ȡ�û���Ȩ��
	 * @see com.south.dao.UserDao#get_roleId(java.lang.String)
	 */
	@Override
	public int get_roleId(String openid) {
		int roleid=0;
		Connection conn =null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select role_id from user where open_id=? and deleted=0";
		try {
			conn=DBUtil.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setString(1, openid);
			rs = pst.executeQuery();
			while(rs.next()) {
				roleid=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���ݿ�����쳣��" + e.getMessage());  
		}finally {
			DBUtil.closeConnection(conn);
		}
		return roleid;
	}
	
	/**
	 * ������Ϣ�޸ģ������������绰������
	 * @param openid
	 * @param department
	 * @param name
	 * @param tel
	 */
	@Override
	public boolean updateUserInfo(String openid,String department,String name,String tel,String email) {
		Connection conn=null;
		PreparedStatement pstm=null;
		String sql="update user set department=?,name=?,tel=?,email=? where open_id=? and deleted=0";
		
		try {
			conn=DBUtil.getConnection();
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, department);
			pstm.setString(2, name);
			pstm.setString(3, tel);
			pstm.setString(4, email);
			pstm.setString(5, openid);
			pstm.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(conn);
		}
		return false;
	}
	
	/* 
	 * ����ҵ��Ա������ѯid
	 * @see com.south.dao.UserDao#userId_Name(java.lang.String)
	 */
	@Override
	public int userId_Name(String name) {
		int userid=0;
		Connection conn =null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select user_id from user where name=?";
		try {
			conn=DBUtil.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setString(1, name);
			rs = pst.executeQuery();
			while(rs.next()) {
				userid=rs.getInt("user_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���ݿ�����쳣��" + e.getMessage());  
		}finally {
			DBUtil.closeConnection(conn);
		}
		return userid;
	}

	
}