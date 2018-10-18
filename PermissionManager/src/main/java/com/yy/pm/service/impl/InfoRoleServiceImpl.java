/**
 * 
 */
package com.yy.pm.service.impl;

import com.yy.pm.dao.impl.InfoRoleDaoImpl;
import com.yy.pm.dao.impl.InfoUserDaoImpl;
import com.yy.pm.dao.inter.IInfoRoleDao;
import com.yy.pm.dao.inter.IInfoUserDao;
import com.yy.pm.entity.InfoUser;
import com.yy.pm.service.inter.InfoRoleService;
import com.yy.pm.service.inter.InfoUserService;
import com.yy.pm.vo.InfoRoleVO;

/**
 * @author zk
 *
 */
public class InfoRoleServiceImpl implements InfoRoleService{
	
	private IInfoRoleDao dao = new InfoRoleDaoImpl();

	public void insert(InfoRoleVO vo) {
		// TODO Auto-generated method stub
		
	} 

}
