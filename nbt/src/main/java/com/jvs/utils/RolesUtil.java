/**
 * 
 */
package com.jvs.utils;

import com.jvs.enums.Roles;

public class RolesUtil {
	public static String getFirstMemberRoles() {
		return Roles.ADMIN.toString() + "|" + Roles.MEMBER.toString();
	}
	
	public static String getMemberRoles() {
		return Roles.MEMBER.toString();
	}
	
	public static String getAdminRoles() {
		return Roles.ADMIN.toString();
	}
	
	public static String getRolesByName(String role) {
		return Roles.valueOf(role).toString();
	}
}
