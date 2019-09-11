package com.woniuxy.mapper;

import com.woniuxy.entity.Leaves;
import com.woniuxy.entity.LeavesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface LeavesMapper {
	int countByExample(LeavesExample example);

	int deleteByExample(LeavesExample example);

	int deleteByPrimaryKey(Integer lid);

	int insert(Leaves record);

	int insertSelective(Leaves record);

	List<Leaves> selectByExample(LeavesExample example);

	Leaves selectByPrimaryKey(Integer lid);

	int updateByExampleSelective(@Param("record") Leaves record, @Param("example") LeavesExample example);

	int updateByExample(@Param("record") Leaves record, @Param("example") LeavesExample example);

	int updateByPrimaryKeySelective(Leaves record);

	int updateByPrimaryKey(Leaves record);

	/**
	 * 分页通过uid查询
	 * @param uid
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	//@Select("select * from leaves where uid in #{ids} and flag = 0 limit #{pageIndex},#{pageSize}")
    @Select({
        "<script>",
            "select * from leaves",
            "where uid in",
                "<foreach collection='ids' item='id' open='(' separator=',' close=')'>",
                "#{id}",
                "</foreach>",
                "and flag = 0 limit #{pageIndex},#{pageSize}",
        "</script>"
})
	List<Leaves> selectofPage(@Param("ids") List<Integer> ids, @Param("pageIndex") int pageIndex,
			@Param("pageSize") int pageSize);

}