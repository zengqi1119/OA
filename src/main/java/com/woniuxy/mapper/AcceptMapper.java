package com.woniuxy.mapper;

import com.woniuxy.entity.Accept;
import com.woniuxy.entity.AcceptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcceptMapper {
    int countByExample(AcceptExample example);

    int deleteByExample(AcceptExample example);

    int deleteByPrimaryKey(Integer acid);

    int insert(Accept record);

    int insertSelective(Accept record);

    List<Accept> selectByExample(AcceptExample example);

    Accept selectByPrimaryKey(Integer acid);

    int updateByExampleSelective(@Param("record") Accept record, @Param("example") AcceptExample example);

    int updateByExample(@Param("record") Accept record, @Param("example") AcceptExample example);

    int updateByPrimaryKeySelective(Accept record);

    int updateByPrimaryKey(Accept record);
    
    List<Accept> selectReceiveAid(@Param("uid") Integer uid,@Param("receivePageIndex") Integer receivePageIndex,@Param("pageSize") Integer pageSize);
}