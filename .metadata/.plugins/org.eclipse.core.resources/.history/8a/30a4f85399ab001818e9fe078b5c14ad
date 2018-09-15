package com.south.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.south.dao.CommonDao;
import com.south.dao.CommonDaoImpl;
import com.south.dao.DailyDao;
import com.south.dao.DailyDaoImpl;
import com.south.dao.UserDao;
import com.south.dao.UserDaoImpl;
import com.south.entity.User;

@WebServlet("/writeDaily.do")
public class WriteDailyServlet extends HttpServlet{

	/**
	 * 根据公司名称和业务员查询对应的联系人
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//System.out.println("1");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out=resp.getWriter();
		
		String company_name=req.getParameter("company_name");
		
		//获得openid
		Cookie[] cookies=req.getCookies();
		String openid=getOpenid(cookies);
		
		CommonDao commonDao=new CommonDaoImpl();
		boolean isExist=commonDao.isExist_company(company_name);
		 String result="";
		if(isExist) {
			//System.out.println("2");
			//System.out.println("++++"+result);
			result=commonDao.query_contacts_company(openid, company_name);
			
		}
		if(!result.equals("")) {
			//System.out.println("-----"+result);
			result=result.substring(0, result.length()-1);
			System.out.println("company="+company_name+",联系人="+result+",当前openid="+openid);
			
		}
			out.write(result);
			out.flush();
			out.close();
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String time=req.getParameter("time");
		time=time.replace('T', ' ');
		//System.out.println("time="+time);
		
		String company_name=req.getParameter("company");
	
		
		//获得openid
		Cookie[] cookies=req.getCookies();
		String openid=getOpenid(cookies);
		
		String contacts_name=req.getParameter("contacts");
		//System.out.println("contacts="+contacts);
		String stage=req.getParameter("stage");
		//System.out.println("stage="+stage);
		String budget=req.getParameter("budget");
		String intention=req.getParameter("intention");
		String discount=req.getParameter("discount");
		String progress=req.getParameter("progress");
		String point=req.getParameter("point");
		String advice=req.getParameter("advice");
		//System.out.println(advice=="");
		
		UserDao userDao=new UserDaoImpl();
		User user=userDao.query_allInfo_User(openid);
		
		DailyDao dailyDao=new DailyDaoImpl();
		boolean result=dailyDao.saveDaily(time, company_name, contacts_name, user, stage, budget, intention, discount, progress, point, advice);
		
		resp.setCharacterEncoding("utf-8");
		PrintWriter out=resp.getWriter();
		out.print(result);
		out.flush();
		out.close();
	}
	
	public String getOpenid(Cookie[] cookies) {
		String openid="";
		if(cookies!=null) {
			for(Cookie cookie:cookies) {
				if(cookie.getName().equals("openid")) 
					openid=cookie.getValue();
			}
		}else {
			System.out.println("+++++++++++++++++writeDaily.do中openid为空");
		}
		return openid;
	}

}
