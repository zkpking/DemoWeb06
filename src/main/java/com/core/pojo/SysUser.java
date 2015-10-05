package com.core.pojo;

/**
 * 系统用户
 * @author kaider
 *
 */
public class SysUser {
	/**
	 * 用户id
	 */
	private int id;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 用户密码
	 */
	private String userPassword;
	/**
	 * 用户状态
	 */
	private int userStatus;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
	
	
	public SysUser() {
		super();
	}
	
	public SysUser(int id, String userName, String userPassword, int userStatus) {
		super();
		this.id = id;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userStatus = userStatus;
	}

}
