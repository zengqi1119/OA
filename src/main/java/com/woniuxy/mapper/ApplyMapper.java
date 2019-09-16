package com.woniuxy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.entity.Apply;
import com.woniuxy.entity.ApplyExample;

public interface ApplyMapper {
    int countByExample(ApplyExample example);

    int deleteByExample(ApplyExample example);

    int deleteByPrimaryKey(Integer appid);

    int insert(Apply record);

    int insertSelective(Apply record);

    List<Apply> selectByExample(ApplyExample example);

    Apply selectByPrimaryKey(Integer appid);

    int updateByExampleSelective(@Param("record") Apply record, @Param("example") ApplyExample example);

    int updateByExample(@Param("record") Apply record, @Param("example") ApplyExample example);

    int updateByPrimaryKeySelective(Apply record);

    int updateByPrimaryKey(Apply record);
    
    List<Apply> selectApply(@Param("uid") Integer uid,@Param("pageIndex") Integer pageIndex,@Param("pageSize") Integer pageSize);

    List<Apply> selectApplyAll(@Param("pageIndex") Integer pageIndex,@Param("pageSize") Integer pageSize);
}