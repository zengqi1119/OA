package com.woniuxy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.entity.PageBeanWork;
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
	//查询，根据用户姓名进行查询
    @RequestMapping("/select/{pageIndex}") 
	 public String schedule(@PathVariable("pageIndex")Integer pageIndex,String realName,Model model) {
    	Integer pageSize = 1;
		PageBeanWork<Schedule> pageBean = scheduleService.queryPageBean(realName, pageIndex, pageSize);
		
		model.addAttribute("page",pageBean);
    	return "system/schedule";
	 }
    //增加
    @ResponseBody
    @RequestMapping("/insert")
    public int insertSchedule(Schedule schedule) {
    	//uid从session获取
    	int uid  = 2;
    	schedule.setUid(uid);
    	schedule.setBid(1);
    	System.out.println(schedule);
    	int row = scheduleService.addSchedule(schedule);
    	return row;
    } 
    
    //更新
    @ResponseBody
    @RequestMapping("/update")
    public int updateSchedule(Schedule schedule) {
    	schedule.setBid(1);
    	System.out.println(schedule);
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
