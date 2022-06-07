package com.projectone.p1.service;

import com.projectone.p1.model.Cart;
import com.projectone.p1.model.User;

import java.util.List;

public interface CartService {
    public boolean addCart(Cart cart);
    public boolean deletCart(int cartId);
    public boolean updateCart(Cart cart);
    public Cart getCart(int cartId);
    public boolean doesCartExists(int cartId);
    public List <Cart> getCartbyUser(User user);
    boolean doesUserIdExists(int userId);
    boolean addItemToCart(int itemId);

}
