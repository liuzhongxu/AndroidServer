package com.test.demo.mapper;

import com.test.demo.po.User_Secondhand;

public interface User_SecondhandMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User_Secondhand record);

    int insertSelective(User_Secondhand record);

    User_Secondhand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User_Secondhand record);

    int updateByPrimaryKey(User_Secondhand record);
}