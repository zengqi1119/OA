package com.woniuxy.service;

import java.util.List;

import com.woniuxy.bean.OvertimePageBean;
import com.woniuxy.entity.Overtime;



/**加班表service接口
 * @刘立英
 */
public interface OvertimeService {
	//查找(根据用户id查找)
	List<Overtime> showOvertimeByUid(Integer uid);
	//插入加班信息
	int insertOvertime(Overtime overtime);
	//删除加班信息
	int deleteOvertime(Integer oid);
	//查找(根据加班表id查找)
	Overtime selectOvertimeByOid(Integer oid);
	//修改根据(根据加班表id修改)
	int updateOvertimeByOid(Overtime overtime);
	//查找(根据用户名称查找)
	List<Overtime> showOvertimeByName(String realName);
	//分页查找
	OvertimePageBean<Overtime> selectPageBeanByUid(Integer pageIndex, int pageSize, Integer uid);
	OvertimePageBean<Overtime> selectPageBeanByName(Integer pageIndex, int pageSize, String realName);
	//判断加班时间是否重复
	Overtime selectBegintime(Overtime overtime);
}
