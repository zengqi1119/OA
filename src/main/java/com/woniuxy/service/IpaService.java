package com.woniuxy.service;

import com.woniuxy.bean.IpaPages;
import com.woniuxy.entity.Relation;

public interface IpaService {
	//增加
	void insertIpa(Relation relation);
	//删除
	void deleteIpaByMobilephone(String mobilephone);
	//查询
	int selectCountByMes(String uname,Integer seid);
	IpaPages<Relation> selectRelationByPage(String uname, int realIdex, int pageSize,Integer seid);
	//修改
	void updateIpa(Relation relation);
	String selectStateemployeesBySeid(Integer seid);
	
}
