package com.woniuxy.bean;

import java.io.Serializable;
import java.util.List;

import com.woniuxy.entity.Apply;
import com.woniuxy.entity.Userinfo;

public class ApplyUser implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<Apply> applys;
	private Userinfo user;
	private Integer pageIndex;
	private Integer pageSize;
	private Integer totalPage;
	private Integer count;
	private Integer beginPage;
	private Integer endPage;
	private String url;
	public ApplyUser() {
		super();
	}
	public ApplyUser(List<Apply> applys, Userinfo user, Integer pageIndex, Integer pageSize, Integer totalPage, Integer count,
			Integer beginPage, Integer endPage, String url) {
		super();
		this.applys = applys;
		this.user = user;
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.totalPage = totalPage;
		this.count = count;
		this.beginPage = beginPage;
		this.endPage = endPage;
		this.url = url;
	}
	public void setBeginPageAndEndPage(){
		if(getTotalPage()<10){
			beginPage=1;
			endPage=getTotalPage();
		}else{
			beginPage = pageIndex-5;
			endPage = pageIndex+4;
			if(pageIndex-5<1){
				beginPage=1;
				endPage=10;
			}
			if(pageIndex+4>getTotalPage()){
				beginPage = getTotalPage()-9;
				endPage = getTotalPage();
			}
		}
	}
	public List<Apply> getApplys() {
		return applys;
	}
	public void setApplys(List<Apply> applys) {
		this.applys = applys;
	}
	public Userinfo getUser() {
		return user;
	}
	public void setUser(Userinfo user) {
		this.user = user;
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
	public Integer getTotalPage() {
		return count%pageSize==0 ? count/pageSize : count/pageSize+1;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getBeginPage() {
		return beginPage;
	}
	public void setBeginPage(Integer beginPage) {
		this.beginPage = beginPage;
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
	@Override
	public String toString() {
		return "ApplyUser [applys=" + applys + ", user=" + user + ", pageIndex=" + pageIndex + ", pageSize=" + pageSize
				+ ", totalPage=" + totalPage + ", count=" + count + ", beginPage=" + beginPage + ", endPage=" + endPage
				+ ", url=" + url + "]";
	}
}
