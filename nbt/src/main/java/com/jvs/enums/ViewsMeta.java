package com.jvs.enums;
public enum ViewsMeta {
	INDEX ("index"),
	LOGIN ("login"),
	SIGNUP ("signup"),
	HOME ("home"),
	LOGOUT ("logout");
	
	private final String viewName;
	private ViewsMeta(String vn) {
		this.viewName = vn;
	}
	
	@Override 
    public String toString(){ 
        return viewName; 
    } 
}
