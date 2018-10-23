/**
 * 
 */
package com.yy.pm.service.impl;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

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

	public List<RolePermissionVO> getByRid(Long rid) {
		// TODO Auto-generated method stub
		RolePermission rp = new RolePermission();
		rp.setRid(rid);
		List<RolePermission> roles = dao.query(rp);
		List<RolePermissionVO> vos = new ArrayList<RolePermissionVO>();
		for(RolePermission r : roles){
			RolePermissionVO vo = new RolePermissionVO();
			try {
				BeanUtils.copyProperties(vo, r);
				vos.add(vo);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return vos;
	}

	/**
	 * 角色id  ,  权限id
	 */
	public void batchInsert(Long id, String[] pid) {
		// TODO Auto-generated method stub
		Long[] pids = null;
		if(null != pid){
			if("undefined".equals(pid[0])){
				pids = new Long[pid.length-1];
				for(int x = 1  ; x < pid.length ; x++){
					pids[x-1] = Long.valueOf(pid[x]);
				}
			}else{
				pids = new Long[pid.length];
				for(int x = 0  ; x < pid.length ; x++){
					pids[x] = Long.valueOf(pid[x]);
				}
			}
		}
		dao.batchInsert(id, pids);
	} 

}
