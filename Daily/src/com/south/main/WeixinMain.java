package com.south.main;

import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

import com.south.po.AccessToken;
import com.south.util.TokenUtil;
import com.south.util.WeixinUtil;

import net.sf.json.JSONObject;

public class WeixinMain {
	public static void main(String[] args) throws ParseException {
		Map<String, Object> tokenMap=TokenUtil.getToken();
		String token=(String) tokenMap.get("access_token");
		
		//String path="C:\\Users\\Administrator\\Pictures\\Saved Pictures\\3.jpg";
		
		
		try {
			//�����˵�
			String menu=JSONObject.fromObject(WeixinUtil.initMenu()).toString();
			int result=WeixinUtil.createMenu(token,menu);
			if(result==0) {
				System.out.println("�����˵��ɹ�");
			}else {
				System.out.println("�����˵�ʧ�ܣ�errorcode="+result);
			}
			JSONObject jsonObject=WeixinUtil.queryMenu(token);
			System.out.println(jsonObject);
			/*//ɾ���˵�
			int result=WeixinUtil.deleteMenu(token);
			if(result==0) {
				System.out.println("�˵�ɾ���ɹ�");
			}else {
				System.out.println(result);
			}*/
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
