package com.lcorp.shoppyservice.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String categoryName;

    @OneToMany(mappedBy="productCategory")
    private List<Product> products;

    public ProductCategory() {

    }

    public ProductCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public ProductCategory(long id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public long getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
