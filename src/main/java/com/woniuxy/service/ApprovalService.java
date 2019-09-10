package com.woniuxy.service;

import java.util.List;

import com.woniuxy.bean.AprovalAssemble;
import com.woniuxy.entity.Userinfo;

public interface ApprovalService {
	/**
	 * 通过uid查找所有待审批项
	 * 
	 * @param uid
	 * @return
	 */
	AprovalAssemble queryByUid(int uid);

	/*
	 * 8 查询所有的待审批项
	 */
	List<Userinfo> queryAllUser();

	/**
	 * 更新审批状态
	 * 
	 * @param state
	 * @param primaryKey
	 * @param aptid
	 * @return
	 */
	int approval(int state, int primaryKey, int aptid);

}
