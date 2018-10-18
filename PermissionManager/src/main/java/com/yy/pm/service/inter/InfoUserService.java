package com.yy.pm.service.inter;

import com.yy.pm.entity.InfoUser;
import com.yy.pm.vo.InfoUserVO;

public interface InfoUserService {
	
	public InfoUserVO getSimpleUserByUsername(String username);
	
	public void insert(InfoUserVO vo);
	
	public void truncate();

}
