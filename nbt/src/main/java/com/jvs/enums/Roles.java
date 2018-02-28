package com.jvs.enums;
public enum Roles {
	ADMIN ("admin"),
	MEMBER ("member");
	
	private final String role;
	private Roles(String role) {
		this.role = role;
	}
	
	@Override 
    public String toString(){ 
        return role; 
    } 
}
