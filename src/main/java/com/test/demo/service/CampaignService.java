package com.test.demo.service;

import com.test.demo.po.Campaign;

import java.util.List;

/**
 * Created by 杨帅 on 2017/3/13.
 */
public interface CampaignService {
    public int insertCampaign(Campaign campaign)  throws Exception;

    public List<Campaign> getGongYiActivity() throws Exception;

    public List<Campaign> getCorpActivity(String corpName) throws Exception;

    public List<Campaign> selectGongYiByName(String activityName) throws Exception;

    public List<Campaign> selectCorpActivityByName(String activityName) throws Exception;

    public int deleteByPrimaryKey(int id) throws Exception;

    public List<Campaign> selectGongYiByLeader(String activityLeader) throws Exception;

    public List<Campaign> selectCorpActivityByLeader(String activityLeader) throws Exception;
}
