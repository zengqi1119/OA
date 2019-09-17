package com.woniuxy.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.bean.ApplyUser;
import com.woniuxy.entity.Apply;
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
	@RequiresRoles("user")
	public String queryApplyByUid(@PathVariable("pageIndex") Integer pageIndex,Model model,HttpSession session) {
		Integer uid = (Integer) session.getAttribute("uid");
		System.out.println(uid);
		if(uid==null) {
			model.addAttribute("error", "系统维护中,抱歉");
			return "error.thml";
		}
		ApplyUser applyUser = new ApplyUser();
		try {
			Integer pageSize = 5;
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
	
	@RequestMapping("/queryAll/{condition}/{pageIndex}")
	@RequiresRoles("admin")
	public String queryApplyAll(@PathVariable("condition") String condition,@PathVariable("pageIndex") Integer pageIndex,Model model,HttpSession session) {
		model.addAttribute("condition", condition);
		String url = "/apply/queryAll/"+condition+"/";
		if(condition.equals("姓名")) {
			condition="";
		}
		System.out.println(pageIndex);
		Integer uid = (Integer) session.getAttribute("uid");
		if(uid==null) {
			model.addAttribute("error", "系统维护中,抱歉");
			return "error.thml";
		}
		ApplyUser applyUser = new ApplyUser();
		try {
			Integer pageSize = 10;
			applyUser = applyService.queryApplyAll(condition,pageIndex,pageSize);
			applyUser.setUrl(url);
			model.addAttribute("applyUser", applyUser);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "系统维护中,抱歉");
			return "error.html";
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
		String role = (String) session.getAttribute("role");
		try {
			applyService.removeApply(appid);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "系统维护中,抱歉");
			return "error.html";
		}
		if("user".equals(role)) {
			return queryApplyByUid(1,model,session);
		}else {
			return queryApplyAll("",1,model,session);
		}
	}
}
