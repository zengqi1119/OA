package com.woniuxy.service.imp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.bean.OvertimePageBean;
import com.woniuxy.entity.Signin;
import com.woniuxy.entity.SigninExample;
import com.woniuxy.entity.SigninExample.Criteria;
import com.woniuxy.mapper.SigninMapper;
import com.woniuxy.service.SigninService;
/**签到表service实现类
 * @刘立英
 */
@Service
public class SigninServiceImp implements SigninService{
	@Autowired
	SigninMapper signinMapper;
	
	SigninExample signinExample=new SigninExample();
	Criteria criteria=signinExample.createCriteria();
	
	

	
	 @Override public List<Signin> showSigninByUid(Integer uid) { 
	 List<Signin> signins = signinMapper.selectSigninByUid1(uid);
	 return signins; 
	}
	

	@Override
	public int signinByUid(Signin signin) {
		int row= signinMapper.insertSignin(signin);
		return row;
	}

	@Override
	public int signOutByOid(Integer sid, Date date) {
		//System.out.println(date);
		int row= signinMapper.updateSignOut(sid,date);
		return row;
	}

	@Override
	public OvertimePageBean<Signin> selectPageBean(int pageIndex, int pageSize, Signin signin) {
		int uid=signin.getUid();
		//根据用户id查符合条件的总记录数目
		criteria.andUidEqualTo(uid);
		int totalRecored=signinMapper.countByExample(signinExample);
		//根据用户id查符合条件的记录	
		int sqlPageIndex=(pageIndex-1)*pageSize;
		List<Signin> beanList= signinMapper.selectSigninByUid(uid,sqlPageIndex,pageSize);
	    //System.out.println(beanList);
		OvertimePageBean<Signin> pageBean=new OvertimePageBean<Signin>();
		pageBean.setBeanList(beanList);
		pageBean.setTotalRecored(totalRecored);
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		pageBean.setPageBeginAndPageEnd();
		return pageBean;
		
		
	}

	

	

	
}
