package com.woniuxy.mapper;

import com.woniuxy.entity.Leavetype;
import com.woniuxy.entity.LeavetypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LeavetypeMapper {
    int countByExample(LeavetypeExample example);

    int deleteByExample(LeavetypeExample example);

    int deleteByPrimaryKey(Integer ltid);

    int insert(Leavetype record);

    int insertSelective(Leavetype record);

    List<Leavetype> selectByExample(LeavetypeExample example);

    Leavetype selectByPrimaryKey(Integer ltid);

    int updateByExampleSelective(@Param("record") Leavetype record, @Param("example") LeavetypeExample example);

    int updateByExample(@Param("record") Leavetype record, @Param("example") LeavetypeExample example);

    int updateByPrimaryKeySelective(Leavetype record);

    int updateByPrimaryKey(Leavetype record);
}