package com.woniuxy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.bean.PageBeanWork;
import com.woniuxy.entity.Schedule;
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
	//查询，根据用户姓名进行查询
    @RequestMapping("/select/{uname}/{pageIndex}") 
	 public String schedule(@PathVariable("pageIndex")Integer pageIndex,@PathVariable("uname")String uname,HttpServletRequest request) {
    	if(uname.equals("null")) {
			uname = null;
		}
    	Integer pageSize = 1;
		PageBeanWork<Schedule> pageBean = scheduleService.queryPageBean(uname, pageIndex, pageSize);
		pageBean.setUrl(getNowUrl(request, pageIndex));
		request.setAttribute("page",pageBean);
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
    public int insertSchedule(Schedule schedule) {
    	//uid从session获取
    	int uid  = 2;
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
