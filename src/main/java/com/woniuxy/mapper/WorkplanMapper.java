package com.woniuxy.mapper;

import com.woniuxy.entity.Workplan;
import com.woniuxy.entity.WorkplanExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WorkplanMapper {
    int countByExample(WorkplanExample example);

    int deleteByExample(WorkplanExample example);

    int deleteByPrimaryKey(Integer wid);

    int insert(Workplan record);

    int insertSelective(Workplan record);

    List<Workplan> selectByExample(WorkplanExample example);

    Workplan selectByPrimaryKey(Integer wid);

    int updateByExampleSelective(@Param("record") Workplan record, @Param("example") WorkplanExample example);

    int updateByExample(@Param("record") Workplan record, @Param("example") WorkplanExample example);

    int updateByPrimaryKeySelective(Workplan record);

    int updateByPrimaryKey(Workplan record);
    
    int insertWorkPlan(Workplan record);
    
    //分页显示内容

	List<Workplan> selectWorkPlanByUname(@Param ("uname") String uname,@Param("pageIndex") Integer pageIndex,@Param("pageSize") Integer pageSize);

	//条件查询记录总条数
	Integer selectTotalRecord(String uname);
	
	//自己的数据
	List<Workplan> selectWorkPlanByUid(@Param ("uid")Integer uid, @Param("pageIndex") Integer pageIndex,@Param("pageSize") Integer pageSize);
	
	//自己的记录总条数
	Integer selectTotalRecordByUid(Integer uid);

	
	
	
	
	
}