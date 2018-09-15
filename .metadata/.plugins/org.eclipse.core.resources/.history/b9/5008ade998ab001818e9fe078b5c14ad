package com.south.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.south.entity.Daily;
import com.south.entity.User;
import com.south.util.CommonUtil;
import com.south.util.DBUtil;

public class DailyDaoImpl implements DailyDao{
	
	/* 
	 * 存储报表
	 * @see com.south.dao.DailyDao#saveDaily(java.lang.String, java.lang.String, java.lang.String, com.south.entity.User, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public  boolean  saveDaily(String create_time,String company_name,String contacts_name,User user,
			   String stage,String budget,String intention,String discount,String progress,String point,String advice) {
		
		boolean flag=true;
		UserDao userDao=new UserDaoImpl();
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String sql="insert into my_daily(create_time,company_name,contacts_name,user_id,"
				+ "stage,budget,intention,discount,progress,point,advice) values(?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			conn=DBUtil.getConnection();
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, create_time);
			pstm.setString(2, company_name);
			pstm.setString(3, contacts_name);
			pstm.setInt(4, userDao.get_userId(user.getOpenId()));
			pstm.setString(5,stage);
			pstm.setString(6, budget);
			pstm.setString(7, intention);
			pstm.setString(8, discount);
			pstm.setString(9, progress);
			pstm.setString(10, point);
			pstm.setString(11, advice);
			pstm.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag=false;
			System.out.println("数据库操作异常：" + e.getMessage());  
		}finally {
			DBUtil.closeConnection(conn);
		}
		return flag;
	}
	
	
	/**
	 * 根据时间查询我的报表
	 * @param start
	 * @param end
	 * @param openid
	 * @return
	 */
	@Override
	public List<Daily> queryDaily_time(String start,String end,String openid) {

		List<Daily> query_Dailys=new ArrayList<>();
		
		UserDao userDao=new UserDaoImpl();
		
		Connection conn =null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		StringBuilder sb=new StringBuilder("select * from user LEFT JOIN my_daily on user.user_id=my_daily.user_id  ");
		sb.append("where open_id=?  and create_time >=? and create_time <=?  ");
		sb.append("and user.deleted=0 AND my_daily.deleted=0 order by create_time");
		String sql=sb.toString();
		try {
			conn=DBUtil.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setString(1, openid);
			pst.setString(2, start);
			pst.setString(3, end);
			rs = pst.executeQuery();
			while(rs.next()) {
				User user=userDao.query_allInfo_User(openid);
				Daily daily=CommonUtil.setDaily(rs.getString("create_time"), rs.getString("company_name"), rs.getString("contacts_name"),
						user, rs.getString("stage"), rs.getString("budget"), rs.getString("intention"),rs.getString("discount") , 
						rs.getString("progress"), rs.getString("point"), rs.getString("advice"));
				query_Dailys.add(daily);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库操作异常：" + e.getMessage());  
		}finally {
			DBUtil.closeConnection(conn);
		}
		return query_Dailys;
		
	}
	
	public String getParam(Map<String, String> param) {
		StringBuilder sb=new StringBuilder(" where ");
		for(Map.Entry<String, String> entry: param.entrySet()) {
			if(entry.getKey().equals("start")) {
				sb.append("my_daily.create_time>='"+entry.getValue()+"' and ");
			}else if(entry.getKey().equals("end")) {
				sb.append("my_daily.create_time<='"+entry.getValue()+"' and ");
			}else if(entry.getKey().equals("user.user_id")) {
				sb.append(entry.getKey()+" = "+entry.getValue()+" and ");
			}else if(entry.getKey().equals("advice")) {
				if(entry.getValue().equals(1+"")) {
					sb.append(" advice != '' and ");
				}else if(entry.getValue().equals(0+"")){
					sb.append(" advice ='' and ");
				}
				
			}else if(entry.getKey().equals("weekend")) {
				sb.append(entry.getValue()+ " and ");
			}else
			 sb.append(entry.getKey()+" = '"+entry.getValue()+"' and ");
		}
		return sb.toString();
	}
	/**
	 * 总经理根据时间查询所有报表
	 * @param start
	 * @param end
	 * @return
	 */
	@Override
	public List<Daily> queryDailyManager(Map<String, String> param) {
		
		List<Daily> query_Dailys=new ArrayList<>();
		
		String whereParam=getParam(param);
		
		
		UserDao userDao=new UserDaoImpl();
		
		Connection conn =null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		StringBuilder sb=new StringBuilder("select * from user LEFT JOIN my_daily on user.user_id=my_daily.user_id  ");
		sb.append(whereParam);
		sb.append(" user.deleted=0 AND my_daily.deleted=0 order by create_time");
		
		String sql=sb.toString();
		System.out.println("查询条件:"+sql);
		
		try {
			conn=DBUtil.getConnection();
			pst=conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				String openid=rs.getString("open_id");
				User user=userDao.query_allInfo_User(openid);
				Daily daily=CommonUtil.setDaily(rs.getString("create_time"), rs.getString("company_name"), rs.getString("contacts_name"),
						user, rs.getString("stage"), rs.getString("budget"), rs.getString("intention"),rs.getString("discount") , 
						rs.getString("progress"), rs.getString("point"), rs.getString("advice"));
				query_Dailys.add(daily);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库操作异常：" + e.getMessage());  
		}finally {
			DBUtil.closeConnection(conn);
		}
		return query_Dailys;
	}
	
	
	/**
	 * 总经理填写意见
	 * @param advice
	 * @param create_time
	 * @param userOpenid
	 * @return
	 */
	@Override
	public boolean updateDaily(String advice,String create_time,String userOpenid) {
		
		UserDao userDao=new UserDaoImpl();
		int userid=userDao.get_userId(userOpenid);
		
		
		Connection conn=null;
		PreparedStatement pstm=null;

		String sql="update my_daily set advice=? where deleted=0 and create_time=? and user_id=?";
		
		try {
			conn=DBUtil.getConnection();
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, advice);
			pstm.setString(2, create_time);
			pstm.setInt(3, userid);
			pstm.executeUpdate();
			return true;
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
	 * 管理员查询报表
	 * @param param
	 * @return
	 */
	@Override
	public List<Daily> queryReportAdmin(Map<String,String> param){
		List<Daily> query_Dailys=new ArrayList<>();
		
		String whereParam=getParam(param);
		
		
		UserDao userDao=new UserDaoImpl();
		
		Connection conn =null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		StringBuilder sb=new StringBuilder("select * from my_daily LEFT JOIN user on user.user_id=my_daily.user_id,"); 
		sb.append("( select max(create_time) as create_time from my_daily group by user_id,company_name) b ");
		sb.append(whereParam);
		sb.append(" b.create_time = my_daily.create_time and user.deleted=0 and my_daily.deleted=0  order by b.create_time");
		
		String sql=sb.toString();
		System.out.println("查询条件:"+sql);
		
		try {
			conn=DBUtil.getConnection();
			pst=conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				String userid=rs.getString("user_id");
				User user=userDao.getUser(userid);
				Daily daily=CommonUtil.setDaily(rs.getString("create_time"), rs.getString("company_name"), rs.getString("contacts_name"),
						user, rs.getString("stage"), rs.getString("budget"), rs.getString("intention"),rs.getString("discount") , 
						rs.getString("progress"), rs.getString("point"), rs.getString("advice"));
				query_Dailys.add(daily);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库操作异常：" + e.getMessage());  
		}finally {
			DBUtil.closeConnection(conn);
		}
		return query_Dailys;
	}

	
		
}
