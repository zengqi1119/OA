package com.woniuxy.service;

import java.util.Date;
import java.util.List;

import com.woniuxy.bean.OvertimePageBean;
import com.woniuxy.entity.Signin;

/**签到表service接口
 * @刘立英
 */
public interface SigninService {
	//根据用户id查找用户id
	List<Signin> showSigninByUid(Integer uid);
	//插入签到信息
	int signinByUid(Signin signin);
	//插入签退信息
	int signOutByOid(Integer sid, Date date);
	//根据用户id分页查找用户id
	OvertimePageBean<Signin> selectPageBean(int pageIndex, int pageSize, Signin signin);
	
	
}
