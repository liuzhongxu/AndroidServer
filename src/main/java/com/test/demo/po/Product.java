package com.test.demo.po;

public class Product {
    private Integer id;

    private String productName;

    private Float productPrice;

    private String productInfo;

    private String productBusiness;

    public String getProductBusiness() {
        return productBusiness;
    }

    public void setProductBusiness(String productBusiness) {
        this.productBusiness = productBusiness;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo == null ? null : productInfo.trim();
    }
}