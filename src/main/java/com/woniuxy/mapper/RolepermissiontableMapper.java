package com.woniuxy.mapper;

import com.woniuxy.entity.Rolepermissiontable;
import com.woniuxy.entity.RolepermissiontableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolepermissiontableMapper {
    int countByExample(RolepermissiontableExample example);

    int deleteByExample(RolepermissiontableExample example);

    int insert(Rolepermissiontable record);

    int insertSelective(Rolepermissiontable record);

    List<Rolepermissiontable> selectByExample(RolepermissiontableExample example);

    int updateByExampleSelective(@Param("record") Rolepermissiontable record, @Param("example") RolepermissiontableExample example);

    int updateByExample(@Param("record") Rolepermissiontable record, @Param("example") RolepermissiontableExample example);
}