/**
 * 
 */
package com.yy.pm.vo;

import com.yy.pm.annotation.FieldAnnotation;
import com.yy.pm.annotation.TableAnnotaion;
import com.yy.pm.enums.FiledType;

/**角色权限对应关系表;一个角色对应多个权限
 * @author zk
 *
 */
@TableAnnotaion(tableName="role_permission")
public class RolePermissionVO {
	
	@FieldAnnotation(index=1,filedName="rid",filedType=FiledType.BIGINT,comment="角色id")
	private Long rid;
	
	@FieldAnnotation(index=2,filedName="pid",filedType=FiledType.BIGINT,comment="权限id")
	private Long pid;

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	} 

}
