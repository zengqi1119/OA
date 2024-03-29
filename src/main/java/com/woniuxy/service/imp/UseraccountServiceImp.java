package com.woniuxy.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.entity.Useraccount;
import com.woniuxy.entity.UseraccountExample;
import com.woniuxy.mapper.UseraccountMapper;
import com.woniuxy.service.UseraccountService;

@Service
public class UseraccountServiceImp implements UseraccountService {
	@Autowired
	UseraccountMapper useraccountMapper;
	@Override
	public List<Useraccount> selectUseraccount(String username) {
		UseraccountExample example = new UseraccountExample();
		example.createCriteria().andAccountEqualTo(username);
		List<Useraccount> useraccounts= useraccountMapper.selectByExample(example);
		return useraccounts;
	}

}
