package com.test.demo.mapper;

import com.test.demo.po.Business_Product;

public interface Business_ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Business_Product record);

    int insertSelective(Business_Product record);

    Business_Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Business_Product record);

    int updateByPrimaryKey(Business_Product record);
}