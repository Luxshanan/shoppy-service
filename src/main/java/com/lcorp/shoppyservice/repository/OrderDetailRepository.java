package com.lcorp.shoppyservice.repository;

import com.lcorp.shoppyservice.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
}
