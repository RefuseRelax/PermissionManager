package com.yy.pm.dao.inter;

import com.yy.pm.entity.InfoUser;

public interface IInfoUserDao<T> extends IBaseDao<T>{
	
	/***
	 * 根据用户账号查询数据
	 * @param username
	 * @return
	 */
	public InfoUser getSimpleUserByUsername(String username);

}
