package com.woniuxy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object user = request.getSession().getAttribute("user");
		//System.out.println(user+"000");
		if(user!=null) {
			return true;
		}
		request.getRequestDispatcher("/login.html").forward(request, response);
		return false;
	}

}
