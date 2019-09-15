package com.woniuxy.entity;

import java.io.Serializable;
import java.util.List;

public class ChangeAnnouncement implements Serializable{
	private static final long serialVersionUID = 1L;
	private Userinfo send;
	private List<Userinfo> receive;
	private Announcement announcement;
	private List<Userinfo> users;
	public ChangeAnnouncement() {
		super();
	}
	public ChangeAnnouncement(Userinfo send, List<Userinfo> receive, Announcement announcement, List<Userinfo> users) {
		super();
		this.send = send;
		this.receive = receive;
		this.announcement = announcement;
		this.users = users;
	}
	public Userinfo getSend() {
		return send;
	}
	public void setSend(Userinfo send) {
		this.send = send;
	}
	public List<Userinfo> getReceive() {
		return receive;
	}
	public void setReceive(List<Userinfo> receive) {
		this.receive = receive;
	}
	public Announcement getAnnouncement() {
		return announcement;
	}
	public void setAnnouncement(Announcement announcement) {
		this.announcement = announcement;
	}
	public List<Userinfo> getUsers() {
		return users;
	}
	public void setUsers(List<Userinfo> users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "ChangeAnnouncement [send=" + send + ", receive=" + receive + ", announcement=" + announcement
				+ ", users=" + users + "]";
	}
}
