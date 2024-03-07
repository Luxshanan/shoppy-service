package com.lcorp.shoppyservice.service;

import com.lcorp.shoppyservice.model.CartItem;
import com.lcorp.shoppyservice.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartItemService {
    
    @Autowired
    private CartItemRepository cartItemRepository;

    public List<CartItem> getCartItemsByCart(long cartId)
    {
        List<CartItem> cartItemList = cartItemRepository.findByCartId(cartId);

        if(cartItemList.size() > 0) {
            return cartItemList;
        } else {
            return new ArrayList<CartItem>();
        }
    }

    public CartItem getCartItem(long id)  {
        Optional<CartItem> cartItem = cartItemRepository.findById(id);
        if (cartItem.isPresent()) {
            return cartItem.get();
        }
        throw new EntityNotFoundException("Cannot find any cartItem under given ID");
    }

    public CartItem createCartItem(CartItem cartItem)
    {
        CartItem savedCartItem = cartItemRepository.save(cartItem);

        return savedCartItem;
    }

    public CartItem updateCartItem(CartItem cartItem)
    {

        Optional<CartItem> existingCartItem = cartItemRepository.findById(cartItem.getId());

        if(existingCartItem.isPresent())
        {
            CartItem cartItemToUpdate = existingCartItem.get();
            cartItemToUpdate.setQuantity(cartItem.getQuantity());

            CartItem updatedCartItem = cartItemRepository.save(cartItemToUpdate);

            return updatedCartItem;

        } else {

            throw new EntityNotFoundException("No existing cartItem found");
        }
    }

    public void deleteCartItem(Long id)
    {
        Optional<CartItem> cartItem = cartItemRepository.findById(id);

        if(cartItem.isPresent())
        {
            cartItemRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Delete failed.Cannot find any existing cartItem under given ID");
        }
    }
}
