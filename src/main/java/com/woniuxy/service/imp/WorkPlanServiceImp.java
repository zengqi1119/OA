package com.woniuxy.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.entity.PageBeanWork;
import com.woniuxy.entity.Userinfo;
import com.woniuxy.entity.Workplan;
import com.woniuxy.entity.WorkplanExample;
import com.woniuxy.entity.WorkplanExample.Criteria;
import com.woniuxy.mapper.WorkplanMapper;
import com.woniuxy.service.WorkPlanService;


@Service
public class WorkPlanServiceImp implements WorkPlanService{
	
	@Autowired
	WorkplanMapper workplanMapper;
	
	
	public void setWorkplanMapper(WorkplanMapper workplanMapper) {
		this.workplanMapper = workplanMapper;
	}
	//增加
	@Override
	public int addWorkPlan(Workplan workplan) {
		int row = workplanMapper.insertWorkPlan(workplan);
		return row;
	}
	//软删除 更新flag=1
	@Override
	public int removeWorkPlanByWid(Workplan workplan) {
		WorkplanExample  example  = new WorkplanExample();
		Criteria criteria = example.createCriteria();
		criteria.andWidEqualTo(workplan.getWid());
		criteria.andFlagEqualTo(0);
		workplan.setFlag(1);
		int row = workplanMapper.updateByExampleSelective(workplan, example);
		return row;
	}

	//修改
	@Override
	public int modifyWorkPlanByWid(Workplan workplan) {
		WorkplanExample  example  = new WorkplanExample();
		Criteria criteria = example.createCriteria();
		 criteria.andWidEqualTo(workplan.getWid());
		int row = workplanMapper.updateByExampleSelective(workplan, example);
		return row;		
	}
	@Override
	public PageBeanWork<Workplan> queryPageBean(String uname,Integer pageIndex, Integer pageSize) {
		PageBeanWork<Workplan> pageBean = new PageBeanWork<Workplan>();
		List<Workplan> workplans = workplanMapper.selectWorkPlanByUname(uname, (pageIndex-1)*pageSize, pageSize);
		Integer totalRecord = workplanMapper.selectTotalRecord(uname);
		pageBean.setBeanlist(workplans);
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		pageBean.setTotalRecord(totalRecord);
		pageBean.setPage();
		
		return pageBean;
	}
	@Override
	public PageBeanWork<Workplan> queryMyPageBean(Integer uid, Integer pageIndex, Integer pageSize) {
		PageBeanWork<Workplan> pageBean = new PageBeanWork<Workplan>();
		List<Workplan> workplans = workplanMapper.selectWorkPlanByUid(uid, (pageIndex-1)*pageSize, pageSize);
		Integer totalRecord = workplanMapper.selectTotalRecordByUid(uid);
		pageBean.setBeanlist(workplans);
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		pageBean.setTotalRecord(totalRecord);
		pageBean.setPage();
		
		return pageBean;
	}
}
