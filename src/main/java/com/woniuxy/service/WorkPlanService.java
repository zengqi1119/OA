package com.woniuxy.service;

import com.woniuxy.bean.PageBeanWork;
import com.woniuxy.entity.Workplan;



public interface WorkPlanService {
	
	//增加
	public int addWorkPlan(Workplan workplan);
	//软删除 更新flag=1
	public int removeWorkPlanByWid(Workplan workplan);
	//查询(根据姓名查询)
	//public List<Workplan> queryWorkPlanByUname(String uname);
	//修改
	public int modifyWorkPlanByWid(Workplan workplan);
	//管理权限——按姓名查询分页
	public PageBeanWork<Workplan> queryPageBean(String uname,Integer pageIndex,Integer pageSize);
	//一般权限——只能查看自己的数据
	public PageBeanWork<Workplan> queryMyPageBean(Integer uid, Integer pageIndex, Integer pageSize);
	
	
}
