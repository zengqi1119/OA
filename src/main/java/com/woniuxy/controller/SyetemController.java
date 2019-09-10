package com.woniuxy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniuxy.bean.UserInfoPageBean;
import com.woniuxy.entity.Userinfo;
import com.woniuxy.service.SystemManagementService;
@Controller
@RequestMapping("/system")
public class SyetemController {
	@Autowired
	SystemManagementService systemManagementService;
	
	public void setSystemManagementService(SystemManagementService systemManagementService) {
		this.systemManagementService = systemManagementService;
	}
	
	
	//用户管理，查询所有用户信息
	@RequestMapping("/userList")
	public String userList(Model model) {
		List<Userinfo> userinfo = systemManagementService.selectAllUserinfo();
		System.out.println("userList"+userinfo);
		model.addAttribute("userinfo", userinfo);
		return "system/userList";
	}
	//修改用户   根据员工编号查员工信息
	@RequestMapping("/userInfo/{uid}")
	public String userInfo(@PathVariable("uid")int uid,Model model) {
		Userinfo userinfos = systemManagementService.selectUserinfoById(uid);
		model.addAttribute("userinfos", userinfos);
		System.out.println("修改用户"+userinfos);
		return "system/userInfo";
	}
	//提交修改员工信息
	@RequestMapping("/update")
	public String update(Userinfo userinfo) {
		//System.out.println("修改"+userinfo);
		int row = systemManagementService.updateByUname(userinfo);
		if(row==1) {
			return "redirect:/system/userinfoByPage";
		}else {
			System.out.println("更新失败"+userinfo);
			return "redirect/system/userinfoByPage";
		}
		
	}
	//查看详情 根据员工编号查员工信息
		@RequestMapping("/particular/{uid}")
		public String particular(@PathVariable("uid")int uid,Model model) {
			Userinfo userinfos = systemManagementService.selectUserinfoById(uid);
			model.addAttribute("userinfos", userinfos);
		//	System.out.println("asdas"+userinfos);
			return "system/particulars";
		}
	@RequestMapping("/userInfo")
	public String userInfos() {
		//System.out.println(uid);
		return "system/userInfo";
	}
	@RequestMapping("/addUser")
	public String addUser() {
		//System.out.println("list");
		return "system/addUser";
	}
	//添加用户
	@RequestMapping("/addusers")
	public String addUsers(String account,Userinfo userinfo,HttpSession session) {
		//System.out.println(account);
		//System.out.println(userinfo.getEntrytime());
		System.out.println(userinfo+"阿西吧");
		if("".equals(account)) {
			//System.out.println(account+"添加失败");
			session.setAttribute("mag", "添加失败");
			return "redirect:/system/userList";
		}
		if("".equals(userinfo.getUname())) {
			//System.out.println("添加失败");
			return "redirect:/system/userList";
		}
		if("".equals(userinfo.getSex())) {
		//	System.out.println("添加失败");
			return "redirect:/system/userList";
		}
		if("".equals(userinfo.getEntrytime())) {
		//	System.out.println("添加失败");
			return "redirect:/system/userList";
		}
		if("".equals(userinfo.getReid())) {
			//System.out.println("添加失败");
			return "redirect:/system/userList";
		}
		systemManagementService.addUserinfo(account, userinfo);
		return "redirect:/system/userinfoByPage";
	}
	//删除用户
	@RequestMapping("/delete/{uid}")
	public String delete(@PathVariable("uid")Integer uid,Model model) {
		int row = systemManagementService.deleteById(uid);
		if(row==1) {
			return "redirect:/system/userinfoByPage";
		}else {
			System.out.println("更新失败"+uid);
			return "redirect/system/userinfoByPage";
		}
	}
	//模糊查询
	@RequestMapping("/query")
	public String query(String uname,String sex,Model model) {
		System.out.println(uname+sex+"asdasdasd");
		List<Userinfo> userinfo = systemManagementService.queryAllUserinfo(uname, sex);
		System.out.println("query"+userinfo);
//		List<Userinfo> userinfo = systemManagementService.selectAllUserinfo();
//		//System.out.println(userinfo);
		//model.addAttribute("userinfo", userinfo);
		model.addAttribute("userinfo", userinfo);
		return "system/userinfoByPage";
	}
	//分页查询
	@RequestMapping("/userinfoByPage")
	public String findAllUserinfoByPage(HttpServletRequest request,Userinfo userinfo,Model model) {
		//pageIndex当前页
		int pageIndex = getPageIndex(request);
		//int pageIndex =2;
		int pageSize = 10;
		UserInfoPageBean<Userinfo> benanList = systemManagementService.getUserinfoConditionByPage(pageIndex, pageSize, userinfo);
		System.out.println(benanList);
		List<Userinfo> userinfos = benanList.getBenanList();
		model.addAttribute("userinfo", userinfos);
		model.addAttribute("benanList", benanList);
		return "system/userListPage";	
	}
	//当前页
		private int getPageIndex(HttpServletRequest request) {
			int index = 1;
			String parameter = request.getParameter("pageIndex");
			if (parameter == null || parameter.equals("")) {
				return index;
			}
			System.out.println("当前页："+parameter);
			return Integer.parseInt(parameter);
		}
}
