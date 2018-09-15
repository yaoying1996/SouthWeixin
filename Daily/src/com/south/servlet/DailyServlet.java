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
		// ΢�ż���ǩ��  
		String msg_signature = req.getParameter("msg_signature");  
	        // ʱ���  
	        String timestamp = req.getParameter("timestamp");  
	        // �����  
	        String nonce = req.getParameter("nonce");  
	        // ����ַ���  
	        String echostr = req.getParameter("echostr");  
	        // ��
	        PrintWriter out = resp.getWriter();  
	        // ͨ������signature���������У�飬��У��ɹ���ԭ������echostr����ʾ����ɹ����������ʧ��  
	        String result = null;  
	        try {  
	        	WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(WeixinUtil.token,WeixinUtil.ENCODINGAESKEY,WeixinUtil.CORPID);  
	        	// ��֤URL����
	        	result = wxcpt.VerifyURL(msg_signature, timestamp, nonce, echostr);  
	        } catch (AesException e) {  
	            e.printStackTrace();  
	        }  
	        if (result == null) {  
	        	// resultΪ�գ�����token���������Ľ�ͼ�����õ�token
	        	result = WeixinUtil.token;
	        }
	        out.print(result);
	        out.close();  
	        out = null;  

		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.��������Ӧ�ı��������ΪUTF-8����ֹ�������룩  
        req.setCharacterEncoding("UTF-8");  
        resp.setCharacterEncoding("UTF-8");  
        
        //2.������Ϣҵ���������Ϣ��������Ϣ  
        MessageService msgsv=new MessageService();
        String respMessage = msgsv.getEncryptRespMessage(req);  
     
        //�������
        // String respMessage = CoreService.processRequest_emoj(request);
        //����ͼ����Ϣ
        //String respMessage = Test_NewsService.processRequest(request);

        
        //3.��Ӧ��Ϣ  
        PrintWriter out = resp.getWriter();  
        out.print(respMessage);  
        out.close(); 
		
			
		
	
	}

	

}
