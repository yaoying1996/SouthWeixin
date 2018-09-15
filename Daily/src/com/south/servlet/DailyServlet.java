package com.south.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.south.util.AesException;
import com.south.util.MessageService;
import com.south.util.WXBizMsgCrypt;
import com.south.util.WeixinUtil;

@WebServlet("/ds.do")
public class DailyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 微信加密签名  
		String msg_signature = req.getParameter("msg_signature");  
	        // 时间戳  
	        String timestamp = req.getParameter("timestamp");  
	        // 随机数  
	        String nonce = req.getParameter("nonce");  
	        // 随机字符串  
	        String echostr = req.getParameter("echostr");  
	        // 流
	        PrintWriter out = resp.getWriter();  
	        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败  
	        String result = null;  
	        try {  
	        	WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(WeixinUtil.token,WeixinUtil.ENCODINGAESKEY,WeixinUtil.CORPID);  
	        	// 验证URL函数
	        	result = wxcpt.VerifyURL(msg_signature, timestamp, nonce, echostr);  
	        } catch (AesException e) {  
	            e.printStackTrace();  
	        }  
	        if (result == null) {  
	        	// result为空，赋予token，即在上文截图中设置的token
	        	result = WeixinUtil.token;
	        }
	        out.print(result);
	        out.close();  
	        out = null;  

		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.将请求、响应的编码均设置为UTF-8（防止中文乱码）  
        req.setCharacterEncoding("UTF-8");  
        resp.setCharacterEncoding("UTF-8");  
        
        //2.调用消息业务类接收消息、处理消息  
        MessageService msgsv=new MessageService();
        String respMessage = msgsv.getEncryptRespMessage(req);  
     
        //处理表情
        // String respMessage = CoreService.processRequest_emoj(request);
        //处理图文消息
        //String respMessage = Test_NewsService.processRequest(request);

        
        //3.响应消息  
        PrintWriter out = resp.getWriter();  
        out.print(respMessage);  
        out.close(); 
		
			
		
	
	}

	

}
