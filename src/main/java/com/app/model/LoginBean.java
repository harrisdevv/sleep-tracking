package com.app.model;

import java.io.Serializable;

public class LoginBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private boolean isAdmin;
	private long uid;

	public String getUsername() {
		return username;
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
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
