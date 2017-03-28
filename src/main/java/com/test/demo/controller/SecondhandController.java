package com.test.demo.controller;

import com.google.gson.Gson;
import com.test.demo.po.Secondhand;
import com.test.demo.po.User;
import com.test.demo.service.SecondhandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 杨帅 on 2017/3/13.
 */
@Controller
@RequestMapping(value="/AppServer")
public class SecondhandController {
    @Autowired
    private SecondhandService secondhandService;

    @RequestMapping(value="/SubmitSecondhandServlet", method = RequestMethod.POST)
    @ResponseBody
    //发布二手商品
    public Object SubmitSecondhandServlet(@RequestBody String json){
        Gson gson = new Gson();
        Secondhand secondhand = gson.fromJson(json,Secondhand.class);
        String returnString = "SubmitSecondhandError";
        try {
            int result = secondhandService.insertSecondhand(secondhand);
            if(result > 0)
                returnString = "SubmitSecondhandSuccess";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnString;
    }

    @RequestMapping(value="/GetMySecondhandServlet", method = RequestMethod.POST)
    @ResponseBody
    //获得当前用户发布的所有二手商品
    public Object GeyMySecondhandServlet(@RequestBody String json){
        Gson gson = new Gson();
        User user = gson.fromJson(json,User.class);
        String sellerName = user.getUserName();
        String result = "GetMySecondhandError";
        try {
            List<Secondhand> secondhandList = secondhandService.selectBySellerName(sellerName);
            if(secondhandList.size() > 0)
            result = gson.toJson(secondhandList);
        } catch (Exception e) {
           // e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value="/DeleteMySecondhandServlet", method = RequestMethod.POST)
    @ResponseBody
    //删除当前用户发布的二手商品
    public Object DeleteMySecondhandServlet(@RequestBody String json){
        Gson gson  = new Gson();
        Secondhand secondhand = gson.fromJson(json,Secondhand.class);
        String returnString = "DeleteSecondhandError";
        try {
            int id = secondhand.getId();
            int result = secondhandService.deleteByPrimaryKey(id);
            if(result > 0)
                returnString = "DeleteSecondhandSuccess";
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return returnString;
    }

    @RequestMapping(value="/SelectAllSecondhandServlet", method = RequestMethod.POST)
    @ResponseBody
    //获得所有用户发布的二手商品
    public Object SelectAllSecondhandServlet(@RequestBody String json){
        String result = "SelectAllSecondhandError";
        Gson gson = new Gson();
        try {
            List<Secondhand> secondhandList = secondhandService.selectAll();
            result = gson.toJson(secondhandList);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value="/SelectByNameServlet", method = RequestMethod.POST)
    @ResponseBody
    //通过二手商品名字查找二手商品
    public Object SelectByNameServlet(@RequestBody String json){
        Gson gson = new Gson();
        Secondhand secondhand = gson.fromJson(json,Secondhand.class);
        String productName = secondhand.getProductName();
        String result = "SelectSecondhandError";
        try{
            List<Secondhand> secondhandList = secondhandService.selectByName(productName);
            if (secondhandList.size() > 0)
                result = gson.toJson(secondhandList);
        } catch (Exception e) {
           // e.printStackTrace();
        }
        return result;
    }



}
