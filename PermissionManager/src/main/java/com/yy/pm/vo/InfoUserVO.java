/**
 * 
 */
package com.yy.pm.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.fabric.xmlrpc.base.Array;
import com.yy.pm.annotation.FieldAnnotation;
import com.yy.pm.annotation.TableAnnotaion;
import com.yy.pm.enums.FiledType;

/**用户表
 * @author zk
 *
 */
@TableAnnotaion(tableName="info_user")
public class InfoUserVO {
	
	//用户主键
	@FieldAnnotation(index=1,filedName="id",filedType=FiledType.BIGINT,isPrimaryKey=true,isAutoIncreament=true,comment="主键")
	private Long id;
	
	//创建时间
	@FieldAnnotation(index=10000,filedName="create_time",filedType=FiledType.DATETIME,comment="创建时间")
	private Date createTime;
	
	//更新时间
	@FieldAnnotation(index=10001,filedName="update_time",filedType=FiledType.DATETIME,comment="更新时间")
	private Date updateTime;
	
	//用户账号
	@FieldAnnotation(index=2,filedName="username",filedType=FiledType.VARCHAR,isUnique=true,length=50,isNull=false,comment="用户账号")
	private String username;
	
	//用户昵称
	@FieldAnnotation(index=3,filedName="nickname",filedType=FiledType.VARCHAR,length=50,comment="昵称")
	private String nickname;
	
	//密码
	@FieldAnnotation(index=4,filedName="password",filedType=FiledType.VARCHAR,length=50,comment="密码")
	private String password;
	
	//性别
	@FieldAnnotation(index=5,filedName="sex",filedType=FiledType.INTEGER,length=4,comment="性别，0女，1男")
	private int sex;
	
	//qq
	@FieldAnnotation(index=6,filedName="qq",filedType=FiledType.VARCHAR,length=50,comment="qq")
	private String qq;
	
	//用户状态 0禁用，1启用
	@FieldAnnotation(index=7,filedName="status",filedType=FiledType.INTEGER,length=4,comment="状态，0禁用，1启用")
	private int status;
	
	//手机号码
	@FieldAnnotation(index=8,filedName="phone",filedType=FiledType.VARCHAR,length=50,comment="手机号码")
	private String phone;
	
	//地址ַ
	@FieldAnnotation(index=9,filedName="address",filedType=FiledType.VARCHAR,length=255,comment="地址ַ")
	private String address;
	
	@FieldAnnotation(index=10,filedName="role_id",filedType=FiledType.INTEGER,length=4,comment="角色idַ")
	private Long roleId;
	
	private List<InfoPermissionVO> pers = new ArrayList<InfoPermissionVO>();
	

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

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<InfoPermissionVO> getPers() {
		return pers;
	}

	public void setPers(List<InfoPermissionVO> pers) {
		this.pers = pers;
	}

	@Override
	public String toString() {
		return "InfoUserVO [id=" + id + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", username=" + username
				+ ", nickname=" + nickname + ", password=" + password
				+ ", sex=" + sex + ", qq=" + qq + ", status=" + status
				+ ", phone=" + phone + ", address=" + address + ", roleId="
				+ roleId + ", pers=" + pers + "]";
	}

}
