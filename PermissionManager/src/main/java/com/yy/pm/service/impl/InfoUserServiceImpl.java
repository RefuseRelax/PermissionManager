/**
 * 
 */
package com.yy.pm.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.yy.pm.dao.impl.InfoUserDaoImpl;
import com.yy.pm.dao.inter.IInfoUserDao;
import com.yy.pm.entity.InfoUser;
import com.yy.pm.service.inter.InfoUserService;
import com.yy.pm.util.JDBCManager;
import com.yy.pm.vo.InfoUserVO;

/**
 * @author zk
 *
 */
public class InfoUserServiceImpl implements InfoUserService{
	
	private IInfoUserDao dao = new InfoUserDaoImpl(); 

	/**
	 * 根据用户账号获取该用户数据
	 */
	public InfoUserVO getSimpleUserByUsername(String username) {
		// TODO Auto-generated method stub
		InfoUser user = dao.getSimpleUserByUsername(username);
		InfoUserVO vo = new InfoUserVO(); 
		try {
			if(null!=user){
				BeanUtils.copyProperties(vo, user);
			}
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}

	public void insert(InfoUserVO vo) {
		// TODO Auto-generated method stub
		InfoUser user = new InfoUser();
		System.out.println(vo);
		try {
			BeanUtils.copyProperties(user, vo);
			dao.insert(user);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void truncate() {
		// TODO Auto-generated method stub
		String sql = "truncate table info_user";
		String sql1 = "truncate table info_permission";
		String sql2 = "truncate table info_role";
		String sql3 = "truncate table role_permission";
		JDBCManager jdbc = new JDBCManager();
		jdbc.update(sql);
		jdbc.update(sql1);
		jdbc.update(sql2);
		jdbc.update(sql3);
		jdbc.close();
	}

}
