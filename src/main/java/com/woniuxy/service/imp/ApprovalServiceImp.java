package com.woniuxy.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.bean.ApprovalEntity;
import com.woniuxy.bean.AprovalAssemble;
import com.woniuxy.bean.AprovalAssemblePage;
import com.woniuxy.entity.Announcement;
import com.woniuxy.entity.AnnouncementExample;
import com.woniuxy.entity.Apply;
import com.woniuxy.entity.ApplyExample;
import com.woniuxy.entity.Approvalstate;
import com.woniuxy.entity.ApprovalstateExample;
import com.woniuxy.entity.Approvaltype;
import com.woniuxy.entity.ApprovaltypeExample;
import com.woniuxy.entity.Buygoods;
import com.woniuxy.entity.BuygoodsExample;
import com.woniuxy.entity.Getgoods;
import com.woniuxy.entity.GetgoodsExample;
import com.woniuxy.entity.Leaves;
import com.woniuxy.entity.LeavesExample;
import com.woniuxy.entity.Leavetype;
import com.woniuxy.entity.LeavetypeExample;
import com.woniuxy.entity.Overtime;
import com.woniuxy.entity.OvertimeExample;
import com.woniuxy.entity.Userinfo;
import com.woniuxy.entity.UserinfoExample;
import com.woniuxy.mapper.AnnouncementMapper;
import com.woniuxy.mapper.ApplyMapper;
import com.woniuxy.mapper.ApprovalMapper;
import com.woniuxy.mapper.ApprovalstateMapper;
import com.woniuxy.mapper.ApprovaltypeMapper;
import com.woniuxy.mapper.BuygoodsMapper;
import com.woniuxy.mapper.GetgoodsMapper;
import com.woniuxy.mapper.LeavesMapper;
import com.woniuxy.mapper.LeavetypeMapper;
import com.woniuxy.mapper.OvertimeMapper;
import com.woniuxy.mapper.UserinfoMapper;
import com.woniuxy.service.ApprovalService;

@Service
public class ApprovalServiceImp implements ApprovalService {
	@Autowired
	UserinfoMapper userinfoMapper;
	@Autowired
	OvertimeMapper overtimeMapper;
	@Autowired
	LeavesMapper leavesMapper;
	@Autowired
	ApplyMapper applysMapper;
	@Autowired
	BuygoodsMapper buygoodsMapper;
	@Autowired
	GetgoodsMapper getgoodsMapper;
	@Autowired
	AnnouncementMapper announcementMapper;
	@Autowired
	ApprovaltypeMapper approvaltypeMapper;
	@Autowired
	ApprovalstateMapper approvalstateMapper;
	@Autowired
	LeavetypeMapper leavetypeMapper;
	@Autowired
	ApprovalMapper approvalMapper;

	@Override
	public AprovalAssemblePage queryAll(Integer pageIndex, int pageSize) {
		List<Userinfo> users = userinfoMapper.selectByExample(new UserinfoExample());
		List<Approvaltype> atypes = approvaltypeMapper.selectByExample(new ApprovaltypeExample());;
		List<Approvalstate> states = approvalstateMapper.selectByExample(new ApprovalstateExample());
		List<Leavetype> ltypes = leavetypeMapper.selectByExample(new LeavetypeExample());
		List<ApprovalEntity> elements = approvalMapper.selectAll(pageSize*(pageIndex-1),pageSize);
		Integer pageCount = approvalMapper.countAll();
		AprovalAssemblePage approvals = new AprovalAssemblePage(users,atypes,states,ltypes,elements,pageIndex,pageSize,pageCount,"/approval/queryall/");
		approvals.setStartandEnd();
		return approvals;
	}

	@Override
	public AprovalAssemble queryByUid(int uid) {
		AprovalAssemble apro = new AprovalAssemble();
		apro.setUser(userinfoMapper.selectByPrimaryKey(uid));
		apro.setOvertimes(getOvertimes(uid));
		apro.setLeaves(getLeaves(uid));
		apro.setApplys(getApplys(uid));
		apro.setBuys(getBuys(uid));
		apro.setGets(getGets(uid));
		apro.setAnns(getAnns(uid));
		apro.setTypes(approvaltypeMapper.selectByExample(new ApprovaltypeExample()));
		return apro;
	}

	@Override
	public List<Userinfo> queryAllUser() {
		return userinfoMapper.selectByExample(new UserinfoExample());
	}

	@Override
	public int approval(int state, int primaryKey, int aptid) {
		switch (aptid) {
		case 1:
			return updateOvertime(state, primaryKey);
		case 2:
			return updateLeave(state, primaryKey);
		case 3:
			return updateApply(state, primaryKey);
		case 4:
			return updateGetgoods(state, primaryKey);
		case 5:
			return updateBuygoods(state, primaryKey);
		case 6:
			return updateAnn(state, primaryKey);
		}
		return 0;
	}

	/**
	 * 更新公告表
	 * 
	 * @param state
	 * @param primaryKey
	 * @return
	 */
	private int updateAnn(int state, int primaryKey) {
		Announcement ann = new Announcement();
		ann.setApid(state);
		AnnouncementExample example = new AnnouncementExample();
		example.createCriteria().andAidEqualTo(primaryKey);
		return announcementMapper.updateByExampleSelective(ann, example);
	}

	/**
	 * 更新申购表
	 * 
	 * @param state
	 * @param primaryKey
	 * @return
	 */
	private int updateBuygoods(int state, int primaryKey) {
		Buygoods buygoods = new Buygoods();
		buygoods.setApid(state);
		BuygoodsExample example = new BuygoodsExample();
		example.createCriteria().andBidEqualTo(primaryKey);
		return buygoodsMapper.updateByExampleSelective(buygoods, example);
	}

	/**
	 * 更新申领表
	 * 
	 * @param state
	 * @param primaryKey
	 * @return
	 */
	private int updateGetgoods(int state, int primaryKey) {
		Getgoods getgoods = new Getgoods();
		getgoods.setApid(state);
		GetgoodsExample example = new GetgoodsExample();
		example.createCriteria().andGidEqualTo(primaryKey);
		return getgoodsMapper.updateByExampleSelective(getgoods, example);
	}

	/**
	 * 更新报销表
	 * 
	 * @param state
	 * @param primaryKey
	 * @return
	 */
	private int updateApply(int state, int primaryKey) {
		Apply apply = new Apply();
		apply.setApid(state);
		ApplyExample example = new ApplyExample();
		example.createCriteria().andAppidEqualTo(primaryKey);
		return applysMapper.updateByExampleSelective(apply, example);
	}

	/**
	 * 更新请假表
	 * 
	 * @param state
	 * @param primaryKey
	 * @return
	 */
	private int updateLeave(int state, int primaryKey) {
		Leaves leave = new Leaves();
		leave.setApid(state);
		LeavesExample example = new LeavesExample();
		example.createCriteria().andLidEqualTo(primaryKey);
		return leavesMapper.updateByExampleSelective(leave, example);
	}

	/**
	 * 更新加班表
	 * 
	 * @param state
	 * @param primaryKey
	 * @return
	 */
	private int updateOvertime(int state, int primaryKey) {
		Overtime overtime = new Overtime();
		overtime.setApid(state);
		OvertimeExample example = new OvertimeExample();
		example.createCriteria().andOidEqualTo(primaryKey);
		return overtimeMapper.updateByExampleSelective(overtime, example);
	}

	/**
	 * 查询公告
	 * 
	 * @param uid
	 * @return
	 */
	private List<Announcement> getAnns(int uid) {
		AnnouncementExample example = new AnnouncementExample();
		example.createCriteria().andUidEqualTo(uid).andFlagEqualTo(0);
		return announcementMapper.selectByExample(example);
	}

	/**
	 * 查询申领表
	 * 
	 * @param uid
	 * @return
	 */
	private List<Getgoods> getGets(int uid) {
		GetgoodsExample example = new GetgoodsExample();
		example.createCriteria().andUidEqualTo(uid).andFlagEqualTo(0);
		return getgoodsMapper.selectByExample(example);
	}

	/**
	 * 查询申购表
	 * 
	 * @param uid
	 * @return
	 */
	private List<Buygoods> getBuys(int uid) {
		BuygoodsExample example = new BuygoodsExample();
		example.createCriteria().andUidEqualTo(uid).andFlagEqualTo(0);
		return buygoodsMapper.selectByExample(example);
	}

	/**
	 * 查询报销表
	 * 
	 * @param uid
	 * @return
	 */
	private List<Apply> getApplys(int uid) {
		ApplyExample example = new ApplyExample();
		example.createCriteria().andUidEqualTo(uid).andFlagEqualTo(0);
		return applysMapper.selectByExample(example);
	}

	/**
	 * 查询请假表
	 * 
	 * @param uid
	 * @return
	 */
	private List<Leaves> getLeaves(int uid) {
		LeavesExample example = new LeavesExample();
		example.createCriteria().andUidEqualTo(uid).andFlagEqualTo(0);
		return leavesMapper.selectByExample(example);
	}

	/**
	 * 查询加班表
	 * 
	 * @param uid
	 * @return
	 */
	private List<Overtime> getOvertimes(int uid) {
		OvertimeExample example = new OvertimeExample();
		example.createCriteria().andUidEqualTo(uid).andFlagEqualTo(0);
		return overtimeMapper.selectByExample(example);
	}



}
