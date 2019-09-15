package com.woniuxy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.woniuxy.entity.Schedule;
import com.woniuxy.entity.ScheduleExample;
@Mapper
public interface ScheduleMapper {
    int countByExample(ScheduleExample example);

    int deleteByExample(ScheduleExample example);

    int deleteByPrimaryKey(Integer sid);

    int insert(Schedule record);

    int insertSelective(Schedule record);

    List<Schedule> selectByExample(ScheduleExample example);

    Schedule selectByPrimaryKey(Integer sid);

    int updateByExampleSelective(@Param("record") Schedule record, @Param("example") ScheduleExample example);

    int updateByExample(@Param("record") Schedule record, @Param("example") ScheduleExample example);

    int updateByPrimaryKeySelective(Schedule record);

    int updateByPrimaryKey(Schedule record);

	int insertSchedule(Schedule schedule);

	//分页显示内容
	List<Schedule> selectScheduleByUname(@Param ("uname") String uname,@Param("pageIndex") Integer pageIndex,@Param("pageSize") Integer pageSize);
	//条件查询记录总条数
	Integer selectTotalRecord(String uname);

	List<Schedule> selectScheduleByUid(@Param ("uid")Integer uid, @Param("pageIndex") Integer pageIndex,@Param("pageSize") Integer pageSize);

	Integer selectTotalRecordByUid(Integer uid);

}