package com.woniuxy;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.woniuxy.mapper.ApprovalMapper;
import com.woniuxy.mapper.ApprovalstateMapper;
import com.woniuxy.mapper.LeavesMapper;
import com.woniuxy.mapper.RelationMapper;
import com.woniuxy.mapper.UseraccountMapper;
import com.woniuxy.mapper.UserinfoMapper;
import com.woniuxy.service.ApprovalService;
import com.woniuxy.service.LoginService;
import com.woniuxy.service.OfficeApplyService;
import com.woniuxy.service.OfficeSubscribeService;
import com.woniuxy.service.SystemManagementService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OasystemApplicationTests {
	
	@Autowired
	OfficeApplyService officeApplyService;
	@Autowired
	OfficeSubscribeService officeSubscribeService;

	@Autowired
	ApprovalstateMapper approvalstateMapper;
	@Autowired
	SystemManagementService systemManagementService;
	@Autowired
	UserinfoMapper userinfoMapper;
	@Autowired
	UseraccountMapper useraccountMapper;
	@Autowired
	LoginService loginService;
	@Autowired
	RelationMapper relationMapper;
	@Autowired
	LeavesMapper leavesMapper;
	@Autowired ApprovalService approvalService;
	@Autowired ApprovalMapper approvalMapper;
	@Test
	public void contextLoads() {
//System.out.println(approvalService.queryAll(1, 5));
		/* Userinfo userinfo = new Userinfo(11,"王", 23, "女", "121243", "34413-234", new
				 * Date(), null, 5234234, "tx", 2,1,0);
//				 */
//				Userinfo userinfo = new Userinfo();
//				userinfo.setUname("王");
//				userinfo.setSex("男");
//				//添加通讯录信息
		/*
		 * Relation relation = new Relation(); relation.setMobilephone("13300010003");
		 * relation.setUid(3); relationMapper.insert(relation);
		 */
				//查询总条数
//				Userinfo userinfo = new Userinfo();
//				systemManagementService.getUserinfoConditionByPage(1, 2, userinfo);
				
//				Staffpositions staffpositions = new Staffpositions(1, "boss");
//				Stateemployees stateemployees = new Stateemployees(2, "asd");
				//System.out.println(new Date());
				//String format = new SimpleDateFormat("yyyy-MM-dd").format("2009-09-09");
//				systemManagementDao.addUserinfo(userinfo);
//				List<Userinfo> userinfo = systemManagementDao.findAllUserinfo();
//				System.out.println(userinfo);
//				List<Userinfo> userinfo1 = systemManagementService.selectAllUserinfo();
//				System.out.println(userinfo1);
				
			//	userinfoMapper.addUserinfo(userinfo);
				//systemManagementService.addUserinfo("王保长", userinfo);
				//System.out.println(userinfo.getUid());
				//useraccountMapper.addUserAccount("王八", userinfo.getUid());
				//根据员工编号查员工信息
//				UserinfoExample userinfoExample = new UserinfoExample();
//				Criteria criteria = userinfoExample.createCriteria();
//				criteria.andUidEqualTo(1);
//				List<Userinfo> selectByExample = userinfoMapper.selectByExample(userinfoExample);
//				System.out.println(selectByExample);
				//Userinfo selectUserinfoById = systemManagementService.selectUserinfoById(1);
				//System.out.println(selectUserinfoById);
				//修改员工信息
//				  int uname = systemManagementService.updateByUname(userinfo);
//				  System.out.println(uname);
				//userinfoMapper.updateByuname(userinfo);
				  //删除
//				  int row = userinfoMapper.deleteById(10);
//				  System.out.println(row);
				  //登录
//				  UseraccountExample userinfoExample = new UseraccountExample();
//					Criteria criteria = userinfoExample.createCriteria();
//					criteria.andAccountEqualTo("张三");
					//criteria.andUidEqualTo(1);
				//  List<Useraccount> list = useraccountMapper.selectByExample(userinfoExample);
				//  System.out.println(list);
//				  Useraccount selectBypassword = loginService.selectBypassword("张三");
//				  System.out.println(selectBypassword);
				  //根据条件查询
//				  List<Userinfo> userinfo2 = systemManagementService.selectAllUserinfo();
//				  System.out.println(userinfo2);
//				  UserinfoExample example = new UserinfoExample();
//				  Criteria criteria = example.createCriteria();
//				  criteria.andUnameLike("%王%");
//				 // criteria.andSexLike("%男%");
//				  criteria.andAgeLike("%30%");
//				  List<Userinfo> selectByExample = userinfoMapper.selectByExample(example);
//				  System.out.println(selectByExample);
//				  List<Userinfo> queryAllUserinfo = systemManagementService.queryAllUserinfo("张三", "男");
//				  System.out.println(queryAllUserinfo);
				  //修改密码
				//  int password = useraccountMapper.updatePassword("张三", "123456");
		/*
		 * String uname="李"; List<Integer> uid =
		 * officeApplyService.selectUidByUname(uname); List<Getgoods> apply =
		 * officeApplyService.selectAllOfficeApply(uid);
		 * System.out.println(apply+"----------");
		 */
		//List<Integer> uid = officeSubscribeService.selectUidByUname("李");
//		List<Integer> uid = officeSubscribeService.selectUidByUname(null);
		/*
		 * System.out.println(uid+":uid"); int count=7; int currentpage = 1;
		 * PageBean<Buygoods> message =
		 * officeSubscribeService.selectAllMessage(currentpage, count, uid);
		 * System.out.println("message:"+message);
		 */
		System.out.println(useraccountMapper.selectRolesAndPermissionByUid(1));
	}

}
