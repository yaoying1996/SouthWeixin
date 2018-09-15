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

	//返回消息类型：文本 
    public static final String RESP_MESSAGE_TYPE_TEXT = "text"; 
   //请求消息类型：文本  
    public static final String REQ_MESSAGE_TYPE_TEXT = "text";  
  //请求消息类型：推送  
    public static final String REQ_MESSAGE_TYPE_EVENT = "event";  
  //事件类型：subscribe(订阅) 
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";  
    //事件类型：unsubscribe(取消订阅) 
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";  
    //事件类型：CLICK(自定义菜单点击事件)  
    public static final String EVENT_TYPE_CLICK = "click";  
  
    
    /**
     * @desc ：1.解析微信发来的请求（XML）,获取请求参数 
     *  
     * @param request
     * @return
     * @throws Exception Map<String,String>
     */
    public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {  
        // 将解析结果存储在HashMap中  
        Map<String, String> map = new HashMap<String, String>();  
  
        // 从request中取得输入流  
        InputStream inputStream = request.getInputStream();  
        // 读取输入流  
        SAXReader reader = new SAXReader();  
        Document document = reader.read(inputStream);  
        // 得到xml根元素  
        Element root = document.getRootElement();  
        // 得到根元素的所有子节点  
        List<Element> elementList = root.elements();  
  
        // 遍历所有子节点  
        for (Element e : elementList)  
            map.put(e.getName(), e.getText());  
  
        // 释放资源  
        inputStream.close();  
        inputStream = null;  
  
        return map;  
    } 
    
    /**
     * @desc ：2.解析微信发来的请求（xmlStr）,获取请求参数 
     *  
     * @param xmlStr
     * @return
     * @throws Exception Map<String,String>
     */
    public static Map<String, String> parseXml(String xmlStr) throws Exception {  
        // 将解析结果存储在HashMap中  
        Map<String, String> map = new HashMap<String, String>();  
  

        //1.将字符串转为Document
        Document document = DocumentHelper.parseText(xmlStr);
        
        //2.获取根元素的所有子节点
        // 得到xml根元素  
        Element root = document.getRootElement();  
        // 得到根元素的所有子节点  
        List<Element> elementList = root.elements();  
  
        //3.遍历所有子节点 
        for (Element e : elementList)  
            map.put(e.getName(), e.getText());  
        
        return map;  
    }  
  
    /** 
     * 2.文本消息对象转换成xml 
     *  
     * @param textMessage 文本消息对象 
     * @return xml 
     */  
    public static String textMessageToXml(TextMessage textMessage) {  
    	XStream xstream =new XStream();
        xstream.alias("xml", textMessage.getClass());  
        return xstream.toXML(textMessage);  
    }  
    
	/**
	 * 企业号的发送消息
	 * text消息
	 * @param touser UserID列表（消息接收者，多个接收者用‘|’分隔）。特殊情况：指定为@all，则向关注该企业应用的全部成员发送————"touser": "UserID1|UserID2|UserID3"
	 * @param toparty PartyID列表，多个接受者用‘|’分隔。当touser为@all时忽略本参数————"toparty": " PartyID1 | PartyID2 "
	 * @param totag TagID列表，多个接受者用‘|’分隔。当touser为@all时忽略本参数————"totag": " TagID1 | TagID2 "
	 * @param msgtype 消息类型，此时固定为：text
	 * @param agentid 企业应用的id，整型。可在应用的设置页面查看
	 * @param content 消息内容
	 * @param safe 表示是否是保密消息，0表示否，1表示是，默认0
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
	 * 关注回复
	 * @return
	 */
	public static String menuText(){
		StringBuffer sb=new StringBuffer();
		sb.append("欢迎您的关注，点击下面链接进行注册：\n");
		sb.append("http://ds.nfledmedia.com/Daily/OAuth/oauth_index.jsp");
		sb.append("\n");
		sb.append("公众号使用指南：\n");
		sb.append("总经理权限：查看日报；业务员权限：写日报，我的日报；管理员权限：报表管理。个人信息属于公共权限，回复任意键查看此菜单。");
		return sb.toString();
	}
	
}
