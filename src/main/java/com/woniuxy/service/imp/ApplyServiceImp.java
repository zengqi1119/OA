package com.woniuxy.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.bean.ApplyUser;
import com.woniuxy.entity.Apply;
import com.woniuxy.entity.ApplyExample;
import com.woniuxy.entity.ApplyExample.Criteria;
import com.woniuxy.entity.Userinfo;
import com.woniuxy.entity.UserinfoExample;
import com.woniuxy.mapper.ApplyMapper;
import com.woniuxy.mapper.UserinfoMapper;
import com.woniuxy.service.ApplyService;

/**
 * 报销业务逻辑处理实现类
 * 对报销添加,查询,修改,删除业务逻辑操作
 * @author ZX
 *
 */

@Service
public class ApplyServiceImp implements ApplyService {
	
	@Autowired
	ApplyMapper applyMapper;
	@Autowired
	UserinfoMapper userinfoMapper;

	//根据用户ID查询报销项
	@Override
	public ApplyUser queryApplyByUid(Integer uid,Integer pageIndex,Integer pageSize) {
		ApplyUser applyUser = new ApplyUser();
		List<Apply> applys = new ArrayList<Apply>();
		List<Userinfo> user = new ArrayList<Userinfo>();
		Integer count = new Integer(0);
		try {
			ApplyExample example = new ApplyExample();
			Criteria createCriteria = example.createCriteria();
			createCriteria.andUidEqualTo(uid).andFlagEqualTo(0);
			count = applyMapper.countByExample(example );
			applys = applyMapper.selectApply(uid, (pageIndex-1)*pageSize, pageSize);
			user = queryUserinfoByUid(uid);
			System.out.println(user.size());
			applyUser.setPageIndex(pageIndex);
			applyUser.setPageSize(pageSize);
			applyUser.setCount(count);
			applyUser.setApplys(applys);
			applyUser.setUser(user);
			applyUser.setBeginPageAndEndPage();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return applyUser;
	}
	
	@Override
	public ApplyUser queryApplyAll(String condition,Integer pageIndex, Integer pageSize) {
		ApplyUser applyUser = new ApplyUser();
		List<Apply> applys = new ArrayList<Apply>();
		List<Userinfo> user = new ArrayList<Userinfo>();
		Integer count = new Integer(0);
		try {
			ApplyExample example = new ApplyExample();
			Criteria createCriteria = example.createCriteria();
			createCriteria.andFlagEqualTo(0);
			UserinfoExample examples = new UserinfoExample();
			if(condition.equals("")||condition==null) {
				user = userinfoMapper.selectByExample(examples);
				count = applyMapper.countByExample(example );
				applys = applyMapper.selectApplyAll((pageIndex-1)*pageSize, pageSize);
			}else {
				condition = "%"+condition+"%";
				examples.createCriteria().andUnameLike(condition);
				user = userinfoMapper.selectByExample(examples);
				createCriteria.andUidEqualTo(user.get(0).getUid());
				applys = applyMapper.selectApply(user.get(0).getUid(), (pageIndex-1)*pageSize, pageSize);
			}
			applyUser.setPageIndex(pageIndex);
			applyUser.setPageSize(pageSize);
			applyUser.setCount(count);
			applyUser.setApplys(applys);
			applyUser.setUser(user);
			applyUser.setBeginPageAndEndPage();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return applyUser;
	}


	//根据用户ID查询用户信息
	@Override
	public List<Userinfo> queryUserinfoByUid(Integer uid) {
		List<Userinfo> users = new ArrayList<Userinfo>();
		UserinfoExample example = new UserinfoExample();
		com.woniuxy.entity.UserinfoExample.Criteria criteria = example.createCriteria();
		criteria.andFlagEqualTo(0);
		criteria.andUidEqualTo(uid);
		try {
			users = userinfoMapper.selectByExample(example);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return users;
	}

	//添加报销项
	@Override
	public void addApply(Apply apply) {
		try {
			applyMapper.insertSelective(apply);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	//修改报销项
	@Override
	public void modifyApply(Apply apply) {
		ApplyExample example = new ApplyExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andAppidEqualTo(apply.getAppid());
		try {
			applyMapper.updateByExampleSelective(apply, example);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	//删除报销项
	@Override
	public void removeApply(Integer appid) {
		ApplyExample example = new ApplyExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andAppidEqualTo(appid);
		Apply apply = new Apply();
		apply.setFlag(1);
		try {
			applyMapper.updateByExampleSelective(apply, example);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
