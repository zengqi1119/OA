package com.woniuxy.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniuxy.entity.Attendance;
import com.woniuxy.entity.Overtime;
import com.woniuxy.service.AttendanceService;
import com.woniuxy.service.OvertimeService;

/**
 * 考勤设置处理器
 *@刘立英
 */
@Controller
@RequestMapping("/attendance")
public class AttendanceController {
	@Autowired
	AttendanceService attendanceService;
	
	
	//考勤管理
	//考勤展示
	@RequestMapping("/showAttendance")
	public String showAttendance(Model model) {
		Attendance attendance=attendanceService.showAttendance();
		model.addAttribute("attendance",attendance);
		return "system/attendanceSetting";
	}
	
	//考勤修改(跳转到修改页面)
	@RequiresPermissions("attendance:update")
	@RequestMapping("/attendanceSetting")
	public String attendanceSetting(Model model) {
		Attendance attendance=attendanceService.showAttendance();
		System.out.println(attendance.getAmtime());
		model.addAttribute("attendance",attendance);
		return "system/updateAttendanceSetting";
	}	
	
	    //考勤修改(修改信息并跳转到展示页面)
		@PostMapping("/updateAttendance")
		public String updateAttendance(Model model,Attendance attendance) {
			System.out.println(attendance);
			attendanceService.updateAttendance(attendance);
			return "redirect:/attendance/showAttendance";
		}
	
		
		
		//使用这个注解绑定转换器，方法名任意，方法的参数必须叫binder
		@InitBinder
		public void initBinder(WebDataBinder binder){
			DateFormat df=new SimpleDateFormat("HH:mm:ss");
			//自定义转换器（转换的目标类型，创建转换器（df,数据是否允许为空））
			binder.registerCustomEditor(Date.class, new CustomDateEditor(df,true));
		}

		
		
	
	

	
	
}
