package com.woniuxy.bean;

import java.io.Serializable;
import java.util.List;

import com.woniuxy.entity.Accept;
import com.woniuxy.entity.Announcement;
import com.woniuxy.entity.Userinfo;

public class AllAnnouncements implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<Announcement> send;
	private List<Announcement> receive;
	private List<Accept> accepts;
	private List<Userinfo> userinfo;
	private Integer sendPageIndex;
	private Integer receivePageIndex;
	private Integer pageSize;
	private Integer sendTotalPage;
	private Integer receiveTotalPage;
	private Integer sendCount;
	private Integer receiveCount;
	private Integer sendBeginPage;
	private Integer sendEndPage;
	private Integer receiveBeginPage;
	private Integer receiveEndPage;
	private String url;
	public void setSendBeginPageAndEndPage(){
		if(getSendTotalPage()<10){
			sendBeginPage=1;
			sendEndPage=getSendTotalPage();
		}else{
			sendBeginPage = sendPageIndex-5;
			sendEndPage = sendPageIndex+4;
			if(sendPageIndex-5<1){
				sendBeginPage=1;
				sendEndPage=10;
			}
			if(sendPageIndex+4>getSendTotalPage()){
				sendBeginPage = getSendTotalPage()-9;
				sendEndPage = getSendTotalPage();
			}
		}
	}
	public void setReceiveBeginPageAndEndPage(){
		if(getReceiveTotalPage()<10){
			receiveBeginPage=1;
			receiveEndPage=getReceiveTotalPage();
		}else{
			receiveBeginPage = receivePageIndex-5;
			receiveEndPage = receivePageIndex+4;
			if(receivePageIndex-5<1){
				receiveBeginPage=1;
				receiveEndPage=10;
			}
			if(receivePageIndex+4>getReceiveTotalPage()){
				receiveBeginPage = getReceiveTotalPage()-9;
				receiveEndPage = getReceiveTotalPage();
			}
		}
	}
	public AllAnnouncements() {
		super();
	}
	public AllAnnouncements(List<Announcement> send, List<Announcement> receive, List<Accept> accepts,
			List<Userinfo> userinfo, Integer sendPageIndex, Integer receivePageIndex, Integer pageSize,
			Integer sendTotalPage, Integer receiveTotalPage, Integer sendCount, Integer receiveCount,
			Integer sendBeginPage, Integer sendEndPage, Integer receiveBeginPage, Integer receiveEndPage, String url) {
		super();
		this.send = send;
		this.receive = receive;
		this.accepts = accepts;
		this.userinfo = userinfo;
		this.sendPageIndex = sendPageIndex;
		this.receivePageIndex = receivePageIndex;
		this.pageSize = pageSize;
		this.sendTotalPage = sendTotalPage;
		this.receiveTotalPage = receiveTotalPage;
		this.sendCount = sendCount;
		this.receiveCount = receiveCount;
		this.sendBeginPage = sendBeginPage;
		this.sendEndPage = sendEndPage;
		this.receiveBeginPage = receiveBeginPage;
		this.receiveEndPage = receiveEndPage;
		this.url = url;
	}
	public List<Announcement> getSend() {
		return send;
	}
	public void setSend(List<Announcement> send) {
		this.send = send;
	}
	public List<Announcement> getReceive() {
		return receive;
	}
	public void setReceive(List<Announcement> receive) {
		this.receive = receive;
	}
	public List<Accept> getAccepts() {
		return accepts;
	}
	public void setAccepts(List<Accept> accepts) {
		this.accepts = accepts;
	}
	public List<Userinfo> getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(List<Userinfo> userinfo) {
		this.userinfo = userinfo;
	}
	public Integer getSendPageIndex() {
		return sendPageIndex;
	}
	public void setSendPageIndex(Integer sendPageIndex) {
		this.sendPageIndex = sendPageIndex;
	}
	public Integer getReceivePageIndex() {
		return receivePageIndex;
	}
	public void setReceivePageIndex(Integer receivePageIndex) {
		this.receivePageIndex = receivePageIndex;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getSendTotalPage() {
		return sendCount%pageSize==0 ? sendCount/pageSize : sendCount/pageSize+1;
	}
	public void setSendTotalPage(Integer sendTotalPage) {
		this.sendTotalPage = sendTotalPage;
	}
	public Integer getReceiveTotalPage() {
		return receiveCount%pageSize==0 ? receiveCount/pageSize : receiveCount/pageSize+1;
	}
	public void setReceiveTotalPage(Integer receiveTotalPage) {
		this.receiveTotalPage = receiveTotalPage;
	}
	public Integer getSendCount() {
		return sendCount;
	}
	public void setSendCount(Integer sendCount) {
		this.sendCount = sendCount;
	}
	public Integer getReceiveCount() {
		return receiveCount;
	}
	public void setReceiveCount(Integer receiveCount) {
		this.receiveCount = receiveCount;
	}
	public Integer getSendBeginPage() {
		return sendBeginPage;
	}
	public void setSendBeginPage(Integer sendBeginPage) {
		this.sendBeginPage = sendBeginPage;
	}
	public Integer getSendEndPage() {
		return sendEndPage;
	}
	public void setSendEndPage(Integer sendEndPage) {
		this.sendEndPage = sendEndPage;
	}
	public Integer getReceiveBeginPage() {
		return receiveBeginPage;
	}
	public void setReceiveBeginPage(Integer receiveBeginPage) {
		this.receiveBeginPage = receiveBeginPage;
	}
	public Integer getReceiveEndPage() {
		return receiveEndPage;
	}
	public void setReceiveEndPage(Integer receiveEndPage) {
		this.receiveEndPage = receiveEndPage;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "AllAnnouncements [send=" + send + ", receive=" + receive + ", accepts=" + accepts + ", userinfo="
				+ userinfo + ", sendPageIndex=" + sendPageIndex + ", receivePageIndex=" + receivePageIndex
				+ ", pageSize=" + pageSize + ", sendTotalPage=" + sendTotalPage + ", receiveTotalPage="
				+ receiveTotalPage + ", sendCount=" + sendCount + ", receiveCount=" + receiveCount + ", sendBeginPage="
				+ sendBeginPage + ", sendEndPage=" + sendEndPage + ", receiveBeginPage=" + receiveBeginPage
				+ ", receiveEndPage=" + receiveEndPage + ", url=" + url + "]";
	}
}
