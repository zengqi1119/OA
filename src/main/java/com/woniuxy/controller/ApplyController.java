package com.woniuxy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.entity.Apply;
import com.woniuxy.entity.ApplyUser;
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
	@RequestMapping("/query")
	public String queryApplyByUid(Integer uid,Model model) {
		System.out.println("111");
		if(uid==null) {
			model.addAttribute("error", "系统维护中,抱歉");
			return "system/error.thml";
		}
		try {
			List<Apply> applys = applyService.queryApplyByUid(uid);
			List<Userinfo> users = applyService.queryUserinfoByUid(uid);
			Userinfo user = users.get(0);
			ApplyUser applyUser = new ApplyUser(applys, user);
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
	public Integer addApply(Apply apply,Model model) {
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
	public String removeApply(Integer appid,Integer uid,Model model) {
		try {
			applyService.removeApply(appid);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "系统维护中,抱歉");
			return "system/error.html";
		}
		return queryApplyByUid(uid,model);
	}
}
