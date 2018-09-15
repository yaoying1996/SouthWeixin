package com.south.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.south.dao.CommonDao;
import com.south.dao.CommonDaoImpl;
import com.south.dao.UserDao;
import com.south.dao.UserDaoImpl;
import com.south.entity.User;
import com.south.util.CommonUtil;

/**
 * Servlet implementation class ContactsServlet
 */
@WebServlet("/contacts.do")
public class ContactsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String contacts_name=request.getParameter("contacts_name");
		String company_name=request.getParameter("company_name");
		String department=request.getParameter("department");
		String post=request.getParameter("post");
		String tel=request.getParameter("tel");
		
		CommonDao commonDao=new CommonDaoImpl();
		
		boolean result=commonDao.save_add_contacts(contacts_name, company_name, department, post, tel);
		
		String openid=CommonUtil.getCookie(request, response);
		/*Cookie[] cookies=request.getCookies();
		if(cookies!=null) {
			for(Cookie cookie:cookies) {
				if(cookie.getName().equals("openid")) {
					openid=cookie.getValue();
					break;
				}
			}
		}*/
		UserDao userDao=new UserDaoImpl();
		User user=userDao.query_allInfo_User(openid);
		
		int contacts_id=commonDao.query_contactsid(contacts_name, tel);
		
		result=commonDao.save_contacts_user(company_name,contacts_id,user.getOpenId(),user.getName());
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		out.print(result);
		out.flush();
		out.close();
	}

	
}
