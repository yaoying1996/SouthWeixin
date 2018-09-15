package com.south.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtil {
	private static BasicDataSource dataSource=null;
	
	public static void init() {
		Properties dbProps=new Properties();
		
		try {
			dbProps.load(DBUtil.class.getClassLoader().getResourceAsStream("com/south/config/db.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
            String driveClassName = dbProps.getProperty("jdbc.driverClassName");
            String url = dbProps.getProperty("jdbc.url");
            String username = dbProps.getProperty("jdbc.username");
            String password = dbProps.getProperty("jdbc.password");

            String initialSize = dbProps.getProperty("dataSource.initialSize");
            String minIdle = dbProps.getProperty("dataSource.minIdle");
            String maxIdle = dbProps.getProperty("dataSource.maxIdle");
            String maxWait = dbProps.getProperty("dataSource.maxWait");
            String maxActive = dbProps.getProperty("dataSource.maxActive");

            dataSource = new BasicDataSource();
            dataSource.setDriverClassName(driveClassName);
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);

            // ��ʼ��������
            if (initialSize != null)
                dataSource.setInitialSize(Integer.parseInt(initialSize));

            // ��С��������
            if (minIdle != null)
                dataSource.setMinIdle(Integer.parseInt(minIdle));

            // ����������
            if (maxIdle != null)
                dataSource.setMaxIdle(Integer.parseInt(maxIdle));

            // ��ʱ����ʱ��(�Ժ���Ϊ��λ)
            if (maxWait != null)
                dataSource.setMaxWait(Long.parseLong(maxWait));

            // ���������
            if (maxActive != null) {
                if (!maxActive.trim().equals("0"))
                    dataSource.setMaxActive(Integer.parseInt(maxActive));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("�������ӳ�ʧ��!��������!!!");
        }
	}
	
	
	/**
     * ���ݿ�����
     * 
     * @return
     * @throws SQLException
     */
	public static synchronized Connection getConnection() throws SQLException {
		if(dataSource==null) {
			init();
		}
		Connection conn =null;
		if(dataSource !=null) {
			conn=dataSource.getConnection();
		}
		return conn;
	}
	
	
	 /**
     * �ر����ݿ�
     * 
     * @param conn
     */
	public static void closeConnection(Connection conn) {
		if(conn!=null) {
			try {
				conn.close();
			}catch(SQLException e) {
				System.out.println("�ر���Դʧ��");
				e.printStackTrace();
			}
		}
		
	}


	
}