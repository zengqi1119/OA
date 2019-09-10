package com.woniuxy.service;


import com.woniuxy.bean.LeavesAssembly;
import com.woniuxy.entity.Leaves;

public interface LeaveService {

	LeavesAssembly selectAll(int uid,int pageIndex,int pageSize);

	int insertLeave(Leaves leave);

	int changeLeave(Leaves leave);

	int removeLeave(Integer lid);

}
