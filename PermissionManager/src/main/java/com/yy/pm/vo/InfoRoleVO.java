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
	@FieldAnnotation(index=1,filedName="id",filedType=FiledType.BIGINT,isPrimaryKey=true,isAutoIncreament=true,comment="主键")
	private Long id;
	
	//创建时间
	@FieldAnnotation(index=10000,filedName="create_time",filedType=FiledType.DATETIME,comment="创建时间")
	private Date createTime;
	
	//更新时间
	@FieldAnnotation(index=10001,filedName="update_time",filedType=FiledType.DATETIME,comment="更新时间")
	private Date updateTime;
	
	//角色名称
	@FieldAnnotation(index=2,filedName="rname",filedType=FiledType.VARCHAR,comment="角色名称")
	private String rname;
	
	//角色代码
	@FieldAnnotation(index=3,filedName="rcode",filedType=FiledType.VARCHAR,comment="角色代码",length=50)
	private String rcode;
	
	//角色描述
	@FieldAnnotation(index=4,filedName="description",filedType=FiledType.VARCHAR,comment="角色描述",length=255)
	private String rdescription;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
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
	
}
