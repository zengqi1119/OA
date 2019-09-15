package com.woniuxy.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.bean.UserInfoPageBean;
import com.woniuxy.entity.Relation;
import com.woniuxy.entity.Userinfo;
import com.woniuxy.entity.UserinfoExample;
import com.woniuxy.entity.UserinfoExample.Criteria;
import com.woniuxy.mapper.RelationMapper;
import com.woniuxy.mapper.UseraccountMapper;
import com.woniuxy.mapper.UserinfoMapper;
import com.woniuxy.service.SystemManagementService;
@Service
public class SystemManagementServiceImp implements SystemManagementService{
//	@Autowired
//	SystemManagementDao systemManagementDao;
	@Autowired
	UserinfoMapper userinfoMapper;
	@Autowired
	UseraccountMapper useraccountMapper;
	@Autowired
	RelationMapper relationMapper;
	
	//查询所有
	@Override
	public List<Userinfo> selectAllUserinfo() {
		List<Userinfo> userinfo = userinfoMapper.findAllUserinfo();
		return userinfo;
	}
	//添加员工信息
	@Override
	public void addUserinfo(String account, Userinfo userinfo) {
		userinfoMapper.addUserinfo(userinfo);
		//添加用户
		useraccountMapper.addUserAccount(account, userinfo.getUid());
		//添加通讯录
		Relation relation = new Relation();
		relation.setMobilephone(userinfo.getReid());
		relation.setUid(userinfo.getUid());
		relationMapper.insert(relation);
		
	}
	//根据员工编号查员工信息
	@Override
	public Userinfo selectUserinfoById(int uid) {
		UserinfoExample userinfoExample = new UserinfoExample();
		Criteria criteria = userinfoExample.createCriteria();
		criteria.andUidEqualTo(uid);
		List<Userinfo> selectByExample = userinfoMapper.selectByExample(userinfoExample);
		//System.out.println(selectByExample);
		if(selectByExample!=null&&selectByExample.size()==1){
			return selectByExample.get(0);
		}
		return null;
	}
	//修改员工信息
	@Override
	public int updateByUname(Userinfo userinfo) {
		//返回影响行数
		int row = userinfoMapper.updateByuname(userinfo);
		return row;
	}
	//软删除员工信息
	@Override
	public int deleteById(int uid) {
		int row = userinfoMapper.deleteById(uid);
		return row;
	}
	//模糊查询
	@Override
	public List<Userinfo> queryAllUserinfo(String uname,String sex) {
//		 UserinfoExample example = new UserinfoExample();
//		  Criteria criteria = example.createCriteria();
//		  criteria.andUnameLike("%"+uname+"%");
//		 // criteria.andSexLike("%男%");
//		  criteria.andSexLike("%"+sex+"%");
//		  List<Userinfo> selectByExample = userinfoMapper.selectByExample(example);
//		  System.out.println(selectByExample);
//		 
		List<Userinfo> queryAllUserinfo = userinfoMapper.queryAllUserinfo(uname,sex);
		 return queryAllUserinfo;
	}
	//分页查询所有
	@Override
	public UserInfoPageBean<Userinfo> getUserinfoConditionByPage(int pageIndex, int pageSize, Userinfo userinfo) {
		//获取总条数
	//	System.out.println("123"+userinfo);
		int count = userinfoMapper.findCount(userinfo);
	//	System.out.println(count);
		UserInfoPageBean<Userinfo> pageBean = new UserInfoPageBean<Userinfo>();
		List<Userinfo> all = userinfoMapper.selectUserinfoConditionByPage((pageIndex-1)*pageSize, pageSize, userinfo);
		pageBean.setBenanList(all);
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		pageBean.setTotalRecored(count);
		pageBean.setPageBeginAndPageEnd();
		//System.out.println(pageBean);
		return  pageBean;
	}

	
}
