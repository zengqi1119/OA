package com.woniuxy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.bean.PageBeanWork;
import com.woniuxy.entity.Schedule;
import com.woniuxy.entity.Workplan;
import com.woniuxy.service.ScheduleService;


@Controller
@RequestMapping("/schedule")
public class ScheduleController {
	@Autowired
	ScheduleService scheduleService;
	
	
	public void setScheduleService(ScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}
	//日程安排
	//管理权限——查询，根据用户姓名进行查询
	@RequiresPermissions("schedule:selectAll")
    @RequestMapping("/select/{uname}/{pageIndex}") 
	 public String allSchedule(@PathVariable("pageIndex")Integer pageIndex,@PathVariable("uname")String uname,HttpServletRequest request) {
    	if(uname.equals("null")) {
			uname = null;
		}
    	Integer pageSize = 1;
		PageBeanWork<Schedule> pageBean = scheduleService.queryPageBean(uname, pageIndex, pageSize);
		pageBean.setUrl(getNowUrl(request, pageIndex));
		request.setAttribute("page",pageBean);
		request.getSession().setAttribute("role","admin");
    	return "system/schedule";
	 }
    
    //一般权限
	@RequiresPermissions("schedule:selectOne")
    @RequestMapping("/select/{pageIndex}") 
	 public String oneSchedule(@PathVariable("pageIndex")Integer pageIndex,HttpServletRequest request) {
    	Integer pageSize = 1;
		Integer uid =(Integer) request.getSession().getAttribute("uid");
		PageBeanWork<Schedule> pageBean = scheduleService.queryMyPageBean(uid, pageIndex, pageSize);
		pageBean.setUrl(getNowUrl(request, pageIndex));
		request.setAttribute("page",pageBean);
		request.getSession().setAttribute("role","user");
		return "system/schedule";
   	
	 }
    
    private String getNowUrl(HttpServletRequest request, Integer pageIndex) {
    	String servletPath = request.getServletPath();
		if (servletPath.indexOf("" + pageIndex) != -1) { 
			servletPath = servletPath.substring(0, servletPath.indexOf("" + pageIndex));
		} 
		
		return servletPath;
	}
	//增加
    @ResponseBody
    @RequestMapping("/insert")
    public int insertSchedule(Schedule schedule,HttpSession session) {
    	//uid从session获取
    	Integer uid =(Integer) session.getAttribute("uid");
    	schedule.setUid(uid);
    	int row = scheduleService.addSchedule(schedule);
    	return row;
    } 
    
    //更新
    @ResponseBody
    @RequestMapping("/update")
    public int updateSchedule(Schedule schedule) {
    
    	int row = scheduleService.modifyScheduleBySid(schedule);
    	return row;
    } 
    //删除
    @ResponseBody
    @RequestMapping("/delete")
    public int deleteSchedule(Schedule schedule) {
    	System.out.println(schedule);
    	int row = scheduleService.removeSchedule(schedule);
    	return row;
    } 
}
