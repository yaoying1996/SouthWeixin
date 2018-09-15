package com.south.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.south.dao.DailyDao;
import com.south.dao.DailyDaoImpl;

/**
 * Servlet implementation class AdviceServlet
 */
@WebServlet("/advice.do")
public class AdviceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdviceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		
		String advice=request.getParameter("advice");
		String create_time=request.getParameter("time");
		String userOpenid=request.getParameter("userOpenid");
		
		System.out.println(advice);
		System.out.println(create_time);
		System.out.println(userOpenid);
		
		DailyDao dailyDao=new DailyDaoImpl();
		boolean result=dailyDao.updateDaily(advice, create_time, userOpenid);
		out.println(result);
		out.flush();
		out.close();
	}

}
