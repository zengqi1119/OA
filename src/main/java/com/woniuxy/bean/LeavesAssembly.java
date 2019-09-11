package com.woniuxy.bean;

import java.util.List;

import com.woniuxy.entity.Approvalstate;
import com.woniuxy.entity.Leaves;
import com.woniuxy.entity.Leavetype;
import com.woniuxy.entity.Userinfo;

public class LeavesAssembly{
	List<Leaves> leaves;//请假
	List<Leavetype> types;//请假类型
	List<Approvalstate> states;//审批状态
	List<Userinfo> users;//当前用户
	Integer pageIndex;//当前页
	Integer pageSize;//页大小
	Integer pageCount;//总数量
	Integer totalPage;//总页数
	Integer startPage;//起始页
	Integer endPage;//结束页
	String url;

	 		public void setStartandEnd() {
		if(pageIndex>getTotalPage()) {
			startPage=0;
			endPage=0;
		}else if(getTotalPage()<10) {
			startPage=1;
			endPage=getTotalPage();
		}else {
			if(pageIndex-4>1) {
				startPage=pageIndex-4;	
			}else {
				startPage=1;
			}
			if(pageIndex+5>getTotalPage()) {
				endPage=getTotalPage();
			}else {
				endPage=pageIndex+5;
			}
		}
	}
	 	public List<Leaves> getLeaves() {
		return leaves;
	}
	public void setLeaves(List<Leaves> leaves) {
		this.leaves = leaves;
	}
	public List<Leavetype> getTypes() {
		return types;
	}
	public void setTypes(List<Leavetype> types) {
		this.types = types;
	}
	public List<Approvalstate> getStates() {
		return states;
	}
	public void setStates(List<Approvalstate> states) {
		this.states = states;
	}
	public List<Userinfo> getUsers() {
		return users;
	}
	public void setUsers(List<Userinfo> users) {
		this.users = users;
	}
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getTotalPage() {
		return pageCount%pageSize==0?pageCount/pageSize:pageCount/pageSize+1;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getStartPage() {
		return startPage;
	}
	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}
	public Integer getEndPage() {
		return endPage;
	}
	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public LeavesAssembly(List<Leaves> leaves, List<Leavetype> types, List<Approvalstate> states, List<Userinfo> users,
			Integer pageIndex, Integer pageSize, Integer pageCount, String url) {
		super();
		this.leaves = leaves;
		this.types = types;
		this.states = states;
		this.users = users;
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
		this.url = url;
	}
	public LeavesAssembly() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LeavesAssembly [leaves=" + leaves + ", types=" + types + ", states=" + states + ", users=" + users
				+ ", pageIndex=" + pageIndex + ", pageSize=" + pageSize + ", pageCount=" + pageCount + ", totalPage="
				+ totalPage + ", startPage=" + startPage + ", endPage=" + endPage + ", url=" + url + "]";
	}
}
