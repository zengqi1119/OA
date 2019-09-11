package com.woniuxy.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.woniuxy.bean.AllAnnouncements;
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
		createCriteria.andFlagEqualTo(0);
		List<Userinfo> users = userinfoMapper.selectByExample(example );
		return users;
	}

	//查询个人公告
	@Override
	public AllAnnouncements queryAnnouncementByUid(Integer uid,Integer sendPageIndex,Integer receivePageIndex,Integer pageSize) {
		AllAnnouncements allAnnouncements = new AllAnnouncements();
		//查询发送公告
		List<Announcement> send = announcementMapper.selectSendAnnouncement(uid,(sendPageIndex-1)*pageSize,pageSize);
		AnnouncementExample example = new AnnouncementExample();
		example.createCriteria().andUidEqualTo(uid).andFlagEqualTo(0);
		Integer sendCount = announcementMapper.countByExample(example);
		//查询接收公告
		List<Accept> accepts = acceptMapper.selectReceiveAid(uid,(receivePageIndex-1)*pageSize,pageSize);
		AcceptExample examples = new AcceptExample();
		examples.createCriteria().andUcidEqualTo(uid).andFlagEqualTo(0);
		Integer receiveCount = acceptMapper.countByExample(examples);
		List<Integer> aid = new ArrayList<Integer>();
		for (int i = 0; i < accepts.size(); i++) {
			aid.add(accepts.get(i).getAid());
		}
		List<Announcement> receive = queryAnnouncements(aid);
		List<Integer> uids = new ArrayList<Integer>();
		for (int i = 0; i < receive.size(); i++) {
			uids.add(receive.get(i).getUid());
		}
		List<Userinfo> userinfo = queryReceive(uids);
		//装配
		allAnnouncements.setSend(send);
		allAnnouncements.setReceive(receive);
		allAnnouncements.setAccepts(accepts);
		allAnnouncements.setUserinfo(userinfo);
		allAnnouncements.setSendPageIndex(sendPageIndex);
		allAnnouncements.setPageSize(pageSize);
		allAnnouncements.setSendCount(sendCount);
		allAnnouncements.setSendBeginPageAndEndPage();
		allAnnouncements.setReceivePageIndex(receivePageIndex);
		allAnnouncements.setReceiveCount(receiveCount);
		allAnnouncements.setReceiveBeginPageAndEndPage();
		return allAnnouncements;
	}

	//根据员工编号查询员工信息
	@Override
	public List<Userinfo> findUserinfo(Integer uid) {
		UserinfoExample example = new UserinfoExample();
		com.woniuxy.entity.UserinfoExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andUidEqualTo(uid);
		createCriteria.andFlagEqualTo(0);
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
		createCriteria.andFlagEqualTo(0);
		List<Accept> accepts = acceptMapper.selectByExample(example );
		return accepts;
	}

	@Override
	public List<Announcement> queryAnnouncements(List<Integer> aid) {
		AnnouncementExample example = new AnnouncementExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andAidIn(aid);
		createCriteria.andFlagEqualTo(0);
		List<Announcement> annoucements = announcementMapper.selectByExample(example );
		return annoucements;
	}

	@Override
	public List<Userinfo> queryReceive(List<Integer> uids) {
		UserinfoExample example = new UserinfoExample();
		com.woniuxy.entity.UserinfoExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andUidIn(uids);
		createCriteria.andFlagEqualTo(0);
		List<Userinfo> userinfo = userinfoMapper.selectByExample(example);
		return userinfo;
	}

	@Override
	public void modifyAnnouncement(Announcement announcement) {
		AnnouncementExample example = new AnnouncementExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andAidEqualTo(announcement.getAid());
		createCriteria.andFlagEqualTo(0);
		announcementMapper.updateByExampleSelective(announcement, example);
	}

	@Override
	public List<Announcement> getAnnouncementByAid(Integer aid) {
		AnnouncementExample example = new AnnouncementExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andAidEqualTo(aid);
		createCriteria.andFlagEqualTo(0);
		List<Announcement> announcement = announcementMapper.selectByExample(example);
		return announcement;
	}

	@Override
	public List<Userinfo> getSendUserinfo(Integer uid) {
		UserinfoExample example = new UserinfoExample();
		com.woniuxy.entity.UserinfoExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andUidEqualTo(uid);
		createCriteria.andFlagEqualTo(0);
		List<Userinfo> send = userinfoMapper.selectByExample(example);
		return send;
	}

	@Override
	public List<Accept> getReceiveUid(Integer aid) {
		AcceptExample example = new AcceptExample();
		com.woniuxy.entity.AcceptExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andAidEqualTo(aid);
		createCriteria.andFlagEqualTo(0);
		List<Accept> accepts = acceptMapper.selectByExample(example);
		return accepts;
	}

	@Override
	public List<Userinfo> getReceiveUserinfo(List<Integer> uids) {
		UserinfoExample example = new UserinfoExample();
		com.woniuxy.entity.UserinfoExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andUidIn(uids);
		createCriteria.andFlagEqualTo(0);
		List<Userinfo> receive = userinfoMapper.selectByExample(example);
		return receive;
	}

	@Override
	public void removeReceive(List<Integer> uids,Integer aid) {
		AcceptExample example = new AcceptExample();
		com.woniuxy.entity.AcceptExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andUcidIn(uids);
		createCriteria.andAidEqualTo(aid);
		Accept accept = new Accept();
		accept.setFlag(1);
		acceptMapper.updateByExampleSelective(accept, example);
	}
}
