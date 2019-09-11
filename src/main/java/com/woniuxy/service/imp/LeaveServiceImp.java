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
import com.woniuxy.entity.UserinfoExample;
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
	public LeavesAssembly selectAll(List<Integer> ids,int pageIndex,int pageSize) {
		LeavesExample example = new LeavesExample();
		example.createCriteria().andUidIn(ids).andFlagEqualTo(0);
		Integer pageCount=leavesMapper.countByExample(example);
		List<Leaves> leaves = leavesMapper.selectofPage(ids,pageSize*(pageIndex-1),pageSize);
		UserinfoExample uexample = new UserinfoExample();
		uexample.createCriteria().andUidIn(ids);
		List<Userinfo> users = userinfoMapper.selectByExample(uexample );
		List<Leavetype> types = leavetypeMapper.selectByExample(new LeavetypeExample());
		List<Approvalstate> states = approvalstateMapper.selectByExample(new ApprovalstateExample());
		LeavesAssembly assembly = new LeavesAssembly(leaves,types,states,users,pageIndex,pageSize,pageCount,"/leave/query/");
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
	@Override
	public List<Userinfo> selectUserByUname(String name) {
		if("null".equals(name)) return null;
		UserinfoExample example = new UserinfoExample();
		example.createCriteria().andUnameLike("%"+name+"%");
		return userinfoMapper.selectByExample(example );
	}

}
