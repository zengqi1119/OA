package com.woniuxy.thymeleafstart.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

//登录后拦截器
public class LoginInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler)
			throws Exception {
		Object attribute = request.getSession().getAttribute("username");
		if (attribute!=null) {
			return true;
		}else {
			//转发 重定向 模板引擎不起作用
			request.getRequestDispatcher("/test.html").forward(request, response);
			return false;
		}
	}
}
