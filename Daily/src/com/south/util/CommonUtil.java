package com.south.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.south.entity.Daily;
import com.south.entity.User;

public class CommonUtil {
	
	/**
	 * 获取当前cookie 主要是用来获取openid
	 * @param request
	 * @param response
	 * @return
	 */
	public static String getCookie(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies=request.getCookies();
		String openid="";
		if(cookies!=null) {
			for(Cookie cookie:cookies) {
				if(cookie.getName().equals("openid")) {
					openid=cookie.getValue();
					break;
				}
			}
		}
		return openid;
	}
	/**
	 * 日期增加一天
	 * @param time
	 * @return
	 */
	public static String addOneDay(String time) {
		String addtime="";
		
		try {
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date timeNow=df.parse(time);
			Calendar begin=Calendar.getInstance();
			begin.setTime(timeNow);
			begin.add(Calendar.DAY_OF_MONTH, 1);
			addtime=df.format(begin.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return addtime;
	}
	
	/**
	 * 日期减少一天
	 * @param time
	 * @return
	 */
	public static  String reduceOneDay(String time) {
		String reducetime="";
		
		try {
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date timeNow=df.parse(time);
			Calendar begin=Calendar.getInstance();
			begin.setTime(timeNow);
			begin.add(Calendar.DAY_OF_MONTH, -1);
			reducetime=df.format(begin.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reducetime;
	}
	
	/**
	 * 时间转换成数据库能存储的格式
	 * @param time
	 * @return
	 */
	public static java.sql.Date stringToDate(String time) {
		Date dateTime=null;
		java.sql.Date sqlTime=null;
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		try {
			dateTime=format.parse(time);
			//System.out.println("1\n"+dateTime);
			//System.out.println("2\n"+dateTime.getTime());
			sqlTime = new java.sql.Date(dateTime.getTime());
			//System.out.println("3\n"+sqlTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sqlTime;
	}
	
	/**
	 * 日期格式处理：2018/08/09转换成2018-08-09
	 * @param time
	 * @return
	 */
	public static String changeTimeString (String time) {
		
		String[] array=time.split("/");
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<array.length;i++) {
			sb.append(array[i]+"-");
		}
		String changeTime=sb.toString();
		changeTime=changeTime.substring(0,changeTime.length()-1);
		return changeTime;
	}
	
	/**
	 *获取daily类型的数据，用来查询日报
	 * @param create_time
	 * @param company_name
	 * @param contacts_name
	 * @param user
	 * @param stage
	 * @param budget
	 * @param intention
	 * @param discount
	 * @param progress
	 * @param point
	 * @param advice
	 * @return
	 */
	public static Daily setDaily(String create_time,String company_name,String contacts_name,User user,
			   String stage,String budget,String intention,String discount,String progress,String point,String advice) {
		
		
		Daily daily=new Daily();
		daily.setCreate_time(create_time);
		daily.setCompany_name(company_name);
		daily.setContacts_name(contacts_name);
		daily.setStage(stage);
		daily.setBudget(budget);
		daily.setDiscount(discount);
		daily.setIntention(intention);
		daily.setProgress(progress);
		daily.setStage(stage);
		daily.setAdvice(advice);
		daily.setUser(user);
		daily.setPoint(point);
		
		return daily;
	}
}
