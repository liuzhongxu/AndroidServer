package com.test.demo.controller;

import com.google.gson.Gson;
import com.test.demo.po.Corporation;
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
 * Created by 丁红玉 on 2017/3/11.
 */
@Controller
@RequestMapping(value="/AppServer")
public class CorporationController {
    @Autowired
   private CorporationService corporationService;

    @Autowired
    private User_CorpService user_corpService;

    @RequestMapping(value="/CreateCorpServlet", method = RequestMethod.POST)
    @ResponseBody
    //创建社团
    public Object CreateCorpServlet(@RequestBody String json){
        Gson gson = new Gson();
        Corporation corporation = gson.fromJson(json,Corporation.class);
        String result = "CreateCorp.error";
       try {
           Corporation resultCorp = corporationService.selectCorpByName(corporation);
           if(resultCorp == null){
               corporationService.insertCorporation(corporation);
               User_Corp user_corp = new User_Corp();
               user_corp.setStateInfo("通过");
               user_corp.setCorpName(corporation.getCorpName());
               user_corp.setUserName(corporation.getCorpLeader());
               user_corpService.insert(user_corp);
               result="CreateCorp.success";
           }
       }catch (Exception e){
           //e.printStackTrace();
       }
        return result;
    }


    @RequestMapping(value="/GetAllCorpServlet", method = RequestMethod.POST)
    @ResponseBody
    //获得所有的社团
    public Object GetAllCorpServlet(@RequestBody String json){
        Gson gson = new Gson();
        String result = "GetAllCorpError";
        try {
            List<Corporation> corporationList = corporationService.getAllCorp();
            result = gson.toJson(corporationList);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return result;
    }
}
