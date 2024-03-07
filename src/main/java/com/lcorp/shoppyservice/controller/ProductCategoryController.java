package com.lcorp.shoppyservice.controller;

import com.lcorp.shoppyservice.model.ProductCategory;
import com.lcorp.shoppyservice.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path ="api/productCategories")
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    @Autowired
    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping
    public ResponseEntity<List<ProductCategory>> getProductCategories() {
        List<ProductCategory> productCategoryList = productCategoryService.getProductCategories();
        return new ResponseEntity<List<ProductCategory>>(productCategoryList, new HttpHeaders(), HttpStatus.OK);
    }
}
