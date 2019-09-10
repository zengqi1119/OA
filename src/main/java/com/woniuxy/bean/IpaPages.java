package com.woniuxy.bean;

import java.util.List;

public class IpaPages <T>{
private int totalCount;
private int totalpage;
private int indexPage;
private int pageSize;
private List<T> IpaList;
private String state;
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public int getTotalCount() {
	return totalCount;
}
public void setTotalCount(int totalCount) {
	this.totalCount = totalCount;
}
public int getTotalpage() {
	return totalpage=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
}
public void setTotalpage(int totalpage) {
	this.totalpage = totalpage;
}
public int getIndexPage() {
	return indexPage;
}
public void setIndexPage(int indexPage) {
	this.indexPage = indexPage;
}
public int getPageSize() {
	return pageSize;
}
public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}
public List<T> getIpaList() {
	return IpaList;
}
public void setIpaList(List<T> ipaList) {
	IpaList = ipaList;
}

@Override
public String toString() {
	return "IpaPages [totalCount=" + totalCount + ", totalpage=" + totalpage + ", indexPage=" + indexPage
			+ ", pageSize=" + pageSize + ", IpaList=" + IpaList + ", state=" + state + "]";
}
public IpaPages(int totalCount, int totalpage, int indexPage, int pageSize, List<T> ipaList, String state) {
	super();
	this.totalCount = totalCount;
	this.totalpage = totalpage;
	this.indexPage = indexPage;
	this.pageSize = pageSize;
	IpaList = ipaList;
	this.state = state;
}
public IpaPages() {
	super();
}

}
