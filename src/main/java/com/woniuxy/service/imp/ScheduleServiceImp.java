package com.woniuxy.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.entity.PageBeanWork;
import com.woniuxy.entity.Schedule;
import com.woniuxy.entity.ScheduleExample;
import com.woniuxy.entity.ScheduleExample.Criteria;
import com.woniuxy.mapper.ScheduleMapper;
import com.woniuxy.service.ScheduleService;




@Service
public class ScheduleServiceImp implements ScheduleService{
	
	@Autowired
	ScheduleMapper scheduleMapper;

	public void setScheduleMapper(ScheduleMapper scheduleMapper) {
		this.scheduleMapper = scheduleMapper;
	}
	
	
	//增加
	@Override
	public int addSchedule(Schedule schedule) {
		int row  = scheduleMapper.insertSchedule(schedule);
		return row;
	}
	
	//删除 软删除 将flag更改为1
	@Override
	public int removeSchedule(Schedule schedule) {
		ScheduleExample example = new ScheduleExample();
		Criteria criteria =example.createCriteria();
		criteria.andFlagEqualTo(0);
		criteria.andSidEqualTo(schedule.getSid());
		schedule.setFlag(1);
		System.out.println("service---"+schedule);
		int row  = scheduleMapper.updateByExampleSelective(schedule, example);
		return row;
	}
	//查询
//	@Override
//	public List<Schedule> queryScheduleByUname(String uname){
//		
//		List<Schedule> schedule = scheduleMapper.selectScheduleByUname(uname);
//		return schedule;
//	}
	
	//修改
	@Override
	public int modifyScheduleBySid(Schedule schedule) {
		ScheduleExample example = new ScheduleExample();
		Criteria criteria =example.createCriteria();
		criteria.andSidEqualTo(schedule.getSid());
		int row = scheduleMapper.updateByExampleSelective(schedule, example);
		return row;
	}


	@Override
	public PageBeanWork<Schedule> queryPageBean(String uname, Integer pageIndex, Integer pageSize) {
		PageBeanWork<Schedule> pageBean = new PageBeanWork<Schedule>();
		List<Schedule> schedules = scheduleMapper.selectScheduleByUname(uname, (pageIndex-1)*pageSize, pageSize);
		Integer totalRecord = scheduleMapper.selectTotalRecord(uname);
		pageBean.setBeanlist(schedules);
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		pageBean.setTotalRecord(totalRecord);
		pageBean.setPage();
		
		return pageBean;
	}
}
