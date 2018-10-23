/**
 * 
 */
package com.yy.pm.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yy.pm.dao.inter.IInfoRoleDao;
import com.yy.pm.entity.InfoRole;
import com.yy.pm.util.DateUtil;
import com.yy.pm.util.JDBCManager;

/**
 * @author zk
 *
 */
public class InfoRoleDaoImpl extends BaseDaoImpl<InfoRole> implements IInfoRoleDao<InfoRole> {

	/**
	 * 插入返回主键
	 */
	public Long insertReturnPrimary(InfoRole t) {
		// TODO Auto-generated method stub
		String sql = "insert into info_role values(null,?,?,?,?,?)";
		JDBCManager jdbc = new JDBCManager();
		PreparedStatement pre = jdbc.getReturnPrimaryPreparedStatement(sql);
		Long id = null;
		try {
			pre.setString(1, t.getRname());
			pre.setString(2, t.getRcode());
			pre.setString(3, t.getRdescription());
			pre.setTimestamp(4, Timestamp.valueOf(DateUtil.dateToRoutineStringFormat(new Date())));
			pre.setTimestamp(5, Timestamp.valueOf(DateUtil.dateToRoutineStringFormat(new Date())));
			pre.addBatch();
			pre.executeBatch();
			ResultSet rs = pre.getGeneratedKeys();
			while(rs.next()){
				id = rs.getLong(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		jdbc.close();
		return id;
	}

	public int delete(InfoRole t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(InfoRole t) {
		// TODO Auto-generated method stub
		String sql = "update info_role set rname='"+t.getRname()+"',description='"+t.getRdescription()+"',update_time='"+Timestamp.valueOf(DateUtil.dateToRoutineStringFormat(new Date()))+"' where id=" + t.getId();
		JDBCManager jdbc = new JDBCManager();
		int i = jdbc.update(sql);
		jdbc.close();
		return i;
	}

	public List<InfoRole> query(InfoRole t) {
		// TODO Auto-generated method stub
		StringBuilder bui = new StringBuilder("select * from info_role");
		if(null!=t){
			if(null!=t.getId()){
				bui.append("  where id = " + t.getId());
			}
		}
		String sql = bui.toString();
		//System.out.println("sql:::"+sql);
		JDBCManager jdbc = new JDBCManager();
		ResultSet rs = jdbc.query(sql);
		List<InfoRole> roles = new ArrayList<InfoRole>();
		try {
			while(rs.next()){
				InfoRole r = new InfoRole();
				r.setId(rs.getLong("id"));
				r.setRname(rs.getString("rname"));
				r.setRcode(rs.getString("rcode"));
				r.setRdescription(rs.getString("description"));
				r.setCreateTime(rs.getTimestamp("create_time"));
				//System.out.println(r.toString());
				roles.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbc.close();
		}
		return roles;
	}

	public int insert(InfoRole t) {
		// TODO Auto-generated method stub
		String sql = "insert into info_role values(null,'"+t.getRname()+"','"+t.getRcode()+"','"+t.getRdescription()+"','"+Timestamp.valueOf(DateUtil.dateToRoutineStringFormat(new Date()))+"','"+Timestamp.valueOf(DateUtil.dateToRoutineStringFormat(new Date()))+"')";
		JDBCManager jdbc = new JDBCManager();
		int i = jdbc.insert(sql);
		jdbc.close();
		return i;
	}

}
