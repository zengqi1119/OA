package com.woniuxy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.bean.ApprovalEntity;

public interface ApprovalMapper {

	List<ApprovalEntity> selectAll(@Param("pageIndex")int pageIndex, 
			@Param("pageSize")int pageSize,@Param("uid")int uid);

	Integer countAll(@Param("uid")int uid);
   
}