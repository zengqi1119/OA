package com.woniuxy.service.imp;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
	

	@Override
	public int signinByUid(Signin signin) {
		int row= signinMapper.insertSignin(signin);
		return row;
	}

	@Override
	public int signOutBySid(Integer sid, Date date) {
		//System.out.println(date);
		int row= signinMapper.updateSignOut(sid,date);
		return row;
	}

	@Override
	public OvertimePageBean<Signin> selectPageBean(int pageIndex, int pageSize, Integer uid) {
		
		//根据用户id查符合条件的总记录数目
		if(uid!=0)
			criteria.andUidEqualTo(uid);
		int totalRecored=signinMapper.countByExample(signinExample);
		//根据用户id查符合条件的记录	
		int sqlPageIndex=(pageIndex-1)*pageSize;
		List<Signin> beanList= signinMapper.selectPageBean(uid,sqlPageIndex,pageSize);
	    //System.out.println(beanList);
		OvertimePageBean<Signin> pageBean=new OvertimePageBean<Signin>();
		pageBean.setBeanList(beanList);
		pageBean.setTotalRecored(totalRecored);
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		pageBean.setPageBeginAndPageEnd();
		return pageBean;
		
		
	}


	@Override
	public Signin selectSigninByUid(Integer uid) {
		 Signin signin = signinMapper.selectSigninByUid(uid);
		 return signin; 
	}

	@Override
	public OvertimePageBean<Signin> findAttend(Integer uid, Integer pageIndex, 
			int pageSize, Date signInStr, Date signOutStr) {
		//根据用户id查符合条件的总记录数目
		if(uid!=0)
			criteria.andUidEqualTo(uid);
		
		//将signOutStr日期往后推一天
		Calendar   calendar = new GregorianCalendar(); 
		calendar.setTime(signOutStr); 
		calendar.add(calendar.DATE,1); //把日期往后增加一天,整数  往后推,负数往前移动 
		Date ssignOutStr=calendar.getTime(); //这个时间就是日期往后推一天的结果
		criteria.andSignintimeBetween(signInStr, ssignOutStr);
		int totalRecored=signinMapper.countByExample(signinExample);
		System.out.println("totalRecored:"+totalRecored);
		//根据用户id查符合条件的记录	
		int sqlPageIndex=(pageIndex-1)*pageSize;
		List<Signin> beanList= signinMapper.findAttend(uid,sqlPageIndex,pageSize,signInStr,signOutStr);
		System.out.println(beanList);
		System.out.println("beanList.size:"+beanList.size());
		OvertimePageBean<Signin> pageBean=new OvertimePageBean<Signin>();
		pageBean.setBeanList(beanList);
		pageBean.setTotalRecored(totalRecored);
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		pageBean.setPageBeginAndPageEnd();
		return pageBean;
	}

	

	

	

	
}
