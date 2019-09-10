package com.woniuxy.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.entity.Useraccount;
import com.woniuxy.entity.UseraccountExample;
import com.woniuxy.entity.UseraccountExample.Criteria;
import com.woniuxy.mapper.UseraccountMapper;
import com.woniuxy.service.LoginService;
@Service
public class LoginServiceImp implements LoginService {
	
	@Autowired
	UseraccountMapper useraccountMapper;
	
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

}
