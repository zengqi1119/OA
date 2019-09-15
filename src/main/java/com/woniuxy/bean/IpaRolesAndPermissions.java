package com.woniuxy.bean;

import java.util.List;

import com.woniuxy.entity.Role;
import com.woniuxy.entity.Userinfo;

public class IpaRolesAndPermissions {
	private Userinfo userinfo;
	private List<Role> roles;
	private List<Permission> permissions;
	public IpaRolesAndPermissions() {
		super();
		// TODO Auto-generated constructor stub
	}
	public IpaRolesAndPermissions(Userinfo userinfo, List<Role> roles, List<Permission> permissions) {
		super();
		this.userinfo = userinfo;
		this.roles = roles;
		this.permissions = permissions;
	}
	@Override
	public String toString() {
		return "IpaRolesAndPermissions [userinfo=" + userinfo + ", roles=" + roles + ", permissions=" + permissions
				+ "]";
	}
	public Userinfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public List<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	

}
