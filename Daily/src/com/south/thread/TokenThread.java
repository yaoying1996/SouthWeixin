package com.south.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.south.po.AccessToken;
import com.south.util.TokenUtil;
import com.south.util.WeixinUtil;

/**
 * 7200秒更新一次accesstoken
 * @author yao
 *
 */
public class TokenThread implements Runnable{
	
	private static Logger log = LoggerFactory.getLogger(TokenThread.class);
	
	public static AccessToken accessToken=null;
	@Override
	public void run() {
		while(true) {
			try {
				accessToken =WeixinUtil.getAccessToken();
				if(null!=accessToken) {
					//调用存储到数据库
					TokenUtil.saveToken(accessToken);
					log.info("获取access_token成功，有效时长{}秒 token:{}", accessToken.getExpiresIn(), accessToken.getToken());
					// 休眠7000秒
                    Thread.sleep(7000*1000);
				}else {
					// 如果access_token为null，60秒后再获取
                    Thread.sleep(60 * 1000);
				}
			}catch (InterruptedException e) {
                try {
                    Thread.sleep(60 * 1000);
                } catch (InterruptedException e1) {
                    log.error("{}", e1);
                }
                log.error("{}", e);
            }
		}
		
	}
	
}
