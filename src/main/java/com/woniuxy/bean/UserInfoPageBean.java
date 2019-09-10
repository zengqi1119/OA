package com.woniuxy.bean;

import java.util.List;

public class UserInfoPageBean<T> {
	private List<T> benanList;//数据库查询
	private int pageIndex;//当前页
	private int pageSize;//页大小，每页显示的数据条数
	private int totalRecored;//总记录条数
	private int totalPage;//总页数
	private int pageBegin;
	private int pageEnd;
	private String url;//封装请求路径参数，servlet赋值

	public UserInfoPageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "PageBean [benanList=" + benanList + ", pageIndex=" + pageIndex + ", pageSize=" + pageSize
				+ ", totalRecored=" + totalRecored + ", totalPage=" + getTotalPage() + ", pageBegin=" + pageBegin
				+ ", pageEnd=" + pageEnd + "url=" + url + "]";
	}

	public void setPageBeginAndPageEnd(){
	
//			不够十页
			if(getTotalPage()<10) {
				pageBegin=1;
				pageEnd=getTotalPage();
			}else {
				/*
				 * 正常情况
				 */
				pageBegin=pageIndex-5;
				pageEnd=pageIndex+4;
				
				
				/*
				 * 特殊情况
				 */
//				上边界越界
				if(pageIndex-5<1) {
					pageBegin=1;
					pageEnd=10;
				}
				
//				下边界越界
				if(pageIndex+4>getTotalPage()) {
					pageBegin=getTotalPage()-9;
					pageEnd=getTotalPage();
				}
			}
	}
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<T> getBenanList() {
		return benanList;
	}
	public void setBenanList(List<T> benanList) {
		this.benanList = benanList;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalRecored() {
		return totalRecored;
	}
	public void setTotalRecored(int totalRecored) {
		this.totalRecored = totalRecored;
	}
	public int getTotalPage() {
		return totalRecored%pageSize==0?totalRecored/pageSize:totalRecored/pageSize+1;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageBegin() {
		return pageBegin;
	}

	public void setPageBegin(int pageBegin) {
		this.pageBegin = pageBegin;
	}

	public int getPageEnd() {
		return pageEnd;
	}

	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}
	
}
