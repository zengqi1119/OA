package com.woniuxy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.bean.PageBeanWork;
import com.woniuxy.entity.Workplan;
import com.woniuxy.service.WorkPlanService;
@Controller
@RequestMapping("/plan")
public class WorkController {
	
	@Autowired
	WorkPlanService workPlanService;

	//管理权限——条件查询：根据姓名条件查询展示工作计划
	@RequestMapping("/work/{uname}/{pageIndex}") 
	public String work(@PathVariable("pageIndex")Integer pageIndex,@PathVariable("uname")String uname,HttpServletRequest request) { 
		if(uname.equals("null")) {
			uname = null;
		}
		Integer pageSize = 1;
		Integer uid =(Integer) request.getSession().getAttribute("uid");
		PageBeanWork<Workplan> pageBean =  workPlanService.queryPageBean(uname, pageIndex, pageSize);
		pageBean.setUrl(getNowUrl(request, pageIndex));
		request.setAttribute("page",pageBean);
		return "system/work";
	}
	//一般权限——不能查询，只能显示自己的数据
	//@RequestMapping("/work/{pageIndex}") 
	public String myWorkPlan(@PathVariable("pageIndex")Integer pageIndex,Model model) { 
		
		Integer pageSize = 1;
		//Integer uid =Integer.parseInt(session.getAttribute("uid"));
		Integer uid = 2;
		PageBeanWork<Workplan> pageBean = workPlanService.queryMyPageBean(uid, pageIndex, pageSize);
		model.addAttribute("page",pageBean);
		return "system/work";
	}
	

	//删除:根据工作计划wid删除
	@ResponseBody
	@RequestMapping("/delete") 
	public int deletePlan(Workplan workplan) { 
		
		int row = workPlanService.removeWorkPlanByWid(workplan);
		return row;
		
	}
	//修改
	@ResponseBody
	@RequestMapping("/update") 
	public int updatePlan(Workplan workplan) {
		
		int row = workPlanService.modifyWorkPlanByWid(workplan);
		return row;
	}
	//增加:根据从session获取用户id插入
	@ResponseBody
	@RequestMapping("/insert") 
	public int work(Workplan workplan) {
		//Integer uid =Integer.parseInt(session.getAttribute("uid"));
		Integer uid = 2;
		workplan.setUid(uid);
		System.out.println("增加"+workplan);
		int row = workPlanService.addWorkPlan(workplan);
		return row;
	}
	
	// 获取url上的后缀信息
		private String getNowUrl(HttpServletRequest request, Integer pageIndex) {
			String servletPath = request.getServletPath();
			if (servletPath.indexOf("/" + pageIndex) != -1) { 
				servletPath = servletPath.substring(0, servletPath.indexOf("" + pageIndex));
		} 
			return servletPath;
		}
}
