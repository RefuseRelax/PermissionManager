/**
 * 
 */
package com.yy.pm.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yy.pm.dao.inter.IInfoPermissionDao;
import com.yy.pm.entity.InfoPermission;
import com.yy.pm.util.DateUtil;
import com.yy.pm.util.JDBCManager;

/**权限持久层
 * @author zk
 *
 */
public class InfoPermissionDaoImpl extends BaseDaoImpl<InfoPermission> implements IInfoPermissionDao<InfoPermission> {

	/**
	 * 插入
	 */
	public int insert(InfoPermission t) {
		// TODO Auto-generated method stub
		String sql = "insert into info_permission values(null,'"+t.getPname()+"','"+t.getPcode()+"','"+t.getUrl()+"',"+t.getIsMenu()+","+t.getParentId()+",'"+t.getDescription()+"','"+Timestamp.valueOf(DateUtil.dateToRoutineStringFormat(new Date()))+"','"+Timestamp.valueOf(DateUtil.dateToRoutineStringFormat(new Date()))+"')";
		JDBCManager jdbc = new JDBCManager();
		int i = jdbc.insert(sql);
		jdbc.close();
		return i;
	}

	/**
	 * 删除
	 */
	public int delete(InfoPermission t) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 修改
	 */
	public int update(InfoPermission t) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 查询
	 */
	public List<InfoPermission> query(InfoPermission t) {
		// TODO Auto-generated method stub
		String sql = "select * from info_permission";
		List<InfoPermission> list = new ArrayList<InfoPermission>();
		JDBCManager jdbc = new JDBCManager();
		ResultSet rs = jdbc.query(sql);
		try {
			while(rs.next()){
				InfoPermission per = new InfoPermission();
				per.setId(rs.getLong("id"));
				per.setPname(rs.getString("pname"));
				per.setPcode(rs.getString("pcode"));
				per.setUrl(rs.getString("url"));
				per.setIsMenu(rs.getString("is_menu"));
				per.setDescription(rs.getString("description"));
				per.setParentId(rs.getLong("parent_id"));
				per.setCreateTime(rs.getTimestamp("create_time"));
				per.setUpdateTime(rs.getTimestamp("update_time"));
				//per.setChildrenPer(getChildrenMenuByUId(userId,rs.getLong("id")));
				list.add(per);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jdbc.close();
		return list;
	}

	/**
	 * 根据角色id查找相应的父级权限
	 * @return
	 */
	@SuppressWarnings("finally")
	public List<InfoPermission> getParentMenuByUId(Long userId) {
		// TODO Auto-generated method stub
		String sql = "select * from info_user u , info_permission p,role_permission rp where u.id = "+userId+" and u.role_id = rp.rid and  rp.pid = p.id and  p.parent_id is null";
		JDBCManager jdbc = new JDBCManager();
		List<InfoPermission> list = new ArrayList<InfoPermission>();
		ResultSet rs = jdbc.query(sql);
		try {
			while(rs.next()){
				InfoPermission per = new InfoPermission();
				per.setId(rs.getLong("id"));
				per.setPname(rs.getString("pname"));
				per.setPcode(rs.getString("pcode"));
				per.setUrl(rs.getString("url"));
				per.setIsMenu(rs.getString("is_menu"));
				per.setDescription(rs.getString("description"));
				per.setParentId(rs.getLong("parent_id"));
				per.setCreateTime(rs.getTimestamp("create_time"));
				per.setUpdateTime(rs.getTimestamp("update_time"));
				per.setChildrenPer(getChildrenMenuByUId(userId,rs.getLong("id")));
				list.add(per);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbc.close();
			return list;
		}
	}
	
	
	/**
	 * 根据角色id查找相应的父级权限下的子集权限
	 * @return
	 */
	public List<InfoPermission> getChildrenMenuByUId(Long userId,Long parentId) {
		// TODO Auto-generated method stub
		String sql = "select * from info_user u, info_permission p,role_permission rp where u.id = "+userId+" and u.role_id = rp.rid  and rp.pid = p.id and  p.parent_id =" + parentId;
		JDBCManager jdbc = new JDBCManager();
		List<InfoPermission> list = new ArrayList<InfoPermission>();
		ResultSet rs = jdbc.query(sql);
		try {
			while(rs.next()){
				InfoPermission per = new InfoPermission();
				per.setId(rs.getLong("id"));
				per.setPname(rs.getString("pname"));
				per.setPcode(rs.getString("pcode"));
				per.setUrl(rs.getString("url"));
				per.setIsMenu(rs.getString("is_menu"));
				per.setDescription(rs.getString("description"));
				per.setParentId(rs.getLong("parent_id"));
				per.setCreateTime(rs.getTimestamp("create_time"));
				per.setUpdateTime(rs.getTimestamp("update_time"));
				list.add(per);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public InfoPermission getPerById(Long id){
		String sql = "select * from info_permission where id = " + id;
		JDBCManager jdbc = new JDBCManager();
		ResultSet rs = jdbc.query(sql);
		InfoPermission per = new InfoPermission();
		try {
			while(rs.next()){
				per.setId(rs.getLong("id"));
				per.setPname(rs.getString("pname"));
				per.setPcode(rs.getString("pcode"));
				per.setUrl(rs.getString("url"));
				per.setIsMenu(rs.getString("is_menu"));
				per.setDescription(rs.getString("description"));
				per.setParentId(rs.getLong("parent_id"));
				per.setCreateTime(rs.getTimestamp("create_time"));
				per.setUpdateTime(rs.getTimestamp("update_time"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jdbc.close();
		return per;
	}

	/**
	 * 获取所有一级菜单
	 * @return
	 */
	@SuppressWarnings("finally")
	public List<InfoPermission> getAllParentMenu() {
		// TODO Auto-generated method stub
		String sql = "select * from info_permission p where  p.parent_id is null";
		JDBCManager jdbc = new JDBCManager();
		List<InfoPermission> list = new ArrayList<InfoPermission>();
		ResultSet rs = jdbc.query(sql);
		try {
			while(rs.next()){
				InfoPermission per = new InfoPermission();
				per.setId(rs.getLong("id"));
				per.setPname(rs.getString("pname"));
				per.setPcode(rs.getString("pcode"));
				per.setUrl(rs.getString("url"));
				per.setIsMenu(rs.getString("is_menu"));
				per.setDescription(rs.getString("description"));
				per.setParentId(rs.getLong("parent_id"));
				per.setCreateTime(rs.getTimestamp("create_time"));
				per.setUpdateTime(rs.getTimestamp("update_time"));
				//per.setChildrenPer(getChildrenMenuByUId(userId,rs.getLong("id")));
				list.add(per);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbc.close();
			return list;
		}
	}
	
}
