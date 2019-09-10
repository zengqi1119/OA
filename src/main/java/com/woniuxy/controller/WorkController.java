package com.woniuxy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.entity.PageBeanWork;
import com.woniuxy.entity.Workplan;
import com.woniuxy.service.WorkPlanService;
@Controller
@RequestMapping("/plan")
public class WorkController {
	
	@Autowired
	WorkPlanService workPlanService;
	
	
	public void setWorkPlanService(WorkPlanService workPlanService) {
		this.workPlanService = workPlanService;
	}

	//管理权限——条件查询：根据姓名条件查询展示工作计划
	@RequestMapping("/work/{pageIndex}") 
	public String work(@PathVariable("pageIndex")Integer pageIndex,String realName,Model model) { 
		
		Integer pageSize = 1;
		PageBeanWork<Workplan> pageBean = workPlanService.queryPageBean(realName, pageIndex, pageSize);
		
		model.addAttribute("page",pageBean);
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
}
