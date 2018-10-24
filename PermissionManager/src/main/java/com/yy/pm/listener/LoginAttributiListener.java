/**
 * 
 */
package com.yy.pm.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.yy.pm.vo.InfoUserVO;

/**
 * @author zk
 *
 */
@WebListener
public class LoginAttributiListener implements HttpSessionAttributeListener,ServletContextListener {

	private ServletContext context; 
	
	private Map<String,InfoUserVO> map = new HashMap<String,InfoUserVO>();
	
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		context = sce.getServletContext();
		context.setAttribute("logined", map);
	}
		
	public void contextDestroyed(ServletContextEvent sce) {
			// TODO Auto-generated method stub
	}	
	
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
//		String name = event.getName();
//		InfoUserVO user = (InfoUserVO)event.getSession().getAttribute("loginUser");
//		System.out.println(user);
//		String username = user.getUsername();
//		if("loginUser".equals(name)){
//			map.remove(username);
//			context.setAttribute("logined", map);
//		}
		System.out.println("已移除");
	}
	
	public void attributeAdded(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		String name = event.getName();
		InfoUserVO user = (InfoUserVO)event.getSession().getAttribute("loginUser");
		String username = user.getUsername();
		if("loginUser".equals(name)){
			map.put(username, user);
			context.setAttribute("logined", map);
		}
	}
	
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		//HttpSessionAttributeListener.super.attributeReplaced(event);
	}
}
