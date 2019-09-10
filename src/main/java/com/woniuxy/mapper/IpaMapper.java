package com.woniuxy.mapper;

import com.woniuxy.entity.Ipa;
import com.woniuxy.entity.IpaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IpaMapper {
    int countByExample(IpaExample example);

    int deleteByExample(IpaExample example);

    int deleteByPrimaryKey(Integer iid);

    int insert(Ipa record);

    int insertSelective(Ipa record);

    List<Ipa> selectByExample(IpaExample example);

    Ipa selectByPrimaryKey(Integer iid);

    int updateByExampleSelective(@Param("record") Ipa record, @Param("example") IpaExample example);

    int updateByExample(@Param("record") Ipa record, @Param("example") IpaExample example);

    int updateByPrimaryKeySelective(Ipa record);

    int updateByPrimaryKey(Ipa record);
}