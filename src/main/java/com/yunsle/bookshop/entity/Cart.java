package com.yunsle.bookshop.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.util.List;

/**
 * Created by Doublestar on 2018/1/10 10:47).
 *购物车
 */
@Component
public class Cart {
    List<CartItem> CartItems;   //购物条目列表

    public void setCartItems(List<CartItem> cartItems) {
        CartItems = cartItems;
    }

    public List<CartItem> getCartItems() {
        return CartItems;
    }
}
