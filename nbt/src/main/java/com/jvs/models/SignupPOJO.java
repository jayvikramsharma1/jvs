package com.jvs.models;

import org.hibernate.validator.constraints.NotEmpty;

public class SignupPOJO {
	@NotEmpty
	private String fullname;
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
	@NotEmpty
	private String cnfpassword;
	@NotEmpty
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCnfpassword() {
		return cnfpassword;
	}
	public void setCnfpassword(String cnfpassword) {
		this.cnfpassword = cnfpassword;
	}
	
	
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "SignupPOJO [fullname=" + fullname + ", username=" + username + ", password=" + password
				+ ", cnfpassword=" + cnfpassword + ", roles=" + roles + "]";
	}
	
	
	
	
	
	
}
