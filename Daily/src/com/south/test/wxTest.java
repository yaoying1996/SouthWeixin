package com.south.test;

import com.south.po.AccessToken;
import com.south.util.MessageUtil;
import com.south.util.WeixinUtil;

import net.sf.json.JSONObject;

public class wxTest {
	 
	public static void main(String[] args) {
		// corpidΪÿ����ҵ��ӵ��Ψһ��corpid����ȡ����Ϣ���ڹ�����̨���ҵ���ҵ��������ҵ��Ϣ���²鿴����Ҫ�й���ԱȨ�ޣ�
		// corpsecret����ҵӦ���������ڱ������ݰ�ȫ�ġ�Կ�ס���ÿһ��Ӧ�ö���һ�������ķ�����Կ
		
		AccessToken token=WeixinUtil.getAccessToken();
		System.out.println("Ʊ��:"+token.getToken());
		System.out.println("��Чʱ��:"+token.getExpiresIn());
			
		String messageText=MessageUtil.STextMsg("@all","@all", "@all", "1000002", MessageUtil.menuText());
		int result = 0;
		String url = WeixinUtil.MESSAGE_URL.replace("ACCESS_TOKEN", token.getToken());
		JSONObject jsonObject = WeixinUtil.doPostStr(url, messageText);
		if(jsonObject != null){
			result = jsonObject.getInt("errcode");
		}
		
		System.out.println(result);
	}
 


}