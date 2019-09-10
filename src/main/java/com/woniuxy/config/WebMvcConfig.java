package com.woniuxy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.woniuxy.interceptor.LoginInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	
	@Bean
	public WebMvcConfigurer WebMvcConfigurer() {
		WebMvcConfigurer webMvcConfigurer=new WebMvcConfigurer() {
			
			@Override
			public void addViewControllers(ViewControllerRegistry registry) {
				System.out.println(1);
				registry.addViewController("/").setViewName("login");
				registry.addViewController("/login.html").setViewName("login");
			}
			
			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				System.out.println(2);
				registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/","/user/login","/login","/login.html","/css/**","/js/**","/img/**","/bootstrap/**");
			}
		};
		return webMvcConfigurer;
		
	}
	
}
