/**
 * 
 */
package com.yy.pm.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.yy.pm.dao.impl.InfoPermissionDaoImpl;
import com.yy.pm.dao.impl.InfoRoleDaoImpl;
import com.yy.pm.dao.impl.InfoUserDaoImpl;
import com.yy.pm.dao.inter.IInfoPermissionDao;
import com.yy.pm.dao.inter.IInfoRoleDao;
import com.yy.pm.dao.inter.IInfoUserDao;
import com.yy.pm.entity.InfoPermission;
import com.yy.pm.entity.InfoUser;
import com.yy.pm.event.DaoAttributeEvent;
import com.yy.pm.listener.impl.DaoLinstenerImpl;
import com.yy.pm.listener.inter.DaoListener;
import com.yy.pm.service.inter.InfoPermissionService;
import com.yy.pm.service.inter.InfoRoleService;
import com.yy.pm.service.inter.InfoUserService;
import com.yy.pm.util.DateUtil;
import com.yy.pm.vo.InfoPermissionVO;

/**
 * @author zk
 *
 */
public class InfoPermissionServiceImpl implements InfoPermissionService{
	
	private IInfoPermissionDao dao = new InfoPermissionDaoImpl();
	


	/**
	 * 插入
	 */
	public void insert(InfoPermissionVO vo) {
		// TODO Auto-generated method stub
		InfoPermission per = new InfoPermission();
		try {
			BeanUtils.copyProperties(per, vo);
			dao.insert(per);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	/**
	 * 根据用户id获取其权限树
	 */
	public List<InfoPermissionVO> getPermissionTreeByUid(Long userId){
		List<InfoPermission> pers = dao.getParentMenuByUId(userId);
		List<InfoPermissionVO> pervos = new ArrayList<InfoPermissionVO>();
		
			try {
				for(InfoPermission per : pers){
					InfoPermissionVO vo = new InfoPermissionVO();
					BeanUtils.copyProperties(vo, per);
					List<InfoPermission> cpers = per.getChildrenPer();
					List<InfoPermissionVO> cpervos = new ArrayList<InfoPermissionVO>();
					for(InfoPermission p : cpers){
						InfoPermissionVO cvo = new InfoPermissionVO();
						BeanUtils.copyProperties(cvo, p);
						cpervos.add(cvo);
					}
					vo.setChildrenPer(cpervos);
					pervos.add(vo);
				}
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return pervos;
	}
	
	/**
	 * 根据id获取所有树状菜单，若无id查询所有
	 */
	public List<InfoPermissionVO> getAllParentMenu(Long id){	
		List<InfoPermission> pers = dao.getAllParentMenu(id);
		List<InfoPermissionVO> pervos = new ArrayList<InfoPermissionVO>();
		try {
			for(InfoPermission per : pers){
				InfoPermissionVO vo = new InfoPermissionVO();
				BeanUtils.copyProperties(vo, per);
				List<InfoPermission> cpers = per.getChildrenPer();
				List<InfoPermissionVO> cpervos = new ArrayList<InfoPermissionVO>();
				for(InfoPermission p : cpers){
					InfoPermissionVO cvo = new InfoPermissionVO();
					BeanUtils.copyProperties(cvo, p);
					cpervos.add(cvo);
				}
				vo.setChildrenPer(cpervos);
				pervos.add(vo);
			}
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pervos;
	}

	/**
	 * 查询所有权限
	 */
	public List<InfoPermissionVO> getAllPermission() {
		// TODO Auto-generated method stub
		List<InfoPermission> pers = dao.query(null);
		List<InfoPermissionVO> pervos = new ArrayList<InfoPermissionVO>();
		try {
			for(InfoPermission per : pers){
				InfoPermissionVO vo = new InfoPermissionVO();
				BeanUtils.copyProperties(vo, per);
				vo.setCreateTime(DateUtil.dateToRoutineStringFormat(per.getCreateTime()));
				pervos.add(vo);
			}
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pervos;
	}
	
	/**
	 * 根据id去权限信息
	 */
	public InfoPermissionVO getPerById(Long id){
		InfoPermission per = dao.getPerById(id);
		InfoPermissionVO vo = new InfoPermissionVO();
		try {
			BeanUtils.copyProperties(vo, per);
			if("null".equals(vo.getUrl())){
				vo.setUrl(null);
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

	/**
	 * 修改权限
	 */
	public void updateById(InfoPermissionVO vo) {
		// TODO Auto-generated method stub
		InfoPermission per = new InfoPermission();
		try {
			BeanUtils.copyProperties(per, vo);
			dao.update(per);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
