/**
 * 
 */
package com.yy.pm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author zk
 *
 */
@WebFilter(filterName="loginFilter",urlPatterns="/*")
public class LoginFilter implements Filter{

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		String s = req.getRequestURI();
		HttpSession session = req.getSession();
		Object user = session.getAttribute("loginUser");
		if(s.endsWith("/")||s.endsWith("login")||s.endsWith("/static")||s.startsWith("/img")||s.startsWith("/assets")||s.endsWith("InitData")){
			chain.doFilter(req, resp);
		}else if(null!=user){
			chain.doFilter(req, resp);
		}else{
			resp.sendRedirect("/login");
		}
	}
	
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
