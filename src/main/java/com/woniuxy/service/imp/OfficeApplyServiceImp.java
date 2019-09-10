package com.woniuxy.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.bean.GetGoodsBean;
import com.woniuxy.bean.PageBean;
import com.woniuxy.entity.Approvalstate;
import com.woniuxy.entity.ApprovalstateExample;
import com.woniuxy.entity.Buygoods;
import com.woniuxy.entity.Getgoods;
import com.woniuxy.entity.GetgoodsExample;
import com.woniuxy.entity.GetgoodsExample.Criteria;
import com.woniuxy.entity.Userinfo;
import com.woniuxy.entity.UserinfoExample;
import com.woniuxy.mapper.ApprovalstateMapper;
import com.woniuxy.mapper.GetgoodsMapper;
import com.woniuxy.mapper.UserinfoMapper;
import com.woniuxy.service.OfficeApplyService;

@Service
public class OfficeApplyServiceImp implements OfficeApplyService {
	
	@Autowired
	GetgoodsMapper getgoodsMapper;
	@Autowired
	ApprovalstateMapper approvalstateMapper;
	@Autowired
	UserinfoMapper userinfoMapper;
	
	public void setGetgoodsMapper(GetgoodsMapper getgoodsMapper) {
		this.getgoodsMapper = getgoodsMapper;
	}
	
	public void setApprovalstateMapper(ApprovalstateMapper approvalstateMapper) {
		this.approvalstateMapper = approvalstateMapper;
	}

	//分页查询展示
		@Override
		public PageBean<Getgoods> selectAllMessage(int currentpage, int count, List<Integer> uid) {
			List<Integer> totalList=new ArrayList<Integer>();
			//总条数
			Integer totals=0;
			//获取所有条数
			totalList=getgoodsMapper.getOfficeApplyTotal(uid);
			for (Integer total : totalList) {
				totals += total;
			}
			//获取当前页所有信息
			List<Getgoods> getgoods=getgoodsMapper.getAllOfficeApply(count,(currentpage-1)*count,uid);
			
			//装配
			PageBean<Getgoods> pageBean=new PageBean<>();
	        pageBean.setElements(getgoods);		//当前页的内容
	        pageBean.setTotal(totals);				//总条数
	        pageBean.setCurrentpage(currentpage);	//当前页
	        pageBean.setCount(count);				//每一页数量
	        pageBean.setTotalPage(totals%count==0? totals/count:totals/count+1); //总页数
	        pageBean.setEndPageAndBeginPage();
	        return pageBean;
		}
		
		
		//模糊查询名字
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
	
	
	//假删除申领信息
	@Override
	public void deleteOfficeApply(Integer gid) {
		Getgoods record=new Getgoods();
		record.setFlag(1);
		GetgoodsExample example= new GetgoodsExample();
		Criteria criteria = example.createCriteria();
		criteria.andGidEqualTo(gid);
		getgoodsMapper.updateByExampleSelective(record, example);
	}
	//修改
	@Override
	public void updateOfficeApply(Getgoods getgoods) {
		Getgoods record=new Getgoods();
		GetgoodsExample example = new GetgoodsExample();
		Criteria criteria = example.createCriteria();
		criteria.andGidEqualTo(getgoods.getGid());
		record.setGname(getgoods.getGname());
		record.setGdate(getgoods.getGdate());
		try {
			getgoodsMapper.updateByExampleSelective(record, example); 
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
		
	}
	
	//添加
	@Override
	public void addOfficeApply(Getgoods getgoods) {
		Getgoods record=new Getgoods();
		record.setGname(getgoods.getGname());
		record.setGdate(getgoods.getGdate());
		record.setUid(getgoods.getGid());
		try {
			getgoodsMapper.insertSelective(record); 
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}
}
