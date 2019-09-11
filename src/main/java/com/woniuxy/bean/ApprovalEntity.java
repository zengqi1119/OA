package com.woniuxy.bean;

import java.util.Date;

public class ApprovalEntity {
private Integer id;
private Integer uid;
private Integer apid;
private Integer aptid;
private Date begin;
private Date end;
private String reason;
private Integer ltid;
private String digest;
private Double amount;
private Integer flag;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Integer getUid() {
	return uid;
}
public void setUid(Integer uid) {
	this.uid = uid;
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
public Date getBegin() {
	return begin;
}
public void setBegin(Date begin) {
	this.begin = begin;
}
public Date getEnd() {
	return end;
}
public void setEnd(Date end) {
	this.end = end;
}
public String getReason() {
	return reason;
}
public void setReason(String reason) {
	this.reason = reason;
}
public Integer getLtid() {
	return ltid;
}
public void setLtid(Integer ltid) {
	this.ltid = ltid;
}
public String getDigest() {
	return digest;
}
public void setDigest(String digest) {
	this.digest = digest;
}
public Double getAmount() {
	return amount;
}
public void setAmount(Double amount) {
	this.amount = amount;
}
public Integer getFlag() {
	return flag;
}
public void setFlag(Integer flag) {
	this.flag = flag;
}
public ApprovalEntity(Integer id, Integer uid, Integer apid, Integer aptid, Date begin, Date end, String reason,
		Integer ltid, String digest, Double amount, Integer flag) {
	super();
	this.id = id;
	this.uid = uid;
	this.apid = apid;
	this.aptid = aptid;
	this.begin = begin;
	this.end = end;
	this.reason = reason;
	this.ltid = ltid;
	this.digest = digest;
	this.amount = amount;
	this.flag = flag;
}
public ApprovalEntity() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "ApprovalEntity [id=" + id + ", uid=" + uid + ", apid=" + apid + ", aptid=" + aptid + ", begin=" + begin
			+ ", end=" + end + ", reason=" + reason + ", ltid=" + ltid + ", digest=" + digest + ", amount=" + amount
			+ ", flag=" + flag + "]";
}

}
