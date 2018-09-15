package com.south.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.south.dao.UserDao;
import com.south.dao.UserDaoImpl;
import com.south.entity.Role;
import com.south.po.UserInfo;
import com.south.util.WeixinUtil;

/**
 * @author yao
 *�û���¼��΢�ţ���ȡcode
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet  {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
				
		String backUrl="http://ds.nfledmedia.com/Daily/callBack.do";
		String url="https://open.weixin.qq.com/connect/oauth2/authorize?"
				+ "appid="+WeixinUtil.CORPID
				+ "&redirect_uri="+URLEncoder.encode(backUrl)
				+ "&response_type=code"
				+ "&scope=snsapi_privateinfo"
				+ "&agentid="+WeixinUtil.AGENTID
				+ "&state=STATE#wechat_redirect";
		resp.sendRedirect(url);
		
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/text; charset=utf-8");
        PrintWriter out = resp.getWriter();
		UserDao userDao=new UserDaoImpl();
		//callBack�����request
		String openid=req.getParameter("openid");
		String name=req.getParameter("realName");
		String tel=req.getParameter("tel");
		String role_id=req.getParameter("role");
		String department=req.getParameter("department");
		String email=req.getParameter("email");
		//System.out.println(department);
		Role role=new Role();
		role.setRole_id(role_id);
		String role_name=userDao.queryRoleName(role_id);
		role.setRole_name(role_name);
		//System.out.println(role_name);
		String isExist=userDao.queryUser(openid);
		if(isExist.equals(openid)) {
			System.out.println("�û��Ѵ��ڲ��ܴ洢");
			
			out.write("false");
		}else {
			UserInfo userInfo=new UserInfo();
			//userInfo.setAccount(account);
			userInfo.setName(name);
			userInfo.setOpenId(openid);
			//userInfo.setPassword(password);
			userInfo.setTel(tel);
			userInfo.setRole(role);
			userInfo.setEmail(email);
			userInfo.setDepartment(department);
			userDao.saveUser(userInfo);
			out.write("true");
		}
		out.flush();
		out.close();
	}
	

	private static final long serialVersionUID = -604734374443560038L;

}