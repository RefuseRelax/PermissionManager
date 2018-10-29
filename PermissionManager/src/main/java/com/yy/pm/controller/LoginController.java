package com.yy.pm.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yy.pm.entity.InfoUser;
import com.yy.pm.service.impl.InfoPermissionServiceImpl;
import com.yy.pm.service.impl.InfoUserServiceImpl;
import com.yy.pm.service.inter.InfoPermissionService;
import com.yy.pm.service.inter.InfoUserService;
import com.yy.pm.vo.InfoPermissionVO;
import com.yy.pm.vo.InfoUserVO;
import com.yy.pm.websocket.WebSocketService;

@WebServlet(urlPatterns="/login")
public class LoginController extends HttpServlet{
	
	InfoUserService uservice = new InfoUserServiceImpl();
	InfoPermissionService pservice = new 	InfoPermissionServiceImpl();
	
	Map<String,InfoUserVO> loginedUser = null;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		loginedUser  = (Map<String,InfoUserVO>)req.getServletContext().getAttribute("logined");
		String message = null;
		String url = null;
		if(null==username||username==""){
			message = "用户名不能为空";
			url = "/login.jsp";
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}else if(null==password||password==""){
			message = "密码不能为空";
			url = "/login.jsp";
		}else {			
			if(loginedUser.containsKey(username)){
				message = "账户已在其他地方登陆";
				url = "/login.jsp";
			}else{
				InfoUserVO user = uservice.getSimpleUserByUsername(username);
				if(null==user){
					message = "账户不存在";
					url = "/login.jsp";
				}else if(username.equals(user.getUsername())&&password.equals(user.getPassword())){

					List<InfoPermissionVO> loginUserPer = pservice.getPermissionTreeByUid(user.getId());
					user.setPers(loginUserPer);
					session.setAttribute("loginUser", user);
					req.setAttribute("jumpPage", "/index.jsp");
					url = "/header.jsp";
				}else{
					message = "账户或密码错误";
					url = "/login.jsp";
				}
			}
		}	
		req.setAttribute("message", message);
		req.getRequestDispatcher(url).forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		if(null != session.getAttribute("loginUser")){
			req.setAttribute("jumpPage", "/index.jsp");
			req.getRequestDispatcher("/header.jsp").forward(req, resp);
			return;
		}
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}

}
