package com.yy.pm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yy.pm.entity.InfoUser;
import com.yy.pm.service.impl.InfoUserServiceImpl;
import com.yy.pm.service.inter.InfoUserService;

@WebServlet(urlPatterns="/login")
public class LoginController extends HttpServlet{
	
	InfoUserService uservice = new InfoUserServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		//InfoUser  user = uservice.getUser(username);
		if(username.equals("111")){
			if(password.equals("111")){
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
