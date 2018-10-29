/**
 * 
 */
package com.yy.pm.dao.impl;

import java.util.List;

import com.yy.pm.dao.inter.IUserRoleDao;
import com.yy.pm.entity.UserRole;
import com.yy.pm.listener.inter.DaoListener;



/**
 * @author zk
 *
 */
public class UserRoleDaoImpl extends BaseDaoImpl<UserRole> implements IUserRoleDao<UserRole>{

	public UserRoleDaoImpl(DaoListener daolistener) {
		super(daolistener);
		// TODO Auto-generated constructor stub
	}
	
	

	public UserRoleDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int insert(UserRole t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(UserRole t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(UserRole t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<UserRole> query(UserRole t) {
		// TODO Auto-generated method stub
		return null;
	}

}
