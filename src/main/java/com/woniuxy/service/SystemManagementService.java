package com.woniuxy.service;

import java.util.List;

import com.woniuxy.bean.UserInfoPageBean;
import com.woniuxy.entity.Userinfo;

public interface SystemManagementService {
	//查询所有
	List<Userinfo> selectAllUserinfo();
	//添加员工信息
	void addUserinfo(String account, Userinfo userinfo);
	//根据员工编号查员工信息
	Userinfo selectUserinfoById(int uid);
	//修改员工信息
	int updateByUname( Userinfo userinfo);
	//软删除员工信息
	int deleteById( int uid);
	//模糊查询
	List<Userinfo> queryAllUserinfo(String uname,String sex);
	//分页查询所有
	UserInfoPageBean<Userinfo> getUserinfoConditionByPage(int pageIndex, int pageSize, Userinfo userinfo);
}
