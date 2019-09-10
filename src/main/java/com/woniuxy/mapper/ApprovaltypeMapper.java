package com.woniuxy.mapper;

import com.woniuxy.entity.Approvaltype;
import com.woniuxy.entity.ApprovaltypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApprovaltypeMapper {
    int countByExample(ApprovaltypeExample example);

    int deleteByExample(ApprovaltypeExample example);

    int deleteByPrimaryKey(Integer aptid);

    int insert(Approvaltype record);

    int insertSelective(Approvaltype record);

    List<Approvaltype> selectByExample(ApprovaltypeExample example);

    Approvaltype selectByPrimaryKey(Integer aptid);

    int updateByExampleSelective(@Param("record") Approvaltype record, @Param("example") ApprovaltypeExample example);

    int updateByExample(@Param("record") Approvaltype record, @Param("example") ApprovaltypeExample example);

    int updateByPrimaryKeySelective(Approvaltype record);

    int updateByPrimaryKey(Approvaltype record);
}