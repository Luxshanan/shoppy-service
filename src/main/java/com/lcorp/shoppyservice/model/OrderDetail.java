package com.lcorp.shoppyservice.model;

import jakarta.persistence.*;

@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private long userId;

    @Column
    private String shippingAddress;

    @Column
    private long cartId;



    public OrderDetail() {

    }

    public OrderDetail(long userId, String shippingAddress, long cartId) {
        this.userId = userId;
        this.shippingAddress = shippingAddress;
        this.cartId = cartId;
    }

    public OrderDetail(long id, long userId, String shippingAddress, long cartId) {
        this.id = id;
        this.userId = userId;
        this.shippingAddress = shippingAddress;
        this.cartId = cartId;
    }

    public long getId() {
        return id;
    }


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }
}
