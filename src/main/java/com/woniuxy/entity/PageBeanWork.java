package com.woniuxy.entity;

import java.util.List;

public class PageBeanWork<T> {
	private List<T> beanlist;
	private Integer pageIndex;
	private Integer pageSize;
	private Integer totalPage;
	private Integer totalRecord;
	private Integer pageBegin;
	private Integer pageEnd;

	public List<T> getBeanlist() {
		return beanlist;
	}
	public void setBeanlist(List<T> beanlist) {
		this.beanlist = beanlist;
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
		return totalRecord%pageSize==0?totalRecord/pageSize:totalRecord/pageSize+1;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}
	public Integer getPageBegin() {
		return pageBegin;
	}
	public void setPageBegin(Integer pageBegin) {
		this.pageBegin = pageBegin;
	}
	public Integer getPageEnd() {
		return pageEnd;
	}
	public void setPageEnd(Integer pageEnd) {
		this.pageEnd = pageEnd;
	}
	
	public PageBeanWork() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageBeanWork(List<T> beanlist, Integer pageIndex, Integer pageSize, Integer totalPage, Integer totalRecord,
			Integer pageBegin, Integer pageEnd) {
		super();
		this.beanlist = beanlist;
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.totalPage = totalPage;
		this.totalRecord = totalRecord;
		this.pageBegin = pageBegin;
		this.pageEnd = pageEnd;
	
	}
	
	@Override
	public String toString() {
		return "PageBean [beanlist=" + beanlist + ", pageIndex=" + pageIndex + ", pageSize=" + pageSize + ", totalPage="
				+ getTotalPage() + ", totalRecord=" + totalRecord + ", pageBegin=" + pageBegin + ", pageEnd=" + pageEnd
				+ "]";
	}
	public void setPage() {
		if(getTotalPage()<10) {
			pageBegin = 1;
			pageEnd = getTotalPage();
		}else {
			pageBegin = pageIndex - 5;
			pageEnd = pageIndex + 4;
			if(pageIndex-5<1) {
				pageBegin = 1;
				pageEnd = 10;
			}
			if(pageIndex+4>getTotalPage()) {
				pageBegin = getTotalPage()-9;
				pageEnd = getTotalPage();
			}
		}
	}
	
}
