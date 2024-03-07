package com.lcorp.shoppyservice.controller;

import com.lcorp.shoppyservice.model.CartItem;
import com.lcorp.shoppyservice.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path ="api/cartItems")
public class CartItemController {
    private final CartItemService cartItemService;

    @Autowired
    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @GetMapping("carts/{cartId}")
    public ResponseEntity<List<CartItem>> getCartItemsByCartId(@PathVariable("cartId") Long cartId) {
        List<CartItem> list = cartItemService.getCartItemsByCart(cartId);
        return new ResponseEntity<List<CartItem>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartItem> getCartItem(@PathVariable("id") Long id) {
        CartItem cartItem = cartItemService.getCartItem(id);

        return new ResponseEntity<CartItem>(cartItem, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CartItem> createCartItem(@RequestBody CartItem cartItem){
        CartItem newCartItem = cartItemService.createCartItem(cartItem);
        return new ResponseEntity<CartItem>(newCartItem, new HttpHeaders(), HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<CartItem> updateCartItem(@RequestBody CartItem cartItem){
        CartItem updatedCartItem = cartItemService.updateCartItem(cartItem);
        System.out.println(updatedCartItem);
        return new ResponseEntity<CartItem>(updatedCartItem, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteCartItem(@PathVariable("id") Long id) {
        cartItemService.deleteCartItem(id);
        return HttpStatus.OK;
    }
}
