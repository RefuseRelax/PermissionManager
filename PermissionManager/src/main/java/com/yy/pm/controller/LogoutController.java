package com.yy.pm.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yy.pm.vo.InfoUserVO;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		InfoUserVO user = (InfoUserVO)session.getAttribute("loginUser");
		if(null!=user){
			ServletContext context = req.getServletContext();
			Map<String,InfoUserVO> map = (Map<String,InfoUserVO>)context.getAttribute("logined");
			map.remove(user.getUsername());
			context.setAttribute("logined", map);
			session.removeAttribute("loginUser");
			session.invalidate();
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
