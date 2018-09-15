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

@WebServlet("/dailyrole.do")
public class DailyRoleServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String openid=CommonUtil.getCookie(req, resp);
		//System.out.println("+++"+openid);
		UserDao userDao=new UserDaoImpl();
		int role_id=userDao.get_roleId(openid);
		if(role_id==RoleUtil.salesman) {//业务员权限可以写日报
			
			resp.sendRedirect("sale/my_daily.jsp");
			
		}else if(role_id==RoleUtil.manager) {//经理权限不能写日报
			
			resp.sendRedirect("common/role.jsp");
			
		}else if(role_id==RoleUtil.admin) {//管理员权限不能写日报
			
			resp.sendRedirect("common/role.jsp");
		}else {//role_id不存在 登录注册
			resp.sendRedirect("OAuth/oauth_index.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}

