package com.woniuxy.mapper;

import com.woniuxy.entity.Announcement;
import com.woniuxy.entity.AnnouncementExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnnouncementMapper {
    int countByExample(AnnouncementExample example);

    int deleteByExample(AnnouncementExample example);

    int deleteByPrimaryKey(Integer aid);

    int insert(Announcement record);

    int insertSelective(Announcement record);

    List<Announcement> selectByExample(AnnouncementExample example);

    Announcement selectByPrimaryKey(Integer aid);

    int updateByExampleSelective(@Param("record") Announcement record, @Param("example") AnnouncementExample example);

    int updateByExample(@Param("record") Announcement record, @Param("example") AnnouncementExample example);

    int updateByPrimaryKeySelective(Announcement record);

    int updateByPrimaryKey(Announcement record);
    
    void insertAnnouncementGetAid(Announcement record);
    
    List<Announcement> selectSendAnnouncement(@Param("uid") Integer uid,@Param("sendPageIndex") Integer sendPageIndex,@Param("pageSize") Integer pageSize);
}