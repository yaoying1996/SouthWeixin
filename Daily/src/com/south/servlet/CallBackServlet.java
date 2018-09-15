package com.south.servlet;


import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.south.util.TokenUtil;
import com.south.util.WeixinUtil;

import net.sf.json.JSONObject;

/**
 * @author yao
 *�ص�������΢�Ź��ں���Ȩ,����û���openId
 */
@WebServlet("/callBack.do")
public class CallBackServlet extends HttpServlet{

	private static final long serialVersionUID = -6135777238592953632L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		Map<String, Object> tokenMap=TokenUtil.getToken();
		String access_token=(String) tokenMap.get("access_token");
		//System.out.println(access_token);
		
		//ͨ��code��ȡ��ҳ��Ȩaccess_token
		String code=req.getParameter("code");
		//System.out.println(code);
		
		String url="https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?"
				+ "access_token="+access_token
				+ "&code="+code;
				
		JSONObject jsonObject=WeixinUtil.doGetStr(url);
		//System.out.println(jsonObject);
		String UserId=jsonObject.getString("UserId");
		//System.out.println(UserId);
		String user_ticket=jsonObject.getString("user_ticket");
		
		/*//ͨ����ҳ��Ȩaccess_token��openid��ȡ�û�������Ϣ
		String infoUrl="https://qyapi.weixin.qq.com/cgi-bin/user/getuserdetail?"
				+ "access_token="+access_token;*/
		
		/*//��ȡ�û��Ļ�����Ϣ(δʵ��)
		JSONObject userInfo=WeixinUtil.doPostStr(infoUrl, user_ticket);
		System.out.println("jsonObject:"+userInfo.toString());
		//System.out.println(userInfo);
		String name=userInfo.getString("name");
		String userid=userInfo.getString("userid");
		String mobile=userInfo.getString("mobile");
		String email=userInfo.getString("email");
		System.out.println("name="+name+",userid="+userid);
		System.out.println("mobile="+mobile+",email="+email);*/
		
		
		req.setAttribute("openid", UserId);
		req.getRequestDispatcher("/OAuth/register.jsp").forward(req, resp);
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}