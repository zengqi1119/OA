package com.woniuxy.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.bean.LeavesAssembly;
import com.woniuxy.entity.Approvalstate;
import com.woniuxy.entity.ApprovalstateExample;
import com.woniuxy.entity.Leaves;
import com.woniuxy.entity.LeavesExample;
import com.woniuxy.entity.Leavetype;
import com.woniuxy.entity.LeavetypeExample;
import com.woniuxy.entity.Userinfo;
import com.woniuxy.mapper.ApprovalstateMapper;
import com.woniuxy.mapper.LeavesMapper;
import com.woniuxy.mapper.LeavetypeMapper;
import com.woniuxy.mapper.UserinfoMapper;
import com.woniuxy.service.LeaveService;

@Service
public class LeaveServiceImp implements LeaveService{
	@Autowired
	LeavesMapper leavesMapper;
	@Autowired
	UserinfoMapper userinfoMapper;
	@Autowired
	LeavetypeMapper leavetypeMapper;
	@Autowired
	ApprovalstateMapper approvalstateMapper;
	@Override
	public LeavesAssembly selectAll(int uid,int pageIndex,int pageSize) {
		LeavesExample example = new LeavesExample();
		example.createCriteria().andUidEqualTo(uid).andFlagEqualTo(0);
		Integer pageCount=leavesMapper.countByExample(example);
		List<Leaves> leaves = leavesMapper.selectofPage(uid,pageSize*(pageIndex-1),pageSize);
		Userinfo userinfo = userinfoMapper.selectByPrimaryKey(uid);
		List<Leavetype> types = leavetypeMapper.selectByExample(new LeavetypeExample());
		List<Approvalstate> states = approvalstateMapper.selectByExample(new ApprovalstateExample());
		LeavesAssembly assembly = new LeavesAssembly(leaves,types,states,userinfo,pageIndex,pageSize,pageCount,"/leave/query/");
		assembly.setStartandEnd();
		return assembly;
	}
	@Override
	public int insertLeave(Leaves leave) {
		return leavesMapper.insertSelective(leave);
	}
	@Override
	public int changeLeave(Leaves leave) {
		LeavesExample example  = new LeavesExample();
		example.createCriteria().andLidEqualTo(leave.getLid());
		return leavesMapper.updateByExampleSelective(leave, example);
	}
	@Override
	public int removeLeave(Integer lid) {
		LeavesExample example=new LeavesExample();
		example.createCriteria().andLidEqualTo(lid);
		Leaves leave=new Leaves();
		leave.setFlag(1);
		leavesMapper.updateByExampleSelective(leave, example);
		return 0;
	}

}
