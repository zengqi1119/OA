package com.woniuxy.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.bean.OvertimePageBean;
import com.woniuxy.entity.Overtime;
import com.woniuxy.entity.OvertimeExample;
import com.woniuxy.entity.OvertimeExample.Criteria;
import com.woniuxy.mapper.OvertimeMapper;
import com.woniuxy.service.OvertimeService;
/**加班表service实现类
 * @刘立英
 */
@Service
public class OvertimeServiceImp implements OvertimeService{
	@Autowired
	OvertimeMapper overtimeMapper;
	
	OvertimeExample overtimeExample=new OvertimeExample();
	Criteria criteria=overtimeExample.createCriteria();
	
	
	//查找(根据用户id查找)
	@Override
	public List<Overtime> showOvertimeByUid(Integer uid) {
		List<Overtime> overtimes = overtimeMapper.showOvertimeByUid(uid);
		return overtimes;
	}
	//新增
	@Override
	public int insertOvertime(Overtime overtime) {
		int row=overtimeMapper.insertOvertime(overtime);
		return row;
	}
	//删除
	@Override
	public int deleteOvertime(Integer oid) {
		int row=overtimeMapper.updateFlagByOid(oid);
		return row;
		
	}
	//查找(根据加班表id查找)
	@Override
	public Overtime selectOvertimeByOid(Integer oid) {
		Overtime overtime=overtimeMapper.selectByPrimaryKey(oid);
		return overtime;
	}
	//修改(根据加班表id修改)
	@Override
	public int updateOvertimeByOid(Overtime overtime) {
		int row=overtimeMapper.updateByOid(overtime);
		
		return row;
		
		
	}
	//查找(根据用户名称查找)
	@Override
	public List<Overtime> showOvertimeByName(String uname) {
		
		List<Overtime> overtimes =overtimeMapper.selectOvertimeByName(uname);
		
		return overtimes;
	}
	
	//分页查找
	@Override
	public OvertimePageBean<Overtime> selectPageBeanByUid(Integer pageIndex, int pageSize, Integer uid) {
		
		//根据用户id查符合条件的总记录数目
		criteria.andUidEqualTo(uid);
		criteria.andFlagEqualTo(0);
		int totalRecored=overtimeMapper.countByExample(overtimeExample);
		//根据用户id查符合条件的记录	
		int sqlPageIndex=(pageIndex-1)*pageSize;
		List<Overtime> beanList= overtimeMapper.selectPageBeanByUid(uid,sqlPageIndex,pageSize);
	    //System.out.println(beanList);
		OvertimePageBean<Overtime> pageBean=new OvertimePageBean<Overtime>();
		pageBean.setBeanList(beanList);
		pageBean.setTotalRecored(totalRecored);
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		pageBean.setPageBeginAndPageEnd();
		return pageBean;
	}
	@Override
	public OvertimePageBean<Overtime> selectPageBeanByName(Integer pageIndex, int pageSize, String realName) {
		
		
		//根据姓名查符合条件的记录	
		int sqlPageIndex=(pageIndex-1)*pageSize;
		int totalRecored=overtimeMapper.countByName(realName);
		List<Overtime> beanList= overtimeMapper.selectPageBeanByName(realName,sqlPageIndex,pageSize);
	    //System.out.println(beanList);
		OvertimePageBean<Overtime> pageBean=new OvertimePageBean<Overtime>();
		pageBean.setBeanList(beanList);
		pageBean.setTotalRecored(totalRecored);
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		pageBean.setPageBeginAndPageEnd();
		return pageBean;
	}
	
	//判断加班时间是否重复
	@Override
	public Overtime selectBegintime(Overtime overtime) {
		Overtime oovertime=overtimeMapper.selectBegintime(overtime);
		//System.out.println("判断加班时间   "+oovertime);
		return oovertime;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
