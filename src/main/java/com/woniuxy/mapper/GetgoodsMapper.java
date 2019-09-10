package com.woniuxy.mapper;

import com.woniuxy.entity.Buygoods;
import com.woniuxy.entity.Getgoods;
import com.woniuxy.entity.GetgoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GetgoodsMapper {
    int countByExample(GetgoodsExample example);

    int deleteByExample(GetgoodsExample example);

    int deleteByPrimaryKey(Integer gid);

    int insert(Getgoods record);

    int insertSelective(Getgoods record);

    List<Getgoods> selectByExample(GetgoodsExample example);

    Getgoods selectByPrimaryKey(Integer gid);

    int updateByExampleSelective(@Param("record") Getgoods record, @Param("example") GetgoodsExample example);

    int updateByExample(@Param("record") Getgoods record, @Param("example") GetgoodsExample example);

    int updateByPrimaryKeySelective(Getgoods record);

    int updateByPrimaryKey(Getgoods record);
    
    //查询所有条数
  	List<Integer> getOfficeApplyTotal(@Param("uid")List<Integer> uid);
  	//查询当前页所有内容
  	List<Getgoods> getAllOfficeApply(@Param("count")int count, @Param("pageIndex")int pageIndex, @Param("uid")List<Integer> uid);
}