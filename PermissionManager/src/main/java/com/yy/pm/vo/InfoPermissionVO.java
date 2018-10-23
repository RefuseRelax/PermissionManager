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
	
	//节点id
	private Long jid;

	//权限主键
	private Long id;
	
	//创建时间
	private String createTime;
	
	//更新时间
	private String updateTime;
	
	//权限名称
	private String pname;
	
	//权限代码
	private String pcode;
	
	//权限路径
	private String url;
	
	//是否为菜单
	private Integer isMenu;

	//父id
	private Long parentId;
		
	//权限描述
	private String description;
	
	/**
	 * 子集权限
	 */
	private List<InfoPermissionVO> childrenPer = new ArrayList<InfoPermissionVO>();

	public Long getJid() {
		return jid;
	}

	public void setJid(Long jid) {
		this.jid = jid;
	}

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
	
	public List<InfoPermissionVO> getChildrenPer() {
		return childrenPer;
	}

	public void setChildrenPer(List<InfoPermissionVO> childrenPer) {
		this.childrenPer = childrenPer;
	}

	@Override
	public String toString() {
		return "InfoPermissionVO [jid=" + jid + ", id=" + id + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", pname="
				+ pname + ", pcode=" + pcode + ", url=" + url + ", isMenu="
				+ isMenu + ", parentId=" + parentId + ", description="
				+ description + ", childrenPer=" + childrenPer + "]";
	}
	
}
