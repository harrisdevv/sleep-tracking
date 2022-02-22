package com.app.model;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private long uid;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private boolean isAdmin;
	public User() {}


	public User(long uid, String firstName, String lastName, String username, String password, boolean isAdmin) {
		this.setUid(uid);
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public boolean isIsAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "{" +
			" uid='" + getUid() + "'" +
			", firstName='" + getFirstName() + "'" +
			", lastName='" + getLastName() + "'" +
			", username='" + getUsername() + "'" +
			", password='" + getPassword() + "'" +
			", isAdmin='" + isIsAdmin() + "'" +
			"}";
	}
}
