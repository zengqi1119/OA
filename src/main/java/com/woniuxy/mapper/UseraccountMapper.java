package com.woniuxy.mapper;

import com.woniuxy.bean.IpaRolesAndPermissions;
import com.woniuxy.bean.Rolepermissiontable;
import com.woniuxy.entity.Useraccount;
import com.woniuxy.entity.UseraccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UseraccountMapper {
    int countByExample(UseraccountExample example);

    int deleteByExample(UseraccountExample example);

    int deleteByPrimaryKey(Integer uaid);

    int insert(Useraccount record);

    int insertSelective(Useraccount record);

    List<Useraccount> selectByExample(UseraccountExample example);

    Useraccount selectByPrimaryKey(Integer uaid);

    int updateByExampleSelective(@Param("record") Useraccount record, @Param("example") UseraccountExample example);

    int updateByExample(@Param("record") Useraccount record, @Param("example") UseraccountExample example);

    int updateByPrimaryKeySelective(Useraccount record);

    int updateByPrimaryKey(Useraccount record);
    //<!-- 添加用户 -->
    void addUserAccount(String account,int uid);
    //修改密码
    int updatePassword(String account,String newpwd);
    //查询ipa权限角色
	IpaRolesAndPermissions selectRolesAndPermissionByUid(Integer uid);
	//查询角色权限
	List<Rolepermissiontable> selectRolesPermissionByAccount(@Param("account")String account);
}