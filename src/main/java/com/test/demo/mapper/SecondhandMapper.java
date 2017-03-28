package com.test.demo.mapper;

import com.test.demo.po.Secondhand;

import java.util.List;

public interface SecondhandMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Secondhand record);

    int insertSelective(Secondhand record);

    Secondhand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Secondhand record);

    int updateByPrimaryKey(Secondhand record);

    List<Secondhand> selectBySellerName(String sellername);

    List<Secondhand> selectAll();

    List<Secondhand> selectByName(String productName);
}