package com.woniuxy.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

@Configuration
public class ShiroConfig {
	@Bean
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(
			@Autowired DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
       //安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
		//内置过滤器
        Map<String,String> filterMap = new LinkedHashMap<String,String>();
		filterMap.put("/user/login", "anon");
		filterMap.put("/logout","logout");
		filterMap.put("/bootstrap/**", "anon");
		filterMap.put("/css/**", "anon");
		filterMap.put("/img/**", "anon");
		filterMap.put("/js/**", "anon");
		filterMap.put("/**","authc");
		shiroFilterFactoryBean.setLoginUrl("/login");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
		return shiroFilterFactoryBean;
	}
	@Bean
	public DefaultWebSecurityManager getDefaultWebSecurityManager(
			@Autowired UserRealm userRealm) {
		DefaultWebSecurityManager securityManager =  
				new DefaultWebSecurityManager();
		//关联realm
		securityManager.setRealm(userRealm);
		return securityManager;
	}
	@Bean
	public UserRealm getUserRealm() {
		return new UserRealm();
	}
	@Bean
	public ShiroDialect getShiroDialect() {
		return new ShiroDialect();
	}
	/**
	 * 
	 * @return
	 */
	@Bean
	public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator
			= new DefaultAdvisorAutoProxyCreator();
		advisorAutoProxyCreator.setProxyTargetClass(true);
		return advisorAutoProxyCreator;
	}
	/*
	 * @Bean public AuthorizationAttributeSourceAdvisor
	 * authorizationAttributeSourceAdvisor(
	 * 
	 * @Autowired SecurityManager securityManager) {
	 * AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new
	 * AuthorizationAttributeSourceAdvisor();
	 * authorizationAttributeSourceAdvisor.setSecurityManager((org.apache.shiro.mgt.
	 * SecurityManager) securityManager); return
	 * authorizationAttributeSourceAdvisor; }
	 */
	
    /**
     * 凭证匹配器
     * （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
     * ）
     * @return
     */
	/*
	 * @Bean public HashedCredentialsMatcher hashedCredentialsMatcher(){
	 * HashedCredentialsMatcher hashedCredentialsMatcher = new
	 * HashedCredentialsMatcher();
	 * hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
	 * hashedCredentialsMatcher.setHashIterations(2);//散列的次数，比如散列两次，相当于
	 * md5(md5("")); return hashedCredentialsMatcher; }
	 */

}
