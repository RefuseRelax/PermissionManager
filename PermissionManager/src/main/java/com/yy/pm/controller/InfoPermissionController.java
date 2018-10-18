/**
 * 
 */
package com.yy.pm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yy.pm.service.impl.InfoPermissionServiceImpl;
import com.yy.pm.service.inter.InfoPermissionService;
import com.yy.pm.vo.InfoPermissionVO;
import com.yy.pm.vo.InfoUserVO;

/**
 * @author zk
 *
 */
@WebServlet(name="permission",urlPatterns="/permission")
public class InfoPermissionController extends HttpServlet {
	
	private InfoPermissionService pservice = new InfoPermissionServiceImpl(); 

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String op = req.getParameter("op");
		if("queryAll".equals(op)){
			queryList(req, resp);
		}
		if("update".equals(op)){
			update(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	public void queryList(HttpServletRequest req, HttpServletResponse resp){
		List<InfoPermissionVO> pers = pservice.getAllPermission();
		System.out.println(pers.toString());
		req.setAttribute("pers", pers);
		try {
			req.getRequestDispatcher("/WEB-INF/views/permission/permission-list.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void update(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(req.getParameter("id"));
		try {
			req.getRequestDispatcher("/WEB-INF/views/permission/permission-update.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
