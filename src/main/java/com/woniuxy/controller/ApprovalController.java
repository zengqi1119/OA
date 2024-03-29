package com.woniuxy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.bean.AprovalAssemble;
import com.woniuxy.bean.AprovalAssemblePage;
import com.woniuxy.service.ApprovalService;
/**
 * 查询所有
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/approval")
public class ApprovalController {
	@Autowired
	ApprovalService approvalService; 
	/**
	 * 通过uid查询审批信息
	 * @param model
	 * @param uid
	 * @return
	 */
@RequestMapping("/query")
public String queerySingle(Model model,HttpSession session) {
	int uid=(int) session.getAttribute("uid");
	AprovalAssemble approvals = approvalService.queryByUid(uid);
	model.addAttribute("approvals", approvals);
	return "system/examine";
}
/**
 * 查询所有审批信息 
 * @param model
 * @return
 */
@RequestMapping("/queryall/{pageIndex}")
public String queerySingle(Model model,@PathVariable("pageIndex")Integer pageIndex) {
	int pageSize=5;
	model.addAttribute("approvals", approvalService.queryAll(pageIndex,pageSize));
	return "system/examine";
}
@ResponseBody
@RequestMapping("/examine")
public int examine(int state,int id,int aptid) {
	return approvalService.approval(state,id,aptid);
}
}
