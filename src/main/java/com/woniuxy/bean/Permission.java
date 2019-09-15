package com.woniuxy.bean;

public class Permission {
private int pid;
private String pname;
private String url;
private String privilege;
private int flag;
public Permission() {
	super();
	// TODO Auto-generated constructor stub
}
public Permission(int pid, String pname, String url, String privilege, int flag) {
	super();
	this.pid = pid;
	this.pname = pname;
	this.url = url;
	this.privilege = privilege;
	this.flag = flag;
}
@Override
public String toString() {
	return "Permission [pid=" + pid + ", pname=" + pname + ", url=" + url + ", privilege=" + privilege + ", flag="
			+ flag + "]";
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getPrivilege() {
	return privilege;
}
public void setPrivilege(String privilege) {
	this.privilege = privilege;
}
public int getFlag() {
	return flag;
}
public void setFlag(int flag) {
	this.flag = flag;
}



}
