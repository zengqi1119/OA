package com.woniuxy.service;

import java.util.List;

import com.woniuxy.entity.Useraccount;

public interface UseraccountService {

	List<Useraccount>  selectUseraccount(String username);
	
	
}
