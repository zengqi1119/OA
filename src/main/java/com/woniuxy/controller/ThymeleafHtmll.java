package com.woniuxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafHtmll {
	//头界面跳转
	@RequestMapping("/top")
	public String top() {
		return "system/index/top";
	}

	//菜单界面跳转
	@RequestMapping("/menu")
	public String menu() {
		return "system/index/menu";
	}

	//内容界面跳转
	@RequestMapping("/content")
	public String content() {
		return "system/index/content";
	}
	
	//发布公告界面跳转
	@RequestMapping("/noticeadd")
	public String noticeAdd() {
		return "system/noticeAdd";
	}
	
	//公告审批界面跳转
	@RequestMapping("/noticeexamin")
	public String noticeExamin() {
		return "system/noticeExamin";
	}
	
	//我的公告界面跳转
	@RequestMapping("/noticemy")
	public String noticeMy() {
		return "system/noticeMy";
	}
	
	//报销管理界面跳转
	@RequestMapping("/apply")
	public String apply() {
		return "system/apply";
	}
	
	//公告审批界面跳转
	@RequestMapping("/noticedetail")
	public String noticeDetail() {
		return "system/noticeDetail";
	}
	
	@RequestMapping("/applyadd")
	public String applyAdd() {
		return "system/applyadd";
	}
}
