/**
 * 
 */
package com.yy.pm.vo;

/**
 * @author zk
 *
 */
public class Tree {
	
	private Long nodeId;
	
	private Long parentId;
	
	private String chechboxName;
	
	private Long chechboxVal;
	
	private String checkboxShow;
	
	private boolean isCheck;
	
	private boolean isUse;

	public Long getNodeId() {
		return nodeId;
	}

	public void setNodeId(Long nodeId) {
		this.nodeId = nodeId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getChechboxName() {
		return chechboxName;
	}

	public void setChechboxName(String chechboxName) {
		this.chechboxName = chechboxName;
	}

	public String getCheckboxShow() {
		return checkboxShow;
	}

	public void setCheckboxShow(String checkboxShow) {
		this.checkboxShow = checkboxShow;
	}

	public boolean getIsCheck() {
		return isCheck;
	}

	public void setIsCheck(boolean isCheck) {
		this.isCheck = isCheck;
	}

	public boolean isUse() {
		return isUse;
	}

	public void setUse(boolean isUse) {
		this.isUse = isUse;
	}

	public Long getChechboxVal() {
		return chechboxVal;
	}

	public void setChechboxVal(Long chechboxVal) {
		this.chechboxVal = chechboxVal;
	}

	@Override
	public String toString() {
		return "Tree [nodeId=" + nodeId + ", parentId=" + parentId
				+ ", chechboxName=" + chechboxName + ", chechboxVal="
				+ chechboxVal + ", checkboxShow=" + checkboxShow + ", isCheck="
				+ isCheck + ", isUse=" + isUse + "]";
	}
	
}
