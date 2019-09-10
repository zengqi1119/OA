package com.woniuxy.entity;

import java.util.List;

public class ApplyUser {
	private List<Apply> applys;
	private Userinfo user;
	public ApplyUser() {
		super();
	}
	public List<Apply> getApplys() {
		return applys;
	}
	public void setApplys(List<Apply> applys) {
		this.applys = applys;
	}
	public Userinfo getUser() {
		return user;
	}
	public void setUser(Userinfo user) {
		this.user = user;
	}
	public ApplyUser(List<Apply> applys, Userinfo user) {
		super();
		this.applys = applys;
		this.user = user;
	}
	@Override
	public String toString() {
		return "ApplyUser [applys=" + applys + ", user=" + user + "]";
	}
}
