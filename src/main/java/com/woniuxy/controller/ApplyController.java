package com.woniuxy.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.bean.ApplyUser;
import com.woniuxy.entity.Apply;
import com.woniuxy.entity.Userinfo;
import com.woniuxy.service.ApplyService;

/**
 * 报销业务控制器
 * 处理报销业务逻辑层方法调用
 * 异常捕获及处理
 * @author ZX
 *
 */

@Controller
@RequestMapping("/apply")
public class ApplyController {
	
	@Autowired
	ApplyService applyService;
	
	//根据用户ID查询对应报销项
	@RequestMapping("/query/{pageIndex}")
	public String queryApplyByUid(@PathVariable("pageIndex") Integer pageIndex,Model model,HttpSession session) {
		Integer uid = (Integer) session.getAttribute("uid");
		if(uid==null) {
			model.addAttribute("error", "系统维护中,抱歉");
			return "system/error.thml";
		}
		ApplyUser applyUser = new ApplyUser();
		try {
			Integer pageSize = 10;
			String url = "/apply/query/";
			applyUser = applyService.queryApplyByUid(uid,pageIndex,pageSize);
			applyUser.setUrl(url);
			model.addAttribute("applyUser", applyUser);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "系统维护中,抱歉");
			return "system/error.html";
		}
		return "system/apply.html";
	}
	
	//添加报销项
	@ResponseBody
	@RequestMapping("/add")
	public Integer addApply(Apply apply,Model model,HttpSession session) {
		Integer uid = (Integer) session.getAttribute("uid");
		apply.setUid(uid);
		if(apply.getUid()==null) {
			model.addAttribute("error", "系统维护中,抱歉");
			return 2;
		}	
		if(apply.getItem()==null||"".equals(apply.getItem())) {
			model.addAttribute("msg", "报销项目不能为空");
			return 1;
		}
		if(apply.getAmount()==null||apply.getAmount()==0) {
			model.addAttribute("msg", "报销单价不能为0");
			return 1;
		}
		try {
			apply.setApptime(new Date());
			applyService.addApply(apply);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "系统维护中,抱歉");
			return 2;
		}
		return 0;
	}
	
	//修改报销项
	@ResponseBody
	@RequestMapping("/modify")
	public Integer modifyApply(Apply apply,Model model) {
		if(apply.getUid()==null) {
			model.addAttribute("error", "系统维护中,抱歉");
			return 2;
		}	
		if(apply.getItem()==null||"".equals(apply.getItem())) {
			model.addAttribute("msg", "报销项目不能为空");
			return 1;
		}
		if(apply.getAmount()==null||apply.getAmount()==0) {
			model.addAttribute("msg", "报销单价不能为0");
			return 1;
		}
		try {
			applyService.modifyApply(apply);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "系统维护中,抱歉");
			return 2;
		}
		return 0;
	}
	
	//移除报销项
	@RequestMapping("/remove")
	public String removeApply(Integer appid,Model model,HttpSession session) {
		try {
			applyService.removeApply(appid);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "系统维护中,抱歉");
			return "system/error.html";
		}
		return queryApplyByUid(1,model,session);
	}
}
