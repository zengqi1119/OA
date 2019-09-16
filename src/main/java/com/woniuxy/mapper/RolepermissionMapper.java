package com.woniuxy.mapper;

import com.woniuxy.entity.Rolepermission;
import com.woniuxy.entity.RolepermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolepermissionMapper {
    int countByExample(RolepermissionExample example);

    int deleteByExample(RolepermissionExample example);

    int deleteByPrimaryKey(Integer rpid);

    int insert(Rolepermission record);

    int insertSelective(Rolepermission record);

    List<Rolepermission> selectByExample(RolepermissionExample example);

    Rolepermission selectByPrimaryKey(Integer rpid);

    int updateByExampleSelective(@Param("record") Rolepermission record, @Param("example") RolepermissionExample example);

    int updateByExample(@Param("record") Rolepermission record, @Param("example") RolepermissionExample example);

    int updateByPrimaryKeySelective(Rolepermission record);

    int updateByPrimaryKey(Rolepermission record);
}