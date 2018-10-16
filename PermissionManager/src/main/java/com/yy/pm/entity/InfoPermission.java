package com.yy.pm.entity;

import java.util.Date;

import com.yy.pm.annotation.FieldAnnotation;
import com.yy.pm.annotation.TableAnnotaion;
import com.yy.pm.enums.FiledType;

/**
 * 权限表
 * @author zk
 *
 */
@TableAnnotaion(tableName="info_permission")
public class InfoPermission {

	//权限主键
	@FieldAnnotation(index=1,filedName="id",filedType=FiledType.BIGINT,isPrimaryKey=true,isAutoIncreament=true,comment="主键")
	private Long id;
	
	//创建时间
	@FieldAnnotation(index=10000,filedName="create_time",filedType=FiledType.DATETIME,comment="创建时间")
	private Date createTime;
	
	//更新时间
	@FieldAnnotation(index=10001,filedName="update_time",filedType=FiledType.DATETIME,comment="更新时间")
	private Date updateTime;
	
	//权限名称
	@FieldAnnotation(index=2,filedName="pname",filedType=FiledType.VARCHAR,comment="权限名称")
	private String rname;
	
	//权限代码
	@FieldAnnotation(index=3,filedName="pcode",filedType=FiledType.VARCHAR,comment="权限代码",length=50,isUnique=true)
	private String rcode;
	
	//权限路径
	@FieldAnnotation(index=3,filedName="url",filedType=FiledType.VARCHAR,comment="权限路径",length=255)
	private String url;
	
	//权限路径
	@FieldAnnotation(index=3,filedName="is_menu",filedType=FiledType.INTEGER,comment="是否为菜单",length=4)
	private String isMenu;
	
	//权限路径
	@FieldAnnotation(index=3,filedName="parent_id",filedType=FiledType.INTEGER,comment="父级菜单id",length=4)
	private String parentId;
		
	//权限描述
	@FieldAnnotation(index=4,filedName="description",filedType=FiledType.VARCHAR,comment="权限描述",length=255)
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIsMenu() {
		return isMenu;
	}

	public void setIsMenu(String isMenu) {
		this.isMenu = isMenu;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getRdescription() {
		return rdescription;
	}

	public void setRdescription(String rdescription) {
		this.rdescription = rdescription;
	}
	
}
