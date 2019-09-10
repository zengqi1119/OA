package com.woniuxy.controller;

import java.net.URI;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.bean.LeavesAssembly;
import com.woniuxy.entity.Leaves;
import com.woniuxy.service.LeaveService;

@Controller
@RequestMapping("/leave")
public class LeaveController {
	@Autowired
	LeaveService leaveService;

	@RequestMapping("/query/{pageIndex}")
	public String query(Model model,@PathVariable("pageIndex")Integer pageIndex,HttpSession session) {
		int uid = (int) session.getAttribute("uid");
		int pageSize=5;
		LeavesAssembly leaves = leaveService.selectAll(uid,pageIndex,pageSize);
		model.addAttribute("leaves", leaves);
		return "system/leave";
	}
	@ResponseBody
	@RequestMapping("/insert")
	public int  insert(Model model,Leaves leave) {
		return leaveService.insertLeave(leave);
	}
	@ResponseBody
	@RequestMapping("/change")
	public int  change(Model model,Leaves leave) {
		return leaveService.changeLeave(leave);
	}  

	@RequestMapping("/remove")
	public String  remove(Model model,Integer lid,Integer uid) {
		leaveService.removeLeave(lid); 
		return "redirect:/leave/query/1";
	}
}
