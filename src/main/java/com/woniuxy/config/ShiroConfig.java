package com.woniuxy.config;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;

import com.woniuxy.exception.ExceptionResolver;
import com.woniuxy.realm.MyShiroRealm;

@Configuration
public class ShiroConfig {
	/* 开启注解授权需要配置这两个bean 配置授权顾问 */
	@Bean
	public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
		advisorAutoProxyCreator.setProxyTargetClass(true);
		return advisorAutoProxyCreator;
	}
	//配置注解顾问
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
		return authorizationAttributeSourceAdvisor;
	}

	// 配置shiro session 的一个管理器
	@Bean(name = "sessionManager")
	public DefaultWebSessionManager getDefaultWebSessionManager() {
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
		// 设置session过期时间
		sessionManager.setGlobalSessionTimeout(60 * 1000);
		return sessionManager;
	}
	//配置过滤器
	@Bean
	public ShiroFilterFactoryBean shrioFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		// 必须设置securityManager
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		// 若不设置访问路径，会自动寻找web工程根目录下
		// 访问的是后端url地址为“/toLogin” 所有的访问都会去tologin
		shiroFilterFactoryBean.setLoginUrl("/user/toLogin");
		// 登录成功后要跳转的连接
		shiroFilterFactoryBean.setSuccessUrl("/system/index/index");
		// 未授权界面
		shiroFilterFactoryBean.setUnauthorizedUrl("msg");
		// 拦截器
		Map<String, String> filterMap = new LinkedHashMap<String, String>();
		filterMap.put("/login", "anon");
		filterMap.put("/login.html", "anon");
		filterMap.put("/user/login", "anon");
		filterMap.put("/css/**", "anon");
		filterMap.put("/js/**", "anon");
		filterMap.put("/img/**", "anon");
		filterMap.put("/bootstrap/**", "anon");
		// 配置退出登录
		filterMap.put("/logout", "logout");
		// 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边
		// <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
		filterMap.put("/", "user");
		filterMap.put("/**", "authc");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
		System.out.println("Shiro拦截器工厂类注入成功");
		return shiroFilterFactoryBean;
	}
	//配置session管理器
	@Bean
	public SecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		// 设置realm.
		securityManager.setRealm(getMyShiroRealm());
		//配置session
		securityManager.setSessionManager(getDefaultWebSessionManager());
		// 配置记住我
		securityManager.setRememberMeManager(rememberMeManager());
		return securityManager;
	}

	// 身份认证realm; (这个需要自己写，账号密码校验；权限等)
	@Bean
	public MyShiroRealm getMyShiroRealm() {
		return new MyShiroRealm();
	}
	//配置异常类
	@Bean
	public HandlerExceptionResolver solver() {
		HandlerExceptionResolver handlerExceptionResolver = new ExceptionResolver();
		return handlerExceptionResolver;
	}
	
	
	//配置记住我的cookie
	@Bean
	public SimpleCookie rememberMeCookie() {
		// 这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
		SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
		// setcookie的httponly属性如果设为true的话，会增加对xss防护的安全系数。它有以下特点：
		// setcookie()的第七个参数
		// 设为true后，只能通过http访问，javascript无法访问
		// 防止xss读取cookie
		 simpleCookie.setHttpOnly(true);
		// simpleCookie.setPath("/");
		// <!-- 记住我cookie生效时间,单位秒;-->
		simpleCookie.setMaxAge(3000);
		return simpleCookie;
	}

	//设置cookie管理器
	@Bean
	public CookieRememberMeManager rememberMeManager() {
		CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
		cookieRememberMeManager.setCookie(rememberMeCookie());
		// rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
		cookieRememberMeManager.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
		return cookieRememberMeManager;
	}
	
	/**
	 * FormAuthenticationFilter 过滤器 过滤记住我
	 * @return
	 */
	@Bean
	public FormAuthenticationFilter formAuthenticationFilter(){
	    FormAuthenticationFilter formAuthenticationFilter = new FormAuthenticationFilter();
	    //对应前端的checkbox的name = rememberMe
	    formAuthenticationFilter.setRememberMeParam("rememberMe");
	    return formAuthenticationFilter;
	}
}
