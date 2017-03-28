package com.test.demo.controller;

import com.google.gson.Gson;
import com.test.demo.po.Corporation;
import com.test.demo.po.User;
import com.test.demo.po.User_Corp;
import com.test.demo.service.CorporationService;
import com.test.demo.service.User_CorpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 杨帅 on 2017/3/15.
 */
@Controller
@RequestMapping(value="/AppServer")
public class User_CorpController {
    @Autowired
    User_CorpService user_corpService;

    @Autowired
    CorporationService corporationService;

    @RequestMapping(value="/JoinCorpServlet", method = RequestMethod.POST)
    @ResponseBody
    //普通用户提交加入社团申请
    public Object JoinCorpServlet(@RequestBody String json){
        Gson gson = new Gson();
        User_Corp user_corp = gson.fromJson(json,User_Corp.class);
        String result = "";
        try {
            User_Corp selectUser_Corp = user_corpService.selectByName(user_corp);
            if (selectUser_Corp == null) {
                user_corp.setStateInfo("处理中");
                user_corpService.insert(user_corp);
                result = "处理中";
            }else if (selectUser_Corp.getStateInfo().equals("处理中")){
                result = "处理中";
            }
            else {
                result = "已经加入,请勿重复申请";
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value="/SelectByUserNameServlet", method = RequestMethod.POST)
    @ResponseBody
    //获得当前用户申请或者参加的所有社团
    public Object SelectByUserNameServlet(@RequestBody String json){
        Gson gson = new Gson();
        User_Corp user_corp = gson.fromJson(json,User_Corp.class);
        String result = "SelectByUserNameError";
        try{
            List<User_Corp> user_corpList = user_corpService.selectByUserName(user_corp);
            if(user_corpList.size() > 0)
                result = gson.toJson(user_corpList);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value="/DeleteByNameServlet", method = RequestMethod.POST)
    @ResponseBody
    //用户退出社团或者撤销申请
    public Object DeleteByNameServlet(@RequestBody String json){
        Gson gson = new Gson();
        String returnString = "DeleteByNameError";
        User_Corp user_corp = gson.fromJson(json,User_Corp.class);
        try {
            int result = user_corpService.deleteByName(user_corp);
            if(result > 0)
                returnString = "DeleteByNameSuccess";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  returnString;
    }

    @RequestMapping(value="/SelectInHandleServlet", method = RequestMethod.POST)
    @ResponseBody
    //干事查看用户提交的加入社团的申请信息
    public Object SelectInHandleServlet(@RequestBody String json){
        Gson gson = new Gson();
        User user = gson.fromJson(json,User.class);
        String leaderName = user.getUserName();
        String result = "SelectInHandleError";
        try {
            Corporation corporation = corporationService.selectCorpByLeaderName(leaderName);
            String corpName = corporation.getCorpName();
            List<User_Corp> user_corpList= user_corpService.selectInHandle(corpName);
            if (user_corpList.size() > 0)
                result = gson.toJson(user_corpList);

        } catch (Exception e) {
            //e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value="/AgreeServlet", method = RequestMethod.POST)
    @ResponseBody
    //干事同意用户的提交的加入社团的申请
    public Object AgreeServlet(@RequestBody String json){
        Gson gson = new Gson();
        String returnString = "AgreeError";
        User_Corp user_corp = gson.fromJson(json,User_Corp.class);
        try {
            int result = user_corpService.updateByPrimaryKey(user_corp);
            if(result > 0)
                returnString = "AgreeSuccess";
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return returnString;
    }

    @RequestMapping(value="/RefuseServlet", method = RequestMethod.POST)
    @ResponseBody
    //干事拒绝用户提交的加入社团的申请
    public Object RefuseServlet(@RequestBody String json){
        Gson gson = new Gson();
        String returnString = "RefuseError";
        User_Corp user_corp = gson.fromJson(json,User_Corp.class);
        try {
            int id = user_corp.getId();
            int result = user_corpService.deleteByPrimaryKey(id);
            if(result > 0)
                returnString = "RefuseSuccess";
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return returnString;
    }

    @RequestMapping(value="/ShowMemberServlet", method = RequestMethod.POST)
    @ResponseBody
    //干事查看当前所有加入社团的成员
    public Object ShowMemberServlet(@RequestBody String json){
        Gson gson = new Gson();
        User user = gson.fromJson(json,User.class);
        String leaderName = user.getUserName();
        String result = "ShowMemberError";
        try {
            Corporation corporation = corporationService.selectCorpByLeaderName(leaderName);
            String corpName = corporation.getCorpName();
            List<User_Corp> user_corpList= user_corpService.selectMember(corpName);
            if (user_corpList.size() > 0)
                result = gson.toJson(user_corpList);

        } catch (Exception e) {
           // e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value="/DeleteMemberServlet", method = RequestMethod.POST)
    @ResponseBody
    //干事删除社团中的成员
    public Object DeleteMemberServlet(@RequestBody String json){
        Gson gson = new Gson();
        String returnString = "DeleteMemberError";
        User_Corp user_corp = gson.fromJson(json,User_Corp.class);
        try {
            int id = user_corp.getId();
            int result = user_corpService.deleteByPrimaryKey(id);
            if(result > 0)
                returnString = "DeleteMemberSuccess";
        } catch (Exception e) {
           // e.printStackTrace();
        }
        return returnString;
    }


}
