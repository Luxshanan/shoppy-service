package com.lcorp.shoppyservice.controller;

import com.lcorp.shoppyservice.model.OrderDetail;
import com.lcorp.shoppyservice.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path ="api/orderDetails")
public class OrderDetailController {

    private final OrderDetailService orderService;

    @Autowired
    public OrderDetailController(OrderDetailService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderDetail> createOrder(@RequestBody OrderDetail order){
        OrderDetail newOrder = orderService.createOrder(order);
        return new ResponseEntity<OrderDetail>(newOrder, new HttpHeaders(), HttpStatus.CREATED);
    }
}
