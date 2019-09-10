package com.woniuxy.bean;

import java.io.Serializable;
import java.util.List;

public class PageBean<T> implements Serializable{
	private Integer currentpage;	//当前页
	private Integer count;			//每一页数量
	private Integer totalPage;		//总页数
	private Integer total;			//总条数
	private List<T> elements;	//当前页的内容
	private Integer beginPage;		//首页
	private Integer endPage;		//末页
	private String url;	        //翻页的url

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setEndPageAndBeginPage(){
		//不够10页
		if(getTotalPage()<10){
			beginPage=1;
			endPage=getTotalPage();
		}else {
			beginPage=currentpage-5;
			endPage=currentpage+4;
			//上边界线(右) 6为分界点
			if(currentpage-5<1){
				beginPage=1;
				endPage=10;
			}
			//下标界线（左） 6为分界点
			if(currentpage+4>getTotalPage()){
				beginPage=getTotalPage()-9;
				endPage=getTotalPage();
			}
		}
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

	public PageBean(Integer beginPage, Integer endPage) {
	super();
	this.beginPage = beginPage;
	this.endPage = endPage;
}

	
	public Integer getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(Integer currentpage) {
		this.currentpage = currentpage;
	}

	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<T> getElements() {
		return elements;
	}
	public void setElements(List<T> elements) {
		this.elements = elements;
	}
	public PageBean(Integer currentPage, Integer count, Integer totalPage, Integer total, List<T> elements) {
		super();
		this.currentpage = currentPage;
		this.count = count;
		this.totalPage = totalPage;
		this.total = total;
	}
	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PageBean [currentpage=" + currentpage + ", count=" + count + ", totalPage=" + totalPage + ", total="
				+ total + ", elements=" + elements + ", beginPage=" + beginPage + ", endPage=" + endPage + ", url="
				+ url + "]";
	}
	
	
}
