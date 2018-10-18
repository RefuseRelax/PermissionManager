/**
 * 
 */
package com.yy.pm.dao.impl;

import java.util.List;

import com.yy.pm.dao.inter.IInfoUserDao;
import com.yy.pm.dao.inter.IRolePermissionDao;
import com.yy.pm.entity.RolePermission;
import com.yy.pm.util.JDBCManager;

/**
 * @author zk
 *
 */
public class RolePermissionDaoImpl extends BaseDaoImpl<RolePermission> implements IRolePermissionDao<RolePermission> {

	public int insert(RolePermission t) {
		// TODO Auto-generated method stub
		String sql = "insert into role_permission values("+t.getRid()+","+t.getPid()+")";
		JDBCManager jdbc = new JDBCManager();
		int i = jdbc.insert(sql);
		jdbc.close();
		return i;
	}

	public int delete(RolePermission t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(RolePermission t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<RolePermission> query(RolePermission t) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
