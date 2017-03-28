package com.test.demo.service.impl;

import com.test.demo.mapper.CampaignMapper;
import com.test.demo.po.Campaign;
import com.test.demo.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 杨帅 on 2017/3/13.
 */
@Service
public class CampaignServiceImpl implements CampaignService {
    @Autowired
    CampaignMapper campaignMapper;

    public int insertCampaign(Campaign campaign) throws Exception{
        return campaignMapper.insert(campaign);
    }

    @Override
    public List<Campaign> getGongYiActivity() throws Exception {
        return campaignMapper.getGongYiActivity();
    }

    @Override
    public List<Campaign> getCorpActivity(String corpName) throws Exception {
        return campaignMapper.getCorpActivity(corpName);
    }

    @Override
    public  List<Campaign> selectGongYiByName(String activityName) throws Exception{
        return campaignMapper.selectGongYiByName(activityName);
    }

    @Override
    public List<Campaign> selectCorpActivityByName(String activityName) throws Exception {
        return campaignMapper.selectCorpActivityByName(activityName);
    }

    @Override
    public int deleteByPrimaryKey(int id) throws Exception {
        return campaignMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Campaign> selectGongYiByLeader(String activityLeader) throws Exception {
        return campaignMapper.selectGongYiByLeader(activityLeader);
    }

    @Override
    public List<Campaign> selectCorpActivityByLeader(String activityLeader) throws Exception {
        return campaignMapper.selectCorpActivityByLeader(activityLeader);
    }
}
