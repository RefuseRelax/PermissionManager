/**
 * 
 */
package com.yy.pm.dao.impl;

import java.util.List;

import com.yy.pm.dao.inter.IBaseDao;
import com.yy.pm.listener.inter.DaoListener;

/**
 * @author zk
 *
 */
public abstract class BaseDaoImpl<T> implements IBaseDao<T> {
	
	private DaoListener daolistener;

	public BaseDaoImpl(DaoListener daolistener) {
		super();
		this.daolistener = daolistener;
	}

	public BaseDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DaoListener getDaolistener() {
		return daolistener;
	}

	public void setDaolistener(DaoListener daolistener) {
		this.daolistener = daolistener;
	}
	
	
	
	
	
//
//	public int insert(T t) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	public int delete(T t) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	public int update(T t) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	public List query(T t) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
