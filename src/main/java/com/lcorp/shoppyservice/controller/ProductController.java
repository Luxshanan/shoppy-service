package com.lcorp.shoppyservice.controller;

import com.lcorp.shoppyservice.model.Product;
import com.lcorp.shoppyservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path ="api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> list = productService.getProducts();
        return new ResponseEntity<List<Product>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
        Product product = productService.getProduct(id);

        return new ResponseEntity<Product>(product, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("category/{categoryId}")
    public ResponseEntity<List<Product>> getProductsByCategoryId(@PathVariable("categoryId") Long categoryId) {
        List<Product> list = productService.getProductsByProductCategoryId(categoryId);
        return new ResponseEntity<List<Product>>(list, new HttpHeaders(), HttpStatus.OK);
    }






}
