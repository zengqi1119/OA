package com.woniuxy.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.bean.PermissionPage;
import com.woniuxy.service.PermissionService;

@Controller
@RequestMapping("/permission")
public class PermissionController {
	
	@Autowired
	PermissionService permissionService;
	@RequiresPermissions("user:permission")
	@RequestMapping("/query/{name}/{pageIndex}")
	public String selectPermission(Model model,@PathVariable("name")String name,
			@PathVariable("pageIndex")Integer pageIndex,HttpSession session) {
		int pageSize = 5;
		PermissionPage pages = permissionService.selectByCondition(pageIndex,pageSize,name,session);
		model.addAttribute("pages", pages);
		System.out.println(pages);
		return "system/permission";
	}
	@ResponseBody
	@RequestMapping("/update")
	public int updateUserRole(Model model,int uid,int rid) {
		return permissionService.updateUserrole(uid,rid);
	}
}
