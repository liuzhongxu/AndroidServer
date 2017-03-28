package com.test.demo.service;

import com.test.demo.po.User_Corp;

import java.util.List;

/**
 * Created by 杨帅 on 2017/3/15.
 */
public interface User_CorpService {

    public int insert(User_Corp record) throws Exception;

    public User_Corp selectByName(User_Corp record) throws Exception;

    public int deleteByName(User_Corp record) throws Exception;

    public List<User_Corp> selectByUserName(User_Corp record) throws Exception;

    public List<User_Corp> selectInHandle(String corpName) throws Exception;

    public int updateByPrimaryKey(User_Corp record) throws Exception;

    public int deleteByPrimaryKey(int id) throws Exception;

    public List<User_Corp> selectMember(String corpName) throws Exception;
}
