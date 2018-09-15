package com.south.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.south.dao.UserDao;
import com.south.dao.UserDaoImpl;
import com.south.entity.Role;
import com.south.entity.User;
import com.south.util.CommonUtil;

@WebServlet("/user.do")
public class userServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String openid=CommonUtil.getCookie(req, resp);
		
		UserDao userDao=new UserDaoImpl();
		User user=userDao.query_allInfo_User(openid);
		String name=user.getName();
		String tel=user.getTel();
		String department=user.getDepartment();
		Role role=user.getRole();
		String roleName=role.getRole_name();
		String email=user.getEmail();
		
		Map<String,String> param=new HashMap<String,String>();
		
		param.put("department", department);
		param.put("realName", name);
		param.put("tel", tel);
		param.put("role", roleName);
		param.put("email", email);
		
		Gson gson=new Gson();
		String str=gson.toJson(param);
		resp.setCharacterEncoding("utf-8");
		PrintWriter out=resp.getWriter();
		out.write(str);
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String openid=CommonUtil.getCookie(req, resp);
		
		String name=req.getParameter("realName");
		//System.out.println(name);
		String tel=req.getParameter("tel");
		//System.out.println(tel);
		String department=req.getParameter("department");
		//System.out.println(department);
		//System.out.println(department);
		String email=req.getParameter("email");
		UserDao userDao=new UserDaoImpl();
		boolean result=userDao.updateUserInfo(openid, department, name, tel,email);
		
		PrintWriter out=resp.getWriter();
		out.println(result);
		out.flush();
		out.close();
	}

}
