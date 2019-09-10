package com.woniuxy.entity;

import java.util.Date;
import java.util.List;

public class Buygoods {
    private Integer bid;

    private Integer uid;

    private Date bdate;

    private String bname;

    private String breason;

    private Integer aptid;

    private Integer apid;

    private Integer flag;
    
    private List<Userinfo> userinfo;
    
    private List<Approvalstate> approvalstate;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getBdate() {
        return bdate;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname == null ? null : bname.trim();
    }

    public String getBreason() {
        return breason;
    }

    public void setBreason(String breason) {
        this.breason = breason == null ? null : breason.trim();
    }

    public Integer getAptid() {
        return aptid;
    }

    public void setAptid(Integer aptid) {
        this.aptid = aptid;
    }

    public Integer getApid() {
        return apid;
    }

    public void setApid(Integer apid) {
        this.apid = apid;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

	public List<Userinfo> getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(List<Userinfo> userinfo) {
		this.userinfo = userinfo;
	}

	public List<Approvalstate> getApprovalstate() {
		return approvalstate;
	}

	public void setApprovalstate(List<Approvalstate> approvalstate) {
		this.approvalstate = approvalstate;
	}
    
}