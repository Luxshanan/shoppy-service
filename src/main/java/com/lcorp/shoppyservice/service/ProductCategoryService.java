package com.lcorp.shoppyservice.service;

import com.lcorp.shoppyservice.model.ProductCategory;
import com.lcorp.shoppyservice.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public List<ProductCategory> getProductCategories()
    {
        List<ProductCategory> productCategoryList = productCategoryRepository.findAll();

        if(productCategoryList.size() > 0) {
            return productCategoryList;
        } else {
            return new ArrayList<ProductCategory>();
        }
    }
}
