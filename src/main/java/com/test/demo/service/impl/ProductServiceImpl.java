package com.test.demo.service.impl;

import com.test.demo.mapper.ProductMapper;
import com.test.demo.po.Product;
import com.test.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 杨帅 on 2017/3/13.
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;

    @Override
    public List<Product> getMyProduct(String productBusiness) throws Exception {
        return productMapper.getMyProduct(productBusiness);
    }

    @Override
    public List<Product> selectByName(String productName) throws Exception{
        return productMapper.selectByName(productName);
    }
}
