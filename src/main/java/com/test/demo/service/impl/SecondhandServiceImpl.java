package com.test.demo.service.impl;

import com.test.demo.mapper.SecondhandMapper;
import com.test.demo.po.Secondhand;
import com.test.demo.service.SecondhandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 杨帅 on 2017/3/13.
 */
@Service
public class SecondhandServiceImpl implements SecondhandService {
    @Autowired
    SecondhandMapper secondhandMapper;

    @Override
    public int insertSecondhand(Secondhand secondhand) throws Exception {
        return secondhandMapper.insert(secondhand);
    }

    public List<Secondhand> selectBySellerName(String sellername) throws Exception{
        return secondhandMapper.selectBySellerName(sellername);
    }

    @Override
    public int deleteByPrimaryKey(int id) throws Exception {
        return secondhandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Secondhand> selectAll() throws Exception {
        return secondhandMapper.selectAll();
    }

    @Override
    public List<Secondhand> selectByName(String productName) throws Exception {
        return secondhandMapper.selectByName(productName);
    }
}
