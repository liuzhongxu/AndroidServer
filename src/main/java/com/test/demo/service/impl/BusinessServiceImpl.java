package com.test.demo.service.impl;

import com.test.demo.mapper.BusinessMapper;
import com.test.demo.po.Business;
import com.test.demo.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 杨帅 on 2017/3/11.
 */

@Service
public class BusinessServiceImpl implements BusinessService {
    @Autowired
    BusinessMapper businessMapper;
    @Override
    public int insertBusiness(Business business) throws Exception {
        return  businessMapper.insert(business);
    }

    @Override
    public List<Business> selectAllBusiness() throws Exception {
        return businessMapper.selectAll();
    }
}
