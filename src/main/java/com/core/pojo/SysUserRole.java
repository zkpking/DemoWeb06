package com.core.pojo;

/**
 * 用户角色
 * @author kaider
 *
 */
public class SysUserRole {
	/**
	 * 自增id
	 */
	private int id;
	
	/**
	 * 用户id
	 */
	private int userId;
	
	/**
	 * 角色id
	 */
	private int roleId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
