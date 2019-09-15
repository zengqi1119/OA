package com.woniuxy.bean;

import java.util.List;

public class OvertimePageBean<T> {
	private List<T> beanList;//当前页码内容
	private int pageIndex;//当前页码
	private int pageSize;//页大小
	private int totalRecored;//总记录
	private int totalPage;//总页数
	private int pageBegin;//开始页数
	private int pageEnd;//结束页数
	private String url;//储存请求路径和条件
	
	
	public OvertimePageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OvertimePageBean(List<T> beanList, int pageIndex, int pageSize, int totalRecored, int totalPage, int pageBegin,
			int pageEnd, String url) {
		super();
		this.beanList = beanList;
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.totalRecored = totalRecored;
		this.totalPage = totalPage;
		this.pageBegin = pageBegin;
		this.pageEnd = pageEnd;
		this.url = url;
	}
	public List<T> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
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
		int totalPage=this.totalRecored%this.pageSize>0?this.totalRecored/this.pageSize+1:this.totalRecored/this.pageSize;
		return totalPage;
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
	
	public void setPageBeginAndPageEnd(){
		//总页码小于10
		if(pageIndex>getTotalPage()) {
			pageBegin=0;
			pageEnd=0;
		}else if(getTotalPage()<10){
			pageBegin=1;
			pageEnd=getTotalPage();
		}else{
			pageBegin=pageIndex-5;
			pageEnd=pageBegin+9;
			if(pageIndex-5<1){
				pageBegin=1;
				pageEnd=10;
			}
			if(pageIndex+4>getTotalPage()){
				pageEnd=getTotalPage();
				pageBegin=pageIndex-9;
			}			
		}
				
	}
			
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "OvertimePageBean [beanList=" + beanList + ", pageIndex=" + pageIndex + ", pageSize=" + pageSize
				+ ", totalRecored=" + totalRecored + ", totalPage=" + getTotalPage() + ", pageBegin=" + pageBegin
				+ ", pageEnd=" + pageEnd + ", url=" + url + "]";
	}
	
	
}
