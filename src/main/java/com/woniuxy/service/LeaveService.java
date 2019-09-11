package com.woniuxy.service;


import java.util.List;

import com.woniuxy.bean.LeavesAssembly;
import com.woniuxy.entity.Leaves;
import com.woniuxy.entity.Userinfo;

public interface LeaveService {

	LeavesAssembly selectAll(List<Integer> ids,int pageIndex,int pageSize,String name);

	int insertLeave(Leaves leave);

	int changeLeave(Leaves leave);

	int removeLeave(Integer lid);

	List<Userinfo> selectUserByUname(String name);

}
