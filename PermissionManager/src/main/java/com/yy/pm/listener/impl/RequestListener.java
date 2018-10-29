/**
 * 
 */
package com.yy.pm.listener.impl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;


/**
 * @author zk
 *
 */
@WebListener
public class RequestListener implements ServletRequestListener{
	
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		((HttpServletRequest)sre.getServletRequest()).getSession();
	}
	
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		
	}
	
}
