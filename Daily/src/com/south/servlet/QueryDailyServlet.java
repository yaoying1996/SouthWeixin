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
 * Servlet implementation class QueryDailyServlet
 */
@WebServlet("/querydaily.do")
public class QueryDailyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryDailyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * �ж��Ƿ��в鿴�ձ���Ȩ��
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String openid=CommonUtil.getCookie(request, response);
		//System.out.println("+++"+openid);
		UserDao userDao=new UserDaoImpl();
		int role_id=userDao.get_roleId(openid);
		if(role_id==RoleUtil.salesman) {//ҵ��ԱȨ�޲鿴�ձ�
			
			response.sendRedirect("sale/query_daily.jsp");
			
		}else if(role_id==RoleUtil.manager) {//����Ȩ�޲鿴�ձ���д����
			
			
			response.sendRedirect("common/role.jsp");
			
		}else if(role_id==RoleUtil.admin) {//����ԱȨ�޲��ܲ鿴�ձ�
			
			response.sendRedirect("common/role.jsp");
			
		}else {//role_id������ ��¼ע��
			
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
			System.out.println("��ѯ�ձ�����ʼʱ��Ϊ��"+start);
			System.out.println("��ѯ�ձ��Ľ�ֹʱ��Ϊ��"+end);
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
		
		String openid=CommonUtil.getCookie(request, response);
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		
		if(!"".equals(openid)) {
			param.put("open_id", openid);
			DailyDao dailyDao=new DailyDaoImpl();
			List<Daily> myDailys=dailyDao.queryDailyManager(param);

			//System.out.println(myDailys.isEmpty());

			if(myDailys.isEmpty()) {
				out.print("true");
			}else {
				for(Daily daily: myDailys) {
					System.out.println(daily.toString());
				}
				Gson gson = new Gson();
				String str = gson.toJson(myDailys);
				out.write(str);
			}
			
		}else {//cookie��Чʱ������Ȩ
			out.write("false");
		}
		out.flush();
		out.close();
		
	}
	
	
}