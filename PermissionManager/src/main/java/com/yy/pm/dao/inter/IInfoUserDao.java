package com.yy.pm.dao.inter;

import com.yy.pm.entity.InfoUser;

public interface IInfoUserDao extends IBaseDao{
	
	public InfoUser getUser(String username);

}
