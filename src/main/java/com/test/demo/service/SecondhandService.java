package com.test.demo.service;

import com.test.demo.po.Secondhand;

import java.util.List;

/**
 * Created by 杨帅 on 2017/3/13.
 */
public interface SecondhandService {
    public int insertSecondhand(Secondhand secondhand) throws Exception;

    public List<Secondhand> selectBySellerName(String sellername) throws Exception;

    public int deleteByPrimaryKey(int id) throws Exception;

    public List<Secondhand> selectAll() throws Exception;

    public List<Secondhand> selectByName(String productName) throws Exception;

}
