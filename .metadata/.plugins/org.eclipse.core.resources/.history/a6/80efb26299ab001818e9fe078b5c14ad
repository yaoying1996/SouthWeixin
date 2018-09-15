package com.south.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.south.entity.Daily;
import com.south.util.DBUtil;

public class CommonDaoImpl implements CommonDao{
	
	@Override
	public String query_contacts_company(String openid,String company_name) {
		Connection conn=null;
		PreparedStatement psmt=null;
		StringBuilder sb=new StringBuilder();
		ResultSet rs=null;
		sb.append("select distinct contacts_name from contacts LEFT JOIN company_user ON contacts.company_name=company_user.company_name ");
		sb.append(" where contacts.deleted=0 and company_user.deleted=0 ");
		sb.append("and contacts.contacts_id=company_user.contacts_id ");
		sb.append("and contacts.company_name=? and open_id=?");
		StringBuilder result=new StringBuilder("");
		try {
			conn=DBUtil.getConnection();
			psmt=conn.prepareStatement(sb.toString());
			psmt.setString(1, company_name);
			psmt.setString(2, openid);
			rs=psmt.executeQuery();
			while(rs.next()) {
				result.append(rs.getString(1));
				result.append(",");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(conn);
		}
		return result.toString();
	}
	
	@Override
	public boolean save_add_contacts(String contacts_name,String company_name,String department,String post,String tel){
		
		Connection conn=null;
		PreparedStatement pstm=null;
		String sql="insert into contacts(contacts_name,company_name,department,post,tel) values(?,?,?,?,?)";
		try {
			conn=DBUtil.getConnection();
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, contacts_name);
			pstm.setString(2, company_name);
			pstm.setString(3, department);
			pstm.setString(4, post);
			pstm.setString(5, tel);
			pstm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			DBUtil.closeConnection(conn);
		}
		return true;
	}
	
	
	/* (non-Javadoc)
	 * @see com.south.dao.CommonDao#query_contactsid(java.lang.String, java.lang.String)
	 */
	@Override
	public int query_contactsid(String name,String tel) {
		int countacts_id=0;
		Connection conn =null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select contacts_id from contacts where contacts_name=? and tel=?";
		try {
			conn=DBUtil.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, tel);
			rs = pst.executeQuery();
			while(rs.next()) {
				countacts_id=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库操作异常：" + e.getMessage());  
		}finally {
			DBUtil.closeConnection(conn);
		}
		return countacts_id;
	}
	public boolean save_contacts_user(String company_name,int contacts_id,String open_id,String user_name) {
		Connection conn =null;
		PreparedStatement pst=null;
		//String sql="insert into user(account,password,open_id,name,nick_name,sex,tel) values(?,?,?,?,?,?,?)";
		String sql="insert into company_user(company_name,contacts_id,open_id,user_name) values(?,?,?,?)";
		try {
			conn=DBUtil.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setString(1, company_name);
			pst.setInt(2, contacts_id);
			pst.setString(3, open_id);
			pst.setString(4, user_name); 
			pst.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库操作异常：" + e.getMessage());  
			return false;
		}finally {
			DBUtil.closeConnection(conn);
		}
		return true;
	}

	public boolean isExist_company(String company_name) {
		//boolean flag=false;
		Connection conn =null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select company_name from contacts where company_name=? and deleted=0";
		try {
			conn=DBUtil.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setString(1, company_name);
			rs = pst.executeQuery();
			while(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库操作异常：" + e.getMessage());  
		}finally {
			DBUtil.closeConnection(conn);
		}
		return false;
	}
	
	
	/**
	 * 返回所有的客户公司
	 * @param company
	 * @return
	 */
	@Override
	public List<String> getCompanyNames(String sql){
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		//之前写autocomplete写的
		//String sql="select company_name from contacts where deleted=0 and company_name like '%"+company+"%'";
	
		List<String> all_company_name=new ArrayList<String>();
		try { 
			conn=DBUtil.getConnection();
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
			while(rs.next()) {
				all_company_name.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(conn);
		}
		return all_company_name;
	}
	/**
	 * 返回所有的业务员姓名
	 * @param company
	 * @return
	 */
	@Override
	public List<String> getAllSale(){
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		String sql="select distinct name from user where deleted=0 and role_id=1 ";
		List<String> all_sale_name=new ArrayList<String>();
		try {
			conn=DBUtil.getConnection();
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
			while(rs.next()) {
				all_sale_name.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(conn);
		}
		return all_sale_name;
	}
	
	
}
