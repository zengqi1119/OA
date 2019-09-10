package com.woniuxy.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.woniuxy.entity.Accept;
import com.woniuxy.entity.AcceptExample;
import com.woniuxy.entity.Announcement;
import com.woniuxy.entity.AnnouncementExample;
import com.woniuxy.entity.AnnouncementExample.Criteria;
import com.woniuxy.entity.Userinfo;
import com.woniuxy.entity.UserinfoExample;
import com.woniuxy.mapper.AcceptMapper;
import com.woniuxy.mapper.AnnouncementMapper;
import com.woniuxy.mapper.UserinfoMapper;
import com.woniuxy.service.AnnouncementService;

/**
 * 公告业务逻辑处理实现类
 * 对公告添加,查询,修改,删除业务逻辑操作
 * @author ZX
 *
 */

@Service
public class AnnouncementServiceImp implements AnnouncementService {
	
	@Autowired
	AnnouncementMapper announcementMapper;
	@Autowired
	UserinfoMapper userinfoMapper;
	@Autowired
	AcceptMapper acceptMapper;
	
	//添加公告信息
	@Override
	public void insertAnnouncementGetAid(Announcement announcement) {
		announcementMapper.insertAnnouncementGetAid(announcement);
	}

	//查询出当前用户外的所有员工
	@Override
	public List<Userinfo> queryUserinfo(Integer uid) {
		UserinfoExample example = new UserinfoExample();
		com.woniuxy.entity.UserinfoExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andUidNotEqualTo(uid);
		List<Userinfo> users = userinfoMapper.selectByExample(example );
		return users;
	}

	//查询个人发送公告
	@Override
	public List<Announcement> queryAnnouncementByUid(Integer uid) {
		AnnouncementExample example = new AnnouncementExample();
		Criteria criteria = example.createCriteria();
		criteria.andUidEqualTo(uid);
		List<Announcement> announcements = announcementMapper.selectByExample(example );
		return announcements;
	}

	//根据员工编号查询员工信息
	@Override
	public List<Userinfo> findUserinfo(Integer uid) {
		UserinfoExample example = new UserinfoExample();
		com.woniuxy.entity.UserinfoExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andUidEqualTo(uid);
		List<Userinfo> findUser = userinfoMapper.selectByExample(example);
		return findUser;
	}

	//添加接受公告表数据
	@Override
	public void addReceive(Integer uid, Integer aid, List<Integer> uids) {
		for(int i=0;i<uids.size();i++) {
			Integer ucid = uids.get(i);
			Accept accept = new Accept();
			accept.setAid(aid);
			accept.setUid(uid);
			accept.setUcid(ucid);
			acceptMapper.insertSelective(accept);
		}
	}

	@Override
	public List<Accept> queryAccept(Integer uid) {
		AcceptExample example = new AcceptExample();
		com.woniuxy.entity.AcceptExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andUcidEqualTo(uid);
		List<Accept> accepts = acceptMapper.selectByExample(example );
		return accepts;
	}

	@Override
	public List<Announcement> queryAnnouncements(List<Integer> aid) {
		AnnouncementExample example = new AnnouncementExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andAidIn(aid);
		List<Announcement> annoucements = announcementMapper.selectByExample(example );
		return annoucements;
	}

	@Override
	public List<Userinfo> queryReceive(List<Integer> uids) {
		UserinfoExample example = new UserinfoExample();
		com.woniuxy.entity.UserinfoExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andUidIn(uids);
		List<Userinfo> userinfo = userinfoMapper.selectByExample(example);
		return userinfo;
	}
	
	

}
