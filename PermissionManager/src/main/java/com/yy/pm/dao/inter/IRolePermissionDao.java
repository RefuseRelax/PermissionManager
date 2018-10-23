package com.yy.pm.dao.inter;

public interface IRolePermissionDao<T> extends IBaseDao<T>{

	public void batchInsert(Long rid,Long[] pid);
	
	public void deleteByRid(Long rid);
}
