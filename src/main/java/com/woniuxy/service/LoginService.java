package com.woniuxy.service;

import com.woniuxy.entity.Useraccount;

public interface LoginService {
	//查询密码
	Useraccount selectBypassword(String account);
	//修改密码
	int updatePassword(String account,String newpwd);
}
