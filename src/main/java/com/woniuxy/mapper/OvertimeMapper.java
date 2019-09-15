package com.woniuxy.mapper;

import com.woniuxy.entity.Overtime;
import com.woniuxy.entity.OvertimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OvertimeMapper {
    int countByExample(OvertimeExample example);

    int deleteByExample(OvertimeExample example);

    int deleteByPrimaryKey(Integer oid);

    int insert(Overtime record);

    int insertSelective(Overtime record);

    List<Overtime> selectByExample(OvertimeExample example);

    Overtime selectByPrimaryKey(Integer oid);

    int updateByExampleSelective(@Param("record") Overtime record, @Param("example") OvertimeExample example);

    int updateByExample(@Param("record") Overtime record, @Param("example") OvertimeExample example);

    int updateByPrimaryKeySelective(Overtime record);

    int updateByPrimaryKey(Overtime record);
    
    //自己添加
    List<Overtime> showOvertimeByUid(Integer uid);

    List<Overtime> selectOvertimeByName(String uname);
    
    int updateByOid(Overtime record);
    
    int insertOvertime(Overtime record);

	int updateFlagByOid(Integer oid);

	List<Overtime> selectPageBeanByUid(@Param("uid")Integer uid,@Param("pageIndex")int pageIndex
    		, @Param("pageSize")int pageSize);

	int countByName(String realName);

	List<Overtime> selectPageBeanByName(@Param("uname")String realName,@Param("pageIndex")int pageIndex
    		, @Param("pageSize")int pageSize);
	
	
	
	
	
	
	
	
	
	
}