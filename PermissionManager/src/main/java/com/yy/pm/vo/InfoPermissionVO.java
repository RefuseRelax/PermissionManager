package com.yy.pm.vo;

import java.util.ArrayList;
import java.util.List;

import com.yy.pm.annotation.FieldAnnotation;
import com.yy.pm.annotation.TableAnnotaion;
import com.yy.pm.entity.InfoPermission;
import com.yy.pm.enums.FiledType;

/**
 * 权限表
 * @author zk
 *
 */
@TableAnnotaion(tableName="info_permission")
public class InfoPermissionVO {

	//权限主键
	@FieldAnnotation(index=1,filedName="id",filedType=FiledType.BIGINT,isPrimaryKey=true,isAutoIncreament=true,comment="主键")
	private Long id;
	
	//创建时间
	@FieldAnnotation(index=10000,filedName="create_time",filedType=FiledType.DATETIME,comment="创建时间")
	private String createTime;
	
	//更新时间
	@FieldAnnotation(index=10001,filedName="update_time",filedType=FiledType.DATETIME,comment="更新时间")
	private String updateTime;
	
	//权限名称
	@FieldAnnotation(index=2,filedName="pname",filedType=FiledType.VARCHAR,comment="权限名称")
	private String pname;
	
	//权限代码
	@FieldAnnotation(index=3,filedName="pcode",filedType=FiledType.VARCHAR,comment="权限代码",length=50,isUnique=true)
	private String pcode;
	
	//权限路径
	@FieldAnnotation(index=3,filedName="url",filedType=FiledType.VARCHAR,comment="权限路径",length=255)
	private String url;
	
	//是否为菜单
	@FieldAnnotation(index=3,filedName="is_menu",filedType=FiledType.INTEGER,comment="是否为菜单",length=4)
	private Integer isMenu;

	//父id
	@FieldAnnotation(index=3,filedName="parent_id",filedType=FiledType.BIGINT,comment="父级菜单id",length=4)
	private Long parentId;
		
	//权限描述
	@FieldAnnotation(index=4,filedName="description",filedType=FiledType.VARCHAR,comment="权限描述",length=255)
	private String description;
	
	/**
	 * 子集权限
	 */
	private List<InfoPermission> childrenPer = new ArrayList<InfoPermission>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public Integer getIsMenu() {
		return isMenu;
	}

	public void setIsMenu(Integer isMenu) {
		this.isMenu = isMenu;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

	public List<InfoPermission> getChildrenPer() {
		return childrenPer;
	}

	public void setChildrenPer(List<InfoPermission> childrenPer) {
		this.childrenPer = childrenPer;
	}

	@Override
	public String toString() {
		return "InfoPermissionVO [id=" + id + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", pname=" + pname
				+ ", pcode=" + pcode + ", url=" + url + ", isMenu=" + isMenu
				+ ", parentId=" + parentId + ", description=" + description
				+ ", childrenPer=" + childrenPer + "]";
	}
	
	
}
