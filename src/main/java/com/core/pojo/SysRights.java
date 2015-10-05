package com.core.pojo;

/**
 * 系统权限
 * @author kaider
 *
 */
public class SysRights {
	/**
	 * 权限id
	 */
	private int id;
	/**
	 * 权限名称
	 */
	private String rightsName;
	/**
	 * 权限状态
	 */
	private int rightsStatus;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRightsName() {
		return rightsName;
	}
	public void setRightsName(String rightsName) {
		this.rightsName = rightsName;
	}
	public int getRightsStatus() {
		return rightsStatus;
	}
	public void setRightsStatus(int rightsStatus) {
		this.rightsStatus = rightsStatus;
	}
	
}
