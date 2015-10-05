package com.core.pojo;

/**
 * 系统角色
 * @author kaider
 *
 */
public class SysRole {
	/**
	 * 角色id
	 */
	private int id;
	/**
	 * 角色名称
	 */
	private String roleName;
	/**
	 * 角色状态
	 */
	private int roleStatus;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public int getRoleStatus() {
		return roleStatus;
	}
	public void setRoleStatus(int roleStatus) {
		this.roleStatus = roleStatus;
	}
	
}
