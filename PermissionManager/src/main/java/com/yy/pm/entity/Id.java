/**
 * 
 */
package com.yy.pm.entity;

import java.util.Date;

import com.yy.pm.annotation.FieldAnnotation;
import com.yy.pm.enums.FiledType;

/**
 * @author zk
 *
 */
public class Id {

	@FieldAnnotation(index=1,filedName="id",filedType=FiledType.BIGINT,isPrimaryKey=true,isAutoIncreament=true,comment="主键")
	private Long id;
	
	@FieldAnnotation(index=10000,filedName="createTime",filedType=FiledType.DATETIME,comment="创建时间")
	private Date createTime;
	
	@FieldAnnotation(index=10001,filedName="updateTime",filedType=FiledType.DATETIME,comment="更新时间")
	private Date updateTime;

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
	
	
	
}
