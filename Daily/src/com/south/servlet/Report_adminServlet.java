package com.south.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.south.dao.UserDao;
import com.south.dao.UserDaoImpl;
import com.south.util.CommonUtil;
import com.south.util.RoleUtil;

/**
 * Servlet implementation class Report_adminServlet
 */
@WebServlet("/report.do")
public class Report_adminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String openid=CommonUtil.getCookie(request, response);
		//System.out.println("+++"+openid);
		UserDao userDao=new UserDaoImpl();
		int role_id=userDao.get_roleId(openid);
		if(role_id==RoleUtil.salesman) {//业务员无权限管理日报
			
			response.sendRedirect("common/role.jsp");
			
		}else if(role_id==RoleUtil.manager) {//经理权限无权限管理日报
			
			response.sendRedirect("common/role.jsp");
			
		}else if(role_id==RoleUtil.admin) {//管理员管理日报
			
			response.sendRedirect("admin/report_manage.jsp");
			
		}else {//role_id不存在 登录注册
			
			response.sendRedirect("OAuth/oauth_index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
