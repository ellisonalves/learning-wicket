package com.ellisonalves.pojo;

import java.io.Serializable;

public class Login implements Serializable {

	private static final long	serialVersionUID	= 1L;
	
	private String				loginStatus;
	private String				username;
	private String				password;
	
	public String getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
