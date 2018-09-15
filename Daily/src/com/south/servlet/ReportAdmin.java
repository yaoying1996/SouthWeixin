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

@WebServlet("/reportAdmin.do")
public class ReportAdmin extends HttpServlet{
	
	private static final long serialVersionUID = 8776692859369571063L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String,String> param=new HashMap<String,String>();
		String start=request.getParameter("start");
		String end=request.getParameter("end");
		if(start!=""&&end!="") {
			/*System.out.println("查询日报的起始时间为："+start);
			System.out.println("查询日报的截止时间为："+end);*/
			start=CommonUtil.changeTimeString(start);
			end=CommonUtil.changeTimeString(end);
			end=CommonUtil.addOneDay(end);
			param.put("start", start);
			param.put("end",end);
		}else {
			param.put("weekend","DATE_SUB(CURDATE(), INTERVAL 7 DAY)  < date(b.create_time)");
		}
		
		String company=request.getParameter("company");
		if(company!="") {
			param.put("company_name", company);
		}
		
		String department=request.getParameter("department");
		if(department!="") {
			param.put("department", department);
		}
		
		String sale=request.getParameter("sale");
		
		UserDao userDao=new UserDaoImpl();
		String userid=userDao.userId_Name(sale)+"";
		if(sale!="") {
			param.put("user.user_id", userid);
		}
		
		String openid=CommonUtil.getCookie(request, response);
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		
		if(!"".equals(openid)) {
			DailyDao dailyDao=new DailyDaoImpl();
			List<Daily> myDailys=dailyDao.queryReportAdmin(param);

			//System.out.println(myDailys.isEmpty());
		
			if(myDailys.isEmpty()) {
				//System.out.println("+++");
				out.write("true");
				
			}else {
				
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
