package com.test.demo.controller;

import com.google.gson.Gson;
import com.test.demo.po.Business;
import com.test.demo.po.Product;
import com.test.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 杨帅 on 2017/3/13.
 */
@Controller
@RequestMapping(value="/AppServer")
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping(value="/GetMyProductServlet", method = RequestMethod.POST)
    @ResponseBody
    //通过商家名字获得当前商家下面的所有商品
    public Object GetMyProductServlet(@RequestBody String json){
        Gson gson = new Gson();
        Business business = gson.fromJson(json, Business.class);
        String businessName = business.getBusinessName();
        String result = "GetMyProductError";
        try {
            List<Product> productList = productService.getMyProduct(businessName);
            result = gson.toJson(productList);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value="/SelectProductByNameServlet", method = RequestMethod.POST)
    @ResponseBody
    //通过商品名字查找商品
    public Object SelectProductByNameServlet(@RequestBody String json){
        Gson gson = new Gson();
        Product product = gson.fromJson(json,Product.class);
        String productName = product.getProductName();
        String result = "SelectProductError";
        try {
            List<Product> productList = productService.selectByName(productName);
            result = gson.toJson(productList);
            if(productList.size()  == 0)
                result ="SelectProductError";
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return result;
    }

}
