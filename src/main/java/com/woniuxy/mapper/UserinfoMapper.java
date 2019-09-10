package com.woniuxy.mapper;

import com.woniuxy.entity.Userinfo;
import com.woniuxy.entity.UserinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserinfoMapper {
    int countByExample(UserinfoExample example);

    int deleteByExample(UserinfoExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    List<Userinfo> selectByExample(UserinfoExample example);

    Userinfo selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") Userinfo record, @Param("example") UserinfoExample example);

    int updateByExample(@Param("record") Userinfo record, @Param("example") UserinfoExample example);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);
    //添加员工
  	void addUserinfo(Userinfo userinfo);
  	//查询所有员工
  	List<Userinfo> findAllUserinfo();
  	//修改员工
  	int updateByuname(Userinfo userinfo);
  	//删除员工
  	int deleteById(int uid);
  	//模糊查询
 	List<Userinfo> queryAllUserinfo(String uname,String sex);
 	//查询Userinfo总条数
 	int findCount(@Param("userinfo")Userinfo userinfo);
 	//分页
 	List<Userinfo> selectUserinfoConditionByPage(@Param("pageIndex")int pageIndex,
 			@Param("pageSize")int pageSize,@Param("userinfo")Userinfo userinfo);
}