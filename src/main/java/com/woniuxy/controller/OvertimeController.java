package com.woniuxy.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.entity.Overtime;
import com.woniuxy.service.OvertimeService;

/**
 * 加班管理处理器
 *@刘立英
 */
@Controller
@RequestMapping("/overtime")
public class OvertimeController {
	
	@Autowired
	OvertimeService overtimeService;
	

	
	//加班管理
	//加班信息展示
	@RequestMapping("/showOvertimes")
	public String showOvertimes(HttpSession session,Model model) {
		Object id=session.getAttribute("uid");
		Integer uid=(Integer) id;
		List<Overtime> overtimes = overtimeService.showOvertimeByUid(uid);
		//System.out.println(overtimes);
		model.addAttribute("overtimes",overtimes);		
		return "system/overtime";
	}
	//加班信息展示(名称查询)
	@RequestMapping("/showOvertimesByName")
	public String showOvertimesByName(Model model,String realName) {
		
		List<Overtime> overtimes = overtimeService.showOvertimeByName(realName);
		System.out.println(overtimes);
		model.addAttribute("overtimes",overtimes);		
		return "system/overtime";
	}
	
	
	
	
	
	//添加加班信息	
	@ResponseBody
	@RequestMapping("/addOvertime")
	public String addOvertime(HttpSession session,Overtime overtime) {
		//添加申请日期，现在的时间
		overtime.setApplytime(new Date());
		//获取加班时长
		Integer movertime=countOvertime(overtime.getBegintime(),overtime.getEndtime());
		overtime.setOvertime(movertime);
		//获取用户id
		Object id=session.getAttribute("uid");
		Integer uid=(Integer) id;
		overtime.setUid(uid);
		//System.out.println(overtime);
		int row =overtimeService.insertOvertime(overtime);		
		return row+"";
	}
	
	//删除加班信息
	@ResponseBody
	@RequestMapping("/deleteOvertime")
	public String deleteOvertime(Integer oid,Model model) {
		//System.out.println(oid);
		int row=overtimeService.deleteOvertime(oid);
		return row+"";
	}
	
	
	
	//修改加班信息(修改完跳到查询页面)
	    @ResponseBody
		@RequestMapping("/updateOvertime")
		public String updateOvertime(Overtime overtime) {
			System.out.println(overtime);
			//获取加班时长
			Integer movertime=countOvertime(overtime.getBegintime(),overtime.getEndtime());
			overtime.setOvertime(movertime);
			int row=overtimeService.updateOvertimeByOid(overtime);
			return row+"";
		}
	
	
	//计算加班时长
	public Integer countOvertime(Date begintime,Date endtime) {
		//获取时长毫秒数
		Integer overtime=(int) (endtime.getTime()-begintime.getTime());
		//转为时长分钟数(不满一分钟不算)
		Integer minute=overtime/60000;
		return minute;
		
	}
	
	

		
		
	
	

	
	
}
