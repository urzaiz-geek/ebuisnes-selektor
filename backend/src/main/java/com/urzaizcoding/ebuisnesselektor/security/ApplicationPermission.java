package com.urzaizcoding.ebuisnesselektor.security;

public enum ApplicationPermission {
	;
	
	
	private final String permissionName;
	
	ApplicationPermission(String permissionName){
		this.permissionName = permissionName;
	}
	
	public String getPermission() {
		return permissionName;
	}
	
}
