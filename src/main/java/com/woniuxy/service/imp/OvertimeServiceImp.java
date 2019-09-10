package com.woniuxy.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
