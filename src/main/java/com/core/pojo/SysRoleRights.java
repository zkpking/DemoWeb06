package com.core.pojo;

/**
 * 角色权限
 * @author kaider
 *
 */
public class SysRoleRights {
	/**
	 * 自增id
	 */
	private int id;
	
	/**
	 * 角色id
	 */
	private int roleId;
	
	/**
	 * 权限id
	 */
	private int rightsId;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getRightsId() {
		return rightsId;
	}

	public void setRightsId(int rightsId) {
		this.rightsId = rightsId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
