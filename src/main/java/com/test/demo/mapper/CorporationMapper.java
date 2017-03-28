package com.test.demo.mapper;

import com.test.demo.po.Corporation;

import java.util.List;

public interface CorporationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Corporation record);

    int insertSelective(Corporation record);

    Corporation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Corporation record);

    int updateByPrimaryKey(Corporation record);

    Corporation selectCorpByName(Corporation record);

    List<Corporation> getAllCorp();

    Corporation selectCorpByLeaderName(String leaderName);
}