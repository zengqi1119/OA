package com.woniuxy.mapper;

import com.woniuxy.entity.Stateemployees;
import com.woniuxy.entity.StateemployeesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StateemployeesMapper {
    int countByExample(StateemployeesExample example);

    int deleteByExample(StateemployeesExample example);

    int deleteByPrimaryKey(Integer seid);

    int insert(Stateemployees record);

    int insertSelective(Stateemployees record);

    List<Stateemployees> selectByExample(StateemployeesExample example);

    Stateemployees selectByPrimaryKey(Integer seid);

    int updateByExampleSelective(@Param("record") Stateemployees record, @Param("example") StateemployeesExample example);

    int updateByExample(@Param("record") Stateemployees record, @Param("example") StateemployeesExample example);

    int updateByPrimaryKeySelective(Stateemployees record);

    int updateByPrimaryKey(Stateemployees record);
}