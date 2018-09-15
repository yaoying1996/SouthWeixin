package com.south.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.south.dao.DailyDao;
import com.south.dao.DailyDaoImpl;
import com.south.dao.UserDao;
import com.south.dao.UserDaoImpl;
import com.south.entity.Daily;
import com.south.util.CommonUtil;
import com.south.util.RoleUtil;

/**
 * Servlet implementation class Query_ManagerServlet
 */
@WebServlet("/queryManager.do")
public class Query_ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	

	/**
	 * 查看日报功能权限设置
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String openid=CommonUtil.getCookie(request, response);
		//System.out.println("+++"+openid);
		UserDao userDao=new UserDaoImpl();
		int role_id=userDao.get_roleId(openid);
		if(role_id==RoleUtil.salesman) {//业务员无权限写建议,查看其它日报
			
			response.sendRedirect("common/role.jsp");
			
		}else if(role_id==RoleUtil.manager) {//经理权限查看日报并写建议，
			
			response.sendRedirect("manager/query_daily_manager.jsp");
			
		}else if(role_id==RoleUtil.admin) {//管理员权限不能查看日报
			
			response.sendRedirect("common/role.jsp");
			
		}else {//role_id不存在 登录注册
			
			response.sendRedirect("OAuth/oauth_index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String,String> param=new HashMap<String,String>();
		String start=request.getParameter("start");
		String end=request.getParameter("end");
		if(start!=""&&start!=null&&end!=""&&end!=null) {
			System.out.println("查询日报的起始时间为："+start);
			System.out.println("查询日报的截止时间为："+end);
			start=CommonUtil.changeTimeString(start);
			end=CommonUtil.changeTimeString(end);
			end=CommonUtil.addOneDay(end);
			param.put("start", start);
			param.put("end",end);
		}
		
		String company=request.getParameter("company");
		if(company!=""&&company!=null) {
			param.put("company_name", company);
		}
		String stage=request.getParameter("stage");
		if(stage!=""&&stage!=null) {
			param.put("stage", stage);
		}
		String sale=request.getParameter("sale");
		
		UserDao userDao=new UserDaoImpl();
		String userid=userDao.userId_Name(sale)+"";
		
		if(sale!=""&&sale!=null) {
			param.put("user.user_id", userid);
		}
		
		String advice_isExist=request.getParameter("exist_advice");
		//System.out.println(advice_isExist==null);
		if(advice_isExist!=null) {
			//System.out.println(advice_isExist.equals(1+""));
			param.put("advice", advice_isExist);
		}
		String openid=CommonUtil.getCookie(request, response);
		System.out.println("openid="+openid);
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		
		if(!"".equals(openid)) {
			DailyDao dailyDao=new DailyDaoImpl();
			List<Daily> myDailys=dailyDao.queryDailyManager(param);

			//System.out.println(myDailys.isEmpty());
		
			if(myDailys.isEmpty()) {
				//System.out.println("+++");
				out.write("true");
				
			}else {
				for(Daily daily: myDailys) {
					System.out.println(daily.toString());
				}
				Gson gson = new Gson();
				String str = gson.toJson(myDailys);
				out.write(str);
			}
			
		}else {//cookie无效时重新授权
			out.write("false");
		}
		out.flush();
		out.close();
	}

}
