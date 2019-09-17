package com.woniuxy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.bean.LeavesAssembly;
import com.woniuxy.entity.Leaves;
import com.woniuxy.entity.Userinfo;
import com.woniuxy.service.LeaveService;

@Controller
@RequestMapping("/leave")
public class LeaveController {
	@Autowired
	LeaveService leaveService;
	//请假查询分页
	@RequestMapping("/query/{name}/{pageIndex}")
	public String query(@PathVariable("name") String name, Model model, @PathVariable("pageIndex") Integer pageIndex,
			HttpSession session) {
		int uid = (int) session.getAttribute("uid");
		int pageSize = 5;
		List<Integer> ids = new ArrayList<Integer>();
		List<Userinfo> users = leaveService.selectUserByUname(name);
		LeavesAssembly leaves = null;
		if (users == null||users.size()<=0) {
			ids.add(uid);
		} else {
			for (Userinfo userinfo : users) {
				ids.add(userinfo.getUid());
			}
		}
		leaves = leaveService.selectAll(ids, pageIndex, pageSize,name);
		model.addAttribute("leaves", leaves);
		return "system/leave";
	}

	@ResponseBody
	@RequestMapping("/insert")
	public int insert(Model model, Leaves leave, HttpSession session) {
		leave.setUid((int) session.getAttribute("uid"));
		return leaveService.insertLeave(leave);
	}

	@ResponseBody
	@RequestMapping("/change")
	public int change(Model model, Leaves leave) {
		return leaveService.changeLeave(leave);
	}

	@RequestMapping("/remove")
	@RequiresPermissions("leave:delete")
	public String remove(Model model, Integer lid, Integer uid) {
		leaveService.removeLeave(lid);
		return "redirect:/leave/query/null/1";
	}
}
