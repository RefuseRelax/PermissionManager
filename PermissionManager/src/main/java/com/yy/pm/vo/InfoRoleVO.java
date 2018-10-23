/**
 * 
 */
package com.yy.pm.vo;

import java.util.Date;

import com.yy.pm.annotation.FieldAnnotation;
import com.yy.pm.annotation.TableAnnotaion;
import com.yy.pm.enums.FiledType;

/**角色表
 * @author zk
 *
 */

@TableAnnotaion(tableName="info_role")
public class InfoRoleVO {
	
	//角色主键
	private Long id;
	
	@FieldAnnotation(index=10000,filedName="create_time",filedType=FiledType.DATETIME,comment="创建时间")
	private String createTime;
	
	//更新时间
	private String updateTime;
	
	//角色名称
	private String rname;
	
	//角色代码
	private String rcode;
	
	//角色描述
	private String rdescription;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRcode() {
		return rcode;
	}

	public void setRcode(String rcode) {
		this.rcode = rcode;
	}

	public String getRdescription() {
		return rdescription;
	}

	public void setRdescription(String rdescription) {
		this.rdescription = rdescription;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "InfoRoleVO [id=" + id + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", rname=" + rname
				+ ", rcode=" + rcode + ", rdescription=" + rdescription + "]";
	}
	
	
	
}
