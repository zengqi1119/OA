package com.woniuxy.service;

import java.util.List;

import com.woniuxy.bean.ApplyUser;
import com.woniuxy.entity.Apply;
import com.woniuxy.entity.Userinfo;

/**
 * 报销业务逻辑处理接口
 * 定义了报销业务逻辑处理实现类必须实现的方法
 * @author ZX
 *
 */

public interface ApplyService {
	//根据用户ID查询报销项
	ApplyUser queryApplyByUid(Integer uid,Integer pageIndex,Integer pageSize);
	ApplyUser queryApplyAll(String condition,Integer pageIndex,Integer pageSize);
	//根据用户ID查询用户信息
	List<Userinfo> queryUserinfoByUid(Integer uid);
	//添加报销项
	void addApply(Apply apply);
	//修改报销项
	void modifyApply(Apply apply);
	//删除报销项
	void removeApply(Integer appid);
}
