package com.fcs.pojo;


/**
 * UserPo entity. @author MyEclipse Persistence Tools
 */

public class UserPo implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String username;
	private String password;

	// Constructors

	/** default constructor */
	public UserPo() {
	}

	/** full constructor */
	public UserPo(String username, String password) {
		this.username = username;
		this.password = password;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}