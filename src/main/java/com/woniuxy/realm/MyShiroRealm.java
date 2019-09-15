package com.woniuxy.realm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.security.auth.login.AccountException;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.woniuxy.entity.Useraccount;
import com.woniuxy.service.UseraccountService;


@Configuration
public class MyShiroRealm extends  AuthorizingRealm{
	
	@Autowired
	UseraccountService UseraccountService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("doGetAuthorizationInfo");
		String primaryPrincipal = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		Collection<String > permissions = new ArrayList<String>();
		//数据库查询权限 通过account
		//查询url
		permissions.add("plan:selectOne");
		//permissions.add("plan:selectOne");
		permissions.add("plan:delete");
		permissions.add("plan:update");
		permissions.add("plan:insert");
		//permissions.add("schedule:selectAll");
		permissions.add("schedule:selectOne");
		permissions.add("schedule:delete");
		permissions.add("schedule:update");
		permissions.add("schedule:insert");
		simpleAuthorizationInfo.addStringPermissions(permissions);
		return simpleAuthorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("----------身份信息验证-------------");
		String username = (String) token.getPrincipal();
		List<Useraccount> useraccounts= UseraccountService.selectUseraccount(username);
		for (Useraccount useraccount : useraccounts){
			if (useraccount.getPassword()!= null) {
				return new SimpleAuthenticationInfo(username, useraccount.getPassword(), getName());
			}else {
				try {
					throw new AccountException("用户名错误");
				} catch (AccountException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}

