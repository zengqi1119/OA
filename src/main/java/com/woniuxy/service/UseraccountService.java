package com.woniuxy.service;

import java.util.List;

import com.woniuxy.bean.IpaRolesAndPermissions;
import com.woniuxy.bean.Rolepermissiontable;
import com.woniuxy.entity.Useraccount;

public interface UseraccountService {

	List<Useraccount>  selectUseraccount(String username);

	IpaRolesAndPermissions selectRolesAndPermission(Integer uid);

	List<Rolepermissiontable> selectRolesPermission(String account);
	
}
