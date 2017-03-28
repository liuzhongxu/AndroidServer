package com.test.demo.service;

import com.test.demo.po.Business;

import java.util.List;

/**
 * Created by 杨帅 on 2017/3/11.
 */
public interface BusinessService {
    public int insertBusiness(Business business) throws Exception;

    public List<Business> selectAllBusiness() throws Exception;
}
