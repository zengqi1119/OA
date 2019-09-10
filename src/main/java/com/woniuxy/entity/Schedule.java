package com.woniuxy.entity;

import java.util.Date;

public class Schedule {
    private Integer sid;

    private Integer uid;

    private Date starttime;

    private Date endtime;

    private Integer bid;

    private String agenda;

    private Integer flag;
    
    private Userinfo userinfo;
    
    private Business business;
    
    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda == null ? null : agenda.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

	public Userinfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	

	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	public Schedule(Integer sid, Integer uid, Date starttime, Date endtime, Integer bid, String agenda, Integer flag,
			Userinfo userinfo, Business business) {
		super();
		this.sid = sid;
		this.uid = uid;
		this.starttime = starttime;
		this.endtime = endtime;
		this.bid = bid;
		this.agenda = agenda;
		this.flag = flag;
		this.userinfo = userinfo;
		this.business = business;
	}

	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Schedule [sid=" + sid + ", uid=" + uid + ", starttime=" + starttime + ", endtime=" + endtime + ", bid="
				+ bid + ", agenda=" + agenda + ", flag=" + flag + ", userinfo=" + userinfo + ", business=" + business
				+ "]";
	}
    
}