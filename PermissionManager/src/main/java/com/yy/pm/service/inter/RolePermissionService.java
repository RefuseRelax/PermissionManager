package com.yy.pm.service.inter;

import java.util.List;

import com.yy.pm.vo.RolePermissionVO;

public interface RolePermissionService {

	public void insert(RolePermissionVO vo);
	
	public List<RolePermissionVO> getByRid(Long rid);
	
	public void batchInsert(Long id ,String[] pid);
}
