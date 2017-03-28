package com.test.demo.mapper;

import com.test.demo.po.User_Corp;

import java.util.List;

public interface User_CorpMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User_Corp record);

    int insertSelective(User_Corp record);

    User_Corp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User_Corp record);

    int updateByPrimaryKey(User_Corp record);

    User_Corp selectByName(User_Corp record);

    int deleteByName(User_Corp record);

    List<User_Corp> selectByUserName(User_Corp record);

    List<User_Corp> selectInHandle(String corpName);

    List<User_Corp> selectMember(String corpName);


}