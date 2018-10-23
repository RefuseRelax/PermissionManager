package com.yy.pm.dao.inter;

import com.yy.pm.entity.InfoRole;

public interface IInfoRoleDao<T> extends IBaseDao<T>{

	public Long insertReturnPrimary(InfoRole t);
}
