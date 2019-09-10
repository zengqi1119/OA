package com.woniuxy.entity;

import java.util.Date;

public class Userinfo {
    private Integer uid;

    private String uname;

    private Integer age;

    private String sex;

    private String reid;

    private String birthday;

    private Date entrytime;

    private Date resignationtime;

    private String identitycard;

    private String head;

    private Integer did;

    private Integer seid;

    private Integer spid;
    
    
    private Stateemployees stateemployeess;
    
   	private Staffpositions staffpositionss;

    private Integer flag;
    
    

    public Userinfo(Integer uid, String uname, Integer age, String sex, String reid, String birthday, Date entrytime,
			Date resignationtime, String identitycard, String head, Integer did, Integer seid, Integer spid,
			Stateemployees stateemployeess, Staffpositions staffpositionss, Integer flag) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.age = age;
		this.sex = sex;
		this.reid = reid;
		this.birthday = birthday;
		this.entrytime = entrytime;
		this.resignationtime = resignationtime;
		this.identitycard = identitycard;
		this.head = head;
		this.did = did;
		this.seid = seid;
		this.spid = spid;
		this.stateemployeess = stateemployeess;
		this.staffpositionss = staffpositionss;
		this.flag = flag;
	}


	@Override
	public String toString() {
		return "Userinfo [uid=" + uid + ", uname=" + uname + ", age=" + age + ", sex=" + sex + ", reid=" + reid
				+ ", birthday=" + birthday + ", entrytime=" + entrytime + ", resignationtime=" + resignationtime
				+ ", identitycard=" + identitycard + ", head=" + head + ", did=" + did + ", seid=" + seid + ", spid="
				+ spid + ", stateemployeess=" + stateemployeess + ", staffpositionss=" + staffpositionss + ", flag="
				+ flag + "]";
	}


	public Userinfo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Stateemployees getStateemployeess() {
		return stateemployeess;
	}


	public void setStateemployeess(Stateemployees stateemployeess) {
		this.stateemployeess = stateemployeess;
	}


	public Staffpositions getStaffpositionss() {
		return staffpositionss;
	}


	public void setStaffpositionss(Staffpositions staffpositionss) {
		this.staffpositionss = staffpositionss;
	}


    
	public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getReid() {
        return reid;
    }
    public void setReid(String reid) {
        this.reid = reid == null ? null : reid.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public Date getEntrytime() {
        return entrytime;
    }

    public void setEntrytime(Date entrytime) {
        this.entrytime = entrytime;
    }

    public Date getResignationtime() {
        return resignationtime;
    }

    public void setResignationtime(Date resignationtime) {
        this.resignationtime = resignationtime;
    }

    public String getIdentitycard() {
        return identitycard;
    }

    public void setIdentitycard(String identitycard) {
        this.identitycard = identitycard == null ? null : identitycard.trim();
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head == null ? null : head.trim();
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getSeid() {
        return seid;
    }

    public void setSeid(Integer seid) {
        this.seid = seid;
    }

    public Integer getSpid() {
        return spid;
    }

    public void setSpid(Integer spid) {
        this.spid = spid;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}