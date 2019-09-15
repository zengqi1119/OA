package com.woniuxy.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.entity.Role;
import com.woniuxy.entity.RoleExample;
import com.woniuxy.entity.Useraccount;
import com.woniuxy.entity.UseraccountExample;
import com.woniuxy.entity.UseraccountExample.Criteria;
import com.woniuxy.entity.Userrole;
import com.woniuxy.entity.UserroleExample;
import com.woniuxy.mapper.RoleMapper;
import com.woniuxy.mapper.UseraccountMapper;
import com.woniuxy.mapper.UserroleMapper;
import com.woniuxy.service.LoginService;
@Service
public class LoginServiceImp implements LoginService {
	
	@Autowired
	UseraccountMapper useraccountMapper;
	@Autowired
	UserroleMapper userroleMapper;
	@Autowired
	RoleMapper roleMapper;
	
	//查询密码
	@Override
	public Useraccount selectBypassword(String account) {
		 UseraccountExample Example = new UseraccountExample();
			Criteria criteria = Example.createCriteria();
			criteria.andAccountEqualTo(account);
			//criteria.andUidEqualTo(1);
		  List<Useraccount> list = useraccountMapper.selectByExample(Example);
		  if(list!=null&&list.size()==1){
				return list.get(0);
			}
			return null;
	}

	//修改密码
	@Override
	public int updatePassword(String account, String newpwd) {
		int row = useraccountMapper.updatePassword(account, newpwd);
		return row;
	}

	@Override
	public Useraccount selectUid(String account) {
		UseraccountExample example = new UseraccountExample();
		example.createCriteria().andAccountEqualTo(account);
		List<Useraccount> users = useraccountMapper.selectByExample(example);
		Useraccount user = users.get(0);
		return user;
	}

	@Override
	public Role selectRole(Integer uid) {
		UserroleExample example = new UserroleExample();
		example.createCriteria().andUidEqualTo(uid);
		List<Userrole> userroles = userroleMapper.selectByExample(example);
		Userrole userrole = userroles.get(0);
		RoleExample examples = new RoleExample();
		examples.createCriteria().andRidEqualTo(userrole.getRid());
		List<Role> roles = roleMapper.selectByExample(examples);
		Role role = roles.get(0);
		return role;
	}

}
