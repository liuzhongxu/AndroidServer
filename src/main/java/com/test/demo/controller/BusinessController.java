package com.test.demo.controller;

import com.google.gson.Gson;
import com.test.demo.po.Business;
import com.test.demo.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 杨帅 on 2017/3/11.
 */
@Controller
@RequestMapping(value="/AppServer")
public class BusinessController {
    @Autowired
    private BusinessService businessService;

    @RequestMapping(value="/GetAllBusinessServlet", method = RequestMethod.POST)
    @ResponseBody
    //获得所有的商家
    public Object GetAllBusinessServlet(@RequestBody String json){
        Gson gson = new Gson();
        String result = "GetAllBusinessError";
        try {
            List<Business> businessList = businessService.selectAllBusiness();
            result = gson.toJson(businessList);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return result;
    }
}
