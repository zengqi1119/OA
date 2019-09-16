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
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.woniuxy.bean.Rolepermissiontable;
import com.woniuxy.entity.Useraccount;
import com.woniuxy.service.UseraccountService;

@Configuration
public class MyShiroRealm extends AuthorizingRealm {

	@Autowired
	UseraccountService useraccountService;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("-----------进行授权------------");
		String account = (String) SecurityUtils.getSubject().getPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		List<Rolepermissiontable> rolepermissions = useraccountService.selectRolesPermission(account);
		Collection<String> permissions = new ArrayList<String>();
		Collection<String> roles = new ArrayList<String>();
		for (Rolepermissiontable rolepermissiontable : rolepermissions) {
			roles.add(rolepermissiontable.getRole());
			permissions.add(rolepermissiontable.getPrivilege());
		}
		info.addStringPermissions(permissions);
		info.addRoles(roles);
		// 数据库查询权限 通过account
		// 审批，请假需要的权限
//		permissions.add("leave:delete");
//		permissions.add("approval:queryall");
//		permissions.add("approval:examine");
		// 报销权限，申领申购权限
//		permissions.add("apply:select");
//		permissions.add("subscribe:select");
		// 考勤管理需要的权限
		// 普通用户权限
//		permissions.add("signin:query");
//		permissions.add("overtime:query");
		// 管理员权限
		// permissions.add("signin:queryall");
		// permissions.add("overtime:queryall");
		// permissions.add("attendance:update");
		//数据库查询权限 通过account
		//permissions.add("plan:selectOne");
		//permissions.add("schedule:selectOne");
//		permissions.add("plan:selectAll");
//		permissions.add("schedule:selectAll");
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("----------身份信息验证-------------");
		String username = (String) token.getPrincipal();
		List<Useraccount> useraccounts = useraccountService.selectUseraccount(username);
		for (Useraccount useraccount : useraccounts) {
			if (useraccount.getPassword() != null) {
				return new SimpleAuthenticationInfo(username, useraccount.getPassword(), getName());
			} else {
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
