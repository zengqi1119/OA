package com.woniuxy.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.woniuxy.entity.Useraccount;
import com.woniuxy.entity.UseraccountExample;
import com.woniuxy.mapper.UseraccountMapper;
import com.woniuxy.mapper.UserinfoMapper;

public class UserRealm extends AuthorizingRealm {
	@Autowired
	UseraccountMapper useraccountMapper;
	@Autowired
	UserinfoMapper userinfoMapper;
	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("doGetAuthorizationInfo");
		String primaryPrincipal = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		Collection<String > permissions = new ArrayList<String>();
		//数据库查询权限 通过account
		permissions.add("leave:delete");
		permissions.add("approval:queryall");
		permissions.add("approval:examine");
		simpleAuthorizationInfo.addStringPermissions(permissions);
		return simpleAuthorizationInfo;
	}
//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("doGetAuthenticationInfo");
		String principal = (String) token.getPrincipal();
		//数据库查询用户和密码
		UseraccountExample example=new UseraccountExample();
		example.createCriteria().andAccountEqualTo(principal);
		List<Useraccount> users = useraccountMapper.selectByExample(example);
		Useraccount account = null;
		if(users!=null) {
		account = users.get(0);
		}else {
			return null;
		}
		String credentials = account.getPassword();
		System.out.println(principal+"   "+credentials);
		SimpleAuthenticationInfo authorizationInfo = 
				new SimpleAuthenticationInfo(principal,credentials,this.getName());
		return authorizationInfo;
	}

}
