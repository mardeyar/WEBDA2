package com.oms.webda2.model;

public class Product {
    private String productName;
    private String productCategory;
    private String productInfo;
    private int quantityInStock;
    private String productImage;

    public Product() { }

    public Product(String productName, String productCategory, String productInfo, int quantityInStock, String productImage) {
        this.productName = productName;
        this.productCategory = productCategory;
        this.productInfo = productInfo;
        this.quantityInStock = quantityInStock;
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }
}
