package com.test.demo.service.impl;

import com.test.demo.mapper.User_CorpMapper;
import com.test.demo.po.User_Corp;
import com.test.demo.service.User_CorpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 杨帅 on 2017/3/15.
 */
@Service
public class User_CorpServiceImpl implements User_CorpService {
    @Autowired
    User_CorpMapper user_corpMapper;

    @Override
    public int insert(User_Corp record) throws Exception {
        return user_corpMapper.insert(record);
    }

    @Override
    public User_Corp selectByName(User_Corp record) throws Exception {
        return user_corpMapper.selectByName(record);
    }

    @Override
    public int deleteByName(User_Corp record) throws Exception {
        return user_corpMapper.deleteByName(record);
    }

    @Override
    public List<User_Corp> selectByUserName(User_Corp record) throws Exception {
        return  user_corpMapper.selectByUserName(record);
    }

    @Override
    public List<User_Corp> selectInHandle(String corpName) throws Exception {
        return user_corpMapper.selectInHandle(corpName);
    }

    @Override
    public int updateByPrimaryKey(User_Corp record) throws Exception {
        return user_corpMapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteByPrimaryKey(int id) throws Exception{
        return user_corpMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<User_Corp> selectMember(String corpName) throws Exception {
        return user_corpMapper.selectMember(corpName);
    }
}
