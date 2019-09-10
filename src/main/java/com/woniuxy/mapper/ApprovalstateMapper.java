package com.woniuxy.mapper;

import com.woniuxy.entity.Approvalstate;
import com.woniuxy.entity.ApprovalstateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApprovalstateMapper {
    int countByExample(ApprovalstateExample example);

    int deleteByExample(ApprovalstateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Approvalstate record);

    int insertSelective(Approvalstate record);

    List<Approvalstate> selectByExample(ApprovalstateExample example);

    Approvalstate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Approvalstate record, @Param("example") ApprovalstateExample example);

    int updateByExample(@Param("record") Approvalstate record, @Param("example") ApprovalstateExample example);

    int updateByPrimaryKeySelective(Approvalstate record);

    int updateByPrimaryKey(Approvalstate record);
}