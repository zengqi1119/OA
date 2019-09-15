package com.woniuxy.service;

import com.woniuxy.bean.PageBeanWork;
import com.woniuxy.entity.Schedule;




public interface ScheduleService {
	
	//增加
	 int addSchedule(Schedule schedule);
	
	//删除 软删除 将flag更改为1
	public int removeSchedule(Schedule schedule);
	//查询
	//public List<Schedule> queryScheduleByUname(String uname);
	
	//修改
	public int modifyScheduleBySid(Schedule schedule);
	//管理权限——查询
	PageBeanWork<Schedule> queryPageBean(String realName, Integer pageIndex, Integer pageSize);
	//一般权限——查询自己的
	PageBeanWork<Schedule> queryMyPageBean(Integer uid, Integer pageIndex, Integer pageSize);
}
