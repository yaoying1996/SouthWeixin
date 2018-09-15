package com.south.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.south.po.AccessToken;
import com.south.util.TokenUtil;
import com.south.util.WeixinUtil;

/**
 * 7200�����һ��accesstoken
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
					//���ô洢�����ݿ�
					TokenUtil.saveToken(accessToken);
					log.info("��ȡaccess_token�ɹ�����Чʱ��{}�� token:{}", accessToken.getExpiresIn(), accessToken.getToken());
					// ����7000��
                    Thread.sleep(7000*1000);
				}else {
					// ���access_tokenΪnull��60����ٻ�ȡ
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