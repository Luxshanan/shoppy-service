package com.lcorp.shoppyservice.controller;

import com.lcorp.shoppyservice.model.Cart;
import com.lcorp.shoppyservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path ="api/carts")
public class CartController {
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }


    @GetMapping("users/{userId}/{cartStatus}")
    public ResponseEntity<List<Cart>> getCartsByUserAndCartStatus(@PathVariable("userId") Long userId,
                                                                  @PathVariable("cartStatus") String cartStatus) {
        List<Cart> cartList = cartService.getCartsByUserAndCartStatus(userId,cartStatus);
        return new ResponseEntity<List<Cart>>(cartList, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCart(@PathVariable("id") Long id) {
        Cart cart = cartService.getCart(id);

        return new ResponseEntity<Cart>(cart, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart){
        Cart newCart = cartService.createCart(cart);
        return new ResponseEntity<Cart>(newCart, new HttpHeaders(), HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<Cart> updateCart(@RequestBody Cart cart){
        Cart updatedCart = cartService.updateCart(cart);
        return new ResponseEntity<Cart>(updatedCart, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteCart(@PathVariable("id") Long id) {
        cartService.deleteCart(id);
        return HttpStatus.OK;
    }
}
