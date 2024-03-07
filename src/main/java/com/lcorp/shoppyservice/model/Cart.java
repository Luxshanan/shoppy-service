package com.lcorp.shoppyservice.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private long userId;

    @Column
    private String cartStatus;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name="cartId")
    private List<CartItem> cartItems;

    public Cart() {

    }

    public Cart(long userId, String cartStatus) {
        this.userId = userId;
        this.cartStatus = cartStatus;
    }

    public Cart(long id, long userId, String cartStatus) {
        this.id = id;
        this.userId = userId;
        this.cartStatus = cartStatus;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(String cartStatus) {
        this.cartStatus = cartStatus;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public long getId() {
        return id;
    }
}
