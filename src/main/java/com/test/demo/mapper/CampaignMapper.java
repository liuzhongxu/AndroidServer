package com.test.demo.mapper;

import com.test.demo.po.Campaign;

import java.util.List;

public interface CampaignMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Campaign record);

    int insertSelective(Campaign record);

    Campaign selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Campaign record);

    int updateByPrimaryKey(Campaign record);

    //获得所有公益活动
    List<Campaign> getGongYiActivity();
    //获得所有社团活动
    List <Campaign> getCorpActivity(String corpName);

    //查找指定名字的公益活动
    List<Campaign> selectGongYiByName(String activityName);

    List<Campaign> selectCorpActivityByName(String activityName);

    List<Campaign> selectGongYiByLeader(String activityLeader);

    List<Campaign> selectCorpActivityByLeader(String activityLeader);

}