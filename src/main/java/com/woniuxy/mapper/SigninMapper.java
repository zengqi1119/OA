package com.woniuxy.mapper;

import com.woniuxy.entity.Signin;
import com.woniuxy.entity.SigninExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SigninMapper {
    int countByExample(SigninExample example);

    int deleteByExample(SigninExample example);

    int deleteByPrimaryKey(Integer sid);

    int insert(Signin record);

    int insertSelective(Signin record);

    List<Signin> selectByExample(SigninExample example);

    Signin selectByPrimaryKey(Integer sid);

    int updateByExampleSelective(@Param("record") Signin record, @Param("example") SigninExample example);

    int updateByExample(@Param("record") Signin record, @Param("example") SigninExample example);

    int updateByPrimaryKeySelective(Signin record);

    int updateByPrimaryKey(Signin record);
    
    //自己添加
    
   List<Signin> selectSigninByUid1(Integer uid);
    
    //根据用户id查签到信息
    List<Signin> selectSigninByUid(@Param("uid")Integer uid,@Param("pageIndex")int pageIndex
    		, @Param("pageSize")int pageSize);
    //插入签到信息
	int insertSignin(Signin signin);
	//插入签退信息
	int updateSignOut(@Param("sid")Integer sid, @Param("date")Date date);
    
}