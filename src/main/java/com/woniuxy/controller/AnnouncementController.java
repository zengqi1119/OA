package com.woniuxy.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.woniuxy.entity.Accept;
import com.woniuxy.entity.AllAnnouncements;
import com.woniuxy.entity.Announcement;
import com.woniuxy.entity.Userinfo;
import com.woniuxy.service.AnnouncementService;

import ch.qos.logback.core.pattern.Converter;
import ch.qos.logback.core.pattern.ConverterUtil;

/**
 * 公告业务控制器
 * 处理公告业务的相应业务逻辑层方法调用
 * 以及异常捕获处理
 * @author ZX
 *
 */

@Controller
@RequestMapping("/announcement")
public class AnnouncementController {
	
	@Autowired
	AnnouncementService announcementService;
	
	//查询除当前用户外的所有员工
	@RequestMapping("/user")
	public String queryUser(Integer uid,Model model) {
		List<Userinfo> users = announcementService.queryUserinfo(uid);
		model.addAttribute("users", users);
		return "system/noticeAdd.html";
	}
	
	//根据员工编号查询员工信息
	@ResponseBody
	@RequestMapping("/find")
	public Userinfo getUserinfo(Integer uid) {
		List<Userinfo> findUsers = announcementService.findUserinfo(uid);
		Userinfo findUser = findUsers.get(0);
		return findUser;
	}
	
	//个人公告提交
	@RequestMapping("/submit")
	public String announcementSubmit(String box,Announcement announcement,Model model) {
		if(announcement==null) {
			model.addAttribute("msg", "请填写相关信息");
			return "system/noticeAdd.html";
		}
		if(announcement.getTitle()==null || "".equals(announcement.getTitle())){
			model.addAttribute("msg", "请填写标题");
			return "system/noticeAdd.html";
		}
		if(announcement.getDigest()==null || "".equals(announcement.getDigest())){
			model.addAttribute("msg", "请填写内容");
			return "system/noticeAdd.html";
		}
		announcementService.insertAnnouncementGetAid(announcement);
		Integer aid = announcement.getAid();
		List<Integer> uids = splitBox(box);
		announcementService.addReceive(announcement.getUid(),aid,uids);
		return noticeQuery(announcement.getUid(),model);
	}
	
	public List<Integer> splitBox(String box) {
		String[] split = box.split(",");
		List<Integer> uids = new ArrayList<Integer>();
		for(int i=0;i<split.length;i++) {
			uids.add(Integer.parseInt(split[i]));
		}
		return uids;
	}

	//个人接收公告查询
	@RequestMapping("/query")
	public String noticeQuery(Integer uid,Model model) {
		List<Announcement> announcements = announcementService.queryAnnouncementByUid(uid);
		model.addAttribute("announcements", announcements);
		List<Accept> accepts = announcementService.queryAccept(uid);
		List<Integer> aid = new ArrayList<Integer>();
		for (int i = 0; i < accepts.size(); i++) {
			aid.add(accepts.get(i).getAid());
		}
		List<Announcement> announcement = announcementService.queryAnnouncements(aid);
		List<Integer> uids = new ArrayList<Integer>();
		for (int i = 0; i < announcement.size(); i++) {
			uids.add(announcement.get(i).getUid());
		}
		List<Userinfo> userinfo = announcementService.queryReceive(uids);
		AllAnnouncements allAnnouncements = new AllAnnouncements(announcement,accepts,userinfo);
		model.addAttribute("allAnnouncements", allAnnouncements);
		return "system/noticeMy.html";
	}
	
	//文件上传
	@RequestMapping("/upload")
	public String upload(String box,Announcement announcement,@RequestParam("filename") MultipartFile file,Model model) {
		if(file.isEmpty()) {
			return announcementSubmit(box,announcement,model);
		}
		//获取文件名称
		String fileName = file.getOriginalFilename();
		//获取文件大小
		int size = (int) file.getSize();
		System.out.println(fileName+"----"+size);
		//设置文件上传根目录
		String path = "E:/OA/file";
		//设置文件上传全路径
		File dest = new File(path+"/"+fileName);
		if(!dest.getParentFile().exists()) {
			dest.getParentFile().mkdir();
		}
		try {
			//将文件上传到本地
			file.transferTo(dest);
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "上传失败,请重试");
			return "system/noticeAdd.html";
		}
		announcement.setAurl(path+"/"+fileName);
		return announcementSubmit(box,announcement,model);
	}
}
