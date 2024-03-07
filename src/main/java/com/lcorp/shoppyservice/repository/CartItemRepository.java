package com.lcorp.shoppyservice.repository;

import com.lcorp.shoppyservice.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
    List<CartItem> findByCartId(long cartId);

}
