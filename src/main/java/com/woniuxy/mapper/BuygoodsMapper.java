package com.woniuxy.mapper;

import com.woniuxy.entity.Buygoods;
import com.woniuxy.entity.BuygoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BuygoodsMapper {
    int countByExample(BuygoodsExample example);

    int deleteByExample(BuygoodsExample example);

    int deleteByPrimaryKey(Integer bid);

    int insert(Buygoods record);

    int insertSelective(Buygoods record);

    List<Buygoods> selectByExample(BuygoodsExample example);

    Buygoods selectByPrimaryKey(Integer bid);

    int updateByExampleSelective(@Param("record") Buygoods record, @Param("example") BuygoodsExample example);

    int updateByExample(@Param("record") Buygoods record, @Param("example") BuygoodsExample example);

    int updateByPrimaryKeySelective(Buygoods record);

    int updateByPrimaryKey(Buygoods record);
    //查询所有条数
   	List<Integer> getOfficeSubscribeTotal(@Param("uid")List<Integer> uid);
   	//查询当前页所有内容
   	List<Buygoods> getAllOfficeSubscribe(@Param("count")int count, @Param("pageIndex")int pageIndex, @Param("uid")List<Integer> uid);

}