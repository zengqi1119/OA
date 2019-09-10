package com.woniuxy.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.woniuxy.bean.OvertimePageBean;
import com.woniuxy.entity.Signin;
import com.woniuxy.service.SigninService;

/**
 * 签到管理处理器
 *@刘立英
 */
@Controller
@RequestMapping("/signin")
public class SigninController {
	
	@Autowired
	SigninService signinService;
	
	
	//签到详情
	@RequestMapping("/attendance")
	public  String attendance(HttpSession session,Model model) {
		Object id=session.getAttribute("uid");
		Integer uid=(Integer) id;
		//List<Signin> signins = signinService.showSigninByUid(uid);
		//System.out.println(signins);
		//model.addAttribute("signins",signins);
		return "system/attendance";
	}
	
	//分页签到详情
	@RequestMapping("/getPageBean/{pageIndex}")
	public ModelAndView getPageBean(@PathVariable("pageIndex") Integer pageIndex,Signin signin,
			HttpServletRequest request){
		ModelAndView mv=new ModelAndView();
		
		//设置页面大小
		int pageSize=2;		
		//获取用户id
		Object id=request.getSession().getAttribute("uid");
		Integer uid=(Integer) id;
		signin.setUid(uid);	
		//获取页面信息
		OvertimePageBean<Signin> pb=signinService.selectPageBean(pageIndex, pageSize, signin);
		//存储页面路径和条件url
		String url=getUrl(request);
		pb.setUrl(url);
		mv.addObject("pb",pb);
		mv.setViewName("system/attendance");
		return mv;
	}
	
	
	
	//存储页面路径和条件url
		private String getUrl(HttpServletRequest request) {
			String contextPath=request.getContextPath();
			String servletPath=request.getServletPath();
			String queryString=request.getQueryString();
			
			//除去页面页号参数
			if(queryString!=null && queryString.indexOf("&pageIndex=")!=-1){
				queryString=queryString.substring(0, queryString.indexOf("&pageIndex="));
			}
			return contextPath+servletPath+"?"+queryString;
			
		}
	
	
	
	
	
	
	
	
	
	//签到处理
	@ResponseBody
	@RequestMapping("/signin")
	public  String signin(HttpSession session) {
		
		//判断是否已经签到
		//获取用户id
		Object id=session.getAttribute("uid");
		Integer uid=(Integer) id;
		//查找所有签到信息
		List<Signin> signins = signinService.showSigninByUid(uid);
		//遍历判断是否已经签到
		for(Signin signin:signins) {
			if(isSignin(signin.getSignintime())) {
				return "2";
			}
		}
		//如果没有签到，将签到信息插入数据库
		Signin signin=new Signin();		
		signin.setUid(uid);
		//设置签到IP
		signin.setUip(getIP());
		//设置签到时间
		signin.setSignintime(new Date());
		System.out.println(signin);
		int row = signinService.signinByUid(signin);
		//System.out.println(row);
		return row+"";
	}
	
	
	    //签退处理
		@ResponseBody
		@RequestMapping("/signout")
		public  int signout(HttpSession session) {
			
			//定义一个布尔值,判断是否已经签到
			boolean isSignintime=false;
			//定义一个int，保存签到时的id
			int sid=0;
			//判断是否已经签退。或是否还未签到
			//获取用户id
			Object id=session.getAttribute("uid");
			Integer uid=(Integer) id;
			//查找所有签到信息
			List<Signin> signins = signinService.showSigninByUid(uid);
			//遍历判断是否已经签到或签退
			for(Signin signin:signins) {
				//判断是否已经签到
				if(isSignin(signin.getSignintime())) {
					//已经签到，判断是否签退
					if(signin.getSignbacktime()!=null) {
						//已经签退过了
						return 3;
					}
					isSignintime=true;
					sid=signin.getSid();
					break;
				}
			}
			//如果没有签到
			if(!isSignintime) {
				return 2;
			}
			
			//如果没有签到过了，没有签退，将签退信息插入数据库
			int row = signinService.signOutByOid(sid,new Date());
			//System.out.println(row);
			return row;
		}
	
	
		//查找签到详情
		@RequestMapping("/findAttend")
		public  String findAttend(HttpSession session,Model model
				,Date signInStr,Date signOutStr) {
			Object id=session.getAttribute("uid");
			Integer uid=(Integer) id;
			List<Signin> signins = signinService.showSigninByUid(uid);
			//新建一个集合保存符合条件的数据
			List<Signin> aSignins=new ArrayList<Signin>();
			//将signOutStr日期往后推一天
			Calendar   calendar = new GregorianCalendar(); 
			calendar.setTime(signOutStr); 
			calendar.add(calendar.DATE,1); //把日期往后增加一天,整数  往后推,负数往前移动 
			signOutStr=calendar.getTime(); //这个时间就是日期往后推一天的结果
			System.out.println(signOutStr);
			for(Signin signin:signins) {
				Long signintime=signin.getSignintime().getTime();
				
				if((signintime>=signInStr.getTime())&&(signintime<=signOutStr.getTime())) {
					aSignins.add(signin);
				}
			}
			model.addAttribute("signins",aSignins);
			return "system/attendance";
		}
	
	
		//使用这个注解绑定转换器，方法名任意，方法的参数必须叫binder
		@InitBinder
		public void initBinder(WebDataBinder binder){
			DateFormat df=new SimpleDateFormat("yyy-MM-dd");
			//自定义转换器（转换的目标类型，创建转换器（df,数据是否允许为空））
			binder.registerCustomEditor(Date.class, new CustomDateEditor(df,true));
		}
	
	
	
	
	
	//判断传入的时间是否是当天时间
	private static Boolean isSignin(Date date) {
		boolean f=false;
		if((date.getTime()>=getDayBegin().getTime())&&(date.getTime()<=getDayEnd().getTime()))
			f=true;
		return f;
		
	}
	
	
	//获取当天的开始时间
	private static Date getDayBegin() {
	Calendar cal = new GregorianCalendar();
	cal.set(Calendar.HOUR_OF_DAY, 0);
	cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    cal.set(Calendar.MILLISECOND, 0);
	return cal.getTime();
	}

	//获取当天的结束时间
	private static Date getDayEnd() {
	Calendar cal = new GregorianCalendar();
	cal.set(Calendar.HOUR_OF_DAY, 23);
	cal.set(Calendar.MINUTE, 59);
	cal.set(Calendar.SECOND, 59);
	cal.set(Calendar.MILLISECOND, 999);
	return cal.getTime();
	}
		
		
	//获取本机ip地址
	private static String getIP() {
		 InetAddress address = null;
		try {
			address = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return address.getHostAddress(); //返回IP地址
	}
	
	
	
	

	
	
}
