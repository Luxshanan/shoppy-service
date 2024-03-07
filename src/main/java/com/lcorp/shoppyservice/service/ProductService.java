package com.lcorp.shoppyservice.service;

import com.lcorp.shoppyservice.model.Product;
import com.lcorp.shoppyservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts()
    {
        List<Product> productList = productRepository.findAll();

        if(productList.size() > 0) {
            return productList;
        } else {
            return new ArrayList<Product>();
        }
    }

    public Product getProduct(long id)  {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        }
        throw new  EntityNotFoundException("Cannot find any product under given ID");
    }

    public List<Product> getProductsByProductCategoryId(long productCategoryId)
    {
        List<Product> productList = productRepository.findByProductCategoryId(productCategoryId);

        if(productList.size() > 0) {
            return productList;
        } else {
            return new ArrayList<Product>();
        }
    }

}
