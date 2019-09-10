package com.woniuxy.service;

import java.util.List;

import com.woniuxy.bean.PageBean;
import com.woniuxy.entity.Buygoods;

public interface OfficeSubscribeService {

	PageBean<Buygoods> selectAllMessage(int currentpage, int count, List<Integer> uid);
	//模糊查询
	List<Integer> selectUidByUname(String uname);
	//删除
	void deleteofficeSubscribe(Integer bid);
	//修改
	void updateOfficeSubscribe(Buygoods buygoods);
	//添加
	void addOfficeSubscribe(Buygoods buygoods);

}
