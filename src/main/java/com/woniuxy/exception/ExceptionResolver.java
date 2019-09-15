package com.woniuxy.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class ExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		 if(ex instanceof UnauthorizedException){  
	           ModelAndView mv = new ModelAndView("msg.html");  
	            return mv;  
        }  
	        ex.printStackTrace();  
	        ModelAndView mv = new ModelAndView("error");  
	        mv.addObject("exception", ex.toString().replaceAll("\n", "<br/>"));  
	        return mv;  
	}

}
