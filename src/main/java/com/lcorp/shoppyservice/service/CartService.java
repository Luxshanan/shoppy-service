package com.lcorp.shoppyservice.service;

import com.lcorp.shoppyservice.model.Cart;
import com.lcorp.shoppyservice.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public List<Cart> getCartsByUserAndCartStatus(long userId,String cartStatus)
    {
        List<Cart> cartList = cartRepository.findByUserIdAndCartStatus(userId,cartStatus);

        if(cartList.size() > 0) {
            return cartList;
        } else {
            return new ArrayList<Cart>();
        }
    }

    public Cart getCart(long id)  {
        Optional<Cart> cart = cartRepository.findById(id);
        if (cart.isPresent()) {
            return cart.get();
        }
        throw new EntityNotFoundException("Cannot find any cart under given ID");
    }

    public Cart createCart(Cart cart)
    {
        Cart savedCart = cartRepository.save(cart);

        return savedCart;
    }

    public Cart updateCart(Cart cart)
    {

        Optional<Cart> existingCart = cartRepository.findById(cart.getId());

        if(existingCart.isPresent())
        {
            Cart cartToUpdate = existingCart.get();
            cartToUpdate.setCartStatus(cart.getCartStatus());
            cartToUpdate.setCartItems(cart.getCartItems());
            Cart updatedCart = cartRepository.save(cartToUpdate);

            return updatedCart;

        } else {

            throw new EntityNotFoundException("No existing cart found");
        }
    }

    public void deleteCart(Long id)
    {
        Optional<Cart> cart = cartRepository.findById(id);

        if(cart.isPresent())
        {
            cartRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Delete failed.Cannot find any existing cart under given ID");
        }
    }
}
