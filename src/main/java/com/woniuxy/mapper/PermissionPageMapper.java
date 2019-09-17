package com.woniuxy.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.woniuxy.bean.Rolepermissiontable;

public interface PermissionPageMapper {

	public int selectAll(@Param("uids")List<Integer> uids) ;

	public List<Rolepermissiontable> selectPermission(@Param("uids")List<Integer> uids) ;

}
