package com.lcorp.shoppyservice.repository;

import com.lcorp.shoppyservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository  extends JpaRepository<Product, Long> {

   List<Product> findByProductCategoryId(long productCategoryId);
}
