/**
 * 
 */
package com.yy.pm.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.yy.pm.dao.impl.InfoRoleDaoImpl;
import com.yy.pm.dao.impl.InfoUserDaoImpl;
import com.yy.pm.dao.inter.IInfoRoleDao;
import com.yy.pm.dao.inter.IInfoUserDao;
import com.yy.pm.entity.InfoRole;
import com.yy.pm.entity.InfoUser;
import com.yy.pm.service.inter.InfoRoleService;
import com.yy.pm.service.inter.InfoUserService;
import com.yy.pm.util.DateUtil;
import com.yy.pm.vo.InfoRoleVO;

/**
 * @author zk
 *
 */
public class InfoRoleServiceImpl implements InfoRoleService{
	
	private IInfoRoleDao dao = new InfoRoleDaoImpl();

	public void insert(InfoRoleVO vo) {
		// TODO Auto-generated method stub
		InfoRole role = new InfoRole();
		try {
			BeanUtils.copyProperties(role, vo);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao.insert(role);
	}
	
	/**
	 * 插入返回主键
	 * @param vo
	 * @return
	 */
	public Long insertReturnPrimary(InfoRoleVO vo) {
		// TODO Auto-generated method stub
		InfoRole role = new InfoRole();
		try {
			BeanUtils.copyProperties(role, vo);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Long id = dao.insertReturnPrimary(role);
		return id;
	}

	public List<InfoRoleVO> queryAll() {
		// TODO Auto-generated method stub
		List<InfoRole> roles = dao.query(null);
		//System.out.println(roles);
		List<InfoRoleVO> vos = new ArrayList<InfoRoleVO>();
		for(InfoRole r : roles){
			InfoRoleVO vo = new InfoRoleVO();
			try {
				BeanUtils.copyProperties(vo, r);
				vo.setCreateTime(DateUtil.dateToRoutineStringFormat(r.getCreateTime()));
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			vos.add(vo);
		}
		return vos;
	}

	public InfoRoleVO getRoleById(Long id) {
		// TODO Auto-generated method stub
		InfoRoleVO vo = new InfoRoleVO();
		InfoRole r = new InfoRole();
		r.setId(id);
		List<InfoRole> roles = dao.query(r);
		for(InfoRole role : roles){
			try {
				BeanUtils.copyProperties(vo, role);
				
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return vo;
	}

	public void update(InfoRoleVO vo) {
		// TODO Auto-generated method stub
		InfoRole role = new InfoRole();
		if(null!=vo){
			try {
				BeanUtils.copyProperties(role, vo);
				dao.update(role);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} 

}
