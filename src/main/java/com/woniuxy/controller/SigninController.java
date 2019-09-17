package com.woniuxy.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
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
 * 
 * @刘立英
 */
@Controller
@RequestMapping("/signin")
public class SigninController {

	@Autowired
	SigninService signinService;

	// 分页签到详情(普通用户)
	@RequiresPermissions("signin:query")
	@RequestMapping("/getPageBean/{signInStr}/{signOutStr}/{pageIndex}")
	public ModelAndView getPageBean(HttpServletRequest request, @PathVariable("pageIndex") Integer pageIndex,
			@PathVariable("signInStr") Date signInStr, @PathVariable("signOutStr") Date signOutStr) {
		ModelAndView mv = new ModelAndView();
		// 设置页面大小
		int pageSize = 2;
		// 获取用户id
		Object id = request.getSession().getAttribute("uid");
		Integer uid = (Integer) id;
		// 将日期转为String进行比较
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String signInDate=sdf.format(signInStr);
		String signOutDate=sdf.format(signOutStr);
		OvertimePageBean<Signin> pb=null;
		if(("0002-11-30".equals(signInDate))&&("0002-11-30".equals(signInDate))) {
			pb = signinService.selectPageBean(pageIndex, pageSize, uid);
			
		}else {
			pb = signinService.findAttend(uid, pageIndex, pageSize, signInStr, signOutStr);
		}
		
		// 存储页面路径和条件url
		String url = getUrl(request, pageIndex);
		pb.setUrl(url);
		mv.addObject("pb", pb);
		mv.setViewName("system/attendance");
		return mv;
	}

	
	// 分页签到详情（管理员）
		@RequiresPermissions("signin:queryall")
		@RequestMapping("/getAllPageBean/{signInStr}/{signOutStr}/{pageIndex}")
		public ModelAndView getAllPageBean(HttpServletRequest request, @PathVariable("pageIndex") Integer pageIndex,
				@PathVariable("signInStr") Date signInStr, @PathVariable("signOutStr") Date signOutStr) {
			ModelAndView mv = new ModelAndView();
			// 设置页面大小
			int pageSize = 2;
			// 将日期转为String进行比较
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String signInDate=sdf.format(signInStr);
			String signOutDate=sdf.format(signOutStr);
			OvertimePageBean<Signin> pb=null;
			if(("0002-11-30".equals(signInDate))&&("0002-11-30".equals(signInDate))) {
				//当权限为管理员时uid=0;
				pb = signinService.selectPageBean(pageIndex, pageSize, 0);
				
			}else {
				//当权限为管理员时uid=0;
				pb = signinService.findAttend(0, pageIndex, pageSize, signInStr, signOutStr);
			}
			
			// 存储页面路径和条件url
			String url = getUrl(request, pageIndex);
			pb.setUrl(url);
			mv.addObject("pb", pb);
			mv.setViewName("system/attendance");
			return mv;
		}
	
	
	
	
	
	// 存储页面路径和条件url
	private String getUrl(HttpServletRequest request, Integer pageIndex) {
		String contextPath = request.getContextPath();
		String servletPath = request.getServletPath();
		// 除去页面页号参数
		if (servletPath != null && servletPath.indexOf("/" + pageIndex) != -1) {
			servletPath = servletPath.substring(0, servletPath.lastIndexOf("/" + pageIndex));
			 System.out.println("路径"+servletPath);
		}
		return contextPath + servletPath + "/";
	}

	

	// 签到处理
	@ResponseBody
	@RequestMapping("/signin")
	public String signin(HttpSession session) {

		// 判断是否已经签到
		// 获取用户id
		Object id = session.getAttribute("uid");
		Integer uid = (Integer) id;
		// 查找是否签到
		Signin isSignin = signinService.selectSigninByUid(uid);
		System.out.println(isSignin);
		// 如果已经签到，返回
		if (isSignin != null) {
			return "2";
		}
		// 如果没有签到，将签到信息插入数据库
		Signin signin = new Signin();
		signin.setUid(uid);
		// 设置签到IP
		signin.setUip(getIP());
		// 设置签到时间
		signin.setSignintime(new Date());
		System.out.println(signin);
		int row = signinService.signinByUid(signin);
		// System.out.println(row);
		return row + "";

	}

	// 签退处理
	@ResponseBody
	@RequestMapping("/signout")
	public int signout(HttpSession session) {

		// 判断是否已经签退。或是否还未签到
		// 获取用户id
		Object id = session.getAttribute("uid");
		Integer uid = (Integer) id;
		// 查找是否签到
		Signin signin = signinService.selectSigninByUid(uid);
		System.out.println(signin);
		// 如果还未签到，返回
		if (signin == null) {
			return 2;
		}
		System.out.println(signin.getSignbacktime());
		// 如果有签退信息,代表已签退
		if (signin.getSignbacktime() != null) {
			return 3;
		}
		// 如果签到过了，没有签退，将签退信息插入数据库
		int row = signinService.signOutBySid(signin.getSid(), new Date());
		System.out.println(row);
		return row;
	}

	// 使用这个注解绑定转换器，方法名任意，方法的参数必须叫binder
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// 自定义转换器（转换的目标类型，创建转换器（df,数据是否允许为空））
		binder.registerCustomEditor(Date.class, 
				new CustomDateEditor(df, true));
	}

	// 获取本机ip地址
	private static String getIP() {
		InetAddress address = null;
		try {
			address = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return address.getHostAddress(); // 返回IP地址
	}

}
