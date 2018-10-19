package com.yy.pm.service.inter;

import java.util.List;

import com.yy.pm.entity.InfoPermission;
import com.yy.pm.vo.InfoPermissionVO;

public interface InfoPermissionService {

	public void insert(InfoPermissionVO vo);
	
	public List<InfoPermissionVO> getPermissionTreeByUid(Long userId);
	
	public List<InfoPermissionVO> getAllPermission();
	
	public InfoPermissionVO getPerById(Long id);
	
	public List<InfoPermissionVO> getAllParentMenu(Long id);
	
	public void updateById(InfoPermissionVO vo);
}
