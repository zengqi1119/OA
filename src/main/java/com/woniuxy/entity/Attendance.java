package com.woniuxy.entity;

import java.util.Date;

public class Attendance {
    private Integer sid;

    private Date amtime;

    private Date noonbegintime;

    private Date noonendtime;

    private Date pmtime;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Date getAmtime() {
        return amtime;
    }

    public void setAmtime(Date amtime) {
        this.amtime = amtime;
    }

    public Date getNoonbegintime() {
        return noonbegintime;
    }

    public void setNoonbegintime(Date noonbegintime) {
        this.noonbegintime = noonbegintime;
    }

    public Date getNoonendtime() {
        return noonendtime;
    }

    public void setNoonendtime(Date noonendtime) {
        this.noonendtime = noonendtime;
    }

    public Date getPmtime() {
        return pmtime;
    }

    public void setPmtime(Date pmtime) {
        this.pmtime = pmtime;
    }

	@Override
	public String toString() {
		return "Attendance [sid=" + sid + ", amtime=" + amtime + ", noonbegintime=" + noonbegintime + ", noonendtime="
				+ noonendtime + ", pmtime=" + pmtime + "]";
	}
    
    
    
}