package com.woniuxy.entity;

import java.io.Serializable;
import java.util.List;

public class AllAnnouncements implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<Announcement> announcement;
	private List<Accept> accepts;
	private List<Userinfo> userinfo;
	public AllAnnouncements() {
		super();
	}
	public AllAnnouncements(List<Announcement> announcement, List<Accept> accepts, List<Userinfo> userinfo) {
		super();
		this.announcement = announcement;
		this.accepts = accepts;
		this.userinfo = userinfo;
	}
	public List<Announcement> getAnnouncement() {
		return announcement;
	}
	public void setAnnouncement(List<Announcement> announcement) {
		this.announcement = announcement;
	}
	public List<Accept> getAccepts() {
		return accepts;
	}
	public void setAccepts(List<Accept> accepts) {
		this.accepts = accepts;
	}
	public List<Userinfo> getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(List<Userinfo> userinfo) {
		this.userinfo = userinfo;
	}
	@Override
	public String toString() {
		return "AllAnnouncements [announcement=" + announcement + ", accepts=" + accepts + ", userinfo=" + userinfo
				+ "]";
	}
}
