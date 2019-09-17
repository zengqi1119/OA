package com.woniuxy.bean;

import java.util.List;


public class PermissionPage {
	private List<com.woniuxy.entity.Rolepermissiontable> rolepermissions;//元素信息
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
	public PermissionPage(List<com.woniuxy.entity.Rolepermissiontable> rolepermissions, Integer pageIndex, Integer pageSize,
			Integer pageCount,  String url) {
		super();
		this.rolepermissions = rolepermissions;
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
		this.url = url;
	}
	public PermissionPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<com.woniuxy.entity.Rolepermissiontable> getRolepermissions() {
		return rolepermissions;
	}

	public void setRolepermissions(List<com.woniuxy.entity.Rolepermissiontable> rolepermissions) {
		this.rolepermissions = rolepermissions;
	}

	@Override
	public String toString() {
		return "PermissionPage [rolepermissions=" + rolepermissions + ", pageIndex=" + pageIndex + ", pageSize="
				+ pageSize + ", pageCount=" + pageCount + ", totalPage=" + totalPage + ", startPage=" + startPage
				+ ", endPage=" + endPage + ", url=" + url + "]";
	}
}
