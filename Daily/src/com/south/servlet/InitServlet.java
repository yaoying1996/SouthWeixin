package com.south.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.south.thread.TokenThread;
import com.south.util.WeixinUtil;

/**
 * 每隔7200s不断获取access_token
 * @author yao
 *
 */
@WebServlet(urlPatterns= {"/init.do"}, loadOnStartup=0)
public class InitServlet extends HttpServlet{

	
	private static Logger log=LoggerFactory.getLogger(WeixinUtil.class);
	
	public void init() {
		// 启动定时获取access_token的线程
		new Thread(new TokenThread()).start();
	}
}
