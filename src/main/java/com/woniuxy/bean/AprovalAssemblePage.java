package com.woniuxy.bean;

import java.util.List;

import com.woniuxy.entity.Approvalstate;
import com.woniuxy.entity.Approvaltype;
import com.woniuxy.entity.Leavetype;
import com.woniuxy.entity.Userinfo;

public class AprovalAssemblePage {
	private List<Userinfo> users;//用户列表
	private List<Approvaltype> atypes;//审批类型
	private List<Approvalstate> states;//审批状态
	private List<Leavetype> ltypes;//请假类型
	private List<ApprovalEntity> elements;//元素信息
	Integer pageIndex;// 当前页
	Integer pageSize;// 页大小
	Integer pageCount;// 总数量
	Integer totalPage;// 总页数
	Integer startPage;// 起始页
	Integer endPage;// 结束页
	String url;
	
	public void setStartandEnd() {
		if (pageIndex > getTotalPage()) {
			startPage = 0;
			endPage = 0;
		} else if (getTotalPage() < 10) {
			startPage = 1;
			endPage = getTotalPage();
		} else {
			if (pageIndex - 4 > 1) {
				startPage = pageIndex - 4;
			} else {
				startPage = 1;
			}
			if (pageIndex + 5 > getTotalPage()) {
				endPage = getTotalPage();
			} else {
				endPage = pageIndex + 5;
			}
		}
	}

	public List<Userinfo> getUsers() {
		return users;
	}
	public void setUsers(List<Userinfo> users) {
		this.users = users;
	}
	public List<Approvaltype> getAtypes() {
		return atypes;
	}
	public void setAtypes(List<Approvaltype> atypes) {
		this.atypes = atypes;
	}
	public List<Approvalstate> getStates() {
		return states;
	}
	public void setStates(List<Approvalstate> states) {
		this.states = states;
	}
	public List<Leavetype> getLtypes() {
		return ltypes;
	}
	public void setLtypes(List<Leavetype> ltypes) {
		this.ltypes = ltypes;
	}
	public List<ApprovalEntity> getElements() {
		return elements;
	}
	public void setElements(List<ApprovalEntity> elements) {
		this.elements = elements;
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
		return pageCount % pageSize == 0 ? pageCount / pageSize : pageCount / pageSize + 1;
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
	public AprovalAssemblePage(List<Userinfo> users, List<Approvaltype> atypes, List<Approvalstate> states,
			List<Leavetype> ltypes, List<ApprovalEntity> elements, Integer pageIndex, Integer pageSize,
			Integer pageCount,  String url) {
		super();
		this.users = users;
		this.atypes = atypes;
		this.states = states;
		this.ltypes = ltypes;
		this.elements = elements;
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
		this.url = url;
	}
	public AprovalAssemblePage() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AprovalAssemblePage [users=" + users + ", atypes=" + atypes + ", states=" + states + ", ltypes="
				+ ltypes + ", elements=" + elements + ", pageIndex=" + pageIndex + ", pageSize=" + pageSize
				+ ", pageCount=" + pageCount + ", totalPage=" + totalPage + ", startPage=" + startPage + ", endPage="
				+ endPage + ", url=" + url + "]";
	}
	
}
