package com.woniuxy.entity;

import java.util.Date;

public class Overtime {
    private Integer oid;

    private Date applytime;

    private Date begintime;

    private Date endtime;

    private Integer overtime;

    private String description;

    private Integer apid;
    
    
    
    //审批状态
    private Approvalstate approvalstate;

    private Integer uid;
    
    //用户信息
    private Userinfo userinfo;

    private Integer aptid;

    public Approvalstate getApprovalstate() {
		return approvalstate;
	}

	public void setApprovalstate(Approvalstate approvalstate) {
		this.approvalstate = approvalstate;
	}

	public Userinfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	private Integer did;

    private Integer flag;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Date getApplytime() {
        return applytime;
    }

    public void setApplytime(Date applytime) {
        this.applytime = applytime;
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getOvertime() {
        return overtime;
    }

    public void setOvertime(Integer overtime) {
        this.overtime = overtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getApid() {
        return apid;
    }

    public void setApid(Integer apid) {
        this.apid = apid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getAptid() {
        return aptid;
    }

    public void setAptid(Integer aptid) {
        this.aptid = aptid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

	@Override
	public String toString() {
		return "Overtime [oid=" + oid + ", applytime=" + applytime + ", begintime=" + begintime + ", endtime=" + endtime
				+ ", overtime=" + overtime + ", description=" + description + ", apid=" + apid + ", approvalstate="
				+ approvalstate + ", uid=" + uid + ", userinfo=" + userinfo + ", aptid=" + aptid + ", did=" + did
				+ ", flag=" + flag + "]";
	}
    
}