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

@WebServlet("/userInfo.do")
public class userInfoServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//获取本地cookie
		String openid=CommonUtil.getCookie(req, resp);
		//System.out.println(openid);
		//数据库中可能已经删除，获取数据库中的openid
		UserDao userDao=new UserDaoImpl();
		String openid2=userDao.queryUser(openid);
		if(!"".equals(openid2)) {
			resp.sendRedirect("common/user_Info.jsp");
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
