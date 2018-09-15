package com.south.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.south.po.TextMessage;
import com.thoughtworks.xstream.XStream;

public class MessageUtil {

	//������Ϣ���ͣ��ı� 
    public static final String RESP_MESSAGE_TYPE_TEXT = "text"; 
   //������Ϣ���ͣ��ı�  
    public static final String REQ_MESSAGE_TYPE_TEXT = "text";  
  //������Ϣ���ͣ�����  
    public static final String REQ_MESSAGE_TYPE_EVENT = "event";  
  //�¼����ͣ�subscribe(����) 
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";  
    //�¼����ͣ�unsubscribe(ȡ������) 
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";  
    //�¼����ͣ�CLICK(�Զ���˵�����¼�)  
    public static final String EVENT_TYPE_CLICK = "click";  
  
    
    /**
     * @desc ��1.����΢�ŷ���������XML��,��ȡ������� 
     *  
     * @param request
     * @return
     * @throws Exception Map<String,String>
     */
    public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {  
        // ����������洢��HashMap��  
        Map<String, String> map = new HashMap<String, String>();  
  
        // ��request��ȡ��������  
        InputStream inputStream = request.getInputStream();  
        // ��ȡ������  
        SAXReader reader = new SAXReader();  
        Document document = reader.read(inputStream);  
        // �õ�xml��Ԫ��  
        Element root = document.getRootElement();  
        // �õ���Ԫ�ص������ӽڵ�  
        List<Element> elementList = root.elements();  
  
        // ���������ӽڵ�  
        for (Element e : elementList)  
            map.put(e.getName(), e.getText());  
  
        // �ͷ���Դ  
        inputStream.close();  
        inputStream = null;  
  
        return map;  
    } 
    
    /**
     * @desc ��2.����΢�ŷ���������xmlStr��,��ȡ������� 
     *  
     * @param xmlStr
     * @return
     * @throws Exception Map<String,String>
     */
    public static Map<String, String> parseXml(String xmlStr) throws Exception {  
        // ����������洢��HashMap��  
        Map<String, String> map = new HashMap<String, String>();  
  

        //1.���ַ���תΪDocument
        Document document = DocumentHelper.parseText(xmlStr);
        
        //2.��ȡ��Ԫ�ص������ӽڵ�
        // �õ�xml��Ԫ��  
        Element root = document.getRootElement();  
        // �õ���Ԫ�ص������ӽڵ�  
        List<Element> elementList = root.elements();  
  
        //3.���������ӽڵ� 
        for (Element e : elementList)  
            map.put(e.getName(), e.getText());  
        
        return map;  
    }  
  
    /** 
     * 2.�ı���Ϣ����ת����xml 
     *  
     * @param textMessage �ı���Ϣ���� 
     * @return xml 
     */  
    public static String textMessageToXml(TextMessage textMessage) {  
    	XStream xstream =new XStream();
        xstream.alias("xml", textMessage.getClass());  
        return xstream.toXML(textMessage);  
    }  
    
	/**
	 * ��ҵ�ŵķ�����Ϣ
	 * text��Ϣ
	 * @param touser UserID�б���Ϣ�����ߣ�����������á�|���ָ��������������ָ��Ϊ@all�������ע����ҵӦ�õ�ȫ����Ա���͡�������"touser": "UserID1|UserID2|UserID3"
	 * @param toparty PartyID�б�����������á�|���ָ�����touserΪ@allʱ���Ա�������������"toparty": " PartyID1 | PartyID2 "
	 * @param totag TagID�б�����������á�|���ָ�����touserΪ@allʱ���Ա�������������"totag": " TagID1 | TagID2 "
	 * @param msgtype ��Ϣ���ͣ���ʱ�̶�Ϊ��text
	 * @param agentid ��ҵӦ�õ�id�����͡�����Ӧ�õ�����ҳ��鿴
	 * @param content ��Ϣ����
	 * @param safe ��ʾ�Ƿ��Ǳ�����Ϣ��0��ʾ��1��ʾ�ǣ�Ĭ��0
	 * */
	public static String STextMsg(String touser,String toparty,String totag,String agentid,String content){
		StringBuffer sb = new StringBuffer();
        sb.append("{");
        sb.append("\"touser\":" + "\"" + touser + "\",");
        sb.append("\"toparty\":" + "\"" + toparty + "\",");
        sb.append("\"totag\":" + "\"" + totag + "\",");
        sb.append("\"msgtype\":" + "\"" + "text" + "\",");
        sb.append("\"agentid\":" + "\"" + agentid + "\",");
        sb.append("\"text\":" + "{");
        sb.append("\"content\":" + "\"" + content + "\"},");
        sb.append("\"safe\":" + "\"" + "0" + "\"");
        sb.append("}");
        
        return sb.toString();
	}
	
	
	/**
	 * ��ע�ظ�
	 * @return
	 */
	public static String menuText(){
		StringBuffer sb=new StringBuffer();
		sb.append("��ӭ���Ĺ�ע������������ӽ���ע�᣺\n");
		sb.append("http://ds.nfledmedia.com/Daily/OAuth/oauth_index.jsp");
		sb.append("\n");
		sb.append("���ں�ʹ��ָ�ϣ�\n");
		sb.append("�ܾ���Ȩ�ޣ��鿴�ձ���ҵ��ԱȨ�ޣ�д�ձ����ҵ��ձ�������ԱȨ�ޣ��������������Ϣ���ڹ���Ȩ�ޣ��ظ�������鿴�˲˵���");
		return sb.toString();
	}
	
}
