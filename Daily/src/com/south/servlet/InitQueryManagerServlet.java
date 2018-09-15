package com.south.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.south.dao.CommonDao;
import com.south.dao.CommonDaoImpl;
import com.south.dao.UserDao;
import com.south.dao.UserDaoImpl;
import com.south.util.CommonUtil;
import com.south.util.RoleUtil;

@WebServlet("/initManager.do")
public class InitQueryManagerServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CommonDao commonDao=new CommonDaoImpl();
		List<String> allSale=commonDao.getAllSale();
		resp.setCharacterEncoding("utf-8");
		PrintWriter out=resp.getWriter();
		//System.out.println(allSale);
		Gson gson=new Gson();
		String str=gson.toJson(allSale);
		out.print(str);
		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String sql="";
		String openid=CommonUtil.getCookie(req, resp);
		UserDao userDao=new UserDaoImpl();
		int  roleid=userDao.get_roleId(openid);
		if(roleid==RoleUtil.salesman) {
			sql="select distinct company_name from company_user where deleted=0 and open_id='"+openid+"'";
		}else if(roleid==RoleUtil.manager||roleid==RoleUtil.admin) {
			 sql="select distinct company_name from contacts where deleted=0 ";
		}

		CommonDao commonDao=new CommonDaoImpl();
		List<String> allCompany=commonDao.getCompanyNames(sql);
		resp.setCharacterEncoding("utf-8");
		PrintWriter out=resp.getWriter();
		
		Gson gson=new Gson();
		String str=gson.toJson(allCompany);
		out.print(str);
		out.flush();
		out.close();
	}

}