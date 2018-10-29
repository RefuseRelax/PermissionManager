/**
 * 
 */
package com.yy.pm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.HashedMap;

import com.alibaba.fastjson.JSON;
import com.yy.pm.entity.InfoRole;
import com.yy.pm.service.impl.InfoPermissionServiceImpl;
import com.yy.pm.service.impl.InfoRoleServiceImpl;
import com.yy.pm.service.impl.RolePermissionServiceImpl;
import com.yy.pm.service.inter.InfoPermissionService;
import com.yy.pm.service.inter.InfoRoleService;
import com.yy.pm.service.inter.RolePermissionService;
import com.yy.pm.vo.InfoPermissionVO;
import com.yy.pm.vo.InfoRoleVO;
import com.yy.pm.vo.RolePermissionVO;
import com.yy.pm.vo.Tree;

/**
 * @author zk
 *
 */
@WebServlet(name="Role",urlPatterns="/role")
public class InfoRoleController extends HttpServlet{
	
	private HttpSession session;
	
	private InfoRoleService rservice =  new InfoRoleServiceImpl();
	
	private InfoPermissionService pservice = new InfoPermissionServiceImpl(); 
	
	private RolePermissionService rpservice = new RolePermissionServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String op = req.getParameter("op");
		if("execTree".equals(op)){
			tree(req,resp);
		}
		if("execUpdate".equals(op)){
			execUpdate(req,resp);
		}
		if("execAdd".equals(op)){
			execAdd(req,resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String op = req.getParameter("op");
		if("queryAll".equals(op)){
			list(req,resp);
		}
		if("update".equals(op)){
			jumpUpdate(req,resp);
		}
		if("add".equals(op)){
			jumpAdd(req,resp);
		}
	}
	

	/**
	 * 执行新增
	 * @param req
	 * @param resp
	 */
	private void execAdd(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		//Long id = Long.parseLong(req.getParameter("id"));
		String description = req.getParameter("description");
		String[] rps = req.getParameterValues("rolepers");
		String rname = req.getParameter("rname");
		String rcode = req.getParameter("rcode");
		InfoRoleVO vo = new InfoRoleVO();
		vo.setRname(rname);
		vo.setRcode(rcode);
		vo.setRdescription(description);
		Long id = rservice.insertReturnPrimary(vo);
		rpservice.batchInsert(id, rps);
		list(req, resp);
	}
	
	/**
	 * 跳转角色新增页面
	 * @param req
	 * @param resp
	 */
	private void jumpAdd(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			req.getRequestDispatcher("/WEB-INF/views/role/role-add.jsp").forward(req, resp);
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
		String description = req.getParameter("description");
		String[] rps = req.getParameterValues("rolepers");
		String rname = req.getParameter("rname");
		String rcode = req.getParameter("rcode");
		InfoRoleVO vo = new InfoRoleVO();
		vo.setId(id);
		vo.setRname(rname);
		vo.setRcode(rcode);
		vo.setRdescription(description);
		rservice.update(vo);
		rpservice.batchInsert(id, rps);
		list(req, resp);
	}

	/**
	 * 跳转角色修改页面
	 * @param req
	 * @param resp
	 */
	private void jumpUpdate(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
		Long id = Long.parseLong(req.getParameter("id")==""||req.getParameter("id")==null?null:req.getParameter("id"));
		InfoRoleVO vo = rservice.getRoleById(id);
		req.setAttribute("role",vo);
		try {
			req.getRequestDispatcher("/WEB-INF/views/role/role-update.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * 角色清单
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void list(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		List<InfoRoleVO> roles = rservice.queryAll();
		req.setAttribute("roles", roles);
		try {
			req.getRequestDispatcher("/WEB-INF/views/role/role-list.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 权限树，共角色选择
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void tree(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		List<InfoPermissionVO> vos = pservice.getAllParentMenu(null);
		Long id = req.getParameter("id")==""||req.getParameter("id")==null?null:Long.parseLong(req.getParameter("id"));
		List<RolePermissionVO> rpvos = null;
		if(null!=id){
			 rpvos = rpservice.getByRid(id);
		}
		List<Tree> trees = new ArrayList<Tree>();
		int count = 0;
		if(null!=vos){
			for(InfoPermissionVO vo : vos){
				Tree t = new Tree();
				t.setNodeId(vo.getId()+count*100);
				t.setParentId(0l);
				t.setChechboxName(vo.getPcode());
				t.setChechboxVal(vo.getId());
				t.setCheckboxShow(vo.getPname());
				t.setIsCheck(isCheck(vo.getId(), rpvos));
				t.setUse(false);
				trees.add(t);
				List<InfoPermissionVO> c = vo.getChildrenPer();
				for(InfoPermissionVO pvo : c){
					Tree ct = new Tree();
					ct.setNodeId(pvo.getId()+count*100);
					ct.setParentId(pvo.getParentId()+count*100);
					ct.setChechboxName(pvo.getPname());
					ct.setChechboxVal(pvo.getId());
					ct.setCheckboxShow(pvo.getPname());
					ct.setIsCheck(isCheck(pvo.getId(),rpvos));
					ct.setUse(false);
					trees.add(ct);
				}
				count++;
			}
		}
		
		resp.setContentType("application/json;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.write(JSON.toJSONString(trees));
		out.flush();
		out.close();
	}
	
	/**
	 * 判断是否选中
	 * @param id
	 * @param pid 权限id
	 * @param rpvos 角色权限对应id集合
	 * @return
	 */
	public boolean isCheck(Long pid,List<RolePermissionVO> rpvos){
		boolean is = false;
		if(null!=rpvos){
			for(RolePermissionVO v : rpvos){
				if(pid == v.getPid()){
					is = true;
					break;
				}
			}
		}
		return is;
	}

}
