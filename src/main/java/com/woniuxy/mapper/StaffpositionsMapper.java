package com.woniuxy.mapper;

import com.woniuxy.entity.Staffpositions;
import com.woniuxy.entity.StaffpositionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StaffpositionsMapper {
    int countByExample(StaffpositionsExample example);

    int deleteByExample(StaffpositionsExample example);

    int deleteByPrimaryKey(Integer spid);

    int insert(Staffpositions record);

    int insertSelective(Staffpositions record);

    List<Staffpositions> selectByExample(StaffpositionsExample example);

    Staffpositions selectByPrimaryKey(Integer spid);

    int updateByExampleSelective(@Param("record") Staffpositions record, @Param("example") StaffpositionsExample example);

    int updateByExample(@Param("record") Staffpositions record, @Param("example") StaffpositionsExample example);

    int updateByPrimaryKeySelective(Staffpositions record);

    int updateByPrimaryKey(Staffpositions record);
}