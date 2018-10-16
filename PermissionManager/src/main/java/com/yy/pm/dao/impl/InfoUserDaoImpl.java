/**
 * 
 */
package com.yy.pm.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.yy.pm.dao.inter.IInfoUserDao;
import com.yy.pm.entity.InfoUser;
import com.yy.pm.util.JDBCManager;

/**
 * @author zk
 *
 */
public class InfoUserDaoImpl extends BaseDaoImpl implements IInfoUserDao {

	public InfoUser getUser(String username) {
		// TODO Auto-generated method stub
		String sql = "select * from info_user where username=" + username;
		JDBCManager jdbc = new JDBCManager();
		ResultSet rs = jdbc.query(sql);
		InfoUser user = null;
		try {
			while(rs.next()){
			    user = new InfoUser();
				user.setId(rs.getLong(0));
				user.setUsername(rs.getString(1));
				user.setNickname(rs.getString(2));
				user.setPassword(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jdbc.close();
		return user;
	}

}
