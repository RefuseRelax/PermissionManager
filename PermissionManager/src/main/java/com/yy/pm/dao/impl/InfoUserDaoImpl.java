/**
 * 
 */
package com.yy.pm.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.yy.pm.dao.inter.IInfoUserDao;
import com.yy.pm.entity.InfoPermission;
import com.yy.pm.entity.InfoUser;
import com.yy.pm.listener.inter.DaoListener;
import com.yy.pm.util.DateUtil;
import com.yy.pm.util.JDBCManager;

/**
 * @author zk
 *
 */
public class InfoUserDaoImpl extends BaseDaoImpl<InfoUser> implements IInfoUserDao<InfoUser> {

	public InfoUserDaoImpl(DaoListener daolistener) {
		super(daolistener);
		// TODO Auto-generated constructor stub
	}
	
	

	public InfoUserDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}



	public InfoUser getSimpleUserByUsername(String username) {
		// TODO Auto-generated method stub
		String sql = "select * from info_user where username = '" + username+"'";
		JDBCManager jdbc = new JDBCManager();
		ResultSet rs = jdbc.query(sql);
		InfoUser user = null;
		try {
			while(rs.next()){
			    user = new InfoUser();
				user.setId(rs.getLong("id"));
				user.setUsername(rs.getString("username"));
				user.setNickname(rs.getString("nickname"));
				user.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jdbc.close();
		return user;
	}

	public int insert(InfoUser t) {
		// TODO Auto-generated method stub
		String sql = "insert into info_user values(null,'"+t.getUsername()+"','"+t.getNickname()+"','"+t.getPassword()+"',"+t.getSex()+",'"+t.getQq()+"',"+t.getStatus()+",'"+t.getPhone()+"','"+t.getAddress()+"',"+t.getRoleId()+",'"+Timestamp.valueOf(DateUtil.dateToRoutineStringFormat(t.getCreateTime()))+"','"+Timestamp.valueOf(DateUtil.dateToRoutineStringFormat(t.getUpdateTime()))+"')";
		JDBCManager jdbc = new JDBCManager();
		int i = jdbc.insert(sql);
		jdbc.close();
		return i;
	}

	public int delete(InfoUser t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(InfoUser t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<InfoUser> query(InfoUser t) {
		// TODO Auto-generated method stub
		return null;
	}

}
