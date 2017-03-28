package com.test.demo.mapper;

import com.test.demo.po.Campaign_Corp;

public interface Campaign_CorpMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Campaign_Corp record);

    int insertSelective(Campaign_Corp record);

    Campaign_Corp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Campaign_Corp record);

    int updateByPrimaryKey(Campaign_Corp record);
}