package com.south.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.south.dao.UserDao;
import com.south.dao.UserDaoImpl;
import com.south.entity.Daily;
import com.south.entity.User;
import com.south.util.CommonExcel;
import com.south.util.CommonUtil;

@WebServlet("/excel.do")
public class ExcelServlet extends HttpServlet {

	
	public final static String path="D:/reportExcel/";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		String title = "报表";
	    String[] rowName = new String[]{"客户","业务员","阶段","进展","存在问题","建议"};
	    List<Object[]>  dataList = new ArrayList<Object[]>();
	    Object[] objs = null;
	    
		String jsonStr=req.getParameter("queryData");
		String content=req.getParameter("query");
		Gson gson = new Gson();
		List<Daily> queryList = gson.fromJson(jsonStr, new TypeToken<List<Daily>>() {}.getType());
		
		for (int i = 0; i < queryList.size(); i++) {
	        objs = new Object[rowName.length];
	        objs[0] =queryList.get(i).getCompany_name();
	        //System.out.println(queryList.get(i).getCompany_name());
	        User user=queryList.get(i).getUser();
	        objs[1] = user.getName();
	        objs[2] = queryList.get(i).getStage();
	        objs[3] = queryList.get(i).getProgress();
	        objs[4] = queryList.get(i).getPoint();
	        objs[5] = queryList.get(i).getAdvice();
	        dataList.add(objs);
	    }
		
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = df.format(new Date());
        String newstr =date.replace(" ", "_");
        String newstr2 =newstr.replace(":", "-");
	    String fileName="报表-"+newstr2+".xls";
	    
	   CommonExcel ex = new CommonExcel(title, rowName, dataList,response,fileName);
	   
	   String openid=CommonUtil.getCookie(req, response);
	   UserDao userDao=new UserDaoImpl();
	   User user=userDao.query_allInfo_User(openid);
	   String email=user.getEmail();
	   
        try {
			ex.downloadExcel(email,content);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	    PrintWriter out=response.getWriter();
	    out.write("true");
	    out.flush();
	    out.close();
		
	    

	}


}
