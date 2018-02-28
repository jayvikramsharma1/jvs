package com.jvs.models;

public class UserPOJO {
	private String fullname;
	private String username;
	private String roles;
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "UserPOJO [fullname=" + fullname + ", username=" + username + ", roles=" + roles + "]";
	}
	
	
	
	
}
