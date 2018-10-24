/**
 * 
 */
package com.yy.pm.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yy.pm.entity.InfoPermission;
import com.yy.pm.service.impl.InfoPermissionServiceImpl;
import com.yy.pm.service.impl.InfoRoleServiceImpl;
import com.yy.pm.service.impl.InfoUserServiceImpl;
import com.yy.pm.service.impl.RolePermissionServiceImpl;
import com.yy.pm.service.inter.InfoPermissionService;
import com.yy.pm.service.inter.InfoRoleService;
import com.yy.pm.service.inter.InfoUserService;
import com.yy.pm.service.inter.RolePermissionService;
import com.yy.pm.util.DateUtil;
import com.yy.pm.vo.InfoPermissionVO;
import com.yy.pm.vo.InfoRoleVO;
import com.yy.pm.vo.InfoUserVO;
import com.yy.pm.vo.RolePermissionVO;

/**
 * @author zk
 *
 */
@WebServlet(urlPatterns="/InitData")
public class InitDataController extends HttpServlet{
	
	private InfoUserService uservice = new InfoUserServiceImpl();
	private InfoRoleService rservice = new InfoRoleServiceImpl();
	private InfoPermissionService pservice = new InfoPermissionServiceImpl();
    private RolePermissionService rpservice = new RolePermissionServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		uservice.truncate();
		System.out.println("haha");
		updatePerTable();
		updateRPTABLE();
		updateRoleTable();
		updateUserTable();
	}
	
	public void updatePerTable(){
		System.out.println("haha");
		InfoPermissionVO pvo = new InfoPermissionVO();
		pvo.setPname("系统管理");
		pvo.setPcode("SYSTEM_MANAGE");
		pvo.setParentId(null);
		pvo.setUrl(null);
		pvo.setIsMenu(1);
		pvo.setDescription("系统管理");
		//pvo.setCreateTime(DateUtil.dateToRoutineStringFormat(new Date()));
		//pvo.setUpdateTime(DateUtil.dateToRoutineStringFormat(new Date()));
		pservice.insert(pvo);
		
		InfoPermissionVO pvo1 = new InfoPermissionVO();
		pvo1.setPname("用户管理");
		pvo1.setPcode("USER_MANAGE");
		pvo1.setParentId(1l);
		pvo1.setUrl("/user?op=queryAll");
		pvo1.setIsMenu(0);
		pvo1.setDescription("用户管理");
		//setCreateTime(new Date());
		//pvo1.setUpdateTime(new Date());
		pservice.insert(pvo1);
		
		InfoPermissionVO pvo2 = new InfoPermissionVO();
		pvo2.setPname("角色管理");
		pvo2.setPcode("ROLE_MANAGE");
		pvo2.setParentId(1l);
		pvo2.setUrl("/role?op=queryAll");
		pvo2.setIsMenu(0);
		pvo2.setDescription("角色管理");
		//pvo2.setCreateTime(new Date());
		//pvo2.setUpdateTime(new Date());
		pservice.insert(pvo2);
		
		InfoPermissionVO pvo3 = new InfoPermissionVO();
		pvo3.setPname("权限管理");
		pvo3.setPcode("PERMISSION_MANAGE");
		pvo3.setParentId(1l);
		pvo3.setUrl("/permission?op=queryAll");
		pvo3.setIsMenu(0);
		pvo3.setDescription("权限管理");
		//pvo3.setCreateTime(new Date());
		//pvo3.setUpdateTime(new Date());
		pservice.insert(pvo3);
	}

	public void updateRPTABLE(){
		RolePermissionVO rpvo = new RolePermissionVO();
		rpvo.setRid(1l);
		rpvo.setPid(1l);
		rpservice.insert(rpvo);
		
		RolePermissionVO rpvo1 = new RolePermissionVO();
		rpvo1.setRid(1l);
		rpvo1.setPid(2l);
		rpservice.insert(rpvo1);
		
		RolePermissionVO rpvo2 = new RolePermissionVO();
		rpvo2.setRid(1l);
		rpvo2.setPid(3l);
		rpservice.insert(rpvo2);
		
		RolePermissionVO rpvo3 = new RolePermissionVO();
		rpvo3.setRid(1l);
		rpvo3.setPid(4l);
		rpservice.insert(rpvo3);
	}

	public void updateRoleTable(){
		InfoRoleVO rvo = new InfoRoleVO();
		rvo.setRname("超级管理员");
		rvo.setRcode("SUPER_MANAGER");
		rvo.setRdescription("超级管理员");
		//rvo.setCreateTime(new Date());
		//rvo.setUpdateTime(new Date());
		rservice.insert(rvo);
	}

	public void updateUserTable(){
		InfoUserVO uvo = new InfoUserVO();
		uvo.setUsername("admin");
		uvo.setNickname("一号");
		uvo.setPassword("111111");
		uvo.setStatus(1);
		uvo.setAddress("安徽");
		uvo.setPhone("133333333");
		uvo.setQq("12456789");
		uvo.setRoleId(1l);
		uvo.setSex(1);
		uvo.setCreateTime(new Date());
		uvo.setUpdateTime(new Date());
		uservice.insert(uvo);
		
		InfoUserVO uvo1 = new InfoUserVO();
		uvo.setUsername("system");
		uvo.setNickname("二号");
		uvo.setPassword("111111");
		uvo.setStatus(1);
		uvo.setAddress("安徽");
		uvo.setPhone("133333333");
		uvo.setQq("12456789");
		uvo.setRoleId(5l);
		uvo.setSex(1);
		uvo.setCreateTime(new Date());
		uvo.setUpdateTime(new Date());
		uservice.insert(uvo);
	}
}
