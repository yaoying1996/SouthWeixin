package com.south.util;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import com.south.dao.UserDao;
import com.south.dao.UserDaoImpl;
import com.south.po.TextMessage;



/**
 * @desc  : �����ظ���Ϣ
 * 
 * @author: yao
 *
 */
public class MessageService {

    private String msg_signature ; // ΢�ż���ǩ��  
    private String timestamp ;    // ʱ���    
    private String nonce ;       // �����  


    /**
     * @desc ����ȡ���ܺ�Ļظ���Ϣ
     *  
     * @param request
     * @return String  ���ؼ��ܺ�Ļظ���Ϣ
     */
    public String getEncryptRespMessage(HttpServletRequest request){
        String respMessage = null; 

        try {
            //1.����΢�ŷ���������Ϣ
            String xmlMsg=this.getDecryptMsg(request);

            //2.����΢�ŷ���������,����xml�ַ���
            Map<String, String> requestMap= MessageUtil.parseXml(xmlMsg);    

            //3.��ȡ�������
            //3.1 ��ԱUserID
            String fromUserName = requestMap.get("FromUserName");  
            //System.out.println("fromUserName:"+fromUserName);
            
            //3.2 ��ҵ΢��CorpID  toUserName:ww50f0bed8f991756a
            String toUserName = requestMap.get("ToUserName");
            //System.out.println("toUserName:"+toUserName);
            
            //3.3 ��Ϣ�������¼� 
            String msgType = requestMap.get("MsgType"); 
            String eventType = requestMap.get("Event");  
            String eventKey = requestMap.get("EventKey"); 
            /*System.out.println("msgType:"+msgType);
            System.out.println("Event:"+eventType+"  eventKey:"+eventKey);*/
            

            //4.��װ �ظ��ı���Ϣ  
            TextMessage textMessage = new TextMessage();  
            textMessage.setToUserName(fromUserName);  
            textMessage.setFromUserName(toUserName);  
            textMessage.setCreateTime(new Date().getTime());  
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);  
            //4.1.��ȡ�ظ���Ϣ������ ����Ϣ�ķ��ദ��
            String respContent=this.getRespContentByMsgType(msgType, eventType, eventKey,fromUserName);
            textMessage.setContent(respContent);  
            //System.out.println("respContent��"+respContent);

            //5.��ȡxml�ַ����� ���������ظ���Ϣ�͵ģ��ı���Ϣ���� ת��  xml�ַ���
            respMessage = MessageUtil.textMessageToXml(textMessage); 
            

            //6.����
            WXBizMsgCrypt wxcpt=new WXBizMsgCrypt(WeixinUtil.token,WeixinUtil.ENCODINGAESKEY,WeixinUtil.CORPID);
            respMessage = wxcpt.EncryptMsg(respMessage, timestamp, msgType);
            

        } catch (Exception e) {
            e.printStackTrace();
        }  

        return respMessage;
    }


    /**
     * @desc ��2.��request�л�ȡ��Ϣ����
     *  
     * @param request
     * @return String   ��Ϣ����
     */
    public String getDecryptMsg(HttpServletRequest request) {

        String postData="";   // ���ģ���ӦPOST���������
        String result="";     // ���ģ�����֮��Ľ��

        this.msg_signature = request.getParameter("msg_signature"); // ΢�ż���ǩ��  
        this.timestamp = request.getParameter("timestamp");   // ʱ���    
        this.nonce = request.getParameter("nonce");          // �����  

        try {
            //1.��ȡ���ܵ�������Ϣ��ʹ����������ü���������ϢpostData
            ServletInputStream in = request.getInputStream();
            BufferedReader reader =new BufferedReader(new InputStreamReader(in));  

            String tempStr="";   //��Ϊ����ַ�������ʱ���������ж��Ƿ��ȡ���  
            while(null!=(tempStr=reader.readLine())){  
                postData+=tempStr;  
            }  

            //2.��ȡ��Ϣ���ģ��Լ��ܵ�������Ϣ���н��ܻ������  
            WXBizMsgCrypt wxcpt=new WXBizMsgCrypt(WeixinUtil.token,WeixinUtil.ENCODINGAESKEY,WeixinUtil.CORPID);
            result = wxcpt.DecryptMsg(msg_signature, timestamp, nonce, postData);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (AesException e) {
            e.printStackTrace();
        }  

        return result;
    }

    /**
     * @desc ��3.������Ϣ��������Ϣ���ͻ�ȡ�ظ�����
     *  
     * @param msgType
     * @return String
     */
    public String getRespContentByMsgType(String msgType,String eventType,String eventKey,String fromUserName){
        String respContent="";
        //1.�ı���Ϣ  
        if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {  
            respContent = MessageUtil.menuText();  

        }  
        //2.�¼�����  
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) { 
            respContent=this.processEevent(eventType, eventKey,fromUserName);
        }
        //7.�����쳣
        else {
            respContent="�������쳣�����Ժ��ԣ�";
        }  

        return respContent;
    }

    public String processEevent(String eventType,String eventKey,String fromUserName){
        
        String respContent="";
        // ����  
        if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {  
            respContent = MessageUtil.menuText();  
        }  
        // ȡ������  
        else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {  
        	UserDao userDao=new UserDaoImpl();
			userDao.deleteUser(fromUserName);
        } 
        // �Զ���˵�����¼�  
        else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {  
/*
            if (eventKey.equals("12")) {  
                // TODO  help
            } else if (eventKey.equals("13")) {  
                respContent = "�ܱ������˵�������";  
            } else if (eventKey.equals("14")) {  
                respContent = "��ʷ�ϵĽ���˵�������";  
            } else if (eventKey.equals("21")) {  
                respContent = "�����㲥�˵�������";  
            } else if (eventKey.equals("22")) {  

                respContent = "������Ϸ�˵�������";  
            } else if (eventKey.equals("23")) {  
                respContent = "��Ů��̨�˵�������";  
            } else if (eventKey.equals("24")) {  
                respContent = "����ʶ��˵�������";  
            } else if (eventKey.equals("25")) {  
                respContent = "������ྲ˵�������";  
            } else if (eventKey.equals("31")) {  
                respContent = "Q��Ȧ�˵�������";  
            } else if (eventKey.equals("32")) {  
                respContent = "��Ӱ���а�˵�������";  
            } else if (eventKey.equals("33")) {  
                respContent = "��ĬЦ���˵�������";  
            }  */
        } 
        return respContent;
    }  
  
    
    
    
    
}