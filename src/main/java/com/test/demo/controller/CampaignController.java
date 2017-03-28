package com.test.demo.controller;


import com.google.gson.Gson;
import com.test.demo.po.Campaign;
import com.test.demo.po.Corporation;
import com.test.demo.po.User;
import com.test.demo.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value="/AppServer")
/**
 * Created by 杨帅 on 2017/3/13.
 */
public class CampaignController {
    @Autowired
    CampaignService campaignService;

    @RequestMapping(value="/CreateCorpActivityServlet", method = RequestMethod.POST)
    @ResponseBody
    //创建社团活动
    public Object CreateCorpActivityServlet(@RequestBody String json){
        Gson gson = new Gson();
        Campaign campaign = gson.fromJson(json,Campaign.class);
        String returnString = "CreateCorpActivityError";
        try {
            int result = campaignService.insertCampaign(campaign);
            if(result > 0)
                returnString = "CreateCorpActivitySuccess";
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return returnString;
    }

    @RequestMapping(value="/CreateGongYiActivityServlet", method = RequestMethod.POST)
    @ResponseBody
    //创建公益活动
    public Object CreateGongYiActivityServlet(@RequestBody String json){
        Gson gson = new Gson();
        Campaign campaign = gson.fromJson(json,Campaign.class);
        String returnString = "CreateGongYiActivityError";
        try {
            int result = campaignService.insertCampaign(campaign);
            if(result > 0)
                returnString = "CreateGongYiActivitySuccess";
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return returnString;
    }

    @RequestMapping(value="/GetGongYiActivityServlet", method = RequestMethod.POST)
    @ResponseBody
    //获得所有的公益活动
    public Object GetGongYiActivityServlet(@RequestBody String json){
        Gson gson = new Gson();
        String returnString = "GetGongYiActivityError";
        try {
            List<Campaign> campaignList = campaignService.getGongYiActivity();
            returnString = gson.toJson(campaignList);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return returnString;
    }


    @RequestMapping(value="/GetCorpActivityServlet", method = RequestMethod.POST)
    @ResponseBody
    //根据社团名获得该社团的所有活动
    public Object GetCorpActivityServlet(@RequestBody String json){
        Gson gson = new Gson();
        Corporation corporation = gson.fromJson(json,Corporation.class);
        String corpName = corporation.getCorpName();
        String result = "GetCorpActivityError";
        try {
            List<Campaign> campaignList = campaignService.getCorpActivity(corpName);
            result = gson.toJson(campaignList);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return  result;
    }

    @RequestMapping(value="/SelectGongYiByNameServlet", method = RequestMethod.POST)
    @ResponseBody
    //通过活动名字查找公益活动
    public Object SelectGongYiByNameServlet(@RequestBody String json){
        Gson gson = new Gson();
        Campaign campaign = gson.fromJson(json,Campaign.class);
        String activityName = campaign.getActivityName();
        String result = "SelectGongYiError";
        try {
            List<Campaign> campaignList = campaignService.selectGongYiByName(activityName);
            if(campaignList.size() > 0)
                result = gson.toJson(campaignList);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value="/SelectCorpActivityByNameServlet", method = RequestMethod.POST)
    @ResponseBody
    //通过活动名字查找社团活动
    public Object SelectCorpActivityByNameServlet(@RequestBody String json){
        String result = "SelectCorpActivityError";
        Gson gson = new Gson();
        Campaign campaign = gson.fromJson(json,Campaign.class);
        String activityName = campaign.getActivityName();
        try {
            List<Campaign> campaignList = campaignService.selectCorpActivityByName(activityName);
            if(campaignList.size() > 0)
                result = gson.toJson(campaignList);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value="/DeleteGongYiActivityServlet", method = RequestMethod.POST)
    @ResponseBody
    //删除公益活动
    public Object DeleteGongYiActivityServlet(@RequestBody String json){
        Gson gson = new Gson();
        Campaign campaign = gson.fromJson(json,Campaign.class);
        int id = campaign.getId();
        String returnString = "DeleteGongYiError";
        try{
            int result = campaignService.deleteByPrimaryKey(id);
            if(result > 0)
                returnString = "DeleteGongYiSuccess";
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return returnString;
    }

    @RequestMapping(value="/DeleteCorpActivityServlet", method = RequestMethod.POST)
    @ResponseBody
    //删除社团活动
    public Object DeleteCorpActivityServlet(@RequestBody String json){
        Gson gson = new Gson();
        Campaign campaign = gson.fromJson(json,Campaign.class);
        int id = campaign.getId();
        String returnString = "DeleteCorpActivityError";
        try{
            int result = campaignService.deleteByPrimaryKey(id);
            if(result > 0)
                returnString = "DeleteCorpActivitySuccess";
        } catch (Exception e) {
           // e.printStackTrace();
        }
        return returnString;
    }

    @RequestMapping(value="/SelectGongYiByLeaderServlet", method = RequestMethod.POST)
    @ResponseBody
    //通过发起人查找公益活动
    public Object SelectGongYiByLeaderServlet(@RequestBody String json){
        Gson gson = new Gson();
        User user = gson.fromJson(json,User.class);
        String leaderName = user.getUserName();
        String result = "SelectGongYiByLeaderError";
        try{
            List<Campaign> campaignList = campaignService.selectGongYiByLeader(leaderName);
            if (campaignList.size() > 0)
                result = gson.toJson(campaignList);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return result;
    }
    @RequestMapping(value="/SelectCorpActivityByLeaderServlet", method = RequestMethod.POST)
    @ResponseBody
    //通过社团干事查找社团活动
    public Object SelectCorpActivityByLeaderServlet(@RequestBody String json){
        Gson gson = new Gson();
        User user =gson.fromJson(json,User.class);
        String leaderName = user.getUserName();
        String result = "SelectCorpActivityByLeaderError";
        try {
            List<Campaign> campaignList = campaignService.selectCorpActivityByLeader(leaderName);
            if(campaignList.size() > 0)
                result = gson.toJson(campaignList);
        } catch (Exception e) {
           // e.printStackTrace();
        }
        return result;
    }

}
