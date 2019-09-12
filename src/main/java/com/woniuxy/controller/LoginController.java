package com.woniuxy.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.woniuxy.entity.Useraccount;
import com.woniuxy.service.LoginService;

@Controller
@RequestMapping("/user")
public class LoginController {

	@Autowired
	LoginService loginService;

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@RequestMapping("/login")
	public String Login(String account, String password, Model model, HttpSession session) {

//		System.out.println("login.do");
//		ModelAndView mv = new ModelAndView();
//		Subject subject = SecurityUtils.getSubject();
//		UsernamePasswordToken token = new UsernamePasswordToken(account, password);
//		try {
//			//自动登录
//			token.setRememberMe(true);
//			subject.login(token);
//			Useraccount useraccount = (Useraccount) subject.getPrincipal();
//			session.setAttribute("useraccount", useraccount);
//			mv.setViewName("/jsp/index.jsp");
//			return mv;
//		}catch (UnknownAccountException e) {
//			mv.addObject("msg","用户名不存在");
//		}catch (IncorrectCredentialsException e) {
//			mv.addObject("msg","密码错误");
//		}catch (AuthenticationException e) {
//			mv.addObject("msg","登录失败");
//		}
//		mv.setViewName("/jsp/login.jsp");
//		return mv;
		// 验证用户名
		if (account == null || account.equals("")) {
			model.addAttribute("msg", "用户名不能为空");
		} else if (account.length() > 11 || account.length() < 2) {
			model.addAttribute("msg", "用户名长度必须为2-11位");
		}
		// 验证密码
		if (password == null || password.equals("")) {
			model.addAttribute("msg", "密码不能为空");
		} else if (password.length() > 15 || password.length() < 6) {
			model.addAttribute("msg", "密码长度必须为6-15位");
		}
		// 验证通过
		// 根据用户名查询的密码
		Useraccount useraccount = loginService.selectBypassword(account);
		if (useraccount == null) {
			model.addAttribute("msg", "用户不存在");
			return "/login";
		}
		String password2 = useraccount.getPassword();
		// System.out.println(useraccount);
		if (password.equals(password2)) {
			model.addAttribute("msg", "登录成功");
			session.setAttribute("user", account);
			session.setAttribute("uid", useraccount.getUid());
			return "/system/index/index";
		} else {
			model.addAttribute("msg", "登录失败");
		}
		return "/login";
	}

	// 返回修改密码页面
	@RequestMapping("/password")
	public String updatepw(Model model) {
		// System.out.println("password");
		return "/system/index/password";
	}

	// 修改密码
	@RequestMapping("/updatepassword")
	@ResponseBody
	public int updatepassword(String oldpwd, String newpwd, Model model, HttpSession session) {
		String account = (String) session.getAttribute("user");
		//System.out.println(account);
		//System.out.println("密码：" + oldpwd + newpwd);
		// 验证用户名
		if (account == null || account.equals("")) {
			model.addAttribute("msg", "用户名不能为空");
		} else if (account.length() > 11 || account.length() < 2) {
			model.addAttribute("msg", "用户名长度必须为2-11位");
		}
		// 根据用户名查询的密码
		Useraccount useraccount = loginService.selectBypassword(account);
		if (useraccount == null) {
			return 2;
		}
		String password2 = useraccount.getPassword();
		//判断输入的密码是否与原密码一致
	//	System.out.println("用户原密码："+password2);
		if(!oldpwd.equals(password2)) {
			//System.out.println("原密码错误");
			return 0;
		}else {
			//如果相等，则把输入的新密码更新到数据库
			int row = loginService.updatePassword(account, newpwd);
			if(row==1) {
			//	System.out.println("修改成功");
				return 1;
			}
		}
		return 2;
	}

}
