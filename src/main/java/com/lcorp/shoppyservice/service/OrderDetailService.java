package com.lcorp.shoppyservice.service;
import com.lcorp.shoppyservice.model.OrderDetail;
import com.lcorp.shoppyservice.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService {
    @Autowired
    private OrderDetailRepository orderRepository;

    public OrderDetail createOrder(OrderDetail order)
    {
        OrderDetail savedOrder = orderRepository.save(order);

        return savedOrder;
    }
}
