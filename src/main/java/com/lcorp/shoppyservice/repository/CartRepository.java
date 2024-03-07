package com.lcorp.shoppyservice.repository;

import com.lcorp.shoppyservice.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Long> {

    List<Cart> findByUserIdAndCartStatus(long userId,String cartStatus);


}
