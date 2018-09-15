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
			//创建菜单
			String menu=JSONObject.fromObject(WeixinUtil.initMenu()).toString();
			int result=WeixinUtil.createMenu(token,menu);
			if(result==0) {
				System.out.println("创建菜单成功");
			}else {
				System.out.println("创建菜单失败，errorcode="+result);
			}
			JSONObject jsonObject=WeixinUtil.queryMenu(token);
			System.out.println(jsonObject);
			/*//删除菜单
			int result=WeixinUtil.deleteMenu(token);
			if(result==0) {
				System.out.println("菜单删除成功");
			}else {
				System.out.println(result);
			}*/
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
