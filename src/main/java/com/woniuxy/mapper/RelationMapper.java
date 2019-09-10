package com.woniuxy.mapper;

import com.woniuxy.entity.Relation;
import com.woniuxy.entity.RelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RelationMapper {
    int countByExample(RelationExample example);

    int deleteByExample(RelationExample example);

    int deleteByPrimaryKey(Integer rid);

    int insert(Relation record);

    List<Relation> selectByExample(RelationExample example);

    Relation selectByPrimaryKey(Integer rid);

    int updateByExampleSelective(@Param("record") Relation record, @Param("example") RelationExample example);

    int updateByExample(@Param("record") Relation record, @Param("example") RelationExample example);

    int updateByPrimaryKeySelective(Relation record);

    int updateByPrimaryKey(Relation record);
    /* 插入联系人 */
    int insertSelective(Relation record);
    /* 删除联系人 */
	void deleteIpaByMobilephone(String mobilephone);
	/* 更新联系人 */
	void updateIpaByRelation(@Param("relation")Relation relation);
	/* 查询联系人数量 */
	int selectCountByMes(String uname, Integer seid);
	/* 根据条件查询联系人 */
	List<Relation> selectRelationByPage(String uname, int realIdex, int pageSize,Integer seid);

}