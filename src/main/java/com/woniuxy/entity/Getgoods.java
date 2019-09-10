package com.woniuxy.entity;

import java.util.Date;
import java.util.List;

public class Getgoods {
    private Integer gid;

    private Integer uid;

    private Date gdate;

    private String gname;

    private String greason;

    private Integer apid;

    private Integer aptid;

    private Integer flag;
    
    private List<Userinfo> userinfo;
    
    private List<Approvalstate> approvalstate;
    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getGdate() {
        return gdate;
    }

    public void setGdate(Date gdate) {
        this.gdate = gdate;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname == null ? null : gname.trim();
    }

    public String getGreason() {
        return greason;
    }

    public void setGreason(String greason) {
        this.greason = greason == null ? null : greason.trim();
    }

    public Integer getApid() {
        return apid;
    }

    public void setApid(Integer apid) {
        this.apid = apid;
    }

    public Integer getAptid() {
        return aptid;
    }

    public void setAptid(Integer aptid) {
        this.aptid = aptid;
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