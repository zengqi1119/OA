package com.woniuxy.entity;

import java.util.Date;

public class Signin {
    private Integer sid;

    private Date signintime;

    private Date signbacktime;

    private String uip;

    private Integer uid;

    private Integer did;
    
    //用户信息
    private Userinfo userinfo;

    
    public Userinfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Date getSignintime() {
        return signintime;
    }

    public void setSignintime(Date signintime) {
        this.signintime = signintime;
    }

    public Date getSignbacktime() {
        return signbacktime;
    }

    public void setSignbacktime(Date signbacktime) {
        this.signbacktime = signbacktime;
    }

    public String getUip() {
        return uip;
    }

    public void setUip(String uip) {
        this.uip = uip == null ? null : uip.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

	@Override
	public String toString() {
		return "Signin [sid=" + sid + ", signintime=" + signintime + ", signbacktime=" + signbacktime + ", uip=" + uip
				+ ", uid=" + uid + ", did=" + did + ", userinfo=" + userinfo + "]";
	}
    
}