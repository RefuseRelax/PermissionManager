package com.yy.pm.service.inter;

import java.util.List;

import com.yy.pm.entity.InfoRole;
import com.yy.pm.vo.InfoRoleVO;

public interface InfoRoleService {

	public void insert(InfoRoleVO vo);
	
	public List<InfoRoleVO> queryAll();
	
	public InfoRoleVO getRoleById(Long id);
	
	public void update(InfoRoleVO vo);
	
	public Long insertReturnPrimary(InfoRoleVO vo);
}
