package com.woniuxy.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.bean.PageBean;
import com.woniuxy.entity.Buygoods;
import com.woniuxy.entity.BuygoodsExample;
import com.woniuxy.entity.Getgoods;
import com.woniuxy.entity.Userinfo;
import com.woniuxy.entity.UserinfoExample;
import com.woniuxy.mapper.ApprovalstateMapper;
import com.woniuxy.mapper.BuygoodsMapper;
import com.woniuxy.mapper.UserinfoMapper;
import com.woniuxy.service.OfficeSubscribeService;
@Service
public class OfficeSubscribeServiceImp implements OfficeSubscribeService {
	@Autowired
	BuygoodsMapper buygoodsMapper;
	@Autowired
	ApprovalstateMapper approvalstateMapper;
	@Autowired
	UserinfoMapper userinfoMapper;
	
	
	@Override
	public PageBean<Buygoods> selectAllMessage(int currentpage, int count, List<Integer> uid) {
		List<Integer> totalList=new ArrayList<Integer>();
		//总条数
		Integer totals=0;
		//获取所有条数
		totalList=buygoodsMapper.getOfficeSubscribeTotal(uid);
		for (Integer total : totalList) {
			totals += total;
		}
		//获取当前页所有信息
		List<Buygoods> buygoods=buygoodsMapper.getAllOfficeSubscribe(count,(currentpage-1)*count,uid);
		
		//装配
		PageBean<Buygoods> pageBean=new PageBean<>();
        pageBean.setElements(buygoods);			//当前页的内容
        pageBean.setTotal(totals);				//总条数
        pageBean.setCurrentpage(currentpage);	//当前页
        pageBean.setCount(count);				//每一页数量
        pageBean.setTotalPage(totals%count==0? totals/count:totals/count+1); //总页数
        pageBean.setEndPageAndBeginPage();
        return pageBean;
	}
	
	//模糊查询找名字
	@Override
	public List<Integer> selectUidByUname(String uname) {
		List<Integer> uid = new ArrayList<Integer>();
		List<Userinfo> user = null;
		UserinfoExample example = new UserinfoExample();
		example.createCriteria().andUnameLike("%" + uname + "%");
		try {
			user = userinfoMapper.selectByExample(example);
			if (user != null) {
				for (Userinfo userinfo2 : user) {
					uid.add(userinfo2.getUid());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return uid;
	}
	//假删除
	@Override
	public void deleteofficeSubscribe(Integer bid) {
		//改变的flag列 
		Buygoods record = new Buygoods();
		record.setFlag(1);
		//where条件 bid
		BuygoodsExample example = new BuygoodsExample();
		example.createCriteria().andBidEqualTo(bid);
		buygoodsMapper.updateByExampleSelective(record, example);
	}
	
	//修改
	@Override
	public void updateOfficeSubscribe(Buygoods buygoods) {
		BuygoodsExample example = new BuygoodsExample();
		example.createCriteria().andBidEqualTo(buygoods.getBid());
		Buygoods record = new Buygoods();
		record.setBdate(buygoods.getBdate());
		record.setBname(buygoods.getBname());
		try {
			buygoodsMapper.updateByExampleSelective(record, example);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}
	//添加
	@Override
	public void addOfficeSubscribe(Buygoods buygoods) {
		System.out.println(buygoods.getUid()+"---Uid--");
		Buygoods record = new Buygoods();
		record.setBdate(buygoods.getBdate());
		record.setBname(buygoods.getBname());
		record.setUid(buygoods.getUid());
		try {
			buygoodsMapper.insertSelective(record);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
}
