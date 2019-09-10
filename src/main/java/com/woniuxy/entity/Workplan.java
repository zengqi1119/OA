package com.woniuxy.entity;

public class Workplan {
    private Integer wid;

    private Integer did;

    private Integer uid;

    private String weeksum;

    private String weekque;

    private String weekplan;

    private Integer flag;
    
    private Userinfo userinfo;
    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getWeeksum() {
        return weeksum;
    }
    

	public void setWeeksum(String weeksum) {
        this.weeksum = weeksum == null ? null : weeksum.trim();
    }

    public String getWeekque() {
        return weekque;
    }

    public void setWeekque(String weekque) {
        this.weekque = weekque == null ? null : weekque.trim();
    }

    public String getWeekplan() {
        return weekplan;
    }

    public void setWeekplan(String weekplan) {
        this.weekplan = weekplan == null ? null : weekplan.trim();
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

	public Workplan() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Workplan(Integer wid, Integer did, Integer uid, String weeksum, String weekque, String weekplan,
			Integer flag, Userinfo userinfo) {
		super();
		this.wid = wid;
		this.did = did;
		this.uid = uid;
		this.weeksum = weeksum;
		this.weekque = weekque;
		this.weekplan = weekplan;
		this.flag = flag;
		this.userinfo = userinfo;
	}

	@Override
	public String toString() {
		return "Workplan [wid=" + wid + ", did=" + did + ", uid=" + uid + ", weeksum=" + weeksum + ", weekque="
				+ weekque + ", weekplan=" + weekplan + ", flag=" + flag + ", userinfo=" + userinfo + "]";
	}

	
    
}