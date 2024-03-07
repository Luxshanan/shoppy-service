package com.lcorp.shoppyservice.model;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String productName;

    @Column
    private String productDescription;

    @Column 
    private  double price;

    @Column 
    private  long supplierId;

    @Column 
    private  String sku;

    @Column 
    private  int stockQuantity;

    @Column
    private  String productImageUrl;

    @ManyToOne
    @JoinColumn(name="productCategoryId", nullable=false)
    private ProductCategory productCategory;


    public Product() {
    }

    public Product(String productName, String productDescription, double price, long supplierId, String sku, int stockQuantity, String productImageUrl, ProductCategory productCategory) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
        this.supplierId = supplierId;
        this.sku = sku;
        this.stockQuantity = stockQuantity;
        this.productImageUrl = productImageUrl;
        this.productCategory = productCategory;
    }

    public Product(long id, String productName, String productDescription, double price, long supplierId, String sku, int stockQuantity, String productImageUrl, ProductCategory productCategory) {
        this.id = id;
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
        this.supplierId = supplierId;
        this.sku = sku;
        this.stockQuantity = stockQuantity;
        this.productImageUrl = productImageUrl;
        this.productCategory = productCategory;
    }

    public long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", price=" + price +
                ", supplierId=" + supplierId +
                ", sku='" + sku + '\'' +
                ", stockQuantity=" + stockQuantity +
                ", productImageUrl='" + productImageUrl + '\'' +
                ", productCategory=" + productCategory +
                '}';
    }
}
