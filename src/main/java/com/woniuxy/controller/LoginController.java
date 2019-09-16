package com.woniuxy.controller;

import java.util.List;

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

import com.woniuxy.entity.Role;
import com.woniuxy.entity.Useraccount;
import com.woniuxy.entity.Userrole;
import com.woniuxy.entity.UserroleExample;
import com.woniuxy.mapper.RoleMapper;
import com.woniuxy.mapper.UserroleMapper;
import com.woniuxy.service.LoginService;
import com.woniuxy.service.UseraccountService;

@Controller
@RequestMapping("/user")
public class LoginController {

	@Autowired
	LoginService loginService;
	@Autowired
	UseraccountService useraccountService;

	@Autowired
	RoleMapper roleMapper;
	@Autowired
	UserroleMapper userroleMapper;

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@RequestMapping("/login")
	public String Login(String account, String password, Model model, HttpSession session, boolean rememberMe) {
		try {
//			List<Useraccount> useraccounts = useraccountService.selectUseraccount(account);
			Subject subject = SecurityUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(account, password);
			subject.login(token);
			Useraccount useraccount = loginService.selectBypassword(account);
			model.addAttribute("msg", "登录成功");
			session.setAttribute("user", account);
			session.setAttribute("uid", useraccount.getUid());
			UserroleExample example = new UserroleExample();
			example.createCriteria().andUidEqualTo(useraccount.getUid());
			List<Userrole> urls = userroleMapper.selectByExample(example);
			session.setAttribute("userrole", urls);
			Role role = loginService.selectRole(useraccount.getUid());
			session.setAttribute("role", role.getRname());
			if(useraccount.getUid()!=1) {
				Integer rid=4;		//普通用户
				session.setAttribute("rid", rid);
			}else {
				Integer rid =1;		//管理员
				session.setAttribute("rid", rid);
			}
			return "/system/index/index";
		} catch (UnknownAccountException e) {
			model.addAttribute("msg", "用户名不存啊");
		} catch (IncorrectCredentialsException e) {
			model.addAttribute("msg", "用户名或密码错误");
		} catch (AuthenticationException e) {
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
		// System.out.println(account);
		// System.out.println("密码：" + oldpwd + newpwd);
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
		// 判断输入的密码是否与原密码一致
		// System.out.println("用户原密码："+password2);
		if (!oldpwd.equals(password2)) {
			// System.out.println("原密码错误");
			return 0;
		} else {
			// 如果相等，则把输入的新密码更新到数据库
			int row = loginService.updatePassword(account, newpwd);
			if (row == 1) {
				// System.out.println("修改成功");
				return 1;
			}
		}
		return 2;
	}

	// 登录前的页面跳转
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "/login.html";
	}

	// 登录前的页面跳转
	@RequestMapping("/remeber")
	public String remember() {
		System.out.println("12132");
		return "system/index/index";
	}
}
