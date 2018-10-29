/**
 * 
 */
package com.yy.pm.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yy.pm.dao.inter.IInfoUserDao;
import com.yy.pm.dao.inter.IRolePermissionDao;
import com.yy.pm.entity.RolePermission;
import com.yy.pm.listener.inter.DaoListener;
import com.yy.pm.util.JDBCManager;

/**
 * @author zk
 *
 */
public class RolePermissionDaoImpl extends BaseDaoImpl<RolePermission> implements IRolePermissionDao<RolePermission> {

	public RolePermissionDaoImpl(DaoListener daolistener) {
		super(daolistener);
		// TODO Auto-generated constructor stub
	}
	
	

	public RolePermissionDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int insert(RolePermission t) {
		// TODO Auto-generated method stub
		String sql = "insert into role_permission values("+t.getRid()+","+t.getPid()+")";
		JDBCManager jdbc = new JDBCManager();
		int i = jdbc.insert(sql);
		jdbc.close();
		return i;
	}

	public int delete(RolePermission t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(RolePermission t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<RolePermission> query(RolePermission t) {
		// TODO Auto-generated method stub
		StringBuilder bui = new StringBuilder("select * from role_permission");
		if(null!=t){
			bui.append(" where rid = " + t.getRid());
		}
		List<RolePermission> list = new ArrayList<RolePermission>();
		String sql = bui.toString();
		JDBCManager jdbc  = new JDBCManager();
		ResultSet rs = jdbc.query(sql);
		try {
			while (rs.next()) {
				RolePermission rp = new RolePermission();
				rp.setRid(rs.getLong("rid"));
				rp.setPid(rs.getLong("pid"));
				list.add(rp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbc.close();
		}
		return list;
	}

	public void batchInsert(Long rid,Long[] pids){
		if(null!=rid){
			deleteByRid(rid);
			if(null!=pids){
				String sql = "insert into role_permission values(?,?)";
				JDBCManager jdbc = new JDBCManager();
				PreparedStatement pre = jdbc.getGeneralPreparedStatement(sql);
				try {
					for(Long pid : pids){
						pre.setLong(1, rid);
						pre.setLong(2, pid);
						pre.addBatch();
						//System.out.println(pre);
					}
				    pre.executeBatch();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					jdbc.close();
				}
			}
		}
	};
	
	public void deleteByRid(Long rid){
		String sql = "delete from role_permission where rid = " +rid ;
		JDBCManager jdbc = new  JDBCManager();
		int i = jdbc.delete(sql);
		jdbc.close();
	}

}
