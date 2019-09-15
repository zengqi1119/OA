package com.woniuxy.realm;

import java.util.List;

import javax.security.auth.login.AccountException;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.woniuxy.bean.IpaRolesAndPermissions;
import com.woniuxy.entity.Role;
import com.woniuxy.entity.Useraccount;
import com.woniuxy.service.UseraccountService;


@Configuration
public class MyShiroRealm extends  AuthorizingRealm{
	
	@Autowired
	UseraccountService useraccountService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("-----------进行授权------------");
		String account=(String) SecurityUtils.getSubject().getPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		List<Useraccount> useraccounts = useraccountService.selectUseraccount(account);
		if(useraccounts!=null && useraccounts.size()!=0) {
		for (Useraccount useraccount : useraccounts) {
			if(useraccount.getUid()!=null) {
				IpaRolesAndPermissions roleAndPermission=useraccountService.selectRolesAndPermission(useraccount.getUid());
				List<Role> roles = roleAndPermission.getRoles();
				for (Role role : roles) {
					System.out.println(role.getRname());
					info.addRole(role.getRname());
				}
			}
		}
		}
	    return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("----------身份信息验证-------------");
		String username = (String) token.getPrincipal();
		List<Useraccount> useraccounts= useraccountService.selectUseraccount(username);
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

