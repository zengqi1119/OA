package com.woniuxy.bean;

import java.util.List;

import com.woniuxy.entity.Announcement;
import com.woniuxy.entity.Apply;
import com.woniuxy.entity.Approvaltype;
import com.woniuxy.entity.Buygoods;
import com.woniuxy.entity.Getgoods;
import com.woniuxy.entity.Leaves;
import com.woniuxy.entity.Overtime;
import com.woniuxy.entity.Userinfo;

public class AprovalAssemble {
	private Userinfo user;
	private List<Overtime> overtimes;
	private List<Leaves> leaves;
	private List<Apply> applys;
	private List<Getgoods> gets;
	private List<Buygoods> buys;
	private List<Announcement> anns;
	private List<Approvaltype> types;
	public Userinfo getUser() {
		return user;
	}
	public void setUser(Userinfo user) {
		this.user = user;
	}
	public List<Overtime> getOvertimes() {
		return overtimes;
	}
	public void setOvertimes(List<Overtime> overtimes) {
		this.overtimes = overtimes;
	}
	public List<Leaves> getLeaves() {
		return leaves;
	}
	public void setLeaves(List<Leaves> leaves) {
		this.leaves = leaves;
	}
	public List<Apply> getApplys() {
		return applys;
	}
	public void setApplys(List<Apply> applys) {
		this.applys = applys;
	}
	public List<Getgoods> getGets() {
		return gets;
	}
	public void setGets(List<Getgoods> gets) {
		this.gets = gets;
	}
	public List<Buygoods> getBuys() {
		return buys;
	}
	public void setBuys(List<Buygoods> buys) {
		this.buys = buys;
	}
	public List<Announcement> getAnns() {
		return anns;
	}
	public void setAnns(List<Announcement> anns) {
		this.anns = anns;
	}
	public List<Approvaltype> getTypes() {
		return types;
	}
	public void setTypes(List<Approvaltype> types) {
		this.types = types;
	}
	public AprovalAssemble(Userinfo user, List<Overtime> overtimes, List<Leaves> leaves, List<Apply> applys,
			List<Getgoods> gets, List<Buygoods> buys, List<Announcement> anns, List<Approvaltype> types) {
		super();
		this.user = user;
		this.overtimes = overtimes;
		this.leaves = leaves;
		this.applys = applys;
		this.gets = gets;
		this.buys = buys;
		this.anns = anns;
		this.types = types;
	}
	public AprovalAssemble() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AprovalAssemble [user=" + user + ", overtimes=" + overtimes + ", leaves=" + leaves + ", applys="
				+ applys + ", gets=" + gets + ", buys=" + buys + ", anns=" + anns + ", types=" + types + "]";
	}
	

}
