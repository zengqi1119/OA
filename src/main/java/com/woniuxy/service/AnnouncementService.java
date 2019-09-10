package com.woniuxy.service;

import java.util.List;

import com.woniuxy.entity.Accept;
import com.woniuxy.entity.Announcement;
import com.woniuxy.entity.Userinfo;

/**
 * 公告业务逻辑处理接口
 * 定义了公告业务逻辑处理实现类必须实现的方法
 * @author ZX
 *
 */

public interface AnnouncementService {
	//添加公告信息
	void insertAnnouncementGetAid(Announcement announcement);
	//查询除当前用户外的所有员工
	List<Userinfo> queryUserinfo(Integer uid);
	//查询个人发送公告
	List<Announcement> queryAnnouncementByUid(Integer uid);
	//查询个人接收公告
	List<Accept> queryAccept(Integer uid);
	//查询个人接收公告详细信息
	List<Announcement> queryAnnouncements(List<Integer> aid);
	//查询发件人信息
	List<Userinfo> queryReceive(List<Integer> uids);
	//根据员工编号查询员工信息
	List<Userinfo> findUserinfo(Integer uid);
	//将收件人写入接收表
	void addReceive(Integer uid, Integer aid, List<Integer> uids);
}
