/**
 * 
 */
package com.yy.pm.service.impl;

import com.yy.pm.dao.impl.InfoUserDaoImpl;
import com.yy.pm.dao.inter.IInfoUserDao;
import com.yy.pm.entity.InfoUser;
import com.yy.pm.service.inter.InfoUserService;

/**
 * @author zk
 *
 */
public class InfoUserServiceImpl implements InfoUserService{
	
	private IInfoUserDao dao = new InfoUserDaoImpl(); 

	public InfoUser getUser(String username) {
		// TODO Auto-generated method stub
		return dao.getUser(username);
	}

}
