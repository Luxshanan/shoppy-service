package com.lcorp.shoppyservice.repository;

import com.lcorp.shoppyservice.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
