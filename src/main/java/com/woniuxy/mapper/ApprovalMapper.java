package com.woniuxy.mapper;

import com.woniuxy.entity.Approval;
import com.woniuxy.entity.ApprovalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApprovalMapper {
    int countByExample(ApprovalExample example);

    int deleteByExample(ApprovalExample example);

    int deleteByPrimaryKey(Integer apprid);

    int insert(Approval record);

    int insertSelective(Approval record);

    List<Approval> selectByExample(ApprovalExample example);

    Approval selectByPrimaryKey(Integer apprid);

    int updateByExampleSelective(@Param("record") Approval record, @Param("example") ApprovalExample example);

    int updateByExample(@Param("record") Approval record, @Param("example") ApprovalExample example);

    int updateByPrimaryKeySelective(Approval record);

    int updateByPrimaryKey(Approval record);
}