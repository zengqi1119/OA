package com.woniuxy.service.imp;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.bean.PermissionPage;
import com.woniuxy.entity.Rolepermissiontable;
import com.woniuxy.entity.RolepermissiontableExample;
import com.woniuxy.entity.Userinfo;
import com.woniuxy.entity.UserinfoExample;
import com.woniuxy.entity.Userrole;
import com.woniuxy.entity.UserroleExample;
import com.woniuxy.mapper.RolepermissiontableMapper;
import com.woniuxy.mapper.UserinfoMapper;
import com.woniuxy.mapper.UserroleMapper;
import com.woniuxy.service.PermissionService;
@Service
public class PermissionServiceImp implements PermissionService {
	@Autowired
	RolepermissiontableMapper rolepermissiontableMapper;
	@Autowired
	UserinfoMapper userinfoMapper;
@Autowired
UserroleMapper userroleMapper;
	@Override
	public PermissionPage selectByCondition(Integer pageIndex, int pageSize, String name,HttpSession session) {
		//如果name ==null 查询所有
		if ("null".equals(name)) {
			name = "";
		}
		UserinfoExample example = new UserinfoExample();
		example.createCriteria().andUnameLike("%" + name.trim() + "%");
		List<Userinfo> users = userinfoMapper.selectByExample(example);
		List<Integer> uids = new ArrayList<Integer>();
		if (users != null && users.size() > 0) {
			for (Userinfo userinfo : users) {
				uids.add(userinfo.getUid());
			}
		}else {
			uids.add((int)session.getAttribute("uid"));
		}
		int pageCount =uids.size();
		List<Rolepermissiontable> rolepermissions = getPermissions(uids,pageIndex,pageSize);
		if(name.equals("")) {
			name = "null";
		}
		PermissionPage pages = new PermissionPage(rolepermissions,pageIndex,pageSize,pageCount,"/permission/query/"+name+"/");
		pages.setStartandEnd();
		return pages;
	}

	private  List<Rolepermissiontable> getPermissions(List<Integer> uids, Integer pageIndex, int pageSize) {
		RolepermissiontableExample example = new RolepermissiontableExample();
		example.setPageIndex(pageSize*(pageIndex-1));
		example.setPageSize(pageSize);
		example.createCriteria().andUidIn(uids);
		return rolepermissiontableMapper.selectByExample(example);
	}

	@Override
	public int updateUserrole(int uid, int rid) {
		UserroleExample example=new UserroleExample();
		example.createCriteria().andUidEqualTo(uid);
		Userrole userrole=new Userrole();
		userrole.setUid(uid);
		userrole.setRid(rid);
		return userroleMapper.updateByExampleSelective(userrole, example);
	}
}
