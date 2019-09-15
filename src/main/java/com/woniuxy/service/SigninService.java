package com.woniuxy.service;

import java.util.Date;
import java.util.List;

import com.woniuxy.bean.OvertimePageBean;
import com.woniuxy.entity.Signin;

/**签到表service接口
 * @刘立英
 */
public interface SigninService {
	
	//插入签到信息
	int signinByUid(Signin signin);
	//插入签退信息
	int signOutBySid(Integer sid, Date date);
	//根据用户id分页查找用户id
	OvertimePageBean<Signin> selectPageBean(int pageIndex, int pageSize, Integer uid);
	//根据现在时间查找签到信息
	Signin selectSigninByUid(Integer uid);
	//根据日期查找签到详情(分页)
	OvertimePageBean<Signin> findAttend(Integer uid, Integer pageIndex, int pageSize, Date signInStr, Date signOutStr);
	
	
	
}
