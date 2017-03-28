package com.test.demo.service;

import com.test.demo.po.Product;

import java.util.List;

/**
 * Created by 杨帅 on 2017/3/13.
 */
public interface ProductService {
    public List<Product> getMyProduct(String productBusiness) throws Exception;

    public List<Product> selectByName(String productName) throws Exception;
}
