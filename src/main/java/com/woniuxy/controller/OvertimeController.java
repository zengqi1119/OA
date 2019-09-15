package com.woniuxy.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.woniuxy.bean.OvertimePageBean;
import com.woniuxy.entity.Overtime;
import com.woniuxy.entity.Signin;
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
	
		
		//分页加班信息展示
		@RequestMapping("/getPageBean/{realName}/{pageIndex}")
		public ModelAndView getPageBean(@PathVariable("realName") String realName,
				@PathVariable("pageIndex") Integer pageIndex,HttpServletRequest request) {
			ModelAndView mv=new ModelAndView();
			System.out.println(pageIndex);
			System.out.println(realName);
			//设置页面大小
			int pageSize=1;		
			OvertimePageBean<Overtime> pb=null;
			//判断查询条件和用户权限
			if(realName==null ||realName.equals("null")) {
				//按uid获取页面信息
				//获取用户id
				Object id=request.getSession().getAttribute("uid");
				Integer uid=(Integer) id;
				pb=overtimeService.selectPageBeanByUid(pageIndex, pageSize, uid);
				System.out.println(pb);
			}else {
				//按姓名获取页面信息
				pb=overtimeService.selectPageBeanByName(pageIndex, pageSize, realName);
				System.out.println(pb);
			}
			//存储页面路径和条件url
			String url=getUrl(request,pageIndex);
			pb.setUrl(url);
			mv.addObject("pb",pb);
			mv.setViewName("system/overtime");
			return mv;
		}
	
		//存储页面路径和条件url
		private String getUrl(HttpServletRequest request, Integer pageIndex) {
			String contextPath=request.getContextPath();
			String servletPath=request.getServletPath();
			//除去页面页号参数
			if(servletPath!=null && servletPath.indexOf("/"+pageIndex)!=-1){
				servletPath=servletPath.substring(0, servletPath.lastIndexOf("/"+pageIndex));
				System.out.println("路径"+servletPath);
			}
			return contextPath+servletPath+"/";
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
