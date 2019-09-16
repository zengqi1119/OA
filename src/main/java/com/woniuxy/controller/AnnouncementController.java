package com.woniuxy.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.woniuxy.bean.AllAnnouncements;
import com.woniuxy.entity.Accept;
import com.woniuxy.entity.Announcement;
import com.woniuxy.entity.ChangeAnnouncement;
import com.woniuxy.entity.Userinfo;
import com.woniuxy.service.AnnouncementService;

/**
 * 公告业务控制器 处理公告业务的相应业务逻辑层方法调用 以及异常捕获处理
 * 
 * @author ZX
 *
 */

@Controller
@RequestMapping("/announcement")
public class AnnouncementController {

	@Autowired
	AnnouncementService announcementService;

	// 查询除当前用户外的所有员工
	@RequestMapping("/user")
	public String queryUser(Model model,HttpSession session) {
		Integer uid = (Integer) session.getAttribute("uid");
		List<Userinfo> users = announcementService.queryUserinfo(uid);
		model.addAttribute("users", users);
		return "system/noticeAdd.html";
	}

	// 根据员工编号查询员工信息
	@ResponseBody
	@RequestMapping("/find")
	public Userinfo getUserinfo(Integer uid) {
		List<Userinfo> findUsers = announcementService.findUserinfo(uid);
		Userinfo findUser = findUsers.get(0);
		return findUser;
	}

	// 个人公告提交
	@RequestMapping("/submit")
	public String announcementSubmit(String box, Announcement announcement, Model model,HttpSession session) {
		if (announcement == null) {
			model.addAttribute("msg", "请填写相关信息");
			return "system/noticeAdd.html";
		}
		if (announcement.getTitle() == null || "".equals(announcement.getTitle())) {
			model.addAttribute("msg", "请填写标题");
			return "system/noticeAdd.html";
		}
		if (announcement.getDigest() == null || "".equals(announcement.getDigest())) {
			model.addAttribute("msg", "请填写内容");
			return "system/noticeAdd.html";
		}
		if(box==null||"".equals(box)) {
			model.addAttribute("msg", "请选择收件人");
			return "system/noticeAdd.html";
		}
		Integer uid = (Integer) session.getAttribute("uid");
		announcement.setUid(uid);
		announcementService.insertAnnouncementGetAid(announcement);
		Integer aid = announcement.getAid();
		List<Integer> uids = splitBox(box);
		announcementService.addReceive(announcement.getUid(), aid, uids);
		return noticeQuery(1,1,1,model,session);
	}

	public List<Integer> splitBox(String box) {
		String[] split = box.split(",");
		List<Integer> uids = new ArrayList<Integer>();
		for (int i = 0; i < split.length; i++) {
			uids.add(Integer.parseInt(split[i]));
		}
		return uids;
	}

	// 个人公告查询
	@RequestMapping("/query/{sendPageIndex}/{receivePageIndex}/{fla}")
	public String noticeQuery(@PathVariable("sendPageIndex") Integer sendPageIndex,@PathVariable("receivePageIndex") Integer receivePageIndex,@PathVariable("fla") Integer fla,Model model,HttpSession session) {
		Integer uid = (Integer) session.getAttribute("uid");
		model.addAttribute("fla", fla);
		Integer pageSize = 1;
		String url = "/announcement/query/";
		AllAnnouncements allAnnouncements = announcementService.queryAnnouncementByUid(uid, sendPageIndex, receivePageIndex, pageSize);
		allAnnouncements.setUrl(url);
		model.addAttribute("allAnnouncements", allAnnouncements);
		return "system/noticeMy.html";
	}

	// 修改公告
	@RequestMapping("/modify")
	public String modifyAnnouncement(String ucid, String box, Announcement announcement, Model model,HttpSession session) {
		if (announcement == null) {
			model.addAttribute("msg", "请填写相关信息");
			return "system/noticeAdd.html";
		}
		if (announcement.getTitle() == null || "".equals(announcement.getTitle())) {
			model.addAttribute("msg", "请填写标题");
			return "system/noticeAdd.html";
		}
		if (announcement.getDigest() == null || "".equals(announcement.getDigest())) {
			model.addAttribute("msg", "请填写内容");
			return "system/noticeAdd.html";
		}
		if(box==null||"".equals(box)) {
			model.addAttribute("msg", "请选择收件人");
			return "system/noticeAdd.html";
		}
		announcementService.modifyAnnouncement(announcement);
		List<Integer> ucids = splitBox(ucid);
		announcementService.removeReceive(ucids, announcement.getAid());
		List<Integer> uids = splitBox(box);
		announcementService.addReceive(announcement.getUid(), announcement.getAid(), uids);
		return noticeQuery(1,1,1,model,session);
	}

	// 查询修改公告信息
	@RequestMapping("/getAnnouncement")
	public String getAnnouncementByAid(Integer aid, Model model) {
		List<Announcement> announcements = announcementService.getAnnouncementByAid(aid);
		Announcement announcement = announcements.get(0);
		String path = announcement.getAurl();
		File upload = new File(path);
		List<Userinfo> sends = announcementService.getSendUserinfo(announcement.getUid());
		Userinfo send = sends.get(0);
		List<Accept> accepts = announcementService.getReceiveUid(aid);
		List<Integer> uids = new ArrayList<Integer>();
		String ucid = "";
		for (int i = 0; i < accepts.size(); i++) {
			uids.add(accepts.get(i).getUcid());
			ucid = ucid+accepts.get(i).getUcid()+",";
		}
		List<Userinfo> receive = announcementService.getReceiveUserinfo(uids);
		List<Userinfo> users = announcementService.queryUserinfo(announcement.getUid());
		ChangeAnnouncement changeAnnouncement = new ChangeAnnouncement(send, receive, announcement, users);
		model.addAttribute("changeAnnouncement", changeAnnouncement);
		model.addAttribute("upload", upload);
		model.addAttribute("ucid", ucid);
		return "system/noticeDetail.html";
	}

	// 文件上传
	@RequestMapping("/upload")
	public String upload(String box, Announcement announcement, @RequestParam("filename") MultipartFile file,
			Model model,HttpSession session) {
		if (file.isEmpty()) {
			return announcementSubmit(box, announcement, model,session);
		}
		// 获取文件名称
		String fileName = file.getOriginalFilename();
		// 获取文件大小
		int size = (int) file.getSize();
		System.out.println(fileName + "----" + size);
		// 设置文件上传根目录
		String path = "E:/OA/file";
		// 设置文件上传全路径
		File dest = new File(path + "/" + fileName);
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdir();
		}
		try {
			// 将文件上传到本地
			file.transferTo(dest);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "上传失败,请重试");
			return "system/noticeAdd.html";
		}
		announcement.setAurl(path + "/" + fileName);
		return announcementSubmit(box, announcement, model,session);
	}

	// 文件下载
	@RequestMapping("/download")
	public void download(String path, Model model, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		File download = new File(path);
		if (!download.exists()) {
			request.setAttribute("mes", "您要下载的资源已删除!");
		}
		// 获取文件名
		String fileName = path.substring(path.lastIndexOf("/") + 1);
		System.out.println(fileName);
		// 设置响应头,控制浏览器下载文件
		response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
		// 读取要下载的文件,保存到文件输入流
		FileInputStream in = new FileInputStream(download);
		// 创建输出流
		OutputStream out = response.getOutputStream();
		// 创建缓冲区
		byte buffer[] = new byte[1024];
		int len = 0;
		// 循环将输入流中的内容读取到缓冲区当中
		while ((len = in.read(buffer)) > 0) {
			// 输出缓冲区的内容到浏览器,实现文件下载
			out.write(buffer, 0, len);
		}
		// 关闭文件输入流
		in.close();
		// 关闭输出流
		out.close();
	}
}
