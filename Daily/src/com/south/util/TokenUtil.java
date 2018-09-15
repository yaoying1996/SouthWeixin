package com.south.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.south.po.AccessToken;

/**
 * 
 * @author yao
 *
 */
public class TokenUtil {
	
	/**从数据库里面取出token
	 * @return
	 */
	public static Map<String, Object> getToken(){
		Connection con=null;
		PreparedStatement stmt =null;
		ResultSet rs=null;
		String sql="select * from t_token order by createTime desc limit 0,1";
		String access_token="";
		Map<String,Object> map=new HashMap<String,Object>();
		Integer expires_in=0;
	
		
		try {
			con=DBUtil.getConnection();
			stmt=con.prepareStatement(sql);
			rs=stmt.executeQuery();
			if(rs.next()) {
				access_token=rs.getString("access_token");
				expires_in=rs.getInt("expires_in");
				map.put("access_token", access_token);
				map.put("expires_in", expires_in);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(con);
		}
		return map;
	}
	
	/**
	 * 保存access_token到数据库
	 * @param token
	 */
	public static void saveToken(AccessToken token) {
		Connection conn =null;
		PreparedStatement pst=null;
		String sql="insert into t_token(access_token,expires_in,createTime) values(?,?,?)";
		try {
			conn=DBUtil.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setString(1, token.getToken());
			pst.setInt(2, token.getExpiresIn());
			long now = new Date().getTime();  
            pst.setTimestamp(3, new java.sql.Timestamp(now));  
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库操作异常：" + e.getMessage());  
		}finally {
			DBUtil.closeConnection(conn);
		}
		
	}
	
	
}
