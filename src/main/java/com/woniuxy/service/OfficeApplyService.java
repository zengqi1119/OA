package com.woniuxy.service;

import java.util.List;

import com.woniuxy.bean.PageBean;
import com.woniuxy.entity.Buygoods;
import com.woniuxy.entity.Getgoods;

public interface OfficeApplyService {
	// 分页查询
	PageBean<Getgoods> selectAllMessage(int currentpage, int count, List<Integer> uid);

	// 模糊查询得到id
	List<Integer> selectUidByUname(String uname);

	//删除
	void deleteOfficeApply(Integer gid);
	//修改
	void updateOfficeApply(Getgoods getgoods);
	//添加
	void addOfficeApply(Getgoods getgoods);
}
