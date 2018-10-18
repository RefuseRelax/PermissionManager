/**
 * 
 */
package com.yy.pm.service.impl;


import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.yy.pm.dao.impl.RolePermissionDaoImpl;
import com.yy.pm.dao.inter.IRolePermissionDao;
import com.yy.pm.entity.RolePermission;
import com.yy.pm.service.inter.RolePermissionService;
import com.yy.pm.vo.RolePermissionVO;

/**
 * @author zk
 *
 */
public class RolePermissionServiceImpl implements RolePermissionService{
	
	private IRolePermissionDao dao = new RolePermissionDaoImpl();

	public void insert(RolePermissionVO vo) {
		// TODO Auto-generated method stub
		RolePermission rp = new RolePermission();
		try {
			BeanUtils.copyProperties(rp, vo);
			dao.insert(rp);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 

}
