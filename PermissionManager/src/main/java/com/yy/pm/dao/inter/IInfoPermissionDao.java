package com.yy.pm.dao.inter;

import java.util.List;

import com.yy.pm.entity.InfoPermission;

public interface IInfoPermissionDao<T> extends IBaseDao<T>{
	
	/**
	 * 根据角色id查找相应的父级权限
	 * @return
	 */
	public List<InfoPermission> getParentMenuByUId(Long userId);
	
	/**
	 * 根据角色id查找相应的父级权限下的子集权限
	 * @return
	 */
	public List<InfoPermission> getChildrenMenuByUId(Long userId,Long parentId);
	
	/**
	 * 根据id查找相应的权限
	 * @return
	 */
	public InfoPermission getPerById(Long id);
	

	/**
	 * 获取所有一级菜单
	 * @return
	 */
	public List<InfoPermission> getAllParentMenu(); 

}
