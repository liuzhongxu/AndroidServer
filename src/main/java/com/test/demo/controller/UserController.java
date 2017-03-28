package com.test.demo.controller;

import com.google.gson.Gson;
import com.test.demo.po.User;
import com.test.demo.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/AppServer")
/**
 * Created by 丁红玉 on 2017/3/10.
 */
public class UserController {
    private Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @RequestMapping(value="/Test", method = RequestMethod.GET)
    @ResponseBody
    //测试
    public Object  Test()
    {

        return "Hello SpringMVC!";
    }

    @RequestMapping(value="/SignUserServlet", method = RequestMethod.POST)
    @ResponseBody
    //用户注册,分为社团干事和普通用户,根据注册时提交的身份分别
    //用户名唯一
    public Object  SignUserServlet(@RequestBody String json)
    {
        Gson gson = new Gson();
        User user = gson.fromJson(json, User.class);
        String result = "SignUser.error."+user.getUserIdentify();
        try {
            User resultUser = userService.selectUserByName(user);
            if(resultUser == null){
                userService.insertUser(user);
                result = "SignUser.success."+user.getUserIdentify();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /*@RequestMapping(value="/SynDataServlet", method = RequestMethod.POST)
    @ResponseBody
    public Object  SynDataServlet(HttpServletRequest request)
    {

        logger.error("asdf");

        *//*System.out.println(request.getParameter("age") + "^^^^^^^^^^^^^^^^^^^^^~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(request.getParameter("name") + "^^^^^^^^^^^^^^^^^^^^^~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(request.getParameter("classes") + "^^^^^^^^^^^^^^^^^^^^^~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        return "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@";*//*
        return "qwe";
    }*/

    @RequestMapping(value="/LoginServlet", method = RequestMethod.POST)
    @ResponseBody
    //用户登录,验证用户名和密码能否在在数据库中查找到匹配信息
    //能查找到返回用户所有信息
    public Object LoginServlet(@RequestBody String json) {
        Gson gson = new Gson();
        User user = gson.fromJson(json, User.class);
        String name = user.getUserName();
        String password = user.getUserPassword();
        String result = "LoginError";
        try {
            User resultUser = userService.selectUserByName(user);
            if (name.equals(resultUser.getUserName()) && password.equals(resultUser.getUserPassword())) {
                result = gson.toJson(resultUser);
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value="/UpdateNameServlet", method = RequestMethod.POST)
    @ResponseBody
    //用户修改用户名
    public Object UpdateNameServlet(@RequestBody String json){
        Gson gson = new Gson();
        User user = gson.fromJson(json, User.class);
        String returnString = "UpdateNameError";
        try{
            //int result = userService.updateByPrimaryKeySelective(user);
            User resultUser = userService.selectUserByName(user);
            if(resultUser == null) {
                returnString = "UpdateNameSuccess";
                userService.updateByPrimaryKeySelective(user);
            }

        }catch (Exception e){
            //e.printStackTrace();
        }
        return returnString;
    }

    @RequestMapping(value="/UpdatePasswordServlet", method = RequestMethod.POST)
    @ResponseBody
    //用户修改密码
    public Object UpdatePasswordServlet(@RequestBody String json){
        Gson gson = new Gson();
        User user = gson.fromJson(json, User.class);
        String returnString = "UpdatePasswordError";
        try{
            int result = userService.updateByPrimaryKeySelective(user);
            if(result > 0 )
                returnString = "UpdatePasswordSuccess";

        }catch (Exception e){
           // e.printStackTrace();
        }
        return returnString;
    }

    @RequestMapping(value="/UpdatePhoneServlet", method = RequestMethod.POST)
    @ResponseBody
    //用户修改电话号码
    public Object UpdatePhoneServlet(@RequestBody String json){
        Gson gson = new Gson();
        User user = gson.fromJson(json, User.class);
        String returnString = "UpdatePhoneError";
        try{
            int result = userService.updateByPrimaryKeySelective(user);
            if(result > 0 )
                returnString = "UpdatePhoneSuccess";

        }catch (Exception e){
            //e.printStackTrace();
        }
        return returnString;
    }

}
