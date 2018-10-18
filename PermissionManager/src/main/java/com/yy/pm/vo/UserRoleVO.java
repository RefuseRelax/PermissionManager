package com.yy.pm.vo;

import com.yy.pm.annotation.FieldAnnotation;
import com.yy.pm.annotation.TableAnnotaion;
import com.yy.pm.enums.FiledType;

/**
 * 用户角色对应关系表；一个用户对应多个角色
 * @author zk
 *
 */
@TableAnnotaion(tableName="user_role")
public class UserRoleVO {

	@FieldAnnotation(index=1,filedName="uid",filedType=FiledType.BIGINT,comment="用户id")
	private Long uid;
	
	@FieldAnnotation(index=2,filedName="rid",filedType=FiledType.BIGINT,comment="角色id")
	private Long rid;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}
	
}
