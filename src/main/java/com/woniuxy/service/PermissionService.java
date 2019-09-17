package com.woniuxy.service;

import javax.servlet.http.HttpSession;

import com.woniuxy.bean.PermissionPage;

public interface PermissionService {

	PermissionPage selectByCondition(Integer pageIndex, int pageSize, String name, HttpSession session);

	int updateUserrole(int uid, int rid);

}
