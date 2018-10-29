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
			jumpUpdate(req, resp);
		}
		if("add".equals(op)){
			jumpAdd(req, resp);
		}
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String op = req.getParameter("op");
		if("execUpdate".equals(op)){
			execUpdate(req,resp);
		}
		if("execAdd".equals(op)){
			execAdd(req,resp);
		}
	}
	
	/**
	 * 跳转到权限清单页面
	 * @param req
	 * @param resp
	 */
	public void queryList(HttpServletRequest req, HttpServletResponse resp){
		List<InfoPermissionVO> pers = pservice.getAllPermission();
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
	
	/**
	 * 跳转到修改页面
	 * @param req
	 * @param resp
	 */
	private void jumpUpdate(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(req.getParameter("id"));
		InfoPermissionVO vo = pservice.getPerById(id);
		List<InfoPermissionVO> pers = pservice.getAllParentMenu(id);
		req.setAttribute("aps", pers);
		req.setAttribute("per", vo);
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
	
	/**
	 * 执行修改
	 * @param req
	 * @param resp
	 */
	private void execUpdate(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(req.getParameter("id"));
		String pname = req.getParameter("pname");
		String url = req.getParameter("url");
		Long parentId = Long.parseLong(req.getParameter("parentId"));
		Integer isMenu = Integer.parseInt(req.getParameter("isMenu"));
		String description = req.getParameter("description");
		
		InfoPermissionVO vo = new InfoPermissionVO();
		vo.setPname(pname);
		vo.setUrl(url);
		vo.setIsMenu(isMenu);
		vo.setId(id);
		vo.setDescription(description);
		vo.setParentId(parentId);
		pservice.updateById(vo);
		queryList(req, resp);
	}
	
	/**
	 * 跳转到新增页面
	 * @param req
	 * @param resp
	 */
	private void jumpAdd(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		List<InfoPermissionVO> pers = pservice.getAllParentMenu(null);
		req.setAttribute("aps", pers);
		try {
			req.getRequestDispatcher("/WEB-INF/views/permission/permission-add.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/***
	 * 执行新增
	 * @param req
	 * @param resp
	 */
	private void execAdd(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		String pname = req.getParameter("pname");
		String pcode = req.getParameter("pcode");
		String url = req.getParameter("url");
		Long parentId = req.getParameter("parentId").equals("")||req.getParameter("parentId").equals("0")||req.getParameter("parentId")==null?null:Long.parseLong(req.getParameter("parentId"));
		Integer isMenu = Integer.parseInt(req.getParameter("isMenu"));
		String description = req.getParameter("description");
		InfoPermissionVO vo = new InfoPermissionVO();
		vo.setPname(pname);
		vo.setPcode(pcode);
		vo.setUrl(url);
		vo.setIsMenu(isMenu);
		vo.setDescription(description);
		vo.setParentId(parentId);
		pservice.insert(vo);
		queryList(req, resp);
	}

}
